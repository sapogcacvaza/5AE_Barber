package poly.barber.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Discount {
    private int discountID;
    private String discountCode; // ✅ thêm
    private String discountName;
    private int discountType;
    private BigDecimal discountValue;
    private String description;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private int status;
    private int maxUsage;
    private int usedCount;
    
    @Override
public String toString() {
    // Nếu DiscountType = 1 thì hiện %, ngược lại hiện VNĐ
    String unit = (this.discountType == 1) ? "%" : " VNĐ";
    return this.discountName + " (-" + this.discountValue + unit + ")";
}
}
