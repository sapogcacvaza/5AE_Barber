package poly.barber.entity;

//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;

//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Data
public class ServiceCategory {
    private int serviceCategoryID;
    private String serviceCategoryName;

    @Override
    public String toString() {
        return this.serviceCategoryName;
    }
    public ServiceCategory() {
    }

    public ServiceCategory(int serviceCategoryID, String serviceCategoryName) {
        this.serviceCategoryID = serviceCategoryID;
        this.serviceCategoryName = serviceCategoryName;
    }

    public int getServiceCategoryID() {
        return serviceCategoryID;
    }

    public void setServiceCategoryID(int serviceCategoryID) {
        this.serviceCategoryID = serviceCategoryID;
    }

    public String getServiceCategoryName() {
        return serviceCategoryName;
    }

    public void setServiceCategoryName(String serviceCategoryName) {
        this.serviceCategoryName = serviceCategoryName;
    }
    
    
}
