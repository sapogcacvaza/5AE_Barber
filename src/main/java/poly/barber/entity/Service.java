package poly.barber.entity;

import java.math.BigDecimal;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;

//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Data
public class Service {
    private int serviceID;
    private String serviceName;
    private BigDecimal price;
    private int duration; // Phút
    private int serviceCategoryID;

    public Service() {
    }

    @Override
    public String toString() {
        return "Service{" + "serviceCategoryID=" + serviceCategoryID + '}';
    }

    public Service(int serviceID, String serviceName, BigDecimal price, int duration, int serviceCategoryID) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.price = price;
        this.duration = duration;
        this.serviceCategoryID = serviceCategoryID;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getServiceCategoryID() {
        return serviceCategoryID;
    }

    public void setServiceCategoryID(int serviceCategoryID) {
        this.serviceCategoryID = serviceCategoryID;
    }

}
