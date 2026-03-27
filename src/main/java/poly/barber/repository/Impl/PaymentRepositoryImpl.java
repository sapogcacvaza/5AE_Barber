/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.barber.repository.Impl;

import java.util.List;
import poly.barber.entity.Payment;
import poly.barber.repository.ICommonRepository;
import poly.barber.util.XQuery;

/**
 *
 * @author Admin
 */
public class PaymentRepositoryImpl implements ICommonRepository<Payment, Integer>{
    String sqlGetOne = "select * from Payment where PaymentID = ?";
    

    @Override
    public List<Payment> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Payment getOne(Integer id) {
        return XQuery.getSingleBean(Payment.class, sqlGetOne, id);
    }

    @Override
    public void add(Payment obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Payment obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    String sqlGetOneByInvoiceId = "select * from Payment where InvoiceID = ?";
    public Payment getOneByInvoiceID(String invoiceId){
        return XQuery.getSingleBean(Payment.class, sqlGetOneByInvoiceId, invoiceId);
    }
}
