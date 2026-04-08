package poly.barber.service;

import poly.barber.entity.Account;
import poly.barber.repository.Impl.loginRepository;

public class AccountService {

    private loginRepository repo = new loginRepository();

    public Account login(String username, String password) {

        if (username == null || username.trim().isEmpty()) {
            throw new RuntimeException("Username không được để trống");
        }

        if (password == null || password.trim().isEmpty()) {
            throw new RuntimeException("Password không được để trống");
        }

        Account acc = repo.findByUsername(username);

        if (acc == null || !password.equals(acc.getPassword())) {
            throw new RuntimeException("Sai tài khoản hoặc mật khẩu");
        }

        return acc;
    }

    // 🔥 ROLE CHECK
    public boolean isAdmin(Account acc) {
        return acc.getRole() == 1;
    }

    public boolean isManager(Account acc) {
        return acc.getRole() == 2;
    }

    public boolean isStaff(Account acc) {
        return acc.getRole() == 3;
    }
}