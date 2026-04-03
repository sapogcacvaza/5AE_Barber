package poly.barber.repository.Impl;

import java.util.List;
import poly.barber.entity.AppointmentDetail;
import poly.barber.repository.ICommonRepository;
import poly.barber.util.XJdbc;
import poly.barber.util.XQuery;

public class AppointmentDetatilRepositoryImpl implements ICommonRepository<AppointmentDetail, Integer> {

    String getAll = "select * from AppointmentDetail";
    String getAllByAppID = "select * from AppointmentDetail where AppointmentID = ?";
    String getAllByAppCode = "select * from AppointmentDetail where AppointmentCode = ?";
    String getOne = "select * from AppointmentDetail where AppointmentID = ? and ServiceID = ?";
    String createSql = "insert into AppointmentDetail (ServiceID, AppointmentID, Duration, Price, Quantity, BarberID) values (?,?,?,?,?,?)";
    String updateStatus = "update AppointmentDetail set Status = ? where AppointmentID = ? and ServiceID = ?";
    String updateStatusByAppID = "update AppointmentDetail set Status = ? where AppointmentID = ?";

    @Override
    public List<AppointmentDetail> getAll() {
        return XQuery.getBeanList(AppointmentDetail.class, getAll);
    }

    public List<AppointmentDetail> getAllByAppID(int appointmentID) {
        return XQuery.getBeanList(AppointmentDetail.class, getAllByAppID, appointmentID);
    }

    public List<AppointmentDetail> getAllByAppCode(String appointmentCode) {
        return XQuery.getBeanList(AppointmentDetail.class, getAllByAppCode, appointmentCode);
    }

    @Override
    public AppointmentDetail getOne(Integer id) {
        return XQuery.getSingleBean(AppointmentDetail.class, getOne, id);
    }

    @Override
    public void add(AppointmentDetail obj) {
        Object[] values = {
            obj.getServiceID(),
            obj.getAppointmentID(),
            obj.getDuration(),
            obj.getPrice(),
            obj.getQuantity(),
            obj.getBarberID()
        };
        XJdbc.executeUpdate(createSql, values);
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(AppointmentDetail obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void updateStatus(int status, int appointmentID, int serviceID) {
        Object[] values = {
            status,
            appointmentID,
            serviceID
        };

        XJdbc.executeUpdate(updateStatus, values);
    }

    public void updateStatusByAppID(int status, int appointmentID) {
        Object[] values = {
            status,
            appointmentID
        };

        XJdbc.executeUpdate(updateStatusByAppID, values);
    }

}
