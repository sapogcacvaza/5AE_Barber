package poly.barber.repository.Impl;

import java.util.Date;
import java.util.List;
import poly.barber.util.XQuery;

/**
 * Repository xử lý thống kê cho dự án Barber5AE Đã cập nhật logic: Status 2 =
 * Đã thanh toán
 */
public class StatisticalRepositoryImpl {

    // --- TAB TỔNG QUAN (BIỂU ĐỒ) ---
    public List<Object[]> getRevenueLast8Days() {
        String sql = "SELECT FORMAT(CheckOutDateTime, 'dd/MM') AS Ngay, SUM(TotalAmount - TotalDiscount) AS DoanhThu "
                + "FROM Invoice "
                + "WHERE Status = 2 "
                + "AND CheckOutDateTime >= CAST(DATEADD(DAY, -7, GETDATE()) AS DATE) "
                + "GROUP BY FORMAT(CheckOutDateTime, 'dd/MM'), CAST(CheckOutDateTime AS DATE) "
                + "ORDER BY CAST(CheckOutDateTime AS DATE) ASC";
        return XQuery.getRawList(sql);
    }

    public List<Object[]> getCustomerCountLast8Days() {
        String sql = "SELECT FORMAT(CheckOutDateTime, 'dd/MM') AS Ngay, COUNT(InvoiceID) AS SoKhach "
                + "FROM Invoice WHERE Status = 2 "
                + "AND CheckOutDateTime >= CAST(DATEADD(DAY, -7, GETDATE()) AS DATE) "
                + "GROUP BY FORMAT(CheckOutDateTime, 'dd/MM'), CAST(CheckOutDateTime AS DATE) "
                + "ORDER BY CAST(CheckOutDateTime AS DATE) ASC";
        return XQuery.getRawList(sql);
    }

    // --- TAB TỔNG QUAN (BẢNG CHI TIẾT PHÍA DƯỚI) ---
    public List<Object[]> getDailySummaryLast8Days() {
        // Dùng CheckInDateTime để đảm bảo hiển thị đủ ngày kể cả khi chưa Checkout
        String sql = "SELECT \n"
                + "    CONVERT(VARCHAR, CheckInDateTime, 103) as Ngay, \n"
                + "    COUNT(InvoiceID) as LuongKhach,\n"
                + "    SUM(CASE WHEN Status = 2 THEN (TotalAmount - TotalDiscount) ELSE 0 END) as DoanhThu\n"
                + "FROM Invoice\n"
                + "WHERE CheckInDateTime >= DATEADD(DAY, -7, CAST(GETDATE() AS DATE))\n"
                + "GROUP BY CONVERT(VARCHAR, CheckInDateTime, 103), CAST(CheckInDateTime AS DATE)\n"
                + "ORDER BY CAST(CheckInDateTime AS DATE) ASC";
        return XQuery.getRawList(sql);
    }

    public List<Object[]> getStatisticalByDate(Date tuNgay, Date denNgay) {
        String sql = "SELECT \n"
                + "    FORMAT(CheckOutDateTime, 'dd/MM/yyyy') AS Ngay, \n" // Format luôn để Table hiện đẹp
                + "    COUNT(InvoiceID) AS SoLuotKhach, \n"
                + "    SUM(TotalAmount - TotalDiscount) AS DoanhThu \n"
                + "FROM Invoice \n"
                + "WHERE Status = 2 \n"
                + "AND CAST(CheckOutDateTime AS DATE) BETWEEN ? AND ? \n"
                + "GROUP BY FORMAT(CheckOutDateTime, 'dd/MM/yyyy'), CAST(CheckOutDateTime AS DATE) \n"
                + "ORDER BY CAST(CheckOutDateTime AS DATE) ASC"; // Sắp xếp theo ngày chuẩn
        return XQuery.getRawList(sql, tuNgay, denNgay);
    }

