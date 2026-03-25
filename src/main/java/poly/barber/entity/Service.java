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
public class Service {
    private int serviceID;
    private String serviceName;
    private BigDecimal price;
    private int duration; // Phút
    private int serviceCategoryID;
}
