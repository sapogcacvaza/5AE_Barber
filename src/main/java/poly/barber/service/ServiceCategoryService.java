package poly.barber.service;

import java.util.ArrayList;
import java.util.List;
import poly.barber.entity.ServiceCategory;
import poly.barber.repository.Impl.ServiceCategoryRepositoryImpl;

public class ServiceCategoryService {

    ServiceCategoryRepositoryImpl repo = new ServiceCategoryRepositoryImpl();

    public List<String> fillToComboServiceCategoryName(List<ServiceCategory> lst) {
        List<String> categoryName = new ArrayList<>();

        categoryName.add(" ");

        for (ServiceCategory sc : lst) {
            categoryName.add(sc.getServiceCategoryName());
        }

        return categoryName;
    }

    public List<ServiceCategory> getAll() {
        return repo.getAll();
    }

    public ServiceCategory getOne(int id) {
        return repo.getOne(id);
    }

    public ServiceCategory getOneByName(String name) {
        return repo.getOneByName(name);
    }
}
