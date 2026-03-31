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
}
