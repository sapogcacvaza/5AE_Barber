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
        validate(d);
        repo.insert(d);
    }

    public void update(Discount d) {
        validate(d);
        repo.update(d);
    }

    // 🔥 FILTER luôn trong service
    public List<Discount> filter(String keyword, int type) {
        return repo.findAll().stream()
                .filter(d -> d.getDiscountName() != null
                && d.getDiscountName().toLowerCase().contains(keyword.toLowerCase()))
                .filter(d -> type == 0 || d.getDiscountType() == type)
                .toList();
    }

    // 🔥 VALIDATE tập trung
    private void validate(Discount d) {

        if (d.getDiscountCode() == null || d.getDiscountCode().isEmpty()) {
            throw new RuntimeException("Mã giảm giá không được trống");
        }

        if (d.getDiscountName() == null || d.getDiscountName().isEmpty()) {
            throw new RuntimeException("Tên không được trống");
        }

        if (d.getDiscountValue() == null
                || d.getDiscountValue().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Giá trị phải > 0");
        }

        if (d.getDiscountType() == 1
                && d.getDiscountValue().compareTo(new BigDecimal("100")) > 0) {
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

        if (repo.existsCode(d.getDiscountCode(), d.getDiscountID())) {
            throw new RuntimeException("Mã giảm giá đã tồn tại");
        }
    }

}
