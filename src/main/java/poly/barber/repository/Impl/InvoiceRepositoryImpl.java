/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.barber.repository.Impl;

import java.util.List;
import poly.barber.entity.Employee;
import poly.barber.entity.Invoice;
import poly.barber.repository.ICommonRepository;
import poly.barber.util.XQuery;

/**
 *
 * @author Admin
 */
public class InvoiceRepositoryImpl implements ICommonRepository<Invoice, Integer> {

    public String sqlGetAll = "select * from Invoice";

    public String sqlGetOneById = "select *from Invoice where InvoiceID = ?";

    public String sqlGetDetailsByInvoiceId = "SELECT \n"
            + "    s.ServiceName, \n"
            + "    id.Quantity, \n"
            + "    id.Price, \n"
            + "    (id.Quantity * id.Price) AS Total\n"
            + "FROM InvoiceDetail id\n"
            + "JOIN Service s ON id.ServiceID = s.ServiceID\n"
            + "WHERE id.InvoiceID = ?";

    public String sqlGetByEmployeeName = "SELECT Invoice.* FROM Invoice "
            + "JOIN Employee ON Invoice.CreatedByEmployeeID = Employee.EmployeeID "
            + "WHERE (Employee.FirstName + ' ' + Employee.LastName) LIKE ?";

    public List<Object[]> getHistoryByDate(String start, String end, String employeeName) {
        // 1. Khai báo câu SQL gốc (luôn lọc theo ngày)
        String sql = "SELECT i.InvoiceID, i.InvoiceCode, e.FirstName + ' ' + e.LastName, "
                + "c.Fullname, c.Phone, i.Status, i.TotalAmount "
                + "FROM Invoice i "
                + "JOIN Employee e ON i.CreatedByEmployeeID = e.EmployeeID "
                + "LEFT JOIN Appointment a ON i.AppointmentID = a.AppointmentID "
                + "LEFT JOIN Customer c ON a.CustomerID = c.CustomerID "
                + "WHERE i.CheckInDateTime >= ? AND i.CheckInDateTime <= ? ";

        // 2. Kiểm tra điều kiện nhân viên
        // Nếu chọn một nhân viên cụ thể (khác "Tất cả")
        if (employeeName != null && !employeeName.equalsIgnoreCase("Tất cả")) {
            sql += " AND (e.FirstName + ' ' + e.LastName) = ? ";
            sql += " ORDER BY i.CheckInDateTime DESC";

            // Truyền 3 tham số: Từ ngày, Đến ngày, Tên nhân viên
            return XQuery.getRawList(sql, start + " 00:00:00", end + " 23:59:59", employeeName);
        }

        // 3. Nếu chọn "Tất cả", chỉ lọc theo ngày
        sql += " ORDER BY i.CheckInDateTime DESC";

        // Chỉ truyền 2 tham số: Từ ngày, Đến ngày
        return XQuery.getRawList(sql, start + " 00:00:00", end + " 23:59:59");
    }

    public List<Invoice> getByEmployeeName(String fullName) {
        return XQuery.getBeanList(Invoice.class, sqlGetByEmployeeName, "%" + fullName + "%");
    }

    @Override
    public Invoice getOne(Integer id) {
        return XQuery.getSingleBean(Invoice.class, sqlGetOneById, id);
    }

    @Override
    public void add(Invoice obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Invoice obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Invoice> getAll() {
        return XQuery.getBeanList(Invoice.class, sqlGetAll);
    }

    public List<Object[]> GetDetailsByInvoiceId(String invoiceId) {
        return XQuery.getRawList(sqlGetDetailsByInvoiceId, invoiceId);
    }
}
