package poly.barber.repository.Impl;

import java.util.Date;
import java.util.List;
import poly.barber.entity.Barber;
import poly.barber.util.XQuery;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
public class HistoryRepositoryImpl {

    // Câu SQL gốc: Tối ưu JOIN để tránh mất dữ liệu nếu AppointmentID bị NULL
    private String getBaseSql() {
        return "SELECT "
                + "    i.InvoiceCode, " // 0
                + "    c.Fullname, " // 1
                + "    ISNULL(BarberGroup.Names, N'Chưa chỉ định'), " // 2
                + "    i.CheckInDateTime, " // 3
                + "    i.CheckOutDateTime, " // 4
                + "    i.TotalAmount, " // 5
                + "    i.TotalDiscount, " // 6
                + "    (i.TotalAmount - i.TotalDiscount) AS FinalAmount, " // 7
                + "    CASE "
                + "        WHEN i.Status = 1 THEN N'Chưa thanh toán' "
                + "        WHEN i.Status = 2 THEN N'Đã thanh toán' "
                + "        WHEN i.Status = 0 THEN N'Đã hủy' "
                + "        ELSE N'Khác' END, " // 8
                + "    c.Phone, " // 9
                + "    i.InvoiceID " // 10
                + "FROM Invoice i "
                + "LEFT JOIN Appointment a ON i.AppointmentID = a.AppointmentID "
                + "LEFT JOIN Customer c ON a.CustomerID = c.CustomerID " // Hoặc lấy trực tiếp nếu Invoice có CustomerID
                + "OUTER APPLY ( "
                + "    SELECT STRING_AGG(CAST(b.FirstName + ' ' + b.LastName AS NVARCHAR(MAX)), ', ') AS Names "
                + "    FROM AppointmentDetail ad "
                + "    JOIN Barber b ON ad.BarberID = b.BarberID "
                + "    WHERE ad.AppointmentID = i.AppointmentID "
                + ") AS BarberGroup ";
    }

    // 1. Hiển thị mặc định (Tất cả)
    public List<Object[]> showHistoryDF() {
        String sql = getBaseSql() + " ORDER BY i.CheckInDateTime DESC";
        return XQuery.getRawList(sql);
    }

    // 2. Tìm kiếm theo từ khóa (Mã HĐ, Tên KH, Số điện thoại)
    public List<Object[]> searchHistory(String keyword) {
        String sql = getBaseSql()
                + " WHERE i.InvoiceCode LIKE ? OR c.Fullname LIKE ? OR c.Phone LIKE ?"
                + " ORDER BY i.CheckInDateTime DESC";
        String k = "%" + keyword + "%";
        return XQuery.getRawList(sql, k, k, k);
    }

    // 3. Lọc theo khoảng ngày (Rất quan trọng cho báo cáo)
    public List<Object[]> filterByDate(String startDate, String endDate) {
        String sql = getBaseSql()
                + " WHERE i.CheckInDateTime BETWEEN ? AND ?"
                + " ORDER BY i.CheckInDateTime DESC";
        return XQuery.getRawList(sql, startDate + " 00:00:00", endDate + " 23:59:59");
    }

    public List<Object[]> filterHistory(String status, String barberName, java.util.Date startDate, java.util.Date endDate) {
        String sql = getBaseSql() + " WHERE 1=1 "; // 1=1 để dễ dàng nối thêm AND
        List<Object> params = new java.util.ArrayList<>();

        // Lọc theo Trạng thái
        if (status != null && !status.equals("Tất Cả")) {
            int statusVal = status.equals("Đã thanh toán") ? 2 : (status.equals("Chưa thanh toán") ? 1 : 0);
            sql += " AND i.Status = ? ";
            params.add(statusVal);
        }

        // Lọc theo Nhân viên (Barber) - Tìm trong chuỗi gộp tên
        if (barberName != null && !barberName.equalsIgnoreCase("Tất Cả")) { // Dùng EqualsIgnoreCase
            sql += " AND BarberGroup.Names LIKE ? ";
            params.add("%" + barberName + "%");
        }

        // Lọc theo Ngày
        if (startDate != null && endDate != null) {
            sql += " AND i.CheckInDateTime BETWEEN ? AND ? ";
            // Format ngày sang String để XQuery xử lý
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            params.add(sdf.format(startDate) + " 00:00:00");
            params.add(sdf.format(endDate) + " 23:59:59");
        }

        sql += " ORDER BY i.CheckInDateTime DESC";
        return XQuery.getRawList(sql, params.toArray());
    }

