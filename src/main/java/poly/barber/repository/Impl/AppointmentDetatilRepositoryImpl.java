package poly.barber.repository.Impl;

import java.util.List;
import poly.barber.entity.AppointmentDetail;
import poly.barber.repository.ICommonRepository;
import poly.barber.util.XQuery;

public class AppointmentDetatilRepositoryImpl implements ICommonRepository<AppointmentDetail, Integer> {

    String getAll = "select * from AppointmentDetail";

    String getAllByAppID = "select * from AppointmentDetail where AppointmentID = ?";

    @Override
    public List<AppointmentDetail> getAll() {
        return XQuery.getBeanList(AppointmentDetail.class, getAll);
    }

    public List<AppointmentDetail> getAllByAppID(int appointmentID) {
        return XQuery.getBeanList(AppointmentDetail.class, getAllByAppID, appointmentID);
    }

    @Override
    public AppointmentDetail getOne(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(AppointmentDetail obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(AppointmentDetail obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
