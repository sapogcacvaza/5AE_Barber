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
public class Discount {
    private int discountID;
    private String discountName;
    private int discountType;
    private BigDecimal discountValue;
    private String description;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private int status;
    private int maxUsage; // Số lượng tối đa
    private int usedCount; // Số lượng đã dùng. mặc định là 0
}
