package poly.barber.repository.Impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import poly.barber.entity.Appointment;
import poly.barber.entity.AppointmentDetail;
import poly.barber.repository.ICommonRepository;
import poly.barber.util.XJdbc;
import poly.barber.util.XQuery;

public class AppointmentRepositoryImpl implements ICommonRepository<Appointment, Integer> {

    String getAll = "select * from Appointment";
    String getAllWhereStatusIsWaiting = "select * from Appointment where Status = 1 or Status = 2 or Status = 4";

    String getUniversalCalendar_ShowAll = "{CALL getUniversalCalendar_ShowAll(?, ?, ?, ?)}";
    String getOne = "select * from Appointment where AppointmentID = ?";
    String createSql = "insert into Appointment (AppointmentDateTime, Note, TotalDuration, CreatedByEmployeeID, CustomerID) values (?,?,?,?,?)";
    String createAndReturn = "insert into Appointment (AppointmentDateTime, Note, TotalDuration, CreatedByEmployeeID, CustomerID) values (?,?,?,?,?)"
            + "SELECT * FROM Appointment WHERE AppointmentID = SCOPE_IDENTITY();";
    String updateStatus = "update Appointment set Status = ? where AppointmentID = ?";

    @Override
    public List<Appointment> getAll() {
        return XQuery.getBeanList(Appointment.class, getAll);
    }

    public List<Appointment> getAllWhereStatusIsWaiting() {
        return XQuery.getBeanList(Appointment.class, getAllWhereStatusIsWaiting);
    }

    public List<Object[]> getUniversalCalendar(int weekIndex, int status, String barber, String customer) {
        List<Object[]> list = new ArrayList<>();
        // Tên Procedure mới có 4 tham số

        try (java.sql.Connection con = poly.barber.util.XJdbc.openConnection(); java.sql.CallableStatement cs = con.prepareCall(getUniversalCalendar_ShowAll)) {

            // Truyền các tham số vào Procedure
            cs.setInt(1, weekIndex);
            cs.setInt(2, status);
            cs.setString(3, barber);
            cs.setString(4, customer);

            try (java.sql.ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    Object[] row = new Object[8];
                    row[0] = rs.getString("Time");
                    row[1] = rs.getString("Monday");
                    row[2] = rs.getString("Tuesday");
                    row[3] = rs.getString("Wednesday");
                    row[4] = rs.getString("Thursday");
                    row[5] = rs.getString("Friday");
                    row[6] = rs.getString("Saturday");
                    row[7] = rs.getString("Sunday");

                    // Xử lý null để JTable hiển thị sạch sẽ
                    for (int i = 1; i < 8; i++) {
                        if (row[i] == null) {
                            row[i] = "";
                        }
                    }
                    list.add(row);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<String> getAppointmentHtmlDetails(java.sql.Date targetDate, java.sql.Time targetTime) {
        List<String> details = new ArrayList<>();
        String sql = "{call getAppointmentDetailsBySlot(?, ?)}";
        try (java.sql.Connection con = poly.barber.util.XJdbc.openConnection(); java.sql.CallableStatement cs = con.prepareCall(sql)) {
            cs.setDate(1, targetDate);
            cs.setTime(2, targetTime);
            try (java.sql.ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    details.add(rs.getNString("FullDetailHtml"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return details;
    }

    public boolean isConflict(int customerID, LocalDate appointmentDate, LocalTime appTime, int duration) {
        // Thêm một dấu ? cho tham số Date
        String sql = "{call sp_CheckCustomerAppointmentConflict(?, ?, ?, ?)}";
        try (Connection con = XJdbc.openConnection(); CallableStatement cs = con.prepareCall(sql)) {

            cs.setInt(1, customerID);
            // Truyền ngày (Date)
            cs.setDate(2, java.sql.Date.valueOf(appointmentDate));
            // Truyền giờ (Time)
            cs.setTime(3, java.sql.Time.valueOf(appTime));
            cs.setInt(4, duration);

            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                return rs.getInt("IsConflict") == 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Appointment getOne(Integer id) {
        return XQuery.getSingleBean(Appointment.class, getOne, id);
    }

    @Override
    public void add(Appointment obj) {
        Object[] values = {
            obj.getAppointmentDateTime(),
            obj.getNote(),
            obj.getTotalDuration(),
            obj.getCreatedByEmployeeID(),
            obj.getCustomerID()
        };
        XJdbc.executeQuery(createSql, values);
    }

    public Appointment addAndReturn(Appointment obj) {
        Object[] values = {
            obj.getAppointmentDateTime(),
            obj.getNote(),
            obj.getTotalDuration(),
            obj.getCreatedByEmployeeID(),
            obj.getCustomerID()
        };
        return XQuery.getSingleBean(Appointment.class, createAndReturn, values);
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Appointment obj) {
        Object[] values = {
            obj.getStatus(),
            obj.getAppointmentID()
        };

        XJdbc.executeUpdate(updateStatus, values);
    }

    public void updateStatus(int appointmentID, int status) {
        Object[] values = {
            status,
            appointmentID
        };

        XJdbc.executeUpdate(updateStatus, values);
    }

}
