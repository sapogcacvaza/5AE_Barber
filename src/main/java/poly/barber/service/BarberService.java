package poly.barber.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import poly.barber.entity.Barber;
import poly.barber.repository.Impl.BarberRepositoryImpl;

public class BarberService {

    BarberRepositoryImpl repo = new BarberRepositoryImpl();

    public List<Barber> getAll() {
        return repo.getAll();
    }

    public Barber getOne(int id) {
        return repo.getOne(id);
    }

    public Barber getOneByName(String name) {
        return repo.getOneByName(name);
    }

    public String getPositionNameByID(int id) {
        return repo.getPositionNameByID(id);
    }

    public List<String> fillToComboBarberName(List<Barber> lst) {
        List<String> barberName = new ArrayList<>();

        barberName.add(" ");

        for (Barber b : lst) {
            barberName.add(b.getLastname() + " " + b.getFirstname());
        }

        return barberName;
    }

    public List<Barber> getListAvailableBarber(LocalDate date, LocalTime time, String categoryName) {
        return repo.getBarbersBySchedule(date, time, categoryName);
    }

    public void updateStatus(int status, int barberID) {
        repo.updateStatus(status, barberID);
    }

    public void updateIsBusy(boolean isBusy, int barberID) {
        repo.updateIsBusy(isBusy, barberID);
    }

    public boolean isBarberFinishedAll(int appointmentID, int barberID) {
        return repo.isBarberFinishedAll(appointmentID, barberID);
    }
}
