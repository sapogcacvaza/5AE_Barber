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
public class InvoiceDiscount {
    private int discountID;
    private int invoiceID;
    private BigDecimal discountAmount;
}
