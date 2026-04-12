package poly.barber.entity;

import java.math.BigDecimal;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class InvoiceDetail {
    private int serviceID;
    private int InvoiceID;
    private int quantity;
    private BigDecimal price;

}
