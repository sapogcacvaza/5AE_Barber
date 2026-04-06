/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.barber.repository.Impl;

import java.util.List;
import poly.barber.entity.ServiceCategory;
import poly.barber.repository.ICommonRepository;
import poly.barber.util.XQuery;

/**
 *
 * @author DELL
 */
public class ServiceCategoryRepository implements ICommonRepository<ServiceCategory, Integer> {

    private final String SELECT_ALL = "SELECT ServiceCategoryID, ServiceCategoryName FROM ServiceCategory ORDER BY ServiceCategoryID ASC";
    private final String SELECT_BY_ID = "SELECT * FROM ServiceCategory WHERE ServiceCategoryID = ?";
    private final String INSERT_SQL = "INSERT INTO ServiceCategory (ServiceCategoryName) VALUES (?)";
    private final String UPDATE_SQL = "UPDATE ServiceCategory SET ServiceCategoryName = ? WHERE ServiceCategoryID = ?";
    private final String DELETE_SQL = "DELETE FROM ServiceCategory WHERE ServiceCategoryID = ?";

    public List<ServiceCategory> getAll() {
        return XQuery.getBeanList(ServiceCategory.class, SELECT_ALL);
    }

    public ServiceCategory getByName(String ten) {
        String sql = "SELECT * FROM ServiceCategory WHERE LTRIM(RTRIM(ServiceCategoryName)) = ?";
        return XQuery.getSingleBean(ServiceCategory.class, sql, ten.trim());
    }

    @Override
    public ServiceCategory getOne(Integer id) {
        return XQuery.getSingleBean(ServiceCategory.class, SELECT_BY_ID, id);
    }

    @Override
    public void add(ServiceCategory obj) {
        XQuery.update(INSERT_SQL,
                obj.getServiceCategoryName());
    }

    @Override
    public void delete(Integer id) {
        XQuery.update(DELETE_SQL, id);
    }

    @Override
    public void update(ServiceCategory obj) {
        XQuery.update(UPDATE_SQL,
                obj.getServiceCategoryName(),
                obj.getServiceCategoryID());
    }

}
