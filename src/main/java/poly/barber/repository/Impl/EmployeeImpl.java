/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.barber.repository.Impl;

import java.util.List;
import poly.barber.entity.Employee;
import poly.barber.repository.ICommonRepository;
import poly.barber.util.XJdbc;
import poly.barber.util.XQuery;


/**
 *
 * @author Dell
 */
public class EmployeeImpl implements ICommonRepository<Employee, Integer> {

    String sqlGetAll = "select EmployeeID,FirstName,LastName,Phone,Email,Gender,Address,PositionID from Employee";
    String sqlGetOne = "select EmployeeID,FirstName,LastName,Phone,Email,Gender,Address,PositionID from Employee where EmployeeID = ?";
    String sqlAdd = "insert into Employee values\n"
            + "(?,?,?,?,?,?,?)";
    String sqlDelete = "delete Employee where EmployeeID = ?";
    String sqlUpdate = "update Employee set FirstName = ?,LastName = ?,Phone = ?,Email = ?,Gender = ?,Address = ?,PositionID = ? where EmployeeID = ?";
    String sqlGetGender = "select *from Employee where Gender like ?";
    String sqlGetPosition = "SELECT * \n"
            + "FROM Employee\n"
            + "WHERE PositionID = ?;";
    String sqlSearchByName = "select * from Employee where LastName like ?";
    String sqlSearchByPhone = "select * from Employee where Phone like ?";
    String sqlSearchByEmail = "select * from Employee where Email like ?";
    
    
    
    public List<Employee> searchByEmail(String email){
        return XQuery.getBeanList(Employee.class, sqlSearchByEmail, "%"+email+"%");
    }
    public List<Employee> searchByPhone(String phone){
        return XQuery.getBeanList(Employee.class, sqlSearchByPhone, "%"+phone+"%");
    }
    public List<Employee> searchByName(String name){
        return XQuery.getBeanList(Employee.class, sqlSearchByName, "%"+name+"%");
    }
    public List<Employee> getPosition(int id) {
        return XQuery.getBeanList(Employee.class, sqlGetPosition, id);
    }

    public List<Employee> getGender(int id) {
        return XQuery.getBeanList(Employee.class, sqlGetGender, id);
    }

    @Override
    public List<Employee> getAll() {
        return XQuery.getBeanList(Employee.class, sqlGetAll);
    }

    @Override
    public Employee getOne(Integer id) {
        return XQuery.getSingleBean(Employee.class, sqlGetOne, id);
    }

    @Override
    public void add(Employee obj) {
        Object[] data = {obj.getFirstname(), obj.getLastname(), obj.getPhone(), obj.getEmail(), obj.isGender(), obj.getAddress(), obj.getPositionID()};
        XJdbc.executeUpdate(sqlAdd, data);
    }
        public int addReturnInt(Employee obj) {
        Object[] data = {obj.getFirstname(), obj.getLastname(), obj.getPhone(), obj.getEmail(), obj.isGender(), obj.getAddress(), obj.getPositionID()};
        return XJdbc.executeUpdate(sqlAdd, data);
    }

    @Override
    public void delete(Integer id) {
        XJdbc.executeUpdate(sqlDelete, id);
    }

    @Override
    public void update(Employee obj) {
        Object[] data = {obj.getFirstname(), obj.getLastname(), obj.getPhone(), obj.getEmail(), obj.isGender(), obj.getAddress(), obj.getPositionID(), obj.getEmployeeID()};
        XJdbc.executeUpdate(sqlUpdate, data);
    }

    public static void main(String[] args) {
        System.out.println(new EmployeeImpl().searchByPhone("0911111111"));
    }
}