    // --- TAB DỊCH VỤ ---
    public List<Object[]> getServiceStatistics(Date tuNgay, Date denNgay) {
        String sql = "SELECT \n"
                + "    dv.ServiceName AS TenDV, \n"
                + "    COUNT(id.ServiceID) AS SoLuot, \n"
                + "    SUM(id.Price) AS DoanhThu,\n"
                + "    CASE \n"
                + "        WHEN COUNT(id.ServiceID) >= 10 THEN N' Hot Trend'\n"
                + "        WHEN COUNT(id.ServiceID) <= 2 THEN N' Cần KM'\n"
                + "        ELSE N'Bình thường'\n"
                + "    END AS TrangThai\n"
                + "FROM Service dv\n"
                + "LEFT JOIN InvoiceDetail id ON dv.ServiceID = id.ServiceID\n"
                + "LEFT JOIN Invoice i ON id.InvoiceID = i.InvoiceID\n"
                + "WHERE i.Status = 2 \n"
                + "AND CAST(i.CheckOutDateTime AS DATE) BETWEEN ? AND ? \n" // THÊM CAST Ở ĐÂY
                + "GROUP BY dv.ServiceName\n"
                + "ORDER BY SoLuot DESC";
        return XQuery.getRawList(sql, tuNgay, denNgay);
    }

    public List<Object[]> getServiceStatisticsDefault() {
        String sql = "SELECT \n"
                + "    dv.ServiceName, \n"
                + "    COUNT(id.ServiceID) AS SoLuot, \n"
                + "    SUM(id.Price) AS DoanhThu,\n"
                + "    CASE \n"
                + "        WHEN COUNT(id.ServiceID) >= 10 THEN N' Hot Trend'\n"
                + "        WHEN COUNT(id.ServiceID) <= 2 THEN N' Cần KM'\n"
                + "        ELSE N'Bình thường'\n"
                + "    END AS TrangThai\n"
                + "FROM Service dv\n"
                + "LEFT JOIN InvoiceDetail id ON dv.ServiceID = id.ServiceID\n"
                + "LEFT JOIN Invoice i ON id.InvoiceID = i.InvoiceID\n"
                + "WHERE i.Status = 2 AND MONTH(i.CheckOutDateTime) = MONTH(GETDATE()) \n"
                + "AND YEAR(i.CheckOutDateTime) = YEAR(GETDATE())\n"
                + "GROUP BY dv.ServiceName\n"
                + "ORDER BY SoLuot DESC";
        return XQuery.getRawList(sql);
    }

