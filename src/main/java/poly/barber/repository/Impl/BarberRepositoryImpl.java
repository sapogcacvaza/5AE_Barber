package poly.barber.repository.Impl;

import java.sql.ResultSet;
import java.util.List;
import poly.barber.entity.Barber;
import poly.barber.repository.ICommonRepository;
import poly.barber.util.XJdbc;
import poly.barber.util.XQuery;

public class BarberRepositoryImpl implements ICommonRepository<Barber, Integer> {

    String getAll = "select BarberID,IsBusy,Status,FirstName,LastName,Phone,Email,PositionID from Barber";
    String getOne = "select BarberID,IsBusy,Status,FirstName,LastName,Phone,Email,PositionID from Barber where BarberID = ?";
    String getOneByName = "select * from Barber where (Lastname + ' ' + Firstname) like ?";
    String getPositionNameByID = "select PositionName from BarberPosition where PositionID = ?";
    String sqlUpdate = "update Barber set Status = ?,FirstName = ?,LastName = ?, Phone = ?, Email = ?, PositionID = ? where BarberID = ?";
    String sqlAdd = "insert into Barber (Status,FirstName,LastName,Phone,Email,PositionID) values\n"
            + "(?,?,?,?,?,?)";
    String sqlDelete = "delete Barber where BarberID = ?";
    String sqlStatusFilter = "select *from Barber where Status = ?";
    String sqlIsBusyFilter = "select *from Barber where isBusy = ?";

    public List<Barber> statusFilter(int id) {
        return XQuery.getBeanList(Barber.class, sqlStatusFilter, id);
    }

    public List<Barber> isBusyFilter(int id) {
        return XQuery.getBeanList(Barber.class, sqlIsBusyFilter, id);
    }

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
        Object[] data = {obj.isStatus(), obj.getFirstname(), obj.getLastname(), obj.getPhone(), obj.getEmail(), obj.getPositionID()};
        XJdbc.executeUpdate(sqlAdd, data);
    }

    @Override
    public void delete(Integer id) {
        XJdbc.executeUpdate(sqlDelete, id);
    }

    @Override
    public void update(Barber obj) {
        Object[] data = {obj.isStatus(), obj.getFirstname(), obj.getLastname(), obj.getPhone(), obj.getEmail(), obj.getPositionID(), obj.getBarberID()};
        XJdbc.executeUpdate(sqlUpdate, data);
    }

    public static void main(String[] args) {
        System.out.println(new BarberRepositoryImpl().getAll());
    }

}
