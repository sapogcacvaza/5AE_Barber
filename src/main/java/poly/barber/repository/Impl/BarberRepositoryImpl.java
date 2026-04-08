package poly.barber.repository.Impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import poly.barber.entity.Barber;
import poly.barber.repository.ICommonRepository;
import poly.barber.util.XJdbc;
import poly.barber.util.XQuery;

public class BarberRepositoryImpl implements ICommonRepository<Barber, Integer> {

    String getAll = "select BarberID,IsBusy,Status,FirstName,LastName,Phone,Email,PositionID from Barber";
    String getOne = "select BarberID,IsBusy,Status,FirstName,LastName,Phone,Email,PositionID from Barber where BarberID = ?";
    String getOneByName = "select * from Barber where (Lastname + ' ' + Firstname) like ?";
    String getPositionNameByID = "select PositionName from BarberPosition where PositionID = ?";
    String sqlUpdate = "update Barber set Status = ?,FirstName = ?,LastName = ?, Phone = ?, Email = ?, PositionID = ? where BarberID = ?";
    String sqlAdd = "insert into Barber (Status,FirstName,LastName,Phone,Email,PositionID) values\n"
            + "(?,?,?,?,?,?)";
    String sqlDelete = "delete Barber where BarberID = ?";
    String sqlStatusFilter = "select *from Barber where Status = ?";
    String sqlIsBusyFilter = "select *from Barber where isBusy = ?";
    String updateStatus = "update Barber set Status = ? where BarberID = ?";
    String updateIsBusy = "update Barber set IsBusy = ? where BarberID = ?";

    public List<Barber> statusFilter(int id) {
        return XQuery.getBeanList(Barber.class, sqlStatusFilter, id);
    }

    public List<Barber> isBusyFilter(int id) {
        return XQuery.getBeanList(Barber.class, sqlIsBusyFilter, id);
    }

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

// Hàm gọi Procedure để lấy thợ rảnh theo lịch trình (Status 1, 4)
    public List<Barber> getBarbersBySchedule(LocalDate date, LocalTime time, String categoryName) {
        List<Barber> list = new ArrayList<>();
        String sql = "{CALL getListAvailableBarber(?, ?, ?)}";

        try (Connection con = XJdbc.openConnection(); CallableStatement cs = con.prepareCall(sql)) {

            cs.setDate(1, java.sql.Date.valueOf(date));
            cs.setTime(2, java.sql.Time.valueOf(time));
            cs.setNString(3, categoryName);

            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    list.add(readBarberFromResultSet(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Hàm lọc thợ dựa trên isBusy (Dùng khi khách đã đến - Status 2)
    public List<Barber> getBarbersByBusyStatus(int status) {
        List<Barber> list = new ArrayList<>();
        String sql = "SELECT * FROM Barber WHERE isBusy = ?";

        try (Connection con = XJdbc.openConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, status);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(readBarberFromResultSet(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Hàm bổ trợ đọc dữ liệu
    private Barber readBarberFromResultSet(ResultSet rs) throws SQLException {
        Barber b = new Barber();
        b.setBarberID(rs.getInt("BarberID"));
        b.setFirstname(rs.getNString("FirstName"));
        b.setLastname(rs.getNString("LastName"));
        b.setPositionID(rs.getInt("PositionID"));
        return b;
    }

    @Override
    public void add(Barber obj) {
        Object[] data = {obj.isStatus(), obj.getFirstname(), obj.getLastname(), obj.getPhone(), obj.getEmail(), obj.getPositionID()};
        XJdbc.executeUpdate(sqlAdd, data);
    }

    @Override
    public void delete(Integer id) {
        XJdbc.executeUpdate(sqlDelete, id);
    }

    @Override
    public void update(Barber obj) {
        Object[] data = {obj.isStatus(), obj.getFirstname(), obj.getLastname(), obj.getPhone(), obj.getEmail(), obj.getPositionID(), obj.getBarberID()};
        XJdbc.executeUpdate(sqlUpdate, data);
    }

    public static void main(String[] args) {
        System.out.println(new BarberRepositoryImpl().getAll());
    }

    public void updateStatus(int status, int barberID) {
        Object[] values = {
            status,
            barberID
        };
        XJdbc.executeUpdate(updateStatus, values);
    }

    public void updateIsBusy(boolean isBusy, int barberID) {
        Object[] values = {
            isBusy ? 1 : 0,
            barberID
        };
        XJdbc.executeUpdate(updateIsBusy, values);
    }

    public boolean isBarberFinishedAll(int appointmentID, int barberID) {
        String sql = "select count(*) from AppointmentDetail "
                + "where AppointmentID = ? and BarberID = ? and Status in (0,1)";
        try {
            Object res = XJdbc.getValue(sql, appointmentID, barberID);
            int count = Integer.parseInt(res.toString());
            return count == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
