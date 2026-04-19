/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package poly.barber.view.dialog;

import java.awt.Color;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import poly.barber.entity.Account;
import poly.barber.entity.Discount;
import poly.barber.repository.Impl.DiscountRepository;
import poly.barber.service.AccountService;
import poly.barber.service.DiscountService;

/**
 *
 * @author Os
 */
public class DiscountJdialog extends javax.swing.JDialog {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DiscountJdialog.class.getName());
    DiscountService service = new DiscountService();
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
    List<Discount> list = new ArrayList<>();

    /**
     * Creates new form DiscountJFrame
     */
    public DiscountJdialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        initComboForm();
        initComboFilter();
        loadTable();

//        cbbdc.addActionListener(e -> loadTable());
//        txtfind.addKeyListener(new java.awt.event.KeyAdapter() {
//            public void keyReleased(java.awt.event.KeyEvent evt) {
//                loadTable();
//            }
//        });
        // ✅ FIX ở đây
//        cbLoai.addActionListener(e -> txtmagiamgia.setText(generateCode()));
    }

    void initComboFilter() {  // ✔ nằm ngoài
        cbbdc.removeAllItems();
        cbbdc.addItem("Tất cả");
        cbbdc.addItem("Giảm %");
        cbbdc.addItem("Giảm tiền");

        cbbtrangthai.removeAllItems();
        cbbtrangthai.addItem("Tất cả");
        cbbtrangthai.addItem("Hoạt động");
        cbbtrangthai.addItem("Ngưng");
    }

    void loadTable() {
        DefaultTableModel model = (DefaultTableModel) tbldc.getModel();
        model.setRowCount(0);

        String keyword = txtfind.getText() == null ? "" : txtfind.getText().toLowerCase();

        int loai = cbbdc.getSelectedIndex();       // 0 all, 1 %, 2 tiền
        int trangthai = cbbtrangthai.getSelectedIndex(); // 0 all, 1 active, 2 off

        list = service.getAll().stream()
                .filter(d
                        -> (keyword.isEmpty()
                || d.getDiscountName().toLowerCase().contains(keyword)
                || d.getDiscountCode().toLowerCase().contains(keyword))
                )
                .filter(d
                        -> loai == 0
                || (loai == 1 && d.getDiscountType() == 1)
                || (loai == 2 && d.getDiscountType() == 2)
                )
                .filter(d
                        -> trangthai == 0
                || (trangthai == 1 && d.getStatus() == 1)
                || (trangthai == 2 && d.getStatus() == 0)
                )
                .toList();

        for (Discount d : list) {
            model.addRow(new Object[]{
                d.getDiscountID(),
                d.getDiscountCode(),
                d.getDiscountName(),
                d.getDiscountType() == 1 ? "Giảm %" : "Giảm tiền",
                d.getDiscountValue(),
                d.getDescription(),
                d.getStartDateTime(),
                d.getEndDateTime(),
                d.getStatus() == 1 ? "Hoạt động" : "Ngưng",
                d.getMaxUsage(),
                d.getUsedCount()
            });
        }
    }

