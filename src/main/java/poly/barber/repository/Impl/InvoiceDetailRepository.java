/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.barber.repository.Impl;

import java.util.List;
import poly.barber.entity.Invoice;
import poly.barber.repository.ICommonRepository;
import poly.barber.util.XQuery;

/**
 *
 * @author DELL
 */
public class InvoiceDetailRepository implements ICommonRepository<Invoice, Integer>{

    // Câu lệnh SQL lấy chi tiết dịch vụ của 1 hóa đơn
    String sqlGetDetails = "SELECT s.ServiceName, id.Quantity, id.Price, (id.Quantity * id.Price) AS Total "
                         + "FROM InvoiceDetail id "
                         + "JOIN Service s ON id.ServiceID = s.ServiceID "
                         + "WHERE id.InvoiceID = ?";
    

    // Hàm lấy danh sách mảng đối tượng để đổ trực tiếp lên Table
    public List<Object[]> getServiceDetails(Integer invoiceId) {
        return XQuery.getRawList(sqlGetDetails, invoiceId);
    }

    @Override
    public List<Invoice> getAll() {
        throw new UnsupportedOperationException("Not supported."); 
    }

    @Override
    public Invoice getOne(Integer id) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public void add(Invoice obj) {
        // Code thêm chi tiết hóa đơn nếu cần
    }

    @Override
    public void delete(Integer id) {}

    @Override
    public void update(Invoice obj) {}
}
