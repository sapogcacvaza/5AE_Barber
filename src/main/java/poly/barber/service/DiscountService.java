package poly.barber.service;

import java.math.BigDecimal;
import java.util.List;
import poly.barber.entity.Discount;
import poly.barber.repository.Impl.DiscountRepository;

public class DiscountService {

    DiscountRepository repo = new DiscountRepository();

    public List<Discount> getAll() {
        return repo.findAll();
    }

    public void add(Discount d) {
        validate(d, true);
        repo.insert(d);
    }

    public void update(Discount d) {
        validate(d, false);
        repo.update(d);
    }

    public List<Discount> search(String keyword) {
        if (keyword == null) keyword = "";

        String finalKeyword = keyword.toLowerCase();

        return repo.findAll().stream()
                .filter(d ->
                        (d.getDiscountName() != null &&
                         d.getDiscountName().toLowerCase().contains(finalKeyword))
                     ||
                        (d.getDiscountCode() != null &&
                         d.getDiscountCode().toLowerCase().contains(finalKeyword))
                )
                .toList();
    }

    // 🔥 VALIDATE FULL
    private void validate(Discount d, boolean isInsert) {

        if (d.getDiscountCode() == null || d.getDiscountCode().trim().isEmpty()) {
            throw new RuntimeException("Mã không được trống");
        }

        if (d.getDiscountName() == null || d.getDiscountName().trim().isEmpty()) {
            throw new RuntimeException("Tên không được trống");
        }

        if (d.getDiscountValue() == null ||
                d.getDiscountValue().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Giá trị phải > 0");
        }

        // Giảm %
        if (d.getDiscountType() == 1 &&
                d.getDiscountValue().compareTo(new BigDecimal("100")) > 0) {
            throw new RuntimeException("Giảm % không được > 100");
        }

        if (d.getMaxUsage() < 0 || d.getUsedCount() < 0) {
            throw new RuntimeException("Số lượng không hợp lệ");
        }

        if (d.getUsedCount() > d.getMaxUsage()) {
            throw new RuntimeException("Đã dùng > số lượng");
        }

        if (d.getStartDateTime() == null || d.getEndDateTime() == null) {
            throw new RuntimeException("Thời gian không hợp lệ");
        }

        if (d.getEndDateTime().isBefore(d.getStartDateTime())) {
            throw new RuntimeException("Ngày kết thúc phải sau ngày bắt đầu");
        }

        // 🔥 CHECK TRÙNG MÃ
        if (repo.existsCode(d.getDiscountCode(), d.getDiscountID())) {
            throw new RuntimeException("Mã giảm giá đã tồn tại");
        }
    }
    
}