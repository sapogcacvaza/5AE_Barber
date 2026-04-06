package poly.barber.service;

import poly.barber.entity.Account;
import poly.barber.repository.Impl.loginRepository;

public class AccountService {

    private loginRepository repo = new loginRepository();

    public Account login(String username, String password) {

        // 1. validate input
        if (username == null || username.trim().isEmpty()) {
            throw new RuntimeException("Username không được để trống");
        }

        if (password == null || password.trim().isEmpty()) {
            throw new RuntimeException("Password không được để trống");
        }

        // 2. tìm account
        Account acc = repo.findByUsername(username);

        // ❗ bảo mật: gộp lỗi
        if (acc == null || !password.equals(acc.getPassword())) {
            throw new RuntimeException("Sai tài khoản hoặc mật khẩu");
        }

        // 3. check status (nếu có cột Status)
        // if(acc.getStatus() == 0){
        //     throw new RuntimeException("Tài khoản đã bị khóa");
        // }

        return acc;
    }

    // 🔥 check quyền
    public boolean isAdmin(Account acc) {
        return acc.getRole() == 1;
    }

    public boolean isStaff(Account acc) {
        return acc.getRole() == 2;
    }
}