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
}
