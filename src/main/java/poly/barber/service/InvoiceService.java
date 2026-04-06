/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.barber.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import poly.barber.repository.Impl.InvoiceRepositoryImpl;

/**
 *
 * @author Admin
 */
public class InvoiceService {

    private InvoiceRepositoryImpl repo = new InvoiceRepositoryImpl();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public List<Object[]> findHistory(Date start, Date end, String empName) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return repo.getHistoryByDate(sdf.format(start), sdf.format(end), empName);
    }
}
