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
        .filter(d -> d.getDiscountName().toLowerCase().contains(keyword.toLowerCase()))
        .filter(d -> type == 0 || d.getDiscountType() == type)
        .toList();
}

    // 🔥 VALIDATE tập trung
private void validate(Discount d) {

    // 🔹 tên
    if (d.getDiscountName().isEmpty()) {
        throw new RuntimeException("Tên không được trống");
    }

    // 🔹 giá trị
    if (d.getDiscountValue().compareTo(BigDecimal.ZERO) <= 0) {
        throw new RuntimeException("Giá trị phải > 0");
    }

    // 🔹 nếu là % thì <= 100
    if (d.getDiscountType() == 1 &&
        d.getDiscountValue().compareTo(new BigDecimal("100")) > 0) {
        throw new RuntimeException("Giảm % không được > 100");
    }

    // 🔹 số lượng
    if (d.getMaxUsage() < 0 || d.getUsedCount() < 0) {
        throw new RuntimeException("Số lượng không hợp lệ");
    }

    if (d.getUsedCount() > d.getMaxUsage()) {
        throw new RuntimeException("Đã dùng > số lượng");
    }

    // 🔹 thời gian
    if (d.getEndDateTime().isBefore(d.getStartDateTime())) {
        throw new RuntimeException("Ngày kết thúc phải sau ngày bắt đầu");
    }
}
    
}