package poly.barber.repository.Impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import poly.barber.entity.Barber;
import poly.barber.repository.ICommonRepository;
import poly.barber.util.XJdbc;
import poly.barber.util.XQuery;

public class BarberRepositoryImpl implements ICommonRepository<Barber, Integer> {

    String getAll = "select * from Barber";
    String getOne = "select * from Barber where id = ?";
    String getOneByName = "select * from Barber where (Lastname + ' ' + Firstname) like ?";
    String getPositionNameByID = "select PositionName from BarberPosition where PositionID = ?";

    @Override
    public List<Barber> getAll() {
        return XQuery.getBeanList(Barber.class, getAll);
    }

    @Override
    public Barber getOne(Integer id) {
        return XQuery.getSingleBean(Barber.class, getOne, id);
    }

    public Barber getOneByName(String name) {
        return XQuery.getSingleBean(Barber.class, getOneByName, "%" + name + "%");
    }

    public String getPositionNameByID(int id) {
        String positionName = null;

        try {
            ResultSet rs = XJdbc.executeQuery(getPositionNameByID, id);

            if (rs.next()) {
                positionName = rs.getString("PositionName");
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return positionName;
    }

    public List<Barber> getListAvailableBarber(LocalDate date, LocalTime time, String categoryName) {
        List<Barber> list = new ArrayList<>();

        // Câu lệnh gọi Store Procedure trong SQL Server
        String sql = "{CALL getListAvailableBarber(?, ?, ?)}";

        try (Connection con = XJdbc.openConnection(); CallableStatement cs = con.prepareCall(sql)) {

            // 1. Set tham số ngày (DATE)
            cs.setDate(1, java.sql.Date.valueOf(date));

            // 2. Set tham số giờ (TIME)
            cs.setTime(2, java.sql.Time.valueOf(time));

            // 3. Set tham số tên loại dịch vụ (NVARCHAR) -> Sửa từ int sang String
            cs.setNString(3, categoryName);

            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Barber b = new Barber();
                    b.setBarberID(rs.getInt("BarberID"));

                    // Lưu ý: Trong SQL mình dùng CONCAT hoặc đặt Alias là FullName 
                    // Nếu bạn muốn lấy riêng lẻ thì SQL phải SELECT riêng Firstname, Lastname
                    b.setFirstname(rs.getNString("FirstName"));
                    b.setLastname(rs.getNString("LastName"));
                    b.setPositionID(rs.getInt("PositionID"));

                    // Nếu trong model Barber có trường PositionName thì set luôn:
                    // b.setPositionName(rs.getNString("PositionName"));
                    list.add(b);
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi lấy danh sách thợ trống: " + e.getMessage());
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void add(Barber obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Barber obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
