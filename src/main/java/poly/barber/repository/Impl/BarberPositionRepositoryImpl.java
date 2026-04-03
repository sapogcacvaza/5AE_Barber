/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.barber.repository.Impl;

import java.util.List;
import poly.barber.entity.Barber;
import poly.barber.entity.BarberPosition;
import poly.barber.util.XQuery;

/**
 *
 * @author Dell
 */
public class BarberPositionRepositoryImpl {
    String sqlGetAll = "select PositionID,PositionName from BarberPosition";
    String sqlGetOne = "select PositionID,PositionName from BarberPosition where PositionID = ?";
    
    public List<BarberPosition> getAll(){
        return XQuery.getBeanList(BarberPosition.class, sqlGetAll);
    }
    public BarberPosition getOne(int id){
        return XQuery.getSingleBean(BarberPosition.class, sqlGetOne, id);
    }
}