    // --- TAB NHÂN VIÊN (THỐNG KÊ DOANH THU THEO THỢ TẠO HÓA ĐƠN) ---
    public List<Object[]> getEmployeeStatisticsDefault() {
        String sql = "SELECT \n"
                + "    B.FirstName + ' ' + B.LastName AS TenNV, \n"
                + "    ISNULL((SELECT TOP 1 S.ServiceName FROM AppointmentDetail AD2 \n"
                + "     JOIN Service S ON AD2.ServiceID = S.ServiceID \n"
                + "     JOIN Invoice I2 ON AD2.AppointmentID = I2.AppointmentID\n" // Join thêm hóa đơn vào subquery
                + "     WHERE AD2.BarberID = B.BarberID \n"
                + "     AND I2.Status = 2 \n" // Chỉ tính hóa đơn đã thanh toán
                + "     AND I2.CheckOutDateTime >= CAST(DATEADD(DAY, -7, GETDATE()) AS DATE)\n" // Chỉ tính trong 7 ngày qua
                + "     GROUP BY S.ServiceName ORDER BY COUNT(*) DESC), N'Chưa có') AS Chuyen, \n"
                + "    COUNT(DISTINCT I.InvoiceID) AS SoLuot, \n"
                + "    ISNULL(SUM(ID.Price), 0) AS DoanhThu,\n"
                + "    CASE \n"
                + "        WHEN COUNT(DISTINCT I.InvoiceID) >= 5 THEN N'Xuất Sắc'\n"
                + "        WHEN COUNT(DISTINCT I.InvoiceID) = 0 THEN N'Lười'\n"
                + "        ELSE N'Tích cực'\n"
                + "    END AS TrangThai\n"
                + "FROM Barber B\n"
                + "LEFT JOIN AppointmentDetail AD ON B.BarberID = AD.BarberID\n"
                + "LEFT JOIN Invoice I ON AD.AppointmentID = I.AppointmentID AND I.Status = 2\n"
                + "    AND I.CheckOutDateTime >= CAST(DATEADD(DAY, -7, GETDATE()) AS DATE)\n"
                + "LEFT JOIN InvoiceDetail ID ON I.InvoiceID = ID.InvoiceID AND ID.ServiceID = AD.ServiceID\n"
                + "GROUP BY B.BarberID, B.FirstName, B.LastName\n"
                + "ORDER BY DoanhThu DESC";
        return XQuery.getRawList(sql);
    }

// 2. Dữ liệu khi Tìm kiếm (Theo khoảng ngày)
    public List<Object[]> getEmployeeStatisticsByDate(Date tuNgay, Date denNgay) {
        String sql = "SELECT \n"
                + "    B.FirstName + ' ' + B.LastName AS TenNV, \n"
                + "    ISNULL((SELECT TOP 1 S.ServiceName FROM AppointmentDetail AD2 \n"
                + "     JOIN Service S ON AD2.ServiceID = S.ServiceID \n"
                + "     JOIN Invoice I2 ON AD2.AppointmentID = I2.AppointmentID\n"
                + "     WHERE AD2.BarberID = B.BarberID \n"
                + "     AND I2.Status = 2 \n"
                + "     AND CAST(I2.CheckOutDateTime AS DATE) BETWEEN ? AND ? \n" // Thêm CAST
                + "     GROUP BY S.ServiceName ORDER BY COUNT(*) DESC), N'Chưa có') AS Chuyen, \n"
                + "    COUNT(DISTINCT I.InvoiceID) AS SoLuot, \n"
                + "    ISNULL(SUM(ID.Price), 0) AS DoanhThu,\n"
                + "    CASE \n"
                + "        WHEN COUNT(DISTINCT I.InvoiceID) >= 10 THEN N'Siêu cấp'\n"
                + "        ELSE N'Bình thường'\n"
                + "    END AS TrangThai\n"
                + "FROM Barber B\n"
                + "LEFT JOIN AppointmentDetail AD ON B.BarberID = AD.BarberID\n"
                + "LEFT JOIN Invoice I ON AD.AppointmentID = I.AppointmentID AND I.Status = 2\n"
                + "    AND CAST(I.CheckOutDateTime AS DATE) BETWEEN ? AND ? \n" // Thêm CAST
                + "LEFT JOIN InvoiceDetail ID ON I.InvoiceID = ID.InvoiceID AND ID.ServiceID = AD.ServiceID\n"
                + "GROUP BY B.BarberID, B.FirstName, B.LastName\n"
                + "ORDER BY DoanhThu DESC";

        // Đảm bảo truyền đủ 4 tham số cho 4 dấu hỏi trong SQL
        return XQuery.getRawList(sql, tuNgay, denNgay, tuNgay, denNgay);
    }

    // --- CÁC Ô TỔNG QUÁT PHÍA TRÊN ---
    public Double getTotalRevenueMonth() {
        String sql = "SELECT ISNULL(SUM(TotalAmount - TotalDiscount), 0) FROM Invoice "
                + "WHERE Status = 2 AND MONTH(CheckOutDateTime) = MONTH(GETDATE()) "
                + "AND YEAR(CheckOutDateTime) = YEAR(GETDATE())";
        List<Object[]> list = XQuery.getRawList(sql);
        return Double.parseDouble(list.get(0)[0].toString());
    }

    public Double getTotalRevenueWeek() {
        String sql = "SELECT ISNULL(SUM(TotalAmount - TotalDiscount), 0) FROM Invoice "
                + "WHERE Status = 2 AND CheckOutDateTime >= CAST(DATEADD(DAY, -7, GETDATE()) AS DATE)";
        List<Object[]> list = XQuery.getRawList(sql);
        if (list != null && !list.isEmpty() && list.get(0)[0] != null) {
            return Double.parseDouble(list.get(0)[0].toString());
        }
        return 0.0;
    }
}
