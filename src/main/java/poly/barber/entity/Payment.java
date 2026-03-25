package poly.barber.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Payment {
    private int paymentID;
    private LocalDateTime createdDateTime;
    private BigDecimal Amount;
    private int invoiceID;
    private int paymentMethodID;
    
}
