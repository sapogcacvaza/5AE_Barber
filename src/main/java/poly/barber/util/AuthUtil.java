package poly.barber.util;

import poly.barber.entity.Account;

public class AuthUtil {

    // ================= ROLE =================
    public static final int ADMIN = 1;
    public static final int MANAGER = 2;
    public static final int STAFF = 3;

    // ================= CHECK ROLE =================
    public static boolean isAdmin(Account u) {
        return u != null && u.getRole() == ADMIN;
    }

    public static boolean isManager(Account u) {
        return u != null && u.getRole() == MANAGER;
    }

    public static boolean isStaff(Account u) {
        return u != null && u.getRole() == STAFF;
    }

    public static boolean isLogin(Account u) {
        return u != null;
    }

    // ================= GROUP =================
    public static boolean isAdminOrManager(Account u) {
        return isAdmin(u) || isManager(u);
    }

    public static boolean isStaffOrAbove(Account u) {
        return isAdmin(u) || isManager(u) || isStaff(u);
    }

    // ================= PERMISSION (THEO ĐỀ BÀI) =================

    // 👤 Khách hàng
    public static boolean canCustomer(Account u) {
        return isLogin(u);
    }

    // 📅 ĐẶT LỊCH: ADMIN + MANAGER + STAFF
    public static boolean canAppointment(Account u) {
        return isStaffOrAbove(u);
    }

    // 💰 HÓA ĐƠN: ADMIN + MANAGER + STAFF
    public static boolean canInvoice(Account u) {
        return isStaffOrAbove(u);
    }

    // 💳 THANH TOÁN: ADMIN + MANAGER
    public static boolean canPayment(Account u) {
        return isAdminOrManager(u);
    }

    // 💈 BARBER: ADMIN + MANAGER
    public static boolean canBarber(Account u) {
        return isAdminOrManager(u);
    }

    // 👨‍💼 NHÂN VIÊN: ADMIN + MANAGER
    public static boolean canEmployee(Account u) {
        return isAdminOrManager(u);
    }

    // 💇‍♂️ DỊCH VỤ: ADMIN ONLY
    public static boolean canService(Account u) {
        return isAdmin(u);
    }

    // 🎟 GIẢM GIÁ: ADMIN ONLY
    public static boolean canDiscount(Account u) {
        return isAdmin(u);
    }

    // 📊 THỐNG KÊ: ADMIN ONLY
    public static boolean canStatistic(Account u) {
        return isAdmin(u);
    }

    // 👤 TÀI KHOẢN: ADMIN ONLY
    public static boolean canAccount(Account u) {
        return isAdmin(u);
    }

    // 📜 LỊCH SỬ: ADMIN + MANAGER + STAFF
    public static boolean canHistory(Account u) {
        return isStaffOrAbove(u);
    }
}