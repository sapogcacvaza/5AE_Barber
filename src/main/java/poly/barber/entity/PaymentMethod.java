package poly.barber.entity;

//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;

//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Data
public class PaymentMethod {
    private int paymentMethodID;
    private String paymentName;

    public PaymentMethod(int paymentMethodID, String paymentName) {
        this.paymentMethodID = paymentMethodID;
        this.paymentName = paymentName;
    }

    @Override
    public String toString() {
        return  paymentName;
    }

    public PaymentMethod() {
    }

    public int getPaymentMethodID() {
        return paymentMethodID;
    }

    public void setPaymentMethodID(int paymentMethodID) {
        this.paymentMethodID = paymentMethodID;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }
    
}
