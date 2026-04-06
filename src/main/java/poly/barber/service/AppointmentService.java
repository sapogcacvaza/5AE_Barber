package poly.barber.service;

import java.time.DayOfWeek;
import static java.time.DayOfWeek.MONDAY;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import poly.barber.entity.Appointment;
import poly.barber.repository.Impl.AppointmentRepositoryImpl;

public class AppointmentService {

    AppointmentRepositoryImpl repo = new AppointmentRepositoryImpl();

    public List<String> getCalendarHeaderTables(int index) {
        List<String> days = new ArrayList<>();

        LocalDate today = LocalDate.now();

        LocalDate startOfWeek = today.with(DayOfWeek.MONDAY);

        if (index == 0) {
            startOfWeek = startOfWeek.minusWeeks(1); // tuần trước
        } else if (index == 2) {
            startOfWeek = startOfWeek.plusWeeks(1); // tuần sau
        }

        days.add("Time");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "E - dd/MM/yyyy",
                new java.util.Locale("vi", "VN")
        );

        for (int i = 0; i < 7; i++) {
            LocalDate day = startOfWeek.plusDays(i);
            days.add(day.format(formatter));
        }

        return days;
    }

    public List<Appointment> getAll() {
        return repo.getAll();
    }

    public List<Appointment> getAllWhereStatusIsWaiting(boolean today) {
        return repo.getAllWhereStatusIsWaiting(today);
    }

    public List<Object[]> getUniversalCalendar(int weekIndex, int status, String barber, String customer) {
        return repo.getUniversalCalendar(weekIndex, status, barber, customer);
    }

    public List<String> getAppointmentHtmlDetails(java.sql.Date targetDate, java.util.Date targetTime) {
        java.sql.Time sqlTime = new java.sql.Time(targetTime.getTime());
        return repo.getAppointmentHtmlDetails(targetDate, sqlTime);
    }

    public boolean isConflict(int customerID, LocalDate appointmentDate, LocalTime appointmentTime, int duration) {
        return repo.isConflict(customerID, appointmentDate, appointmentTime, duration);
    }

    public List<String> fillToComboTimeRange(boolean isToday) {
        List<String> times = new ArrayList<>();
        LocalTime start = LocalTime.of(8, 0);
        LocalTime now = LocalTime.now();
        LocalTime end = LocalTime.of(21, 30);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        times.add("");

        while (!start.isAfter(end)) {
            if (isToday) {
                LocalTime limitTime = now.plusMinutes(10);

                if (!start.isBefore(limitTime)) {
                    times.add(start.format(formatter));
                }
            } else {
                times.add(start.format(formatter));
            }

            start = start.plusMinutes(30);
        }

        return times;
    }

    public void add(Appointment obj) {
        repo.add(obj);
    }

    public Appointment addAndReturn(Appointment obj) {
        return repo.addAndReturn(obj);
    }

    public void updateStatus(int appointmentID, int status) {
        repo.updateStatus(appointmentID, status);
    }
    
    public int updateStatusAutomatically() {
        return repo.updateStatusAutomatically();
    }
}
