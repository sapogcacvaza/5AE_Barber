/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.barber.repository;

import java.util.List;
import poly.barber.entity.Service;
import poly.barber.util.XQuery;
/**
 *
 * @author DELL
 */
public class ServiceRepository implements ICommonRepository<Service, Integer>{
    private final String SELECT_ALL = "SELECT ServiceID, ServiceName, Price, Duration, ServiceCategoryID FROM Service";
    private final String SELECT_BY_ID = "SELECT * FROM Service WHERE ServiceID = ?";
    private final String INSERT_SQL = "INSERT INTO Service (ServiceName, Price, Duration, ServiceCategoryID) VALUES (?, ?, ?, ?)";
    private final String UPDATE_SQL = "UPDATE Service SET ServiceName = ?, Price = ?, Duration = ?, ServiceCategoryID = ? WHERE ServiceID = ?";
    private final String DELETE_SQL = "DELETE FROM Service WHERE ServiceID = ?";

    @Override
    public List<Service> getAll() {
        return XQuery.getBeanList(Service.class, SELECT_ALL);
    }

    @Override
    public Service getOne(Integer id) {
        return XQuery.getSingleBean(Service.class, SELECT_BY_ID, id);
    }

    @Override
    public void add(Service obj) {
        XQuery.update(INSERT_SQL, 
                obj.getServiceName(), 
                obj.getPrice(), 
                obj.getDuration(), 
                obj.getServiceCategoryID());
    }

    @Override
    public void update(Service obj) {
        XQuery.update(UPDATE_SQL, 
                obj.getServiceName(), 
                obj.getPrice(), 
                obj.getDuration(), 
                obj.getServiceCategoryID(), 
                obj.getServiceID());
    }

    @Override
    public void delete(Integer id) {
        XQuery.update(DELETE_SQL, id);
    }

    public List<Service> getByType(int categoryId) {
        String sql = "SELECT * FROM Service WHERE ServiceCategoryID = ?";
        return XQuery.getBeanList(Service.class, sql, categoryId);
    }

    public Service getByName(String ten) {
        String sql = "SELECT * FROM Service WHERE LTRIM(RTRIM(ServiceName)) = ?";
        return XQuery.getSingleBean(Service.class, sql, ten.trim());
    }
}

