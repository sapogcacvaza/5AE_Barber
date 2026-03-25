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
   private int AppointmentID;
   private int duration; // Phút
   private BigDecimal price;
   private int quantity;
   private int barberID;
}
