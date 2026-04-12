package poly.barber.service;

import poly.barber.entity.InvoiceDetail;
import poly.barber.repository.Impl.InvoiceDetailRepository;

public class InvoiceDetailService {

    InvoiceDetailRepository repo = new InvoiceDetailRepository();

    public void add(InvoiceDetail obj) {
        repo.add(obj);
    }
}
