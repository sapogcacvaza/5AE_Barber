package poly.barber.repository.Impl;

import java.util.Date;
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
public class StatisticalRepositoryImpl {

    public List<Object[]> getRevenueLast8Days() {
        String sql = "SELECT FORMAT(CheckOutDateTime, 'dd/MM') AS Ngay, SUM(TotalAmount) AS DoanhThu "
                + "FROM Invoice "
                + "WHERE Status = 1 "
                + "AND CheckOutDateTime >= CAST(DATEADD(DAY, -7, GETDATE()) AS DATE) " // Lấy từ 7 ngày trước + hôm nay = 8 ngày
                + "GROUP BY FORMAT(CheckOutDateTime, 'dd/MM'), CAST(CheckOutDateTime AS DATE) "
                + "ORDER BY CAST(CheckOutDateTime AS DATE) ASC";

        return XQuery.getRawList(sql);
    }

    // 1. Lấy lượng khách 8 ngày gần nhất (cho biểu đồ bên phải)
    public List<Object[]> getCustomerCountLast8Days() {
        String sql = "SELECT FORMAT(CheckOutDateTime, 'dd/MM') AS Ngay, COUNT(InvoiceID) AS SoKhach "
                + "FROM Invoice WHERE Status = 1 "
                + "AND CheckOutDateTime >= CAST(DATEADD(DAY, -7, GETDATE()) AS DATE) "
                + "GROUP BY FORMAT(CheckOutDateTime, 'dd/MM'), CAST(CheckOutDateTime AS DATE) "
                + "ORDER BY CAST(CheckOutDateTime AS DATE) ASC";
        return XQuery.getRawList(sql);
    }

// 2. Lấy dữ liệu tổng hợp (cho bảng phía dưới)
    public List<Object[]> getDailySummaryLast8Days() {
        String sql = "SELECT \n"
                + "    CONVERT(VARCHAR, CheckInDateTime, 103) as Ngay, -- Trả về dd/MM/yyyy\n"
                + "    COUNT(InvoiceID) as LuongKhach,\n"
                + "    SUM(TotalAmount - TotalDiscount) as DoanhThu\n"
                + "FROM Invoice\n"
                + "WHERE CheckInDateTime >= DATEADD(DAY, -7, CAST(GETDATE() AS DATE)) -- Lấy từ 7 ngày trước đến nay\n"
                + "GROUP BY CONVERT(VARCHAR, CheckInDateTime, 103)\n"
                + "ORDER BY MAX(CheckInDateTime) ASC; -- Sắp xếp từ cũ đến mới cho biểu đồ đẹp";
        return XQuery.getRawList(sql);
    }

    public List<Object[]> getStatisticalByDate(Date tuNgay, Date denNgay) {
        // Câu lệnh SQL gọi Procedure hoặc SELECT trực tiếp
        // Đảm bảo kết quả trả về đúng thứ tự: {Ngày, Lượng khách, Doanh thu}
        String sql = "{CALL sp_ThongKeTheoKhoangNgay(?, ?)}";

        // Sử dụng trực tiếp phương thức getRawList đã có trong lớp XQuery của bạn
        return XQuery.getRawList(sql, tuNgay, denNgay);
    }

    // --- PHẦN BỔ SUNG CHO TAB DỊCH VỤ ---
    /**
     * Lấy dữ liệu tổng hợp cho Tab Dịch vụ (Bảng + 2 Biểu đồ) Trả về: {TenDV,
     * SoLuot, DoanhThu, TrangThai}
     */
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
                + "WHERE i.Status = 1 AND i.CheckOutDateTime BETWEEN ? AND ? \n"
                + "GROUP BY dv.ServiceName\n"
                + "ORDER BY SoLuot DESC";

        // Lưu ý: Bạn cần kiểm tra lại tên bảng (Service, InvoiceDetail) 
        // và tên cột (ServiceName, ServiceID) cho khớp với Database của bạn.
        return XQuery.getRawList(sql, tuNgay, denNgay);
    }

    /**
     * Lấy dữ liệu mặc định khi vừa mở Tab Dịch vụ (Thường là tháng hiện tại)
     */
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
                + "WHERE i.Status = 1 AND MONTH(i.CheckOutDateTime) = MONTH(GETDATE()) \n"
                + "AND YEAR(i.CheckOutDateTime) = YEAR(GETDATE())\n"
                + "GROUP BY dv.ServiceName\n"
                + "ORDER BY SoLuot DESC";

        return XQuery.getRawList(sql);

    }

    // --- PHẦN BỔ SUNG CHO TAB NHÂN VIÊN ---
    /**
     * Lấy dữ liệu mặc định cho Tab Nhân viên (8 ngày gần nhất) Trả về: {TenNV,
     * ChucVu, SoHoaDon, DoanhThu, TrangThai}
     */
    public List<Object[]> getEmployeeStatisticsDefault() {
        String sql = "SELECT \n"
                + "    E.FirstName + ' ' + E.LastName AS TenNV, \n"
                + "    EP.PositionName, \n"
                + "    COUNT(I.InvoiceID) AS SoHoaDon, \n"
                + "    ISNULL(SUM(I.TotalAmount), 0) AS DoanhThu,\n"
                + "    CASE \n"
                + "        WHEN COUNT(I.InvoiceID) >= 5 THEN N' Xuất Sắc'\n"
                + "        WHEN COUNT(I.InvoiceID) = 0 THEN N' Lười'\n"
                + "        ELSE N'Tích cực'\n"
                + "    END AS TrangThai\n"
                + "FROM Employee E\n"
                + "JOIN EmployeePosition EP ON E.PositionID = EP.PositionID\n"
                + "LEFT JOIN Invoice I ON E.EmployeeID = I.CreatedByEmployeeID \n"
                + "    AND I.Status = 1 \n"
                + "    AND I.CheckOutDateTime >= CAST(DATEADD(DAY, -7, GETDATE()) AS DATE)\n"
                + "GROUP BY E.EmployeeID, E.FirstName, E.LastName, EP.PositionName\n"
                + "ORDER BY DoanhThu DESC";

        return XQuery.getRawList(sql);
    }

    /**
     * Tìm kiếm hiệu suất nhân viên theo khoảng ngày
     */
    public List<Object[]> getEmployeeStatisticsByDate(Date tuNgay, Date denNgay) {
        String sql = "SELECT \n"
                + "    E.FirstName + ' ' + E.LastName AS TenNV, \n"
                + "    EP.PositionName, \n"
                + "    COUNT(I.InvoiceID) AS SoHoaDon, \n"
                + "    SUM(I.TotalAmount) AS DoanhThu,\n"
                + "    CASE \n"
                + "        WHEN COUNT(I.InvoiceID) >= 15 THEN N' Xuất Sắc'\n"
                
                + "        ELSE N'Quá Lười'\n"
                + "    END AS TrangThai\n"
                + "FROM Employee E\n"
                + "JOIN EmployeePosition EP ON E.PositionID = EP.PositionID\n"
                + "LEFT JOIN Invoice I ON E.EmployeeID = I.CreatedByEmployeeID \n"
                + "    AND I.Status = 1 \n"
                + "    AND I.CheckOutDateTime BETWEEN ? AND ? \n"
                + "GROUP BY E.EmployeeID, E.FirstName, E.LastName, EP.PositionName\n"
                + "ORDER BY DoanhThu DESC";

        return XQuery.getRawList(sql, tuNgay, denNgay);
    }

    // Lấy tổng doanh thu tháng hiện tại
    public Double getTotalRevenueMonth() {
        // Thêm ISNULL để tránh lỗi NULL từ Database
        String sql = "SELECT ISNULL(SUM(TotalAmount - TotalDiscount), 0) FROM Invoice "
                + "WHERE Status = 1 AND MONTH(CheckOutDateTime) = MONTH(GETDATE()) "
                + "AND YEAR(CheckOutDateTime) = YEAR(GETDATE())";
        List<Object[]> list = XQuery.getRawList(sql);
        return Double.parseDouble(list.get(0)[0].toString());
    }

// Lấy tổng doanh thu 7 ngày gần nhất (Tuần)
    public Double getTotalRevenueWeek() {
        String sql = "SELECT SUM(TotalAmount - TotalDiscount) FROM Invoice "
                + "WHERE Status = 1 AND CheckOutDateTime >= CAST(DATEADD(DAY, -7, GETDATE()) AS DATE)";
        List<Object[]> list = XQuery.getRawList(sql);
        if (list != null && !list.isEmpty() && list.get(0)[0] != null) {
            return Double.parseDouble(list.get(0)[0].toString());
        }
        return 0.0;
    }

}
