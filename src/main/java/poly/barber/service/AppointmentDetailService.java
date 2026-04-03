package poly.barber.service;

import java.util.List;
import poly.barber.entity.AppointmentDetail;
import poly.barber.repository.Impl.AppointmentDetatilRepositoryImpl;

public class AppointmentDetailService {

    AppointmentDetatilRepositoryImpl repo = new AppointmentDetatilRepositoryImpl();

    public List<AppointmentDetail> getAll() {
        return repo.getAll();
    }

    public List<AppointmentDetail> getAllByAppID(int appointmentID) {
        return repo.getAllByAppID(appointmentID);
    }

    public void add(AppointmentDetail obj) {
        repo.add(obj);
    }

    public List<AppointmentDetail> getAllByAppCode(String appointmentCode) {
        return repo.getAllByAppCode(appointmentCode);
    }

    public void updateStatus(int status, int appointmentID, int serviceID) {
        repo.updateStatus(status, appointmentID, serviceID);
    }

    public void updateStatusByAppID(int status, int appointmentID) {
        repo.updateStatusByAppID(status, appointmentID);
    }
}
