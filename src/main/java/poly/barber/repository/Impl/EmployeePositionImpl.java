/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.barber.repository.Impl;

import java.util.List;
import poly.barber.entity.EmployeePosition;
import poly.barber.repository.ICommonRepository;
import poly.barber.util.XQuery;

/**
 *
 * @author Dell
 */
public class EmployeePositionImpl implements ICommonRepository<EmployeePosition, Integer> {

    String sqlGetAll = "select PositionID,PositionName from EmployeePosition";
    String sqlGetOne = "select PositionID,PositionName from EmployeePosition where PositionID = ?";

    @Override
    public List<EmployeePosition> getAll() {
        return XQuery.getBeanList(EmployeePosition.class, sqlGetAll);
    }

    @Override
    public EmployeePosition getOne(Integer id) {
        return XQuery.getSingleBean(EmployeePosition.class, sqlGetOne, id);
    }

    @Override
    public void add(EmployeePosition obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(EmployeePosition obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public static void main(String[] args) {
        System.out.println(new EmployeePositionImpl().getAll());
    }


}