    public List<Object[]> getBarbersAndServicesByInvoice(int idHoaDon) {
        // JOIN từ Invoice -> Appointment -> AppointmentDetail -> Barber & Service
        String sql = "SELECT b.FirstName + ' ' + b.LastName AS BarberName, s.ServiceName "
                + "FROM Invoice i "
                + "JOIN AppointmentDetail ad ON i.AppointmentID = ad.AppointmentID "
                + "JOIN Barber b ON ad.BarberID = b.BarberID "
                + "JOIN Service s ON ad.ServiceID = s.ServiceID "
                + "WHERE i.InvoiceID = ?";

        return XQuery.getRawList(sql, idHoaDon);
    }

    public List<Object[]> getAppointmentHistory() {
        String sql = "SELECT \n"
                + "    a.AppointmentID, \n" // Thêm ID để xử lý logic ngầm
                + "    a.AppointmentCode, \n"
                + "    c.Fullname, \n"
                + "    c.Phone, \n"
                + "    FORMAT(a.AppointmentDateTime, 'dd/MM/yyyy HH:mm'), \n"
                + "    CASE a.[Status]\n"
                + "        WHEN 1 THEN N'Chưa đến'\n"
                + "        WHEN 2 THEN N'Đã đến'\n"
                + "        WHEN 3 THEN N'Đã hủy'\n"
                + "        WHEN 4 THEN N'Đang chờ xử lý'\n"
                + "        WHEN 5 THEN N'Đã xong'\n"
                + "        ELSE N'Khác'\n"
                + "    END, \n"
                + "    e.FirstName + ' ' + e.LastName \n"
                + "FROM Appointment a \n"
                + "JOIN Customer c ON a.CustomerID = c.CustomerID \n"
                + "JOIN Employee e ON a.CreatedByEmployeeID = e.EmployeeID \n"
                + "ORDER BY a.AppointmentDateTime DESC";
        return XQuery.getRawList(sql);
    }

    public Object[] getPaymentDetailByInvoiceID(int invoiceID) {
        String sql = "SELECT "
                + "    i.CheckOutDateTime, " // index 0
                + "    i.TotalDiscount, " // index 1
                + "    i.TotalAmount, " // index 2
                + "    pm.PaymentName, " // index 3
                + "    (SELECT SUM(id.Quantity * id.Price) FROM InvoiceDetail id WHERE id.InvoiceID = i.InvoiceID) AS TotalService, " // index 4
                + "    d.DiscountCode, " // index 5 (Mã giảm giá)
                + "    d.DiscountName " // index 6 (Tên chương trình)
                + "FROM Invoice i "
                + "LEFT JOIN Payment p ON i.InvoiceID = p.InvoiceID "
                + "LEFT JOIN PaymentMethod pm ON p.PaymentMethodID = pm.PaymentMethodID "
                // JOIN để lấy thông tin khuyến mãi từ database của bạn
                + "LEFT JOIN InvoiceDiscount idisc ON i.InvoiceID = idisc.InvoiceID "
                + "LEFT JOIN Discount d ON idisc.DiscountID = d.DiscountID "
                + "WHERE i.InvoiceID = ?";

        List<Object[]> list = XQuery.getRawList(sql, invoiceID);
        return list.isEmpty() ? null : list.get(0);
    }

    public Object[] getAppointmentDetailById(int appointmentId) {
        String sql = "SELECT \n"
                + "    a.AppointmentCode, \n"
                + "    a.AppointmentDateTime, \n"
                + "    a.CreatedDateTime, \n"
                + "    a.TotalDuration, \n"
                + "    a.Note, \n"
                + "    CASE a.[Status]\n"
                + "        WHEN 1 THEN N'Chưa đến'\n"
                + "        WHEN 2 THEN N'Đã đến'\n"
                + "        WHEN 3 THEN N'Đã hủy'\n"
                + "        WHEN 4 THEN N'Đang chờ xử lý'\n"
                + "        WHEN 5 THEN N'Đã xong'\n"
                + "        ELSE N'Khác'\n"
                + "    END AS StatusText, \n"
                + "    c.CustomerCode, \n"
                + "    c.Fullname, \n"
                + "    c.Phone \n"
                + "FROM Appointment a \n"
                + "JOIN Customer c ON a.CustomerID = c.CustomerID \n"
                + "WHERE a.AppointmentID = ?";

        List<Object[]> list = XQuery.getRawList(sql, appointmentId);
        return list.isEmpty() ? null : list.get(0);
    }

    public List<Object[]> getServiceDetailsByAppointmentId(int appointmentId) {
        String sql = "SELECT \n"
                + "    s.ServiceName, \n" // Tên dịch vụ
                + "    b.FirstName + ' ' + b.LastName, \n" // Thợ thực hiện
                + "    ad.Price, \n" // Giá
                + "    CASE ad.[Status]\n" // Trạng thái dịch vụ
                + "        WHEN 0 THEN N'Chờ'\n"
                + "        WHEN 1 THEN N'Đang làm'\n"
                + "        WHEN 2 THEN N'Xong'\n"
                + "        WHEN 3 THEN N'Hủy dịch vụ'\n"
                + "        ELSE N'Không xác định'\n"
                + "    END \n"
                + "FROM AppointmentDetail ad \n"
                + "JOIN Service s ON ad.ServiceID = s.ServiceID \n"
                + "JOIN Barber b ON ad.BarberID = b.BarberID \n"
                + "WHERE ad.AppointmentID = ?";

        return XQuery.getRawList(sql, appointmentId); // Sử dụng hàm tiện ích XQuery bạn đã cung cấp
    }

    public List<Object[]> getFilteredLichDat(int status, int empId, Date from, Date to) {
    String sql = "SELECT \n"
            + "    a.AppointmentID, \n"
            + "    a.AppointmentCode, \n"
            + "    c.Fullname, \n"
            + "    c.Phone, \n"
            + "    a.AppointmentDateTime, \n"
            + "    CASE a.Status \n"
            + "        WHEN 1 THEN N'Chưa đến' \n" // Bổ sung mã 1
            + "        WHEN 2 THEN N'Đã đến' \n"
            + "        WHEN 3 THEN N'Đã hủy' \n"
            + "        WHEN 4 THEN N'Đang chờ xử lý' \n"
            + "        WHEN 5 THEN N'Đã xong' \n"
            + "    END, \n"
            + "    e.FirstName + ' ' + e.LastName \n"
            + "FROM Appointment a \n"
            + "JOIN Customer c ON a.CustomerID = c.CustomerID \n"
            + "JOIN Employee e ON a.CreatedByEmployeeID = e.EmployeeID \n"
            + "WHERE \n"
            + "    (? = -1 OR a.Status = ?) \n"
            + "    AND (? = -1 OR a.CreatedByEmployeeID = ?) \n"
            + "    AND (? IS NULL OR CAST(a.AppointmentDateTime AS DATE) >= ?) \n"
            + "    AND (? IS NULL OR CAST(a.AppointmentDateTime AS DATE) <= ?) \n"
            + "ORDER BY a.AppointmentDateTime DESC";

    // Chuyển đổi Date sang java.sql.Date để SQL Server hiểu đúng định dạng
    java.sql.Date sDate = (from != null) ? new java.sql.Date(from.getTime()) : null;
    java.sql.Date eDate = (to != null) ? new java.sql.Date(to.getTime()) : null;

    // Truyền tham số: Chú ý dùng empId (ID nhân viên) thay vì barberId vì bảng Appointment lưu CreatedByEmployeeID
    return XQuery.getRawList(sql, status, status, empId, empId, sDate, sDate, eDate, eDate);
}

}
