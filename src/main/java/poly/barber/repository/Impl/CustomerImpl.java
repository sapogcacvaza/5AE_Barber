/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.barber.repository.Impl;

import java.util.List;
import poly.barber.entity.Customer;
import poly.barber.repository.ICommonRepository;
import poly.barber.util.XJdbc;
import poly.barber.util.XQuery;

/**
 *
 * @author Dell
 */
public class CustomerImpl implements ICommonRepository<Customer, Integer> {

    String sqlSearchByPhone = "select * from Customer where Phone like ?";
    String sqlSearchByName = "select * from Customer where Fullname like ?";
    String sqlGetAll = "select CustomerID,Fullname,Phone,Email,Gender,Note,CustomerCode from Customer";
    String sqlGetOne = "select CustomerID,Fullname,Phone,Email,Gender,Note from Customer where CustomerID = ?";
    String sqlGetGender = "select *from Customer  where Gender like ?";
    String sqlDeleteInvoiceDiscount = """
    DELETE FROM InvoiceDiscount 
    WHERE InvoiceID IN (
        SELECT InvoiceID FROM Invoice 
        WHERE AppointmentID IN (
            SELECT AppointmentID FROM Appointment WHERE CustomerID = ?
        )
    )
""";
    String sqlDeletePayment = """
    DELETE FROM Payment 
    WHERE InvoiceID IN (
        SELECT InvoiceID FROM Invoice 
        WHERE AppointmentID IN (
            SELECT AppointmentID FROM Appointment WHERE CustomerID = ?
        )
    )
""";
    String sqlDeleteInvoiceDetail = """
    DELETE FROM InvoiceDetail 
    WHERE InvoiceID IN (
        SELECT InvoiceID FROM Invoice 
        WHERE AppointmentID IN (
            SELECT AppointmentID FROM Appointment WHERE CustomerID = ?
        )
    )
""";
    String sqlDeleteDetail = """
    DELETE FROM AppointmentDetail 
    WHERE AppointmentID IN (
        SELECT AppointmentID FROM Appointment WHERE CustomerID = ?
    )
""";
    String sqlDeleteInvoice = """
    DELETE FROM Invoice 
    WHERE AppointmentID IN (
        SELECT AppointmentID FROM Appointment WHERE CustomerID = ?
    )
""";
    String sqlDeleteAppointment = "DELETE FROM Appointment WHERE CustomerID = ?";
    String sqlDeleteCustomer = "DELETE FROM Customer WHERE CustomerID = ?";
    String sqlAdd = "insert into Customer (Fullname,Phone,Email,Gender,Note) values\n"
            + "(?,?,?,?,?)";
    String sqlUpdate = "update Customer set Fullname = ?,Phone = ?,Email = ?,Gender = ?,Note = ?,CustomerCode = ? where CustomerID = ?";

    public List<Customer> searchByPhone(String phone) {
        return XQuery.getBeanList(Customer.class, sqlSearchByPhone, "%" + phone + "%");
    }

    public List<Customer> searchByName(String name) {
        return XQuery.getBeanList(Customer.class, sqlSearchByName, "%" + name + "%");
    }

    @Override

    public List<Customer> getAll() {
        return XQuery.getBeanList(Customer.class, sqlGetAll);
    }

    public List<Customer> getGender(int id) {
        return XQuery.getBeanList(Customer.class, sqlGetGender, id);
    }

    @Override
    public Customer getOne(Integer id) {
        return XQuery.getSingleBean(Customer.class, sqlGetOne, id);
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void add(Customer obj) {
        Object[] data = {obj.getFullname(), obj.getPhone(), obj.getEmail(), obj.isGender(), obj.getNote()};
        XJdbc.executeUpdate(sqlAdd, data);
    }

    @Override
    public void delete(Integer id) {

        XJdbc.executeUpdate(sqlDeletePayment, id);
        XJdbc.executeUpdate(sqlDeleteInvoiceDetail, id);
        XJdbc.executeUpdate(sqlDeleteInvoiceDiscount, id);
        XJdbc.executeUpdate(sqlDeleteDetail, id);
        XJdbc.executeUpdate(sqlDeleteInvoice, id);
        XJdbc.executeUpdate(sqlDeleteAppointment, id);
        XJdbc.executeUpdate(sqlDeleteCustomer, id);
    }

    @Override
    public void update(Customer obj) {
        Object[] data = {obj.getFullname(), obj.getPhone(), obj.getEmail(), obj.isGender(), obj.getNote(), obj.getCustomerCode(), obj.getCustomerID()};
        XJdbc.executeUpdate(sqlUpdate, data);
    }

    public static void main(String[] args) {
        System.out.println(new CustomerImpl().searchByPhone("004"));
    }
}
