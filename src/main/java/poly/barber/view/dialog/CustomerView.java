/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package poly.barber.view.dialog;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import poly.barber.controller.Impl.CustomerController;
import poly.barber.entity.Customer;
import poly.barber.repository.Impl.CustomerImpl;
import poly.barber.util.XDialog;

import javax.swing.JOptionPane;

import java.util.List;

import java.util.List;

/**
 *
 * @author Dell
 */
public class CustomerView extends javax.swing.JDialog implements CustomerController {

    CustomerImpl khrepo = new CustomerImpl();
    DefaultTableModel dtm = new DefaultTableModel();
    DefaultComboBoxModel dcbm = new DefaultComboBoxModel();

    private Customer selectedCustomer;
    private List<Customer> list = new ArrayList<>();

    public CustomerView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        dtm = (DefaultTableModel) tblKhachHang.getModel();
        fillToTable(khrepo.getAll());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        cboFilter = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnFilter = new javax.swing.JButton();
        btnUnFilter = new javax.swing.JButton();
        btnUseCustomer = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        rdoNu = new javax.swing.JRadioButton();
        rdoNam = new javax.swing.JRadioButton();
        txtCustomerID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCustomerCode = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Khách hàng");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Quản lý khách hàng");

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên", "Số Điện Thoại", "Email", "Giới Tính", "Mã Khách Hàng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        jButton2.setText(">>");

        jButton3.setText("<<");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("1");

        jLabel3.setText("Showing 1 to 5 of 5 entries");

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        cboFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cboFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFilterActionPerformed(evt);
            }
        });

        jLabel4.setText("Lọc giới tính:");

        btnFilter.setText("Lọc");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        btnUnFilter.setText("Bỏ Lọc");
        btnUnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnFilterActionPerformed(evt);
            }
        });

        btnUseCustomer.setText("Chọn khách hàng");
        btnUseCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUseCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(48, 48, 48)
                                .addComponent(btnUseCustomer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(17, 17, 17)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(15, 15, 15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUnFilter)
                        .addGap(16, 16, 16))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem)
                    .addComponent(cboFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnFilter)
                    .addComponent(btnUnFilter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(btnDelete)
                    .addComponent(btnUseCustomer))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sách", jPanel1);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Thông tin cá nhân");

        jLabel9.setText("Tên:");

        jLabel10.setText("Số Điện Thoại:");

        jLabel11.setText("Email:");

        jLabel12.setText("Giới Tính:");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnUpdate.setText("Chỉnh sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        buttonGroup1.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");
        rdoNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNamActionPerformed(evt);
            }
        });

        txtCustomerID.setEditable(false);

        jLabel13.setText("ID:");

        jLabel14.setText("Mã Khách Hàng:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(102, 102, 102)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCustomerCode, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdoNam)
                                .addGap(18, 18, 18)
                                .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel8)
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCustomerCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnUpdate)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoNu)
                            .addComponent(rdoNam))))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnThem, btnUpdate});

        jTabbedPane1.addTab("Thêm mới", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        int index = tblKhachHang.getSelectedRow();
        setForm(index);
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteCheckedItems();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void rdoNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNamActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (checkNull()) {
            if (checkDuplicateInsert()) {
                khrepo.add(getForm());
                fillToTable(khrepo.getAll());
                JOptionPane.showMessageDialog(this, "Đã thêm khách hàng thành công");
            }
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (checkNull()) {
            if (checkDuplicateUpdate()) {
                khrepo.update(getForm());
                fillToTable(khrepo.getAll());
                JOptionPane.showMessageDialog(this, "Đã chỉnh sửa khách hàng thành công");
            }
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void cboFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboFilterActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        fillToTable(khrepo.getGender(genderFilter()));
    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnUnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnFilterActionPerformed
        fillToTable(khrepo.getAll());
    }//GEN-LAST:event_btnUnFilterActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed

        List<Customer> lst = khrepo.searchByPhone(txtTimKiem.getText());
        if (!lst.isEmpty()) {
            fillToTable(lst);
            return;
        }
        List<Customer> lst2 = khrepo.searchByName(txtTimKiem.getText());
        if (!lst.isEmpty()) {
            fillToTable(lst2);
            return;
        }
        JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả nào cho từ khóa " + txtTimKiem.getText());
        fillToTable(khrepo.getAll());
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnUseCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUseCustomerActionPerformed
        int row = tblKhachHang.getSelectedRow();
        if (row < 0) {
            XDialog.alert("Vui lòng chọn khách hàng!");
            return;
        }

        selectedCustomer = list.get(row);
        this.dispose();
    }//GEN-LAST:event_btnUseCustomerActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CustomerView dialog = new CustomerView(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnUnFilter;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUseCustomer;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboFilter;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtCustomerCode;
    private javax.swing.JTextField txtCustomerID;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    public boolean checkNull() {
        if (txtName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống name");
            return false;
        }

        if (txtPhone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống phone");
            return false;
        }

        if (txtPhone.getText().length() != 10 || !txtPhone.getText().startsWith("0")) {
            JOptionPane.showMessageDialog(this, "SĐT phải đủ 10 số và bắt đầu bằng 0");
            return false;
        }

        if (!txtEmail.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            JOptionPane.showMessageDialog(this, "Email không đúng định dạng");
            return false;
        }
        if (txtCustomerCode.getText().length() > 9) {
            JOptionPane.showMessageDialog(this, "CustomerCode vượt quá 9 ký tự!");
            return false;
        }

        return true;
    }

    public boolean checkDuplicateInsert() {
        for (Customer kh : khrepo.getAll()) {
            if (txtPhone.getText().equals(kh.getPhone())) {
                JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại");
                return false;
            }
            if (txtEmail.getText().equalsIgnoreCase(kh.getEmail())) {
                JOptionPane.showMessageDialog(this, "Email đã tồn tại");
                return false;
            }
            if (txtCustomerCode.getText().equalsIgnoreCase(kh.getCustomerCode())) {
                JOptionPane.showMessageDialog(this, "CustomerCode đã tồn tại");
                return false;
            }
        }
        return true;
    }

    public boolean checkDuplicateUpdate() {
        int currentID = Integer.parseInt(txtCustomerID.getText());

        for (Customer kh : khrepo.getAll()) {
            if (kh.getCustomerID() == currentID) {
                continue;
            }

            if (txtPhone.getText().equals(kh.getPhone())) {
                JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại");
                return false;
            }
            if (txtEmail.getText().equalsIgnoreCase(kh.getEmail())) {
                JOptionPane.showMessageDialog(this, "Email đã tồn tại");
                return false;
            }
            if (txtCustomerCode.getText().equalsIgnoreCase(kh.getCustomerCode())) {
                JOptionPane.showMessageDialog(this, "CustomerCode đã tồn tại");
                return false;
            }
        }
        return true;
    }

    public int genderFilter() {
        if (cboFilter.getSelectedItem().equals("Nam")) {
            return 1;
        }
        return 0;
    }

    @Override
    public void open() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setForm(int index) {
        txtCustomerID.setText(tblKhachHang.getValueAt(index, 0) + "");
        txtName.setText(tblKhachHang.getValueAt(index, 1) + "");
        txtEmail.setText(tblKhachHang.getValueAt(index, 3) + "");
        txtPhone.setText(tblKhachHang.getValueAt(index, 2) + "");
        if (tblKhachHang.getValueAt(index, 4).equals("Nam")) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        txtCustomerCode.setText(tblKhachHang.getValueAt(index, 5) + "");
    }

    @Override
    public Customer getForm() {
        Customer kh = new Customer();
        kh.setFullname(txtName.getText());
        kh.setPhone(txtPhone.getText());
        kh.setEmail(txtEmail.getText());
        kh.setGender(rdoNam.isSelected());
        kh.setCustomerID(Integer.parseInt(txtCustomerID.getText()));
        kh.setCustomerCode(txtCustomerCode.getText());
        return kh;
    }

    @Override
    public void fillToTable(List<Customer> lst) {
        this.list = lst;
        dtm.setRowCount(0);
        for (Customer kh : lst) {
            dtm.addRow(new Object[]{kh.getCustomerID(), kh.getFullname(), kh.getPhone(), kh.getEmail(), kh.isGender() ? "Nam" : "Nữ", kh.getCustomerCode()});
        }
    }

    @Override
    public void edit() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setEditable(boolean editable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void checkAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void uncheckAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteCheckedItems() {

        if (txtCustomerID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng bạn muốn xóa!");
            return;
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa không. Việc này sẽ xóa toàn bộ thông tin liên quan đến khách hàng này.");
            if (confirm == JOptionPane.YES_OPTION) {
                khrepo.delete(Integer.parseInt(txtCustomerID.getText()));
                fillToTable(khrepo.getAll());
            } else {
                return;
            }
        };

    }

    @Override
    public void moveFirst() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void movePrevious() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void moveNext() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void moveLast() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void moveTo(int rowIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setForm(Customer entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }
}
