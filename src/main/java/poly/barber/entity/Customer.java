package poly.barber.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Customer {
    private int customerID;
    private String fullname;
    private String phone;
    private String email;
    private boolean gender;
    private String note;
}