//    void loadTable() {
//        var model = (javax.swing.table.DefaultTableModel) tbldc.getModel();
//        model.setRowCount(0);
//
//        String keyword = txtfind.getText().toLowerCase();
//
//        int typeIndex = cbbdc.getSelectedIndex();
//        int statusIndex = cbbtrangthai.getSelectedIndex();
//
//        int type = 0;
//        if (typeIndex == 1) {
//            type = 1;
//        }
//        if (typeIndex == 2) {
//            type = 2;
//        }
//
//        int status = -1;
//        if (statusIndex == 1) {
//            status = 1;
//        }
//        if (statusIndex == 2) {
//            status = 0;
//        }
//
//        list = service.getAll(); // 👉 lấy all
//
//        for (var d : list) {
//
//            // 🔍 SEARCH
//            if (!d.getDiscountName().toLowerCase().contains(keyword)) {
//                continue;
//            }
//
//            // 🎯 FILTER LOẠI
//            if (type != 0 && d.getDiscountType() != type) {
//                continue;
//            }
//
//            // 🎯 FILTER TRẠNG THÁI
//            if (status != -1 && d.getStatus() != status) {
//                continue;
//            }
//
//            model.addRow(new Object[]{
//                d.getDiscountID(),
//                d.getDiscountCode(),
//                d.getDiscountName(),
//                d.getDiscountType() == 1 ? "Giảm %" : "Giảm tiền",
//                d.getDiscountValue(),
//                d.getDescription(),
//                d.getStartDateTime(),
//                d.getEndDateTime(),
//                d.getStatus() == 1 ? "Hoạt động" : "Ngưng",
//                d.getMaxUsage(),
//                d.getUsedCount()
//            });
//        }
//    }

    void initComboForm() {
        cbLoai.removeAllItems();
        cbLoai.addItem("Giảm %");     // 1
        cbLoai.addItem("Giảm tiền");  // 2

        cbTrangThai.removeAllItems();
        cbTrangThai.addItem("Hoạt động"); // 1
        cbTrangThai.addItem("Ngưng");     // 0
    }

    Discount getForm(boolean isInsert) {

        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        try {
            new BigDecimal(txtgiatri.getText());
            Integer.parseInt(txtsoluong.getText());
        } catch (Exception e) {
            throw new RuntimeException("Giá trị hoặc số lượng không hợp lệ");
        }

        return Discount.builder()
                .discountID(txtid.getText().isEmpty() ? 0 : Integer.parseInt(txtid.getText()))
                .discountCode(txtmagiamgia.getText()) // 🔥 nhập tay
                .discountName(txtten.getText())
                .discountType(cbLoai.getSelectedIndex() == 0 ? 1 : 2)
                .discountValue(new BigDecimal(txtgiatri.getText()))
                .description(txtmota.getText())
                .startDateTime(LocalDateTime.parse(txtstart.getText(), f))
                .endDateTime(LocalDateTime.parse(txtend.getText(), f))
                .status(cbTrangThai.getSelectedIndex() == 0 ? 1 : 0)
                .maxUsage(Integer.parseInt(txtsoluong.getText()))
                .usedCount(isInsert ? 0 : Integer.parseInt(txtdasudung.getText()))
                .build();

    }

    String generateCode() {
        String prefix = cbLoai.getSelectedIndex() == 0 ? "PT" : "TM";
        return prefix + System.currentTimeMillis();
    }

    public void setUser(Account user) {
        AccountService service = new AccountService();

        // Nhân viên không được sửa
        if (service.isStaff(user)) {
            txtthem.setEnabled(false);
            txtsua.setEnabled(false);
        }

        // Quản lý được sửa nhưng không xoá (ví dụ)
        if (service.isManager(user)) {
            // ok
        }
    }

    void showDetail(int index) {
        Discount d = list.get(index);

        txtid.setText(String.valueOf(d.getDiscountID()));
        txtmagiamgia.setText(d.getDiscountCode());
        txtten.setText(d.getDiscountName());

        cbLoai.setSelectedIndex(d.getDiscountType() == 1 ? 0 : 1);

        txtgiatri.setText(d.getDiscountValue().toString());
        txtmota.setText(d.getDescription());

        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        txtstart.setText(d.getStartDateTime().format(f));
        txtend.setText(d.getEndDateTime().format(f));

        cbTrangThai.setSelectedIndex(d.getStatus() == 1 ? 0 : 1);

        txtsoluong.setText(String.valueOf(d.getMaxUsage()));
        txtdasudung.setText(String.valueOf(d.getUsedCount()));
    }

    void clearForm() {
        txtid.setText("");
        txtmagiamgia.setText("");
        txtten.setText("");
        txtgiatri.setText("");
        txtmota.setText("");
        txtstart.setText("");
        txtend.setText("");
        txtsoluong.setText("");
        txtdasudung.setText("0");

        cbLoai.setSelectedIndex(0);
        cbTrangThai.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        cbbdc = new javax.swing.JComboBox<>();
        txtfind = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbldc = new javax.swing.JTable();
        cbbtrangthai = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnlocloai = new javax.swing.JButton();
        btnloctrangthai = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtten = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtgiatri = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtmota = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtstart = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtend = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtsoluong = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtdasudung = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtthem = new javax.swing.JButton();
        txtsua = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtmagiamgia = new javax.swing.JTextField();
        cbTrangThai = new javax.swing.JComboBox<>();
        cbLoai = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtLamSach = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbbdc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbdc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbdcActionPerformed(evt);
            }
        });
        jPanel2.add(cbbdc, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 150, -1));
        jPanel2.add(txtfind, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 150, -1));

        jButton1.setBackground(new java.awt.Color(0, 102, 153));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("TÌM KIẾM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 90, -1));

        tbldc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "MÃ GIẢM GIÁ", "TÊN", "LOẠI", "GIÁ TRỊ", "MÔ TẢ", "BẮT ĐẦU", "KẾT THÚC", "TRẠNG THÁI", "SỐ LƯỢNG", "ĐÃ SỬ DỤNG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbldc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldcMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbldc);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 930, 370));

        cbbtrangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbtrangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbtrangthaiActionPerformed(evt);
            }
        });
        jPanel2.add(cbbtrangthai, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 140, -1));

        jButton3.setBackground(new java.awt.Color(0, 102, 153));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("BỎ LỌC");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 70, 90, -1));

        jLabel13.setText("Lọc Theo Trạng Thái:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, -1, 20));

        jLabel14.setText("Tìm theo mã hoặc tên giảm giá ");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 20));

        btnlocloai.setBackground(new java.awt.Color(0, 102, 153));
        btnlocloai.setForeground(new java.awt.Color(255, 255, 255));
        btnlocloai.setText("LỌC");
        btnlocloai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlocloaiActionPerformed(evt);
            }
        });
        jPanel2.add(btnlocloai, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 60, -1));

        btnloctrangthai.setBackground(new java.awt.Color(0, 102, 153));
        btnloctrangthai.setForeground(new java.awt.Color(255, 255, 255));
        btnloctrangthai.setText("LỌC");
        btnloctrangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloctrangthaiActionPerformed(evt);
            }
        });
        jPanel2.add(btnloctrangthai, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 60, -1));

        jLabel15.setText("Lọc Theo Loại:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, 20));

        jTabbedPane1.addTab("Danh sách", jPanel2);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 160, -1));

        jLabel3.setText("TÊN");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));
        jPanel1.add(txtten, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 160, -1));

        jLabel4.setText("GIÁ TRỊ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));
        jPanel1.add(txtgiatri, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 160, -1));

        jLabel5.setText("MÔ TẢ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));
        jPanel1.add(txtmota, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 160, -1));

        jLabel6.setText("BẮT ĐẦU");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));
        jPanel1.add(txtstart, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 160, -1));

        jLabel7.setText("KẾT THÚC");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));
        jPanel1.add(txtend, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 160, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setText("Nhập theo format: năm-tháng-ngày | giờ-phút");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 280, -1));

        jLabel9.setText("SỐ LƯỢNG");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, -1));
        jPanel1.add(txtsoluong, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 160, -1));

        jLabel10.setText("ĐÃ SỬ DỤNG");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, -1, -1));
        jPanel1.add(txtdasudung, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 160, -1));

        jLabel11.setText("LOẠI");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        txtthem.setBackground(new java.awt.Color(0, 102, 153));
        txtthem.setForeground(new java.awt.Color(255, 255, 255));
        txtthem.setText("THÊM");
        txtthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtthemActionPerformed(evt);
            }
        });
        jPanel1.add(txtthem, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 130, 30));

        txtsua.setBackground(new java.awt.Color(0, 102, 153));
        txtsua.setForeground(new java.awt.Color(255, 255, 255));
        txtsua.setText("SỬA");
        txtsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsuaActionPerformed(evt);
            }
        });
        jPanel1.add(txtsua, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 130, 30));

        jLabel12.setText("MÃ GIẢM GIÁ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        jPanel1.add(txtmagiamgia, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 160, -1));

        cbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 160, -1));

        cbLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 160, -1));

        jLabel16.setText("TRẠNG THÁI");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        txtLamSach.setBackground(new java.awt.Color(0, 102, 153));
        txtLamSach.setForeground(new java.awt.Color(255, 255, 255));
        txtLamSach.setText("LÀM SẠCH");
        txtLamSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLamSachActionPerformed(evt);
            }
        });
        jPanel1.add(txtLamSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 130, 30));

        jTabbedPane1.addTab("Thêm mới", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtthemActionPerformed
        // TODO add your handling code here:
        try {
            Discount d = getForm(true);

            // 🔥 check trùng lần 2 cho chắc
            if (service.getAll().stream()
                    .anyMatch(x -> x.getDiscountCode().equalsIgnoreCase(d.getDiscountCode()))) {

                JOptionPane.showMessageDialog(this, "Mã giảm giá đã tồn tại!");
                return;
            }

            service.add(d);

            loadTable();
            clearForm();

            JOptionPane.showMessageDialog(this, "Thêm thành công");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_txtthemActionPerformed

    private void txtsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsuaActionPerformed
        // TODO add your handling code here:
        try {
            Discount d = getForm(false);

            service.update(d);

            loadTable();

            JOptionPane.showMessageDialog(this, "Sửa thành công");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_txtsuaActionPerformed

    private void tbldcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldcMouseClicked
        // TODO add your handling code here:

        int i = tbldc.getSelectedRow();
        showDetail(i);
        jTabbedPane1.setSelectedIndex(1);

    }//GEN-LAST:event_tbldcMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        loadTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbbdcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbdcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbdcActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        txtfind.setText("");
        cbbdc.setSelectedIndex(0);
        cbbtrangthai.setSelectedIndex(0);
        loadTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnlocloaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlocloaiActionPerformed
        // TODO add your handling code here:
        loadTable();
    }//GEN-LAST:event_btnlocloaiActionPerformed

    private void btnloctrangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloctrangthaiActionPerformed
        // TODO add your handling code here:
        loadTable();
    }//GEN-LAST:event_btnloctrangthaiActionPerformed

    private void cbbtrangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbtrangthaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbtrangthaiActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txtLamSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLamSachActionPerformed
        txtid.setText("");
        txtmagiamgia.setText("");
        txtten.setText("");
        txtgiatri.setText("");
        txtmota.setText("");
        txtstart.setText("");
        txtend.setText("");
        txtsoluong.setText("");
        txtdasudung.setText("");
    }//GEN-LAST:event_txtLamSachActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DiscountJdialog dialog = new DiscountJdialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlocloai;
    private javax.swing.JButton btnloctrangthai;
    private javax.swing.JComboBox<String> cbLoai;
    private javax.swing.JComboBox<String> cbTrangThai;
    private javax.swing.JComboBox<String> cbbdc;
    private javax.swing.JComboBox<String> cbbtrangthai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbldc;
    private javax.swing.JButton txtLamSach;
    private javax.swing.JTextField txtdasudung;
    private javax.swing.JTextField txtend;
    private javax.swing.JTextField txtfind;
    private javax.swing.JTextField txtgiatri;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtmagiamgia;
    private javax.swing.JTextField txtmota;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JTextField txtstart;
    private javax.swing.JButton txtsua;
    private javax.swing.JTextField txtten;
    private javax.swing.JButton txtthem;
    // End of variables declaration//GEN-END:variables
}
