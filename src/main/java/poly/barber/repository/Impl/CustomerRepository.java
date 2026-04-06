/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.barber.repository.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import poly.barber.repository.ICommonRepository;
import poly.barber.util.XJdbc;

/**
 *
 * @author DELL
 */
public class CustomerRepository implements ICommonRepository<Object, Object>{

        String sql = "SELECT c.Fullname, c.Phone " +
                 "FROM Invoice i " +
                 "JOIN Appointment a ON i.AppointmentID = a.AppointmentID " +
                 "JOIN Customer c ON a.CustomerID = c.CustomerID " +
                 "WHERE i.InvoiceID = ?";
    public String[] getCustomerInfoByInvoiceId(int invoiceId) {
        try {
            // Sử dụng XJdbc để thực thi câu lệnh select
            ResultSet rs = XJdbc.executeQuery(sql, invoiceId);
            
            if (rs.next()) {
                return new String[]{
                    rs.getString("Fullname"),
                    rs.getString("Phone")
                };
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; 
    }

    // Các phương thức Override tạm thời để trống nếu chưa dùng tới
    @Override
    public List<Object> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getOne(Object id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
