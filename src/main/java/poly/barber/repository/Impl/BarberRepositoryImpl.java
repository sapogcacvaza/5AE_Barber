package poly.barber.repository.Impl;

import java.sql.ResultSet;
import java.util.List;
import poly.barber.entity.Barber;
import poly.barber.repository.ICommonRepository;
import poly.barber.util.XJdbc;
import poly.barber.util.XQuery;

public class BarberRepositoryImpl implements ICommonRepository<Barber, Integer> {

    String getAll = "select * from Barber";
    String getOne = "select * from Barber where id = ?";
    String getOneByName = "select * from Barber where (Lastname + ' ' + Firstname) like ?";
    String getPositionNameByID = "select PositionName from BarberPosition where PositionID = ?";

    @Override
    public List<Barber> getAll() {
        return XQuery.getBeanList(Barber.class, getAll);
    }

    @Override
    public Barber getOne(Integer id) {
        return XQuery.getSingleBean(Barber.class, getOne, id);
    }

    public Barber getOneByName(String name) {
        return XQuery.getSingleBean(Barber.class, getOneByName, "%" + name + "%");
    }

    public String getPositionNameByID(int id) {
        String positionName = null;

        try {
            ResultSet rs = XJdbc.executeQuery(getPositionNameByID, id);

            if (rs.next()) {
                positionName = rs.getString("PositionName");
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return positionName;
    }

    @Override
    public void add(Barber obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Barber obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
