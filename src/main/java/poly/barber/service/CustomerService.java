package poly.barber.service;

import java.util.ArrayList;
import java.util.List;
import poly.barber.entity.Customer;
import poly.barber.repository.Impl.CustomerRepositoryImpl;

public class CustomerService {

    CustomerRepositoryImpl repo = new CustomerRepositoryImpl();

    public List<Customer> getAll() {
        return repo.getAll();
    }

    public Customer getOne(int id) {
        return repo.getOne(id);
    }

    public Customer getOneByName(String name) {
        return repo.getOneByName(name);
    }

    public List<String> fillToComboCustomerName(List<Customer> lst) {
        List<String> customerName = new ArrayList<>();

        customerName.add(" ");

        for (Customer sc : lst) {
            customerName.add(sc.getFullname());
        }

        return customerName;
    }

}
