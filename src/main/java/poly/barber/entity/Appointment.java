package poly.barber.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Appointment {
    
    private int appointmentID;
    private LocalDateTime createdDateTime;
    private LocalDateTime appointmentDateTime;
    private String note;
    private int totalDuration;
    private int status;
    private int createdByEmployeeID;
    private int customerID;
    private int appointmentCode;

    public Appointment(LocalDateTime appointmentDateTime, String note, int totalDuration, int createdByEmployeeID, int customerID) {
        this.appointmentDateTime = appointmentDateTime;
        this.note = note;
        this.totalDuration = totalDuration;
        this.createdByEmployeeID = createdByEmployeeID;
        this.customerID = customerID;
    }

}
