/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.barber.repository.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import poly.barber.entity.Account;
import poly.barber.repository.ICommonRepository;
import poly.barber.util.XJdbc;
import poly.barber.util.XQuery;

/**
 *
 * @author Dell
 */
public class AccountImpl implements ICommonRepository<Account, Integer> {

    String sqlGetAll = "select AccountID,Username,Password,Role,EmployeeID from Account";
    String sqlGetOne = "select AccountID,Username,Password,Role,EmployeeID from Account where AccountID = ?";
    String sqlAdd = "insert into Account values\n"
            + "(?,?,?,?)";
    String sqlGetRole = "select * from Account where Role = ?";
    String sqlUpdate = "update Account set Username = ?,Password = ?,Role = ?,EmployeeID = ? where AccountID = ?";
    String sqlDelete = "delete Account where AccountID = ?";
    String sqlSearchByUsername = "select * from Account where Username like ?";
    String sqlGetRoleInt = "SELECT DISTINCT role FROM Account";

    public List<Account> searchByUsername(String username) {
        return XQuery.getBeanList(Account.class, sqlSearchByUsername, "%"+username+"%");
    }

    public List<Account> getRole(int id) {
        return XQuery.getBeanList(Account.class, sqlGetRole, id);
    }

    @Override
    public List<Account> getAll() {
        return XQuery.getBeanList(Account.class, sqlGetAll);
    }

    @Override
    public Account getOne(Integer id) {
        return XQuery.getSingleBean(Account.class, sqlGetOne, id);
    }

    @Override
    public void add(Account obj) {
        Object[] data = {obj.getUsername(), obj.getPassword(), obj.getRole(), obj.getEmployeeID()};
        XJdbc.executeUpdate(sqlAdd, data);
    }

    @Override
    public void delete(Integer id) {
        XJdbc.executeUpdate(sqlDelete, id);
    }

    @Override
    public void update(Account obj) {
        Object[] data = {obj.getUsername(), obj.getPassword(), obj.getRole(), obj.getEmployeeID(), obj.getAccountID()};
        XJdbc.executeUpdate(sqlUpdate, data);
    }

    public List<Integer> getRoles() {
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sqlGetRoleInt);
            while (rs.next()) {
                list.add(rs.getInt("Role"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public Account findByUsername(String username) {
    String sql = """
        SELECT * FROM Account 
        WHERE Username = ?
    """;

    List<Account> list = XQuery.getBeanList(Account.class, sql, username);
    return list.isEmpty() ? null : list.get(0);
}

    public static void main(String[] args) {
        System.out.println(new AccountImpl().getRoles());
    }

}
