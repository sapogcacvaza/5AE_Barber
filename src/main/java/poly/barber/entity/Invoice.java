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

    private String barberName;
    private int invoiceID;
    private String invoiceCode; // Mã Hóa Đơn
    private LocalDateTime checkInDateTime;
    private LocalDateTime checkOutDateTime;
    private BigDecimal totalAmount;
    private BigDecimal totalDiscount;
    private int status;
    private int createdByEmployeeID;
    private int appointmentID;

    private String employeeName;

//    public String getEmployeeName() {
//        return employeeName;
//    }
//
//    public void setEmployeeName(String employeeName) {
//        this.employeeName = employeeName;
//    }
//
//    private String barberName;
//
//    public String getBarberName() {
//        return barberName;
//    }
//
//    public void setBarberName(String barberName) {
//        this.barberName = barberName;
//    }
//
//    public Invoice() {
//    }
//
//    public Invoice(int invoiceID, String invoiceCode, LocalDateTime checkInDateTime, LocalDateTime checkOutDateTime, BigDecimal totalAmount, BigDecimal totalDiscount, int status, int createdByEmployeeID, int appointmentID) {
//        this.invoiceID = invoiceID;
//        this.invoiceCode = invoiceCode;
//        this.checkInDateTime = checkInDateTime;
//        this.checkOutDateTime = checkOutDateTime;
//        this.totalAmount = totalAmount;
//        this.totalDiscount = totalDiscount;
//        this.status = status;
//        this.createdByEmployeeID = createdByEmployeeID;
//        this.appointmentID = appointmentID;
//    }
//
//    public int getInvoiceID() {
//        return invoiceID;
//    }
//
//    public void setInvoiceID(int invoiceID) {
//        this.invoiceID = invoiceID;
//    }
//
//    public String getInvoiceCode() {
//        return invoiceCode;
//    }
//
//    public void setInvoiceCode(String invoiceCode) {
//        this.invoiceCode = invoiceCode;
//    }
//
//    public LocalDateTime getCheckInDateTime() {
//        return checkInDateTime;
//    }
//
//    public void setCheckInDateTime(LocalDateTime checkInDateTime) {
//        this.checkInDateTime = checkInDateTime;
//    }
//
//    public LocalDateTime getCheckOutDateTime() {
//        return checkOutDateTime;
//    }
//
//    public void setCheckOutDateTime(LocalDateTime checkOutDateTime) {
//        this.checkOutDateTime = checkOutDateTime;
//    }
//
//    public BigDecimal getTotalAmount() {
//        return totalAmount;
//    }
//
//    public void setTotalAmount(BigDecimal totalAmount) {
//        this.totalAmount = totalAmount;
//    }
//
//    public BigDecimal getTotalDiscount() {
//        return totalDiscount;
//    }
//
//    public void setTotalDiscount(BigDecimal totalDiscount) {
//        this.totalDiscount = totalDiscount;
//    }
//
//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
//
//    public int getCreatedByEmployeeID() {
//        return createdByEmployeeID;
//    }
//
//    public void setCreatedByEmployeeID(int createdByEmployeeID) {
//        this.createdByEmployeeID = createdByEmployeeID;
//    }
//
//    public int getAppointmentID() {
//        return appointmentID;
//    }
//
//    public void setAppointmentID(int appointmentID) {
//        this.appointmentID = appointmentID;
//    }
//
//<<<<<<< HEAD
    public Invoice(BigDecimal totalAmount, int createdByEmployeeID, int appointmentID) {
        this.totalAmount = totalAmount;
        this.createdByEmployeeID = createdByEmployeeID;
        this.appointmentID = appointmentID;
    }
//
////=======
////>>>>>>> Khanh
}
