package poly.barber.repository.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import poly.barber.entity.Discount;
import poly.barber.util.XJdbc;
import poly.barber.util.XQuery;

public class DiscountRepository {
    String sql = "SELECT * FROM Discount WHERE Status = 1 AND EndDateTime > GETDATE() AND (MaxUsage > UsedCount)";
    public List<Discount> getAll(){
        return XQuery.getBeanList(Discount.class, sql);
    }
    // 🔥 map dữ liệu
    private Discount mapRow(ResultSet rs) throws Exception {
        return Discount.builder()
                .discountID(rs.getInt("DiscountID"))
                .discountCode(rs.getString("DiscountCode"))
                .discountName(rs.getString("DiscountName"))
                .discountType(rs.getInt("DiscountType"))
                .discountValue(rs.getBigDecimal("DiscountValue"))
                .description(rs.getString("Description"))
                .startDateTime(
                        rs.getTimestamp("StartDateTime") != null
                        ? rs.getTimestamp("StartDateTime").toLocalDateTime()
                        : null
                )
                .endDateTime(
                        rs.getTimestamp("EndDateTime") != null
                        ? rs.getTimestamp("EndDateTime").toLocalDateTime()
                        : null
                )
                .status(rs.getInt("Status"))
                .maxUsage(rs.getInt("MaxUsage"))
                .usedCount(rs.getInt("UsedCount"))
                .build();
    }

    // 🔥 lấy tất cả
    public List<Discount> findAll() {
        List<Discount> list = new ArrayList<>();
        String sql = "SELECT * FROM Discount";

        try {
            ResultSet rs = XJdbc.executeQuery(sql);
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    // 🔥 theo status
    public List<Discount> findByStatus(int status) {
        List<Discount> list = new ArrayList<>();
        String sql = "SELECT * FROM Discount WHERE Status = ?";

        try {
            ResultSet rs = XJdbc.executeQuery(sql, status);
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    // 🔥 đang còn hạn + active
    public List<Discount> findActiveNow() {
        List<Discount> list = new ArrayList<>();
        String sql = """
            SELECT * FROM Discount
            WHERE Status = 1
            AND GETDATE() BETWEEN StartDateTime AND EndDateTime
        """;

        try {
            ResultSet rs = XJdbc.executeQuery(sql);
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    // 🔥 thêm
    public void insert(Discount d) {
        String sql = """
        INSERT INTO Discount
        (DiscountName, DiscountType, DiscountValue, Description,
         StartDateTime, EndDateTime, Status, MaxUsage, UsedCount)
        VALUES (?,?,?,?,?,?,?,?,?)
    """;

    XJdbc.executeUpdate(sql,
            d.getDiscountName(), 
            d.getDiscountType(),
            d.getDiscountValue(),
            d.getDescription(),
            d.getStartDateTime(),
            d.getEndDateTime(),
            d.getStatus(),
            d.getMaxUsage(),
            d.getUsedCount()
    );
    }

    // 🔥 update
    public void update(Discount d) {
        String sql = """
            UPDATE Discount SET
            DiscountName=?,
            DiscountType=?,
            DiscountValue=?,
            Description=?,
            StartDateTime=?,
            EndDateTime=?,
            Status=?,
            MaxUsage=?,
            UsedCount=?
            WHERE DiscountID=?
        """;

        XJdbc.executeUpdate(sql,
                d.getDiscountName(),
                d.getDiscountType(),
                d.getDiscountValue(),
                d.getDescription(),
                d.getStartDateTime(),
                d.getEndDateTime(),
                d.getStatus(),
                d.getMaxUsage(),
                d.getUsedCount(),
                d.getDiscountID()
        );
    }

    // 🔥 xoá mềm
    public void updateStatus(int id, int status) {
        String sql = "UPDATE Discount SET UsedCount = UsedCount + 1 WHERE DiscountID = ?";
        XJdbc.executeUpdate(sql, status, id);
    }
}
