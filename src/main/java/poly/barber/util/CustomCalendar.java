package poly.barber.util;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class CustomCalendar extends JPanel {

    private DateSelectListener listener;
    private JLabel lblMonthYear;
    private JPanel pnDays;
    private Calendar calendar;

    // Phương thức để gắn listener từ bên ngoài (ví dụ từ AppointmentJDialog)
    public void setOnDateSelected(DateSelectListener listener) {
        this.listener = listener;
    }

    public CustomCalendar() {
        setLayout(new BorderLayout());
        calendar = new GregorianCalendar(); // Lấy thời gian hiện tại

        // --- 1. Header: Điều hướng tháng ---
        JPanel pnHeader = new JPanel(new BorderLayout());
        pnHeader.setBackground(new Color(240, 240, 240));
        
        JButton btnPrev = new JButton("<");
        JButton btnNext = new JButton(">");
        lblMonthYear = new JLabel("", SwingConstants.CENTER);
        lblMonthYear.setFont(new Font("Segoe UI", Font.BOLD, 14));

        updateHeader();

        btnPrev.addActionListener(e -> {
            calendar.add(Calendar.MONTH, -1);
            updateCalendar();
        });

        btnNext.addActionListener(e -> {
            calendar.add(Calendar.MONTH, 1);
            updateCalendar();
        });

        pnHeader.add(btnPrev, BorderLayout.WEST);
        pnHeader.add(lblMonthYear, BorderLayout.CENTER);
        pnHeader.add(btnNext, BorderLayout.EAST);

        // --- 2. Weekday Bar: Hiển thị thứ ---
        JPanel pnWeekDays = new JPanel(new GridLayout(1, 7));
        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : days) {
            JLabel lbl = new JLabel(day, SwingConstants.CENTER);
            lbl.setForeground(Color.GRAY);
            pnWeekDays.add(lbl);
        }

        // --- 3. Days Grid: Hiển thị các ngày ---
        pnDays = new JPanel(new GridLayout(0, 7));

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(pnHeader, BorderLayout.NORTH);
        topPanel.add(pnWeekDays, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);
        add(pnDays, BorderLayout.CENTER);

        updateCalendar();
    }

    private void updateHeader() {
        String monthName = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
        int year = calendar.get(Calendar.YEAR);
        lblMonthYear.setText(monthName + " " + year);
    }

    public void updateCalendar() {
        updateHeader();
        pnDays.removeAll();

        // Tạo bản sao để tính toán mà không làm thay đổi biến calendar gốc
        Calendar tempCal = (Calendar) calendar.clone();
        tempCal.set(Calendar.DAY_OF_MONTH, 1); 

        int startDay = tempCal.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = tempCal.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Thêm các ô trống nếu ngày đầu tháng không phải Chủ Nhật
        for (int i = 1; i < startDay; i++) {
            pnDays.add(new JLabel(""));
        }

        // Tạo nút cho từng ngày
        for (int day = 1; day <= daysInMonth; day++) {
            JButton btnDay = new JButton(String.valueOf(day));
            btnDay.setMargin(new Insets(5, 5, 5, 5));
            btnDay.setFocusPainted(false);
            btnDay.setBackground(Color.WHITE);

            // Highlight ngày hôm nay
            Calendar today = Calendar.getInstance();
            if (day == today.get(Calendar.DATE)
                    && calendar.get(Calendar.MONTH) == today.get(Calendar.MONTH)
                    && calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR)) {
                btnDay.setBackground(new Color(173, 216, 230)); // Light Blue
                btnDay.setForeground(Color.BLACK);
            }

            // Xử lý sự kiện khi chọn ngày
            btnDay.addActionListener(e -> {
                int selectedDay = Integer.parseInt(btnDay.getText());
                int selectedMonth = calendar.get(Calendar.MONTH) + 1;
                int selectedYear = calendar.get(Calendar.YEAR);
                
                // Định dạng chuỗi ngày tháng (dd/MM/yyyy)
                String dateStr = String.format("%02d/%02d/%d", selectedDay, selectedMonth, selectedYear);
                
                if (listener != null) {
                    listener.onDateSelected(dateStr);
                }
            });

            pnDays.add(btnDay);
        }

        pnDays.revalidate();
        pnDays.repaint();
    }
}