package poly.barber.repository.Impl;

import java.util.List;
import poly.barber.entity.Customer;
import poly.barber.repository.ICommonRepository;
import poly.barber.util.XQuery;

public class CustomerRepositoryImpl implements ICommonRepository<Customer, Integer> {

    String getAll = "select * from Customer";
    String getOne = "select * from Customer where CustomerID = ?";
    String getOneByName = "select * from Customer where Fullname like ?";

    @Override
    public List<Customer> getAll() {
        return XQuery.getBeanList(Customer.class, getAll);
    }

    @Override
    public Customer getOne(Integer id) {
        return XQuery.getSingleBean(Customer.class, getOne, id);
    }

    public Customer getOneByName(String name) {
        return XQuery.getSingleBean(Customer.class, getOneByName, "%" + name + "%");
    }

    @Override
    public void add(Customer obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Customer obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
