package poly.barber.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AppointmentDetail {

    private int serviceID;
    private int appointmentID;
    private int duration; // Phút
    private BigDecimal price;
    private int quantity;
    private int barberID;
    private int status;

    public AppointmentDetail(int serviceID, int appointmentID, int duration, BigDecimal price, int quantity, int barberID) {
        this.serviceID = serviceID;
        this.appointmentID = appointmentID;
        this.duration = duration;
        this.price = price;
        this.quantity = quantity;
        this.barberID = barberID;
    }

}
