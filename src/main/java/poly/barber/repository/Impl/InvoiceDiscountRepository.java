/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.barber.repository.Impl;

import java.util.List;
import poly.barber.entity.InvoiceDiscount;
import poly.barber.repository.ICommonRepository;
import poly.barber.util.XJdbc;

/**
 *
 * @author DELL
 */
public class InvoiceDiscountRepository implements ICommonRepository{

    @Override
    public List getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object getOne(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(Object obj) {
        InvoiceDiscount invDisc = (InvoiceDiscount) obj; // Ép kiểu về Entity của bạn
    String sql = "INSERT INTO InvoiceDiscount (DiscountID, InvoiceID, DiscountAmount) VALUES (?, ?, ?)";
    try {
        // Gọi helper để thực thi câu lệnh SQL
        poly.barber.util.XJdbc.executeUpdate(sql, 
            invDisc.getDiscountID(), 
            invDisc.getInvoiceID(), 
            invDisc.getDiscountAmount()
        );
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    @Override
    public void delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
