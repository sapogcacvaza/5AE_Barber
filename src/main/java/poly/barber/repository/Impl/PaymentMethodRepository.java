/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.barber.repository.Impl;

import java.util.List;
import poly.barber.entity.PaymentMethod;
import poly.barber.repository.ICommonRepository;
import poly.barber.util.XQuery;

/**
 *
 * @author DELL
 */
public class PaymentMethodRepository implements ICommonRepository{
    String getAll = "SELECT * FROM PaymentMethod";
    String getOne = "SELECT * FROM PaymentMethod WHERE PaymentMethodID = ?";
    @Override
    public List<PaymentMethod> getAll() {
        return XQuery.getBeanList(PaymentMethod.class, getAll);
    }

    @Override
    public PaymentMethod getOne(Object id) {
        return XQuery.getSingleBean(PaymentMethod.class, getOne, id);
    }

    @Override
    public void add(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
