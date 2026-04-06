package poly.barber.service;

import java.util.ArrayList;
import java.util.List;
import poly.barber.entity.Service;
import poly.barber.repository.Impl.ServiceRepositoryImpl;

public class ServiceService {

    ServiceRepositoryImpl repo = new ServiceRepositoryImpl();

    public List<String> fillToComboServiceName(List<Service> lst) {
        List<String> serviceName = new ArrayList<>();

        serviceName.add(" ");

        for (Service s : lst) {
            serviceName.add(s.getServiceName());
        }

        return serviceName;
    }

    public List<Service> getAll() {
        return repo.getAll();
    }

    public Service getOne(int id) {
        return repo.getOne(id);
    }

    public Service getOneByName(String name) {
        return repo.getOneByName(name);
    }

    public List<Service> getOneByCat(int id) {
        return repo.getOneByCat(id);
    }
}
