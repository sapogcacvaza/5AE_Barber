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

        cbbdc.addActionListener(e -> loadTable());

        txtfind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                loadTable();
            }
        });

        // ✅ FIX ở đây
        cbLoai.addActionListener(e -> txtmagiamgia.setText(generateCode()));
    }

    void initComboFilter() {
        cbbdc.removeAllItems();
        cbbdc.addItem("Tất cả");
        cbbdc.addItem("Giảm %");
        cbbdc.addItem("Giảm tiền");
    }

    void loadTable() {
        var model = (javax.swing.table.DefaultTableModel) tbldc.getModel();
        model.setRowCount(0);

        String keyword = txtfind.getText();
        int typeIndex = cbbdc.getSelectedIndex();

        int type = 0;
        if (typeIndex == 1) {
            type = 1;
        }
        if (typeIndex == 2) {
            type = 2;
        }
        list = service.filter(keyword, type);

        for (var d : list) {
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

    void initComboForm() {
        cbLoai.removeAllItems();
        cbLoai.addItem("Giảm %");     // 1
        cbLoai.addItem("Giảm tiền");  // 2

        cbTrangThai.removeAllItems();
        cbTrangThai.addItem("Hoạt động"); // 1
        cbTrangThai.addItem("Ngưng");     // 0
    }

    Discount getForm() {
        txtten.setBackground(Color.white);
        txtgiatri.setBackground(Color.white);
        txtsoluong.setBackground(Color.white);
        txtmagiamgia.setBackground(Color.white);
        if (txtmagiamgia.getText().trim().isEmpty()) {
            throw new RuntimeException("Mã giảm giá không được trống");
        }

        if (txtten.getText().trim().isEmpty()) {
            txtten.setBackground(Color.pink);
            throw new RuntimeException("Tên không được trống");
        }

        if (txtgiatri.getText().trim().isEmpty()) {
            txtgiatri.setBackground(Color.pink);
            throw new RuntimeException("Giá trị không được trống");
        }

        if (txtsoluong.getText().trim().isEmpty()) {
            throw new RuntimeException("Số lượng không được trống");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime start;
        LocalDateTime end;

        try {
            start = LocalDateTime.parse(txtstart.getText(), formatter);
            end = LocalDateTime.parse(txtend.getText(), formatter);
        } catch (Exception e) {
            throw new RuntimeException("Sai định dạng ngày! Ví dụ: 2026-04-07 14:30");
        }

        if (end.isBefore(start)) {
            throw new RuntimeException("Ngày kết thúc phải sau ngày bắt đầu");
        }

        int type = cbLoai.getSelectedIndex() == 0 ? 1 : 2;
        int status = cbTrangThai.getSelectedIndex() == 0 ? 1 : 0;

        BigDecimal value;
        try {
            value = new BigDecimal(txtgiatri.getText());
        } catch (Exception e) {
            throw new RuntimeException("Giá trị phải là số");
        }

        return Discount.builder()
                .discountID(txtid.getText().isEmpty() ? 0 : Integer.parseInt(txtid.getText()))
                .discountCode(txtmagiamgia.getText())
                .discountName(txtten.getText())
                .discountType(type)
                .discountValue(value)
                .description(txtmota.getText())
                .startDateTime(start)
                .endDateTime(end)
                .status(status)
                .maxUsage(Integer.parseInt(txtsoluong.getText()))
                .usedCount(Integer.parseInt(txtdasudung.getText()))
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
        jLabel2 = new javax.swing.JLabel();
        txtfind = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbldc = new javax.swing.JTable();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbbdc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbbdc, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 230, -1));

        jLabel2.setText("Lọc theo tên ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));
        jPanel2.add(txtfind, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 330, -1));

        jButton1.setBackground(new java.awt.Color(0, 102, 153));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("TÌM KIẾM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 110, -1));

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

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 930, 580));

        jTabbedPane1.addTab("Danh sách", jPanel2);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));
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

        jLabel8.setText("TRẠNG THÁI");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

        jLabel9.setText("SỐ LƯỢNG");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));
        jPanel1.add(txtsoluong, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 160, -1));

        jLabel10.setText("ĐÃ SỬ DỤNG");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, -1));
        jPanel1.add(txtdasudung, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 160, -1));

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
        jPanel1.add(txtthem, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 130, 30));

        txtsua.setBackground(new java.awt.Color(0, 102, 153));
        txtsua.setForeground(new java.awt.Color(255, 255, 255));
        txtsua.setText("SỬA");
        txtsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsuaActionPerformed(evt);
            }
        });
        jPanel1.add(txtsua, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 130, 30));

        jLabel12.setText("MÃ GIẢM GIÁ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        jPanel1.add(txtmagiamgia, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 160, -1));

        cbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 160, -1));

        cbLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 160, -1));

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
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtthemActionPerformed
        // TODO add your handling code here:
        try {
            Discount d = getForm();
            d.setDiscountCode(generateCode());
            service.add(d);

            JOptionPane.showMessageDialog(this, "Thêm thành công!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_txtthemActionPerformed

    private void txtsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsuaActionPerformed
        // TODO add your handling code here:
        try {
            Discount d = getForm();
            if (txtid.getText().isEmpty()) {
                d.setDiscountCode(generateCode()); // thêm mới
            } else {
                // nếu sửa thì chỉ update khi đổi loại
                d.setDiscountCode(generateCode());
            }
            service.update(d);
            JOptionPane.showMessageDialog(this, "Sửa thành công!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
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
    private javax.swing.JComboBox<String> cbLoai;
    private javax.swing.JComboBox<String> cbTrangThai;
    private javax.swing.JComboBox<String> cbbdc;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
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
