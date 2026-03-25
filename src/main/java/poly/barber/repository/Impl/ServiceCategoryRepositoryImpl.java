package poly.barber.repository.Impl;

import java.util.List;
import poly.barber.entity.ServiceCategory;
import poly.barber.repository.ICommonRepository;
import poly.barber.util.XQuery;

public class ServiceCategoryRepositoryImpl implements ICommonRepository<ServiceCategory, Integer> {

    String getAll = "select * from ServiceCategory";
    String getOne = "select * from ServiceCategory where ServiceCategoryID = ?";

    @Override
    public List<ServiceCategory> getAll() {
        return XQuery.getBeanList(ServiceCategory.class, getAll);
    }

    @Override
    public ServiceCategory getOne(Integer id) {
        return XQuery.getSingleBean(ServiceCategory.class, getOne, id);
    }

    @Override
    public void add(ServiceCategory obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(ServiceCategory obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
