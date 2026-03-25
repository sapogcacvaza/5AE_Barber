package poly.barber.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Barber {
    private int barberID;
    private boolean isBusy;
    private boolean status;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private int positionID;
}
