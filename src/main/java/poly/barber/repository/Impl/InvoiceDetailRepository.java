/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.barber.repository.Impl;

import java.util.List;
import poly.barber.entity.Invoice;
import poly.barber.entity.InvoiceDetail;
import poly.barber.repository.ICommonRepository;
import poly.barber.util.XJdbc;
import poly.barber.util.XQuery;

/**
 *
 * @author DELL
 */
public class InvoiceDetailRepository implements ICommonRepository<InvoiceDetail, Integer> {

    // Câu lệnh SQL lấy chi tiết dịch vụ của 1 hóa đơn
    String sqlGetDetails = "SELECT s.ServiceName, id.Quantity, id.Price, (id.Quantity * id.Price) AS Total "
            + "FROM InvoiceDetail id "
            + "JOIN Service s ON id.ServiceID = s.ServiceID "
            + "WHERE id.InvoiceID = ?";

    String createSQl = "insert into InvoiceDetail (ServiceID, InvoiceID, Quantity, Price) values (?,?,?,?)";

    // Hàm lấy danh sách mảng đối tượng để đổ trực tiếp lên Table
    public List<Object[]> getServiceDetails(Integer invoiceId) {
        return XQuery.getRawList(sqlGetDetails, invoiceId);
    }

    @Override
    public List<InvoiceDetail> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public InvoiceDetail getOne(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(InvoiceDetail obj) {
        Object[] values = {
            obj.getServiceID(),
            obj.getInvoiceID(),
            obj.getQuantity(),
            obj.getPrice()
        };

        XJdbc.executeUpdate(createSQl, values);
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(InvoiceDetail obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
