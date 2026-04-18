package poly.barber.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Account {

    private int accountID;
    private String username;
    private String password;
    private int role; // 🔥 THÊM CÁI NÀY
    private int employeeID;

    public String getRoleName() {
        switch (this.role) {
            case 1:
                return "Admin";
            case 2:
                return "Quản lý";
            case 3:
                return "Nhân viên";
            default:
                return "Không xác định";
        }
    }

    @Override
    public String toString() {
        return username + " (" + getRoleName() + ")";
    }
}
