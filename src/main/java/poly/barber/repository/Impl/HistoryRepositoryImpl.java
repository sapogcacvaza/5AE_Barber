package poly.barber.repository.Impl;

import java.util.ArrayList;
import java.util.List;
import poly.barber.entity.Invoice;
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

    // Câu SQL mặc định khi vừa mở form
    public String sqlShowHistoryDF = "SELECT "
            + "    i.InvoiceCode, " // 0
            + "    c.Fullname, " // 1
            + "    BarberGroup.Names, " // 2 (Gộp tên thợ)
            + "    i.CheckInDateTime, " // 3
            + "    i.CheckOutDateTime, " // 4
            + "    i.TotalAmount, " // 5
            + "    i.TotalDiscount, " // 6
            + "    (i.TotalAmount - i.TotalDiscount), " // 7 (Thanh toán thực)
            + "    CASE "
            + "        WHEN i.Status = 1 THEN N'Chưa thanh toán' "
            + "        WHEN i.Status = 2 THEN N'Đã thanh toán' "
            + "        WHEN i.Status = 0 THEN N'Đã hủy' "
            + "        ELSE N'Khác' END, " // 8
            + "    c.Phone, " // 9
            + "    i.InvoiceID " // 10
            + "FROM Invoice i "
            + "LEFT JOIN Appointment a ON i.AppointmentID = a.AppointmentID "
            + "LEFT JOIN Customer c ON a.CustomerID = c.CustomerID "
            + "CROSS APPLY ( "
            + "    SELECT STRING_AGG(b.FirstName + ' ' + b.LastName, ', ') AS Names "
            + "    FROM AppointmentDetail ad "
            + "    JOIN Barber b ON ad.BarberID = b.BarberID "
            + "    WHERE ad.AppointmentID = i.AppointmentID "
            + ") AS BarberGroup "
            + "ORDER BY i.CheckInDateTime DESC";

    public List<Object[]> showHistoryDF() {
        return XQuery.getRawList(sqlShowHistoryDF);
    }

//    public List<Object[]> filterHistory(String barberName, String trangThai, String tuNgay, String denNgay) {
//        // Luôn hiển thị danh sách tất cả thợ (Cách 1)
//        String barberDisplaySQL = "(SELECT STRING_AGG(b.LastName + ' ' + b.FirstName, ', ') "
//                + " FROM AppointmentDetail ad JOIN Barber b ON ad.BarberID = b.BarberID "
//                + " WHERE ad.AppointmentID = i.AppointmentID)";
//
//        String sql = "SELECT i.InvoiceCode, c.Fullname, " + barberDisplaySQL + ", "
//                + "i.CheckInDateTime, i.CheckOutDateTime, i.TotalAmount, i.TotalDiscount, "
//                + "(i.TotalAmount - i.TotalDiscount), "
//                + "CASE WHEN i.Status = 1 THEN N'Chưa thanh toán' "
//                + "     WHEN i.Status = 2 THEN N'Đã thanh toán' "
//                + "     WHEN i.Status = 0 THEN N'Đã hủy' ELSE N'Khác' END, "
//                + "c.Phone, i.InvoiceID "
//                + "FROM Invoice i "
//                + "LEFT JOIN Appointment a ON i.AppointmentID = a.AppointmentID "
//                + "LEFT JOIN Customer c ON a.CustomerID = c.CustomerID "
//                + "WHERE 1=1 ";
//
//        List<Object> params = new java.util.ArrayList<>();
//
//        // Lọc theo nhân viên (Nếu chọn thợ A, chỉ hiện hóa đơn thợ A có tham gia)
//        if (barberName != null && !barberName.equals("Tất Cả")) {
//            sql += " AND i.AppointmentID IN ( "
//                    + "    SELECT ad2.AppointmentID FROM AppointmentDetail ad2 "
//                    + "    JOIN Barber b2 ON ad2.BarberID = b2.BarberID "
//                    + "    WHERE (b2.LastName + ' ' + b2.FirstName) = ? "
//                    + " ) ";
//            params.add(barberName.trim());
//        }
//
//        // Lọc Trạng thái
//        if (trangThai != null && !trangThai.equals("Tất Cả")) {
//            int statusVal = trangThai.equals("Chưa thanh toán") ? 1 : (trangThai.equals("Đã thanh toán") ? 2 : 0);
//            sql += " AND i.Status = ? ";
//            params.add(statusVal);
//        }
//
//        // Lọc Ngày tháng
//        if (tuNgay != null && !tuNgay.isEmpty()) {
//            sql += " AND i.CheckInDateTime >= ? ";
//            params.add(tuNgay + " 00:00:00");
//        }
//        if (denNgay != null && !denNgay.isEmpty()) {
//            sql += " AND i.CheckInDateTime <= ? ";
//            params.add(denNgay + " 23:59:59");
//        }
//
//        sql += " ORDER BY i.InvoiceID DESC";
//        return XQuery.getRawList(sql, params.toArray());
//    }
}
