package poly.barber.view.dialog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import poly.barber.controller.Impl.AppointmentController;
import poly.barber.entity.Appointment;
import poly.barber.service.AppointmentDetailService;
import poly.barber.service.AppointmentService;
import poly.barber.service.BarberService;
import poly.barber.service.CustomerService;
import poly.barber.service.ServiceCategoryService;
import poly.barber.service.ServiceService;

public class AppointmentJDialog extends javax.swing.JDialog implements AppointmentController {

    DefaultTableModel modelCalendar = new DefaultTableModel();
    DefaultTableModel modelService = new DefaultTableModel();

    DefaultComboBoxModel<String> comboWeek = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> comboBarber = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> comboBarberName = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> comboCategory = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> comboService = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> comboCustomer = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> comboTimeRange = new DefaultComboBoxModel<>();
//    private 
    AppointmentService serAppointment = new AppointmentService();
    AppointmentDetailService serAppointmentDetail = new AppointmentDetailService();
    ServiceService serService = new ServiceService();
    BarberService serBarber = new BarberService();
    ServiceCategoryService serServiceCategory = new ServiceCategoryService();
    CustomerService serCustomer = new CustomerService();

    List<Object[]> dichVu = new ArrayList<>();

    public AppointmentJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        open();

        tblCalendar.setRowHeight(110);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupStatus = new javax.swing.ButtonGroup();
        Tabbs = new javax.swing.JTabbedPane();
        panelCalendar = new javax.swing.JPanel();
        txtFind = new javax.swing.JTextField();
        cboWeek = new javax.swing.JComboBox<>();
        btnAddAppoint = new javax.swing.JButton();
        rdoPending = new javax.swing.JRadioButton();
        rdoCanceled = new javax.swing.JRadioButton();
        rdoCheckIned = new javax.swing.JRadioButton();
        rdoAll = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCalendar = new javax.swing.JTable();
        cboBarber = new javax.swing.JComboBox<>();
        btnCancelFilter = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelCrud = new javax.swing.JPanel();
        btnChooseCustomer = new javax.swing.JButton();
        lblCusName = new javax.swing.JLabel();
        btnChooseDate = new javax.swing.JButton();
        lblDate = new javax.swing.JLabel();
        cboCategory = new javax.swing.JComboBox<>();
        cboService = new javax.swing.JComboBox<>();
        lblCusName1 = new javax.swing.JLabel();
        btnAddService = new javax.swing.JButton();
        cboTimeRange = new javax.swing.JComboBox<>();
        btnBarber = new javax.swing.JButton();
        lblBarberName = new javax.swing.JLabel();
        lblBarberPosition = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAppointment = new javax.swing.JTable();
        txtQuantity = new javax.swing.JTextField();
        lblTotalAmount = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        txtCustomerPhone = new javax.swing.JTextField();
        txtAppointmentDate = new javax.swing.JTextField();
        lblServiceCategory = new javax.swing.JLabel();
        lblService = new javax.swing.JLabel();
        txtServiceCategoryName = new javax.swing.JTextField();
        txtServiceName = new javax.swing.JTextField();
        txtBarberName = new javax.swing.JTextField();
        txtBarberPosition = new javax.swing.JTextField();
        lblQuantity = new javax.swing.JLabel();
        txtAppointmentTime = new javax.swing.JTextField();
        lblAppointmentTime = new javax.swing.JLabel();
        btnAddAppointment = new javax.swing.JButton();
        txtNote = new java.awt.TextArea();
        lblNote = new javax.swing.JLabel();
        cboCustomer = new javax.swing.JComboBox<>();
        cboBarberName = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LỊCH");

        txtFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindActionPerformed(evt);
            }
        });

        cboWeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboWeekActionPerformed(evt);
            }
        });

        btnAddAppoint.setText("Thêm lịch");
        btnAddAppoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAppointActionPerformed(evt);
            }
        });

        rdoPending.setBackground(new java.awt.Color(204, 204, 204));
        btnGroupStatus.add(rdoPending);
        rdoPending.setText("Chưa đến");
        rdoPending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoPendingActionPerformed(evt);
            }
        });

        rdoCanceled.setBackground(new java.awt.Color(255, 204, 204));
        btnGroupStatus.add(rdoCanceled);
        rdoCanceled.setText("Đã hủy");
        rdoCanceled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoCanceledActionPerformed(evt);
            }
        });

        rdoCheckIned.setBackground(new java.awt.Color(153, 255, 153));
        btnGroupStatus.add(rdoCheckIned);
        rdoCheckIned.setText("Đã đến");
        rdoCheckIned.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoCheckInedActionPerformed(evt);
            }
        });

        btnGroupStatus.add(rdoAll);
        rdoAll.setText("Tất cả");
        rdoAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoAllActionPerformed(evt);
            }
        });

        tblCalendar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCalendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCalendarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCalendar);

        cboBarber.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cboBarber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBarberActionPerformed(evt);
            }
        });

        btnCancelFilter.setText("BỎ LỌC");
        btnCancelFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelFilterActionPerformed(evt);
            }
        });

        btnFind.setText("TÌM");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        jLabel1.setText("LỌC THEO THỢ CẮT");

        jLabel2.setText("LỌC THEO TUẦN");

        jLabel3.setText("TÌM KIẾM THEO TÊN VÀ SĐT KH");

        jLabel4.setText("LỌC THEO TÌNH TRẠNG");

        javax.swing.GroupLayout panelCalendarLayout = new javax.swing.GroupLayout(panelCalendar);
        panelCalendar.setLayout(panelCalendarLayout);
        panelCalendarLayout.setHorizontalGroup(
            panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCalendarLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCalendarLayout.createSequentialGroup()
                        .addComponent(rdoAll, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdoPending, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdoCheckIned, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdoCanceled, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelFilter)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelCalendarLayout.createSequentialGroup()
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFind)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(cboBarber, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddAppoint, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        panelCalendarLayout.setVerticalGroup(
            panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCalendarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboWeek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddAppoint)
                    .addComponent(cboBarber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoPending)
                    .addComponent(rdoCanceled)
                    .addComponent(rdoCheckIned)
                    .addComponent(btnCancelFilter)
                    .addComponent(rdoAll)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tabbs.addTab("LỊCH", panelCalendar);

        btnChooseCustomer.setText("CHỌN KHÁCH HÀNG");

        lblCusName.setText("TÊN KHÁCH HÀNG:");

        btnChooseDate.setText("CHỌN NGÀY");

        lblDate.setText("NGÀY:");

        cboCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoryActionPerformed(evt);
            }
        });

        cboService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboServiceActionPerformed(evt);
            }
        });

        lblCusName1.setText("SỐ ĐT KHÁCH HÀNG:");

        btnAddService.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAddService.setText("THÊM DỊCH VỤ");
        btnAddService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddServiceActionPerformed(evt);
            }
        });

        cboTimeRange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTimeRangeActionPerformed(evt);
            }
        });

        btnBarber.setText("CHỌN THỢ CẮT TÓC");

        lblBarberName.setText("TÊN THỢ:");

        lblBarberPosition.setText("VỊ TRÍ:");

        tblAppointment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã DV", "Loại DV", "Tên DV", "Tên thợ cắt", "Thời gian hẹn", "Số lượng", "Giá dịch vụ", "Mã KH", "Tên KH", "Số ĐT KH"
            }
        ));
        jScrollPane2.setViewportView(tblAppointment);

        lblTotalAmount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTotalAmount.setText("TỔNG SỐ TIỀN:");

        lblServiceCategory.setText("TÊN LOẠI DỊCH VỤ:");

        lblService.setText("TÊN DỊCH VỤ");

        lblQuantity.setText("SỐ LƯỢNG:");

        lblAppointmentTime.setText("THỜI GIAN HẸN:");

        btnAddAppointment.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAddAppointment.setText("ĐẶT LỊCH");

        txtNote.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        lblNote.setText("GHI CHÚ:");

        cboCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCustomerActionPerformed(evt);
            }
        });

        cboBarberName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBarberNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCrudLayout = new javax.swing.GroupLayout(panelCrud);
        panelCrud.setLayout(panelCrudLayout);
        panelCrudLayout.setHorizontalGroup(
            panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrudLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCrudLayout.createSequentialGroup()
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelCrudLayout.createSequentialGroup()
                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnChooseCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(btnChooseDate, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(cboCategory, 0, 150, Short.MAX_VALUE)
                                    .addComponent(cboService, 0, 150, Short.MAX_VALUE)
                                    .addComponent(cboTimeRange, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboCustomer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblCusName1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCusName)
                                    .addComponent(lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblServiceCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblAppointmentTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panelCrudLayout.createSequentialGroup()
                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnBarber, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(cboBarberName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblBarberName, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBarberPosition)
                                    .addComponent(lblQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCustomerName)
                            .addComponent(txtCustomerPhone)
                            .addComponent(txtAppointmentDate)
                            .addComponent(txtServiceCategoryName)
                            .addComponent(txtServiceName)
                            .addComponent(txtBarberName)
                            .addComponent(txtBarberPosition)
                            .addComponent(txtQuantity)
                            .addComponent(txtAppointmentTime, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)))
                    .addComponent(btnAddService, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNote))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrudLayout.createSequentialGroup()
                        .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalAmount)
                            .addComponent(btnAddAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panelCrudLayout.setVerticalGroup(
            panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrudLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelCrudLayout.createSequentialGroup()
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnChooseCustomer)
                            .addComponent(lblCusName)
                            .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCusName1)
                            .addComponent(txtCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChooseDate)
                            .addComponent(txtAppointmentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblServiceCategory)
                                .addComponent(txtServiceCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblService)
                            .addComponent(txtServiceName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboTimeRange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAppointmentTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAppointmentTime))
                        .addGap(18, 18, 18)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBarber)
                            .addComponent(lblBarberName)
                            .addComponent(txtBarberName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBarberPosition)
                            .addComponent(txtBarberPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboBarberName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblQuantity))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddService, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCrudLayout.createSequentialGroup()
                        .addComponent(lblTotalAmount)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddAppointment))
                    .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNote))
                .addContainerGap(202, Short.MAX_VALUE))
        );

        Tabbs.addTab("ĐẶT LỊCH", panelCrud);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabbs)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabbs, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdoPendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoPendingActionPerformed
        fillToTable(serAppointment.getAll());
    }//GEN-LAST:event_rdoPendingActionPerformed

    private void cboWeekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboWeekActionPerformed
        int index = cboWeek.getSelectedIndex();

        setCalendarHeaderTables(serAppointment.getCalendarHeaderTables(index));

        fillToTable(serAppointment.getAll());
    }//GEN-LAST:event_cboWeekActionPerformed

    private void btnCancelFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelFilterActionPerformed
        rdoAll.setSelected(true);
        cboBarber.setSelectedIndex(0);
        txtFind.setText("");
        fillToTable(serAppointment.getAll());
    }//GEN-LAST:event_btnCancelFilterActionPerformed

    private void rdoAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoAllActionPerformed
        fillToTable(serAppointment.getAll());
    }//GEN-LAST:event_rdoAllActionPerformed

    private void rdoCheckInedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoCheckInedActionPerformed
        fillToTable(serAppointment.getAll());
    }//GEN-LAST:event_rdoCheckInedActionPerformed

    private void cboBarberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBarberActionPerformed
        fillToTable(serAppointment.getAll());
    }//GEN-LAST:event_cboBarberActionPerformed

    private void rdoCanceledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoCanceledActionPerformed
        fillToTable(serAppointment.getAll());
    }//GEN-LAST:event_rdoCanceledActionPerformed

    private void txtFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFindActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        fillToTable(serAppointment.getAll());
    }//GEN-LAST:event_btnFindActionPerformed

    private void cboCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoryActionPerformed
        txtServiceCategoryName.setText(cboCategory.getSelectedItem().toString());
    }//GEN-LAST:event_cboCategoryActionPerformed

    private void cboCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCustomerActionPerformed
        txtCustomerName.setText(cboCustomer.getSelectedItem().toString());

        txtCustomerPhone.setText(serCustomer.getOneByName(cboCustomer.getSelectedItem().toString()).getPhone());
    }//GEN-LAST:event_cboCustomerActionPerformed

    private void cboServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboServiceActionPerformed
        txtServiceName.setText(cboService.getSelectedItem().toString());
    }//GEN-LAST:event_cboServiceActionPerformed

    private void cboTimeRangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTimeRangeActionPerformed
        txtAppointmentTime.setText(cboTimeRange.getSelectedItem().toString());
    }//GEN-LAST:event_cboTimeRangeActionPerformed

    private void cboBarberNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBarberNameActionPerformed
        txtBarberName.setText(cboBarberName.getSelectedItem().toString());

        String barbarName = txtBarberName.getText();

        int positionID = serBarber.getOneByName(barbarName).getPositionID();

        String positionName = serBarber.getPositionNameByID(positionID);

        txtBarberPosition.setText(positionName);
    }//GEN-LAST:event_cboBarberNameActionPerformed

    private void btnAddServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddServiceActionPerformed
        int serviceID = serService.getOneByName(txtServiceName.getText()).getServiceID();
        BigDecimal servicePrice = serService.getOneByName(txtServiceName.getText()).getPrice();
        int customerID = serCustomer.getOneByName(txtCustomerName.getText()).getCustomerID();

        Object[] row = {
            serviceID + "",
            txtServiceCategoryName.getText(),
            txtServiceName.getText(),
            txtBarberName.getText(),
            txtAppointmentTime.getText(),
            txtQuantity.getText(),
            servicePrice + "",
            customerID + "",
            txtCustomerName.getText(),
            txtCustomerPhone.getText()
        };

        dichVu.add(row);

        modelService = (DefaultTableModel) tblAppointment.getModel();

        modelService.setRowCount(0);

        for (Object[] o : dichVu) {
            modelService.addRow(row);
        }

        clear();
    }//GEN-LAST:event_btnAddServiceActionPerformed

    private void tblCalendarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCalendarMouseClicked
        int row = tblCalendar.getSelectedRow();
        int col = tblCalendar.getSelectedColumn();

        // 1. Kiểm tra: Không làm gì nếu click vào cột Time (cột 0) hoặc vùng trống
        if (col <= 0 || row == -1) {
            return;
        }

        // Thực hiện khi người dùng Double Click (nhấn 2 lần) để tránh bấm nhầm
        if (evt.getClickCount() == 2) {
            try {
                // 2. Lấy Giờ từ cột đầu tiên (Ví dụ: "08:00")
                // Thêm ":00" để đúng định dạng HH:mm:ss cho SQL Time
                String timeStr = tblCalendar.getValueAt(row, 0).toString() + ":00";
                java.sql.Time targetTime = java.sql.Time.valueOf(timeStr);

                // 3. Lấy Ngày từ tiêu đề cột (Định dạng của bạn: "Th ... - dd/MM/yyyy")
                String header = tblCalendar.getColumnName(col);
                // Cắt chuỗi lấy phần sau dấu "-"
                String dateStr = header.substring(header.lastIndexOf("-") + 1).trim();

                // Chuyển chuỗi dd/MM/yyyy sang java.sql.Date
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
                java.util.Date parsedDate = sdf.parse(dateStr);
                java.sql.Date targetDate = new java.sql.Date(parsedDate.getTime());

                // 4. Gọi Service để lấy danh sách HTML chi tiết
                // Lưu ý: Thay 'appointmentService' bằng tên biến service bạn đã khai báo
                List<String> details = serAppointment.getAppointmentHtmlDetails(targetDate, targetTime);

                // 5. Hiển thị thông báo
                if (details != null && !details.isEmpty()) {
                    Object[] message = details.toArray();
                    javax.swing.JOptionPane.showMessageDialog(this,
                            message,
                            "Chi tiết lịch hẹn [" + dateStr + " " + timeStr.substring(0, 5) + "]",
                            javax.swing.JOptionPane.INFORMATION_MESSAGE);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Không có lịch hẹn trong khung giờ này.");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                javax.swing.JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi lấy chi tiết: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_tblCalendarMouseClicked

    private void btnAddAppointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAppointActionPerformed
        Tabbs.setSelectedIndex(1);
    }//GEN-LAST:event_btnAddAppointActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AppointmentJDialog dialog = new AppointmentJDialog(new javax.swing.JFrame(), true);
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

    @Override
    public void open() {
        this.setLocationRelativeTo(null);

        comboWeek = (DefaultComboBoxModel<String>) cboWeek.getModel();

        comboBarber = (DefaultComboBoxModel<String>) cboBarber.getModel();

        comboCategory = (DefaultComboBoxModel<String>) cboCategory.getModel();

        comboService = (DefaultComboBoxModel<String>) cboService.getModel();

        comboCustomer = (DefaultComboBoxModel<String>) cboCustomer.getModel();

        comboTimeRange = (DefaultComboBoxModel<String>) cboTimeRange.getModel();

        comboBarberName = (DefaultComboBoxModel<String>) cboBarberName.getModel();

        // 
        fillToComboWeek();

        fillToComboBarber();

        fillToComboCategory();

        fillToComboService();

        fillToComboCustomer();

        fillToComboTimeRange();

        cboWeek.setSelectedIndex(1);

        this.setCalendarHeaderTables(serAppointment.getCalendarHeaderTables(1));

        fillToTable(serAppointment.getAll());
    }

    public void setCalendarHeaderTables(List<String> lst) {
        String[] columns = lst.toArray(new String[0]);

        modelCalendar = (DefaultTableModel) tblCalendar.getModel();

        modelCalendar.setColumnIdentifiers(columns);
    }

    @Override
    public void setForm(Appointment entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Appointment getForm() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void fillToTable(List<Appointment> lst) {
        int week = cboWeek.getSelectedIndex();
        int status;
        if (rdoPending.isSelected()) {
            status = 1; // Chưa đến
        } else if (rdoCheckIned.isSelected()) {
            status = 2; // Đã đến
        } else if (rdoCanceled.isSelected()) {
            status = 3; // Đã hủy
        } else {
            status = 0; // Tất cả
        }

        Object selectedBarber = cboBarber.getSelectedItem();
        String barber = (selectedBarber != null) ? selectedBarber.toString().trim() : "";

        if (barber.equals(" ") || barber.isEmpty()) {
            barber = "";
        }

        String customer = txtFind.getText().trim();

        List<Object[]> data = serAppointment.getUniversalCalendar(week, status, barber, customer);

        modelCalendar.setRowCount(0);
        for (Object[] rows : data) {
            modelCalendar.addRow(rows);
        }
    }

    public void fillToComboWeek() {
        comboWeek.removeAllElements();

        String[] items = {"lịch tuần trước", "lịch tuần này", "lịch tuần sau"};

        for (String i : items) {
            comboWeek.addElement(i);
        }

    }

    public void fillToComboBarber() {
        comboBarber.removeAllElements();

        List<String> items = serBarber.fillToComboBarberName(serBarber.getAll());

        for (String item : items) {
            comboBarber.addElement(item);
        }
    }

    public void fillToComboBarberName() {
        comboBarberName.removeAllElements();

        List<String> items = serBarber.fillToComboBarberName(serBarber.getAll());

        for (String item : items) {
            comboBarberName.addElement(item);
        }
    }

    public void fillToComboCategory() {
        comboCategory.removeAllElements();

        List<String> items = serServiceCategory.fillToComboServiceCategoryName(serServiceCategory.getAll());

        for (String i : items) {
            comboCategory.addElement(i);
        }
    }

    public void fillToComboService() {
        comboService.removeAllElements();

        List<String> items = serService.fillToComboServiceName(serService.getAll());

        for (String i : items) {
            comboService.addElement(i);
        }
    }

    public void fillToComboCustomer() {
        comboCustomer.removeAllElements();

        List<String> items = serCustomer.fillToComboCustomerName(serCustomer.getAll());

        for (String i : items) {
            comboCustomer.addElement(i);
        }
    }

    public void fillToComboTimeRange() {
        comboTimeRange.removeAllElements();

        List<String> items = serAppointment.fillToComboTimeRange();

        for (String i : items) {
            comboTimeRange.addElement(i);
        }
    }

    @Override
    public void edit() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        txtCustomerName.setText("");
        txtCustomerPhone.setText("");
        txtAppointmentDate.setText("");
        txtServiceCategoryName.setText("");
        txtServiceName.setText("");
        txtAppointmentTime.setText("");
        txtBarberName.setText("");
        txtBarberPosition.setText("");
        txtQuantity.setText("");
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Tabbs;
    private javax.swing.JButton btnAddAppoint;
    private javax.swing.JButton btnAddAppointment;
    private javax.swing.JButton btnAddService;
    private javax.swing.JButton btnBarber;
    private javax.swing.JButton btnCancelFilter;
    private javax.swing.JButton btnChooseCustomer;
    private javax.swing.JButton btnChooseDate;
    private javax.swing.JButton btnFind;
    private javax.swing.ButtonGroup btnGroupStatus;
    private javax.swing.JComboBox<String> cboBarber;
    private javax.swing.JComboBox<String> cboBarberName;
    private javax.swing.JComboBox<String> cboCategory;
    private javax.swing.JComboBox<String> cboCustomer;
    private javax.swing.JComboBox<String> cboService;
    private javax.swing.JComboBox<String> cboTimeRange;
    private javax.swing.JComboBox<String> cboWeek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAppointmentTime;
    private javax.swing.JLabel lblBarberName;
    private javax.swing.JLabel lblBarberPosition;
    private javax.swing.JLabel lblCusName;
    private javax.swing.JLabel lblCusName1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblNote;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblService;
    private javax.swing.JLabel lblServiceCategory;
    private javax.swing.JLabel lblTotalAmount;
    private javax.swing.JPanel panelCalendar;
    private javax.swing.JPanel panelCrud;
    private javax.swing.JRadioButton rdoAll;
    private javax.swing.JRadioButton rdoCanceled;
    private javax.swing.JRadioButton rdoCheckIned;
    private javax.swing.JRadioButton rdoPending;
    private javax.swing.JTable tblAppointment;
    private javax.swing.JTable tblCalendar;
    private javax.swing.JTextField txtAppointmentDate;
    private javax.swing.JTextField txtAppointmentTime;
    private javax.swing.JTextField txtBarberName;
    private javax.swing.JTextField txtBarberPosition;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtCustomerPhone;
    private javax.swing.JTextField txtFind;
    private java.awt.TextArea txtNote;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtServiceCategoryName;
    private javax.swing.JTextField txtServiceName;
    // End of variables declaration//GEN-END:variables
}
