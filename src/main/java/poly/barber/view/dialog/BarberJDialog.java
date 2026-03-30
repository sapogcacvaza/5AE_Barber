package poly.barber.view.dialog;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import poly.barber.controller.Impl.BarberController;
import poly.barber.entity.Barber;
import poly.barber.entity.ServiceCategory;
import poly.barber.service.AppointmentService;
import poly.barber.service.BarberService;
import poly.barber.service.ServiceCategoryService;
import poly.barber.service.ServiceService;
import poly.barber.util.XDialog;

public class BarberJDialog extends javax.swing.JDialog implements BarberController {

    DefaultTableModel modelBarber = new DefaultTableModel();

    DefaultComboBoxModel<String> comboCategory = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> comboService = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> comboTimeRange = new DefaultComboBoxModel<>();

    BarberService serBarber = new BarberService();
    ServiceCategoryService serCategory = new ServiceCategoryService();
    ServiceService serService = new ServiceService();
    AppointmentService serAppointment = new AppointmentService();

    private Barber selectedBarber;
    private List<Barber> list = new ArrayList<>();

    public BarberJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        open();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        pnlList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBarber = new javax.swing.JTable();
        btnChooseBarber = new javax.swing.JButton();
        cboCategoryName = new javax.swing.JComboBox<>();
        cboServiceName = new javax.swing.JComboBox<>();
        cboTimeRange = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 873, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Thêm mới", jPanel2);

        tblBarber.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Trạng thái làm việc", "Trạng thái", "Họ và tên", "Số điện thoại", "Email", "Vị trí"
            }
        ));
        jScrollPane1.setViewportView(tblBarber);

        btnChooseBarber.setText("Chọn barber");
        btnChooseBarber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseBarberActionPerformed(evt);
            }
        });

        cboCategoryName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoryNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlListLayout = new javax.swing.GroupLayout(pnlList);
        pnlList.setLayout(pnlListLayout);
        pnlListLayout.setHorizontalGroup(
            pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnChooseBarber, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlListLayout.createSequentialGroup()
                        .addComponent(cboCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboServiceName, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboTimeRange, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlListLayout.setVerticalGroup(
            pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboServiceName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTimeRange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(btnChooseBarber)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Danh sách", pnlList);

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

    private void btnChooseBarberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseBarberActionPerformed
        int row = tblBarber.getSelectedRow();
        if (row < 0) {
            XDialog.alert("Vui lòng chọn khách hàng!");
            return;
        }

        selectedBarber = list.get(row);
        this.dispose();
    }//GEN-LAST:event_btnChooseBarberActionPerformed

    private void cboCategoryNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoryNameActionPerformed
        fillToComboService();
    }//GEN-LAST:event_cboCategoryNameActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BarberJDialog dialog = new BarberJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnChooseBarber;
    private javax.swing.JComboBox<String> cboCategoryName;
    private javax.swing.JComboBox<String> cboServiceName;
    private javax.swing.JComboBox<String> cboTimeRange;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pnlList;
    private javax.swing.JTable tblBarber;
    // End of variables declaration//GEN-END:variables

    @Override
    public void open() {
        setLocationRelativeTo(null);

        modelBarber = (DefaultTableModel) tblBarber.getModel();

        comboCategory = (DefaultComboBoxModel<String>) cboCategoryName.getModel();

        comboService = (DefaultComboBoxModel<String>) cboServiceName.getModel();

        comboTimeRange = (DefaultComboBoxModel<String>) cboTimeRange.getModel();

        fillToComboCategory();

//        fillToComboTimeRange();

        fillToTable(serBarber.getAll());
    }

    @Override
    public void setForm(Barber entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Barber getForm() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void fillToTable(List<Barber> lst) {
        this.list = lst;
        modelBarber.setRowCount(0);

        for (Barber b : lst) {
            modelBarber.addRow(new Object[]{
                b.getBarberID(),
                b.isBusy() ? "Đang phục vụ" : "Sẵn sàng",
                b.isStatus() ? "Làm" : "Nghỉ",
                b.getFirstname() + " " + b.getLastname(),
                b.getPhone(),
                b.getEmail(),
                serBarber.getPositionNameByID(b.getPositionID())
            });
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    public Barber getSelectedBarber() {
        return selectedBarber;
    }

    public void fillToComboCategory() {
        comboCategory.removeAllElements();

        List<String> items = serCategory.fillToComboServiceCategoryName(serCategory.getAll());

        for (String i : items) {
            comboCategory.addElement(i);
        }
    }

    public void fillToComboService() {
        comboService.removeAllElements();
        
        Object selected = cboCategoryName.getSelectedItem();

        String categoryName = (selected != null) ? selected.toString() : "";
        
        System.out.println(categoryName);
        
        int serviceCatID = serCategory.getOneByName(cboCategoryName.getSelectedItem().toString()).getServiceCategoryID();

        List<String> items = serService.fillToComboServiceName(serService.getOneByCat(serviceCatID));

        for (String i : items) {
            comboService.addElement(i);
        }
    }

//    public void fillToComboTimeRange() {
//        comboTimeRange.removeAllElements();
//
//        List<String> items = serAppointment.fillToComboTimeRange();
//
//        for (String i : items) {
//            comboTimeRange.addElement(i);
//        }
//    }

}
