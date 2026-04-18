package poly.barber.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PaymentMethod {

    private int paymentMethodID;
    private String paymentName;

    @Override
    public String toString() {
        return this.getPaymentName();
    }
}
