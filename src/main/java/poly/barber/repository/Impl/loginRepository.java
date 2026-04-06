package poly.barber.repository.Impl;

import poly.barber.entity.Account;
import poly.barber.util.XQuery;
import java.util.List;

public class loginRepository {

public Account findByUsername(String username) {
    String sql = "SELECT * FROM Account WHERE Username = ?";
    List<Account> list = XQuery.getBeanList(Account.class, sql, username);
    return list.isEmpty() ? null : list.get(0);
}
}