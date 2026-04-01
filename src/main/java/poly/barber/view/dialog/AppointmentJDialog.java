package poly.barber.view.dialog;

import java.awt.Font;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import poly.barber.controller.Impl.AppointmentController;
import poly.barber.entity.Appointment;
import poly.barber.entity.AppointmentDetail;
import poly.barber.entity.Barber;
import poly.barber.entity.Customer;
import poly.barber.service.AppointmentDetailService;
import poly.barber.service.AppointmentService;
import poly.barber.service.BarberService;
import poly.barber.service.CustomerService;
import poly.barber.service.ServiceCategoryService;
import poly.barber.service.ServiceService;
import poly.barber.util.CustomCalendar;
import poly.barber.util.XDialog;

public class AppointmentJDialog extends javax.swing.JDialog implements AppointmentController {

    DefaultTableModel modelCalendar = new DefaultTableModel();
    DefaultTableModel modelService = new DefaultTableModel();
    DefaultTableModel modelBarber = new DefaultTableModel();

    DefaultComboBoxModel<String> comboWeek = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> comboBarber = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> comboBarberName = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> comboCategory = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> comboService = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> comboTimeRange = new DefaultComboBoxModel<>();

    AppointmentService serAppointment = new AppointmentService();
    AppointmentDetailService serAppointmentDetail = new AppointmentDetailService();
    ServiceService serService = new ServiceService();
    BarberService serBarber = new BarberService();
    ServiceCategoryService serServiceCategory = new ServiceCategoryService();
    CustomerService serCustomer = new CustomerService();

    JPopupMenu popCalendar = new JPopupMenu();
    CustomCalendar cal = new CustomCalendar();

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
        rdoWaiting = new javax.swing.JRadioButton();
        rdoCanceled = new javax.swing.JRadioButton();
        rdoCheckIned = new javax.swing.JRadioButton();
        rdoPending = new javax.swing.JRadioButton();
        rdoAll = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCalendar = new javax.swing.JTable();
        cboBarber = new javax.swing.JComboBox<>();
        btnCancelFilter = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        lblFilterByBarber = new javax.swing.JLabel();
        lblFilterByWeek = new javax.swing.JLabel();
        lblFind = new javax.swing.JLabel();
        lblFilterByStatus = new javax.swing.JLabel();
        panelCrud = new javax.swing.JPanel();
        btnChooseCustomer = new javax.swing.JButton();
        btnChooseDate = new javax.swing.JButton();
        lblDate = new javax.swing.JLabel();
        cboCategory = new javax.swing.JComboBox<>();
        cboService = new javax.swing.JComboBox<>();
        btnAddService = new javax.swing.JButton();
        cboTimeRange = new javax.swing.JComboBox<>();
        btnChooseBarber = new javax.swing.JButton();
        lblBarberName = new javax.swing.JLabel();
        lblBarberPosition = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSercive = new javax.swing.JTable();
        txtQuantity = new javax.swing.JTextField();
        lblTotalAmount = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        txtCustomerPhone = new javax.swing.JTextField();
        txtAppointmentDate = new javax.swing.JTextField();
        lblServiceCategory = new javax.swing.JLabel();
        lblService = new javax.swing.JLabel();
        txtBarberName = new javax.swing.JTextField();
        txtBarberPosition = new javax.swing.JTextField();
        lblQuantity = new javax.swing.JLabel();
        lblAppointmentTime = new javax.swing.JLabel();
        btnAddAppointment = new javax.swing.JButton();
        txtNote = new java.awt.TextArea();
        lblNote = new javax.swing.JLabel();
        lblCustomerName = new javax.swing.JLabel();
        lblCustomerPhone = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAppointment = new javax.swing.JTable();
        lblTitle1 = new javax.swing.JLabel();
        btnGetListBarber = new javax.swing.JButton();
        lblTotalAmount4 = new javax.swing.JLabel();
        txtTotalDuration = new javax.swing.JTextField();
        txtTotalPrice = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnClear = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblBarber = new javax.swing.JTable();
        lblTitle2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

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

        rdoWaiting.setBackground(new java.awt.Color(204, 204, 204));
        btnGroupStatus.add(rdoWaiting);
        rdoWaiting.setText("Chưa đến");
        rdoWaiting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoWaitingActionPerformed(evt);
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

        rdoPending.setBackground(new java.awt.Color(255, 204, 102));
        btnGroupStatus.add(rdoPending);
        rdoPending.setText("Đang chờ xử lý");
        rdoPending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoPendingActionPerformed(evt);
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

        lblFilterByBarber.setText("LỌC THEO THỢ CẮT");

        lblFilterByWeek.setText("LỌC THEO TUẦN");

        lblFind.setText("TÌM KIẾM THEO TÊN VÀ SĐT KH");

        lblFilterByStatus.setText("LỌC THEO TÌNH TRẠNG");

        javax.swing.GroupLayout panelCalendarLayout = new javax.swing.GroupLayout(panelCalendar);
        panelCalendar.setLayout(panelCalendarLayout);
        panelCalendarLayout.setHorizontalGroup(
            panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCalendarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelCalendarLayout.createSequentialGroup()
                        .addGroup(panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFind)
                            .addComponent(lblFilterByStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCalendarLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(rdoAll, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdoWaiting, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdoCheckIned, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdoCanceled, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdoPending)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelFilter))
                            .addGroup(panelCalendarLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblFilterByBarber)
                                .addGap(18, 18, 18)
                                .addComponent(cboBarber, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblFilterByWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cboWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddAppoint, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
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
                    .addComponent(lblFilterByBarber)
                    .addComponent(lblFilterByWeek)
                    .addComponent(lblFind))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoWaiting)
                    .addComponent(rdoCanceled)
                    .addComponent(rdoCheckIned)
                    .addComponent(btnCancelFilter)
                    .addComponent(rdoAll)
                    .addComponent(lblFilterByStatus)
                    .addComponent(rdoPending))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tabbs.addTab("LỊCH", panelCalendar);

        btnChooseCustomer.setText("CHỌN KHÁCH HÀNG");
        btnChooseCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseCustomerActionPerformed(evt);
            }
        });

        btnChooseDate.setText("CHỌN NGÀY");
        btnChooseDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseDateActionPerformed(evt);
            }
        });

        lblDate.setText("NGÀY HẸN:");

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

        btnChooseBarber.setText("CHỌN THỢ CẮT TÓC");
        btnChooseBarber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseBarberActionPerformed(evt);
            }
        });

        lblBarberName.setText("TÊN THỢ:");

        lblBarberPosition.setText("VỊ TRÍ:");

        tblSercive.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã DV", "Loại DV", "Tên DV", "Tên thợ cắt", "Thời gian DV", "Số lượng", "Giá dịch vụ"
            }
        ));
        jScrollPane2.setViewportView(tblSercive);

        lblTotalAmount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotalAmount.setText("TỔNG SỐ TIỀN:");

        txtCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerNameActionPerformed(evt);
            }
        });

        txtAppointmentDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAppointmentDateActionPerformed(evt);
            }
        });

        lblServiceCategory.setText("TÊN LOẠI DỊCH VỤ:");

        lblService.setText("TÊN DỊCH VỤ");

        lblQuantity.setText("SỐ LƯỢNG DỊCH VỤ:");

        lblAppointmentTime.setText("THỜI GIAN HẸN:");

        btnAddAppointment.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAddAppointment.setText("ĐẶT LỊCH");
        btnAddAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAppointmentActionPerformed(evt);
            }
        });

        txtNote.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        lblNote.setText("GHI CHÚ:");

        lblCustomerName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCustomerName.setText("TÊN KH:");

        lblCustomerPhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCustomerPhone.setText("SỐ ĐT KH:");

        tblAppointment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã lịch", "Tên khách hàng", "Số khách hàng", "Thời gian hẹn", "Trạng thái"
            }
        ));
        jScrollPane3.setViewportView(tblAppointment);

        lblTitle1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle1.setText("THÊM DỊCH VỤ VÀO LỊCH MỚI");

        btnGetListBarber.setText("XUẤT DANH SÁCH THỢ");
        btnGetListBarber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetListBarberActionPerformed(evt);
            }
        });

        lblTotalAmount4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotalAmount4.setText("TỔNG THỜI GIAN:");

        btnClear.setText("LÀM MỚI");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        tblBarber.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Họ và tên", "Vị trí"
            }
        ));
        jScrollPane4.setViewportView(tblBarber);

        lblTitle2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle2.setText("QUẢN LÝ TRẠNG THÁI LỊCH VÀ DỊCH VỤ");

        jRadioButton1.setBackground(new java.awt.Color(153, 255, 153));
        jRadioButton1.setText("Đã đến");

        jRadioButton2.setBackground(new java.awt.Color(255, 204, 204));
        jRadioButton2.setText("Hủy lịch");

        jButton1.setText("THAY ĐỔI TRẠNG THÁI");

        javax.swing.GroupLayout panelCrudLayout = new javax.swing.GroupLayout(panelCrud);
        panelCrud.setLayout(panelCrudLayout);
        panelCrudLayout.setHorizontalGroup(
            panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrudLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(panelCrudLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelCrudLayout.createSequentialGroup()
                                .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnChooseBarber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrudLayout.createSequentialGroup()
                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblBarberName, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBarberPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBarberPosition, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                                    .addComponent(txtBarberName)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrudLayout.createSequentialGroup()
                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCrudLayout.createSequentialGroup()
                                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnChooseDate, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblServiceCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblAppointmentTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, Short.MAX_VALUE))
                                    .addGroup(panelCrudLayout.createSequentialGroup()
                                        .addComponent(lblService, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnGetListBarber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboService, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrudLayout.createSequentialGroup()
                                        .addComponent(lblDate)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtAppointmentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cboTimeRange, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboCategory, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panelCrudLayout.createSequentialGroup()
                                .addComponent(lblQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(txtQuantity))
                            .addComponent(btnAddService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCrudLayout.createSequentialGroup()
                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelCrudLayout.createSequentialGroup()
                                        .addComponent(lblNote)
                                        .addGap(148, 148, 148)
                                        .addComponent(btnChooseCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38))
                                    .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCrudLayout.createSequentialGroup()
                                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(lblCustomerPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblCustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblTotalAmount4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                                            .addComponent(lblTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, Short.MAX_VALUE)
                                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCustomerPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                            .addComponent(txtCustomerName)
                                            .addComponent(txtTotalDuration)
                                            .addComponent(txtTotalPrice)))
                                    .addComponent(btnAddAppointment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane2))))
                .addGap(15, 15, 15))
            .addGroup(panelCrudLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                    .addComponent(lblTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCrudLayout.setVerticalGroup(
            panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrudLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCrudLayout.createSequentialGroup()
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTitle1)
                            .addComponent(btnClear))
                        .addGap(18, 18, 18)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnChooseDate)
                            .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAppointmentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAppointmentTime)
                            .addComponent(cboTimeRange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblServiceCategory)
                            .addComponent(cboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblService))
                        .addGap(18, 18, 18)
                        .addComponent(btnGetListBarber)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelCrudLayout.createSequentialGroup()
                        .addComponent(btnChooseBarber)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCrudLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblBarberName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelCrudLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(txtBarberName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblBarberPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelCrudLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(txtBarberPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblQuantity)
                                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnAddService, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCrudLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCustomerPhone)
                                    .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTotalAmount4)
                                    .addComponent(txtTotalDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTotalAmount)
                                    .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddAppointment))))
                    .addGroup(panelCrudLayout.createSequentialGroup()
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNote)
                            .addComponent(btnChooseCustomer)
                            .addComponent(lblCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCrudLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(panelCrudLayout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addContainerGap(115, Short.MAX_VALUE))))
        );

        Tabbs.addTab("ĐẶT LỊCH", panelCrud);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabbs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Tabbs, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdoWaitingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoWaitingActionPerformed
        fillToTable(serAppointment.getAll());
    }//GEN-LAST:event_rdoWaitingActionPerformed

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

    private void txtAppointmentDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAppointmentDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAppointmentDateActionPerformed

    private void btnChooseBarberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseBarberActionPerformed
        int index = tblAppointment.getSelectedRow();

        String barberName = tblAppointment.getValueAt(index, 0) + "";
        String barberPositionName = tblAppointment.getValueAt(index, 1) + "";

        txtBarberName.setText(barberName);
        txtBarberPosition.setText(barberPositionName);
    }//GEN-LAST:event_btnChooseBarberActionPerformed

    private void cboTimeRangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTimeRangeActionPerformed

    }//GEN-LAST:event_cboTimeRangeActionPerformed

    private void btnAddServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddServiceActionPerformed
        if (checkEcxitingService()) {
            if (checkValidateAddService()) {
                String serviceName = cboService.getSelectedItem().toString();
                String serviceCategoryName = cboCategory.getSelectedItem().toString();
                int duration = serService.getOneByName(serviceName).getDuration();
                int serviceID = serService.getOneByName(serviceName).getServiceID();
                BigDecimal servicePrice = serService.getOneByName(serviceName).getPrice();

                // Logic tính giờ nối tiếp:
                LocalTime startTime;
                if (dichVu.isEmpty()) {
                    // Nếu là dịch vụ đầu tiên, lấy từ giờ khách chọn ban đầu (ví dụ: cboTime)
                    startTime = LocalTime.parse(cboTimeRange.getSelectedItem().toString());
                } else {
                    // Nếu đã có dịch vụ trước đó, lấy giờ kết thúc của dịch vụ cuối cùng
                    Object[] lastRow = dichVu.get(dichVu.size() - 1);
                    // Giả sử giờ bắt đầu nằm ở cột 7 và duration ở cột 4
                    LocalTime lastStartTime = LocalTime.parse(lastRow[7].toString());
                    int lastDuration = Integer.parseInt(lastRow[4].toString());
                    startTime = lastStartTime.plusMinutes(lastDuration);
                }

                Object[] row = {
                    serviceID + "",
                    serviceCategoryName,
                    serviceName,
                    txtBarberName.getText(),
                    duration,
                    txtQuantity.getText(),
                    servicePrice + "",
                    startTime.toString() // THÊM CỘT GIỜ BẮT ĐẦU VÀO ĐÂY
                };

                dichVu.add(row);
                fillToServiceTable(dichVu);
                calculateTotalAmountAndDuration();
                clear();
            }
        }
    }//GEN-LAST:event_btnAddServiceActionPerformed

    private void cboServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboServiceActionPerformed
        Object selected = cboService.getSelectedItem();
        if (selected == null) {
            return; // Thoát ra nếu không có gì được chọn (đang clear combo)
        }
        // Code xử lý tiếp theo của bạn...
        String serviceName = selected.toString();
    }//GEN-LAST:event_cboServiceActionPerformed

    private void cboCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoryActionPerformed
        Object selectedItem = cboCategory.getSelectedItem();

        if (selectedItem != null || !selectedItem.toString().isEmpty()) {
            fillToComboService();
        } else {
            cboService.setSelectedIndex(0);
        }
    }//GEN-LAST:event_cboCategoryActionPerformed

    private void btnChooseDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseDateActionPerformed
        popCalendar.show(btnChooseDate, 0, btnChooseDate.getHeight());

        cal.setOnDateSelected(date -> {
            txtAppointmentDate.setText(date);

            fillToComboTimeRange();

            popCalendar.setVisible(false);
        });
    }//GEN-LAST:event_btnChooseDateActionPerformed

    private void btnChooseCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseCustomerActionPerformed
        java.awt.Frame parentFrame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this);

        CustomerView cMJD = new CustomerView(parentFrame, true);

        cMJD.setVisible(true);

        Customer c = cMJD.getSelectedCustomer();
        if (c != null) {
            setCustomerToText(c);
        }
    }//GEN-LAST:event_btnChooseCustomerActionPerformed

    private void rdoPendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoPendingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoPendingActionPerformed

    private void btnGetListBarberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetListBarberActionPerformed
        if (checkValidateGetListBarber()) {
            try {
                String selectedTime = cboTimeRange.getSelectedItem().toString();
                String selectedDate = txtAppointmentDate.getText();
                String selectedCategory = cboCategory.getSelectedItem().toString();

                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

                LocalDate date = LocalDate.parse(selectedDate, dateFormatter);
                LocalTime time = LocalTime.parse(selectedTime, timeFormatter);

                modelBarber = (DefaultTableModel) tblAppointment.getModel();
                modelBarber.setRowCount(0);

                List<Barber> lst = serBarber.getListAvailableBarber(date, time, selectedCategory);

                for (Barber b : lst) {
                    modelBarber.addRow(new Object[]{
                        b.getLastname() + " " + b.getFirstname(),
                        serBarber.getPositionNameByID(b.getPositionID())
                    });
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnGetListBarberActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        resetForm();
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerNameActionPerformed

    }//GEN-LAST:event_txtCustomerNameActionPerformed

    private void btnAddAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAppointmentActionPerformed
        boolean answer = XDialog.confirm("Bạn có chắc chắn muốn xác nhận đặt lịch này không?", "Xác nhân đặt lịch.");
        if (answer) {
            try {
                addAppAndAppDetails();
                XDialog.alert("Đặt lịch thành công!");
                resetForm();
                fillToTable(serAppointment.getAll());
            } catch (Exception e) {
                XDialog.alert("Lỗi hệ thống: Không thể lưu lịch hẹn.");
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnAddAppointmentActionPerformed

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

        Font font = new Font("Segoe UI", Font.PLAIN, 14);
        txtNote.setFont(font);

        comboWeek = (DefaultComboBoxModel<String>) cboWeek.getModel();
        comboBarber = (DefaultComboBoxModel<String>) cboBarber.getModel();
        comboCategory = (DefaultComboBoxModel<String>) cboCategory.getModel();
        comboService = (DefaultComboBoxModel<String>) cboService.getModel();
        comboTimeRange = (DefaultComboBoxModel<String>) cboTimeRange.getModel();

        fillToComboWeek();
        fillToComboBarber();
        fillToComboCategory();

        cal.setOnDateSelected(selectedDateStr -> {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate selectedDate = LocalDate.parse(selectedDateStr, formatter);

                LocalDate today = LocalDate.now();
                LocalTime now = LocalTime.now();
                LocalTime end = LocalTime.of(19, 30);
                long daysBetween = ChronoUnit.DAYS.between(today, selectedDate);

                boolean isToday = selectedDate.isEqual(today);

                if (selectedDate.isBefore(today)) {
                    XDialog.alert("Ngày hẹn không được trước hôm nay!");
                    txtAppointmentDate.setText("");
                } else if (daysBetween > 14) {
                    XDialog.alert("Ngày hẹn chỉ được hơn ngày hôm nay 14 ngày!");
                    txtAppointmentDate.setText("");
                } else if (now.isAfter(end) && isToday) {
                    XDialog.alert("Hôm nay đã quá giờ đặt lịch!");
                    txtAppointmentDate.setText("");
                } else {
                    txtAppointmentDate.setText(selectedDateStr);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            popCalendar.setVisible(false);   // Đóng lịch
        });

        popCalendar.add(cal);

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
        if (rdoWaiting.isSelected()) {
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

        String servciceCategoryName = cboCategory.getSelectedItem().toString();

        int serviceCatID = serServiceCategory.getOneByName(servciceCategoryName).getServiceCategoryID();

        List<String> items = serService.fillToComboServiceName(serService.getOneByCat(serviceCatID));

        for (String i : items) {
            comboService.addElement(i);
        }
    }

    public void fillToComboTimeRange() {
        comboTimeRange.removeAllElements();
        String dateText = txtAppointmentDate.getText();

        if (dateText == null || dateText.trim().isEmpty()) {
            return;
        }

        try {
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate selectedDate = LocalDate.parse(dateText, formatter);

            boolean isToday = selectedDate.isEqual(today);

            List<String> items = serAppointment.fillToComboTimeRange(isToday);

            for (String i : items) {
                comboTimeRange.addElement(i);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillToBarberTable(List<Barber> lst) {
        modelBarber.setRowCount(0);

        for (Barber b : lst) {
            modelBarber.addRow(new Object[]{
                b.getFirstname() + " " + b.getLastname(),
                serBarber.getPositionNameByID(b.getPositionID())
            });
        }
    }

    public void fillToServiceTable(List<Object[]> lst) {
        modelService.setRowCount(0);
        modelService = (DefaultTableModel) tblSercive.getModel();

        for (Object[] o : dichVu) {
            modelService.addRow(o);
        }
    }

    @Override
    public void edit() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        cboCategory.setSelectedIndex(0);
        cboService.setSelectedIndex(0);
        txtBarberName.setText("");
        txtBarberPosition.setText("");
        txtQuantity.setText("");
        modelBarber.setRowCount(0);
        txtCustomerName.setText("");
        txtCustomerPhone.setText("");
    }

    public void resetForm() {
        txtTotalDuration.setText("");
        txtTotalPrice.setText("");
        txtAppointmentDate.setText("");
        cboTimeRange.setSelectedIndex(0);
        modelService.setRowCount(0);
        clear();
        dichVu.clear();
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

    private void setCustomerToText(Customer c) {
        if (c == null) {
            return;
        }

        txtCustomerName.setText(c.getFullname());
        txtCustomerPhone.setText(c.getPhone());

        XDialog.alert("Đã chọn khách hàng: " + c.getFullname());
    }

    public void calculateTotalAmountAndDuration() {
        int totalDuration = 0;
        BigDecimal totalPrice = BigDecimal.ZERO;

        for (int i = 0; i < tblSercive.getRowCount(); i++) {
            try {
                String durationStr = tblSercive.getValueAt(i, 4).toString();
                String quantityStr = tblSercive.getValueAt(i, 5).toString();
                String priceStr = tblSercive.getValueAt(i, 6).toString();

                int duration = Integer.parseInt(durationStr);
                int quantity = Integer.parseInt(quantityStr);
                BigDecimal price = new BigDecimal(priceStr);

                totalDuration += duration;
                totalPrice = totalPrice.add(price.multiply(new BigDecimal(quantity)));

            } catch (Exception e) {
                System.out.println("Lỗi tại dòng: " + i + ":" + e.getMessage());
                e.printStackTrace();
            }
        }

        txtTotalDuration.setText(totalDuration + "");
        txtTotalPrice.setText(totalPrice.toString());
    }

    public void addAppAndAppDetails() {
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

            LocalDateTime dateTime = LocalDateTime.of(
                    LocalDate.parse(txtAppointmentDate.getText(), dateFormatter),
                    LocalTime.parse(cboTimeRange.getSelectedItem().toString(), timeFormatter)
            );

            var customer = serCustomer.getOneByNameAndPhone(txtCustomerName.getText(), txtCustomerPhone.getText());
            if (customer == null) {
                return;
            }
            int customerID = customer.getCustomerID();

            Appointment apNew = new Appointment(dateTime, txtNote.getText(),
                    Integer.parseInt(txtTotalDuration.getText()), 1, customerID);
            Appointment apReturn = serAppointment.addAndReturn(apNew);

            List<AppointmentDetail> list = new ArrayList<>();
            for (int i = 0; i < tblSercive.getRowCount(); i++) {
                int serviceID = serService.getOneByName(tblSercive.getValueAt(i, 2).toString()).getServiceID();
                int appoinmentID = apReturn.getAppointmentID();
                int duration = Integer.parseInt(tblSercive.getValueAt(i, 4).toString());

                Object valPrice = tblSercive.getValueAt(i, 6);
                BigDecimal price = (valPrice != null) ? new BigDecimal(valPrice.toString()) : BigDecimal.ZERO;
                int quantity = Integer.parseInt(tblSercive.getValueAt(i, 5).toString());

                String barberName = tblSercive.getValueAt(i, 3).toString();
                int barberID = serBarber.getOneByName(barberName).getBarberID();

                list.add(new AppointmentDetail(serviceID, appoinmentID, duration, price, quantity, barberID));
            }

            // 5. Lưu danh sách chi tiết
            for (AppointmentDetail aD : list) {
                serAppointmentDetail.add(aD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean checkValidateGetListBarber() {
        if (txtAppointmentDate.getText().trim().isEmpty()) {
            XDialog.alert("Vui lòng chọn ngày!");
            txtAppointmentDate.requestFocus();
            return false;
        }

        if (cboTimeRange.getSelectedItem() == null
                || cboTimeRange.getSelectedItem().toString().trim().isEmpty()) {
            XDialog.alert("Vui lòng chọn giờ!");
            cboTimeRange.requestFocus();
            return false;
        }

        if (cboCategory.getSelectedItem() == null
                || cboCategory.getSelectedItem().toString().trim().isEmpty()) {
            XDialog.alert("Vui lòng chọn loại dịch vụ!");
            cboCategory.requestFocus();
            return false;
        }

        return true;

    }

    private boolean checkValidateAddService() {
        if (txtAppointmentDate.getText().trim().isEmpty()) {
            XDialog.alert("Vui lòng chọn ngày!");
            txtAppointmentDate.requestFocus();
            return false;
        }

        if (cboCategory.getSelectedItem() == null
                || cboCategory.getSelectedItem().toString().trim().isEmpty()) {
            XDialog.alert("Vui lòng chọn loại dịch vụ!");
            cboCategory.requestFocus();
            return false;
        }

        if (cboService.getSelectedItem() == null
                || cboService.getSelectedItem().toString().trim().isEmpty()) {
            XDialog.alert("Vui lòng chọn dịch vụ!");
            cboService.requestFocus();
            return false;
        }

        if (cboTimeRange.getSelectedItem() == null
                || cboTimeRange.getSelectedItem().toString().trim().isEmpty()) {
            XDialog.alert("Vui lòng chọn giờ!");
            cboTimeRange.requestFocus();
            return false;
        }

        if (txtBarberName.getText().trim().isEmpty() || txtBarberPosition.getText().trim().isEmpty()) {
            XDialog.alert("Vui lòng chọn barber!");
            btnChooseBarber.requestFocus();
            return false;
        }

        if (txtQuantity.getText().trim().isEmpty()) {
            XDialog.alert("Vui lòng nhập số lượng!");
            txtQuantity.requestFocus();
            return false;
        }

        return true;
    }

    private boolean checkEcxitingService() {
        Object selected = cboService.getSelectedItem();
        if (selected == null) {
            return false;
        }

        String serviceName = selected.toString();

        for (Object[] o : dichVu) {
            if (o[2] == null || o[2].toString().equalsIgnoreCase(serviceName)) {
                XDialog.alert("Đã có dịch vụ này!");
                modelBarber.setRowCount(0);
                cboService.setSelectedIndex(0);
                txtBarberName.setText("");
                txtBarberPosition.setText("");
                return false;
            }
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Tabbs;
    private javax.swing.JButton btnAddAppoint;
    private javax.swing.JButton btnAddAppointment;
    private javax.swing.JButton btnAddService;
    private javax.swing.JButton btnCancelFilter;
    private javax.swing.JButton btnChooseBarber;
    private javax.swing.JButton btnChooseCustomer;
    private javax.swing.JButton btnChooseDate;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnGetListBarber;
    private javax.swing.ButtonGroup btnGroupStatus;
    private javax.swing.JComboBox<String> cboBarber;
    private javax.swing.JComboBox<String> cboCategory;
    private javax.swing.JComboBox<String> cboService;
    private javax.swing.JComboBox<String> cboTimeRange;
    private javax.swing.JComboBox<String> cboWeek;
    private javax.swing.JButton jButton1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAppointmentTime;
    private javax.swing.JLabel lblBarberName;
    private javax.swing.JLabel lblBarberPosition;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblCustomerPhone;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblFilterByBarber;
    private javax.swing.JLabel lblFilterByStatus;
    private javax.swing.JLabel lblFilterByWeek;
    private javax.swing.JLabel lblFind;
    private javax.swing.JLabel lblNote;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblService;
    private javax.swing.JLabel lblServiceCategory;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblTotalAmount;
    private javax.swing.JLabel lblTotalAmount4;
    private javax.swing.JPanel panelCalendar;
    private javax.swing.JPanel panelCrud;
    private javax.swing.JRadioButton rdoAll;
    private javax.swing.JRadioButton rdoCanceled;
    private javax.swing.JRadioButton rdoCheckIned;
    private javax.swing.JRadioButton rdoPending;
    private javax.swing.JRadioButton rdoWaiting;
    private javax.swing.JTable tblAppointment;
    private javax.swing.JTable tblBarber;
    private javax.swing.JTable tblCalendar;
    private javax.swing.JTable tblSercive;
    private javax.swing.JTextField txtAppointmentDate;
    private javax.swing.JTextField txtBarberName;
    private javax.swing.JTextField txtBarberPosition;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtCustomerPhone;
    private javax.swing.JTextField txtFind;
    private java.awt.TextArea txtNote;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtTotalDuration;
    private javax.swing.JTextField txtTotalPrice;
    // End of variables declaration//GEN-END:variables
}
