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
public class Invoice {
    private int invoiceID;
    private LocalDateTime checkInDateTime;
    private LocalDateTime checkOutDateTime;
    private BigDecimal totalAmount;
    private BigDecimal totalDiscount;
    private int status;
    private int createdByEmployeeID;
    private int appointmentID;
}
