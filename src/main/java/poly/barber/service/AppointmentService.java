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

        // Lấy thứ 2 tuần hiện tại
        LocalDate startOfWeek = today.with(DayOfWeek.MONDAY);

        // 🔥 Điều chỉnh theo combobox
        if (index == 0) {
            startOfWeek = startOfWeek.minusWeeks(1); // tuần trước
        } else if (index == 2) {
            startOfWeek = startOfWeek.plusWeeks(1); // tuần sau
        }
        // index == 1 → giữ nguyên (tuần này)

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

    public List<Object[]> getUniversalCalendar(int weekIndex, int status, String barber, String customer) {
        return repo.getUniversalCalendar(weekIndex, status, barber, customer);
    }

    public List<String> getAppointmentHtmlDetails(java.sql.Date targetDate, java.util.Date targetTime) {
        // Chuyển đổi từ java.util.Date sang java.sql.Time để khớp với Repository
        java.sql.Time sqlTime = new java.sql.Time(targetTime.getTime());

        // Gọi sang Repository để lấy dữ liệu
        return repo.getAppointmentHtmlDetails(targetDate, sqlTime);
    }

    public List<String> fillToComboTimeRange() {
        List<String> times = new ArrayList<>();

        LocalTime start = LocalTime.of(8, 0);
        LocalTime end = LocalTime.of(21, 30);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        times.add("");

        while (!start.isAfter(end)) {
            times.add(start.format(formatter));
            start = start.plusMinutes(30);
        }

        return times;
    }

}
