package poly.barber.repository.Impl;

import java.util.List;
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

    public String sqlShowAppoinmentDF = "SELECT \n"
            + "    a.AppointmentCode AS [Mã Lịch Hẹn],\n"
            + "    c.Fullname AS [Khách Hàng],\n"
            + "	c.Phone as[Số Điện Thoại],\n"
            + "    a.AppointmentDateTime AS [Thời Gian Hẹn],\n"
            + "    a.TotalDuration AS [Tổng Thời Lượng (Phút)],\n"
            + "    (SELECT SUM(ad.Price * ad.Quantity) \n"
            + "     FROM AppointmentDetail ad \n"
            + "     WHERE ad.AppointmentID = a.AppointmentID) AS [Tổng Tiền Dự Kiến],\n"
            + "    CASE \n"
            + "        WHEN a.Status = 1 THEN N'Chờ xác nhận'\n"
            + "        WHEN a.Status = 2 THEN N'Đã xác nhận'\n"
            + "        WHEN a.Status = 3 THEN N'Đã hoàn thành'\n"
            + "        WHEN a.Status = 0 THEN N'Đã hủy'\n"
            + "    END AS [Trạng Thái]\n"
            + "FROM Appointment a\n"
            + "JOIN Customer c ON a.CustomerID = c.CustomerID\n"
            + "ORDER BY a.AppointmentDateTime DESC;";
    
    public List<Object[]> showAppDF(String appointmentCode){
        return XQuery.getRawList(sqlShowAppoinmentDF,appointmentCode);
    }
}
