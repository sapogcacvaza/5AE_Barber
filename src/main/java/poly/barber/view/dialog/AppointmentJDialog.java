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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicMenuUI;
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
    DefaultTableModel modelAppointment = new DefaultTableModel();
    DefaultTableModel modelAppointmentDetail = new DefaultTableModel();

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

        btnGroupFilterStatus = new javax.swing.ButtonGroup();
        btnGroupAppointment = new javax.swing.ButtonGroup();
        btnGroupDetail = new javax.swing.ButtonGroup();
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
        rdoDoneStatus = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCalendar = new javax.swing.JTable();
        cboBarber = new javax.swing.JComboBox<>();
        btnCancelFilter = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        lblFilterByBarber = new javax.swing.JLabel();
        lblFilterByWeek = new javax.swing.JLabel();
        lblFind = new javax.swing.JLabel();
        lblFilterByStatus = new javax.swing.JLabel();
        btnReloadTablleCalendar = new javax.swing.JButton();
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
        btnClear = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblBarber = new javax.swing.JTable();
        lblTitle2 = new javax.swing.JLabel();
        rdoCheckIn = new javax.swing.JRadioButton();
        rdoCancel = new javax.swing.JRadioButton();
        btnUpdateDetails = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblAppointmentDetail = new javax.swing.JTable();
        btnChangeAppointmentStatus = new javax.swing.JButton();
        lblTitle3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnChangeDetailStatus = new javax.swing.JButton();
        rdoInProcess = new javax.swing.JRadioButton();
        rdoIsDone = new javax.swing.JRadioButton();
        rdoCancelDetail = new javax.swing.JRadioButton();
        chkChooseAll = new javax.swing.JCheckBox();
        rdoDone = new javax.swing.JRadioButton();
        chkToday = new javax.swing.JCheckBox();

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

        btnAddAppoint.setText("THÊM LỊCH");
        btnAddAppoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAppointActionPerformed(evt);
            }
        });

        rdoWaiting.setBackground(new java.awt.Color(204, 204, 204));
        btnGroupFilterStatus.add(rdoWaiting);
        rdoWaiting.setText("Chưa đến");
        rdoWaiting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoWaitingActionPerformed(evt);
            }
        });

        rdoCanceled.setBackground(new java.awt.Color(255, 204, 204));
        btnGroupFilterStatus.add(rdoCanceled);
        rdoCanceled.setText("Đã hủy");
        rdoCanceled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoCanceledActionPerformed(evt);
            }
        });

        rdoCheckIned.setBackground(new java.awt.Color(204, 255, 255));
        btnGroupFilterStatus.add(rdoCheckIned);
        rdoCheckIned.setText("Đã đến");
        rdoCheckIned.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoCheckInedActionPerformed(evt);
            }
        });

        rdoPending.setBackground(new java.awt.Color(255, 204, 102));
        btnGroupFilterStatus.add(rdoPending);
        rdoPending.setText("Đang chờ xử lý");
        rdoPending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoPendingActionPerformed(evt);
            }
        });

        btnGroupFilterStatus.add(rdoAll);
        rdoAll.setText("Tất cả");
        rdoAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoAllActionPerformed(evt);
            }
        });

        rdoDoneStatus.setBackground(new java.awt.Color(153, 255, 153));
        btnGroupFilterStatus.add(rdoDoneStatus);
        rdoDoneStatus.setText("Đã xong");
        rdoDoneStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDoneStatusActionPerformed(evt);
            }
        });

        tblCalendar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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

        btnReloadTablleCalendar.setText("CẬP NHẬP LẠI BẢNG");
        btnReloadTablleCalendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadTablleCalendarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCalendarLayout = new javax.swing.GroupLayout(panelCalendar);
        panelCalendar.setLayout(panelCalendarLayout);
        panelCalendarLayout.setHorizontalGroup(
            panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCalendarLayout.createSequentialGroup()
                .addGroup(panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCalendarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnReloadTablleCalendar))
                    .addGroup(panelCalendarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(panelCalendarLayout.createSequentialGroup()
                                .addGroup(panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFind)
                                    .addComponent(lblFilterByStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCalendarLayout.createSequentialGroup()
                                        .addComponent(rdoAll, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoWaiting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelCalendarLayout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblFilterByBarber, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cboBarber, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCalendarLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoCheckIned, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoDoneStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoCanceled, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoPending)))
                                .addGroup(panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCalendarLayout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addComponent(btnCancelFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE))
                                    .addGroup(panelCalendarLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(lblFilterByWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cboWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAddAppoint, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(11, 11, 11))
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
                    .addComponent(rdoPending)
                    .addComponent(rdoDoneStatus)
                    .addComponent(btnReloadTablleCalendar))
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblSercive);

        lblTotalAmount.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
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

        lblCustomerName.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblCustomerName.setText("TÊN KH:");

        lblCustomerPhone.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblCustomerPhone.setText("SỐ ĐT KH:");

        tblAppointment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã lịch", "Tên khách hàng", "Số khách hàng", "Thời gian hẹn", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblAppointment);

        lblTitle1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle1.setText("THÊM DỊCH VỤ VÀO LỊCH MỚI");

        btnGetListBarber.setText("XUẤT DANH SÁCH THỢ");
        btnGetListBarber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetListBarberActionPerformed(evt);
            }
        });

        lblTotalAmount4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblBarber);

        lblTitle2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle2.setText("QUẢN LÝ TRẠNG THÁI LỊCH");

        rdoCheckIn.setBackground(new java.awt.Color(153, 255, 204));
        btnGroupAppointment.add(rdoCheckIn);
        rdoCheckIn.setText("Đã đến");

        rdoCancel.setBackground(new java.awt.Color(255, 204, 204));
        btnGroupAppointment.add(rdoCancel);
        rdoCancel.setText("Hủy lịch");

        btnUpdateDetails.setText("CẬP NHẬT CHI TIẾT");
        btnUpdateDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDetailsActionPerformed(evt);
            }
        });

        tblAppointmentDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên dịch vụ", "Mã lịch hẹn", "Thời gian GV", "Giá", "Số lượng", "Tên thợ", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblAppointmentDetail);

        btnChangeAppointmentStatus.setText("THAY ĐỔI TRẠNG THÁI");
        btnChangeAppointmentStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeAppointmentStatusActionPerformed(evt);
            }
        });

        lblTitle3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle3.setText("QUẢN LÝ TRẠNG THÁI DỊCH VỤ");

        btnChangeDetailStatus.setText("CẬP NHẬP TRẠNG THÁI");
        btnChangeDetailStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeDetailStatusActionPerformed(evt);
            }
        });

        rdoInProcess.setBackground(new java.awt.Color(204, 255, 255));
        btnGroupDetail.add(rdoInProcess);
        rdoInProcess.setText("Đang làm");

        rdoIsDone.setBackground(new java.awt.Color(153, 255, 153));
        btnGroupDetail.add(rdoIsDone);
        rdoIsDone.setText("Đã xong");

        rdoCancelDetail.setBackground(new java.awt.Color(255, 204, 204));
        btnGroupDetail.add(rdoCancelDetail);
        rdoCancelDetail.setText("Hủy dịch vụ");
        rdoCancelDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoCancelDetailActionPerformed(evt);
            }
        });

        chkChooseAll.setText("Chọn tất cả");

        rdoDone.setBackground(new java.awt.Color(153, 255, 153));
        btnGroupAppointment.add(rdoDone);
        rdoDone.setText("Đã xong");

        chkToday.setText("Lịch hôm nay");
        chkToday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTodayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCrudLayout = new javax.swing.GroupLayout(panelCrud);
        panelCrud.setLayout(panelCrudLayout);
        panelCrudLayout.setHorizontalGroup(
            panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrudLayout.createSequentialGroup()
                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCrudLayout.createSequentialGroup()
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCrudLayout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(panelCrudLayout.createSequentialGroup()
                                            .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblAppointmentTime, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panelCrudLayout.createSequentialGroup()
                                                .addComponent(btnChooseDate, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblDate)
                                                .addGap(51, 51, 51)
                                                .addComponent(txtAppointmentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lblServiceCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panelCrudLayout.createSequentialGroup()
                                                .addComponent(lblService, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(59, 59, 59)
                                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(btnGetListBarber, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                                    .addComponent(cboCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cboTimeRange, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cboService, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCrudLayout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnChooseBarber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                            .addGroup(panelCrudLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCrudLayout.createSequentialGroup()
                                        .addComponent(lblQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(txtQuantity))
                                    .addGroup(panelCrudLayout.createSequentialGroup()
                                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblBarberPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblBarberName, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                                        .addGap(29, 29, 29)
                                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtBarberName)
                                            .addComponent(txtBarberPosition)))
                                    .addComponent(btnAddService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCrudLayout.createSequentialGroup()
                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelCrudLayout.createSequentialGroup()
                                        .addComponent(lblNote)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnChooseCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCrudLayout.createSequentialGroup()
                                        .addComponent(lblCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                                    .addGroup(panelCrudLayout.createSequentialGroup()
                                        .addComponent(lblCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCustomerPhone))
                                    .addGroup(panelCrudLayout.createSequentialGroup()
                                        .addComponent(lblTotalAmount4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTotalDuration))
                                    .addGroup(panelCrudLayout.createSequentialGroup()
                                        .addComponent(lblTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTotalPrice))
                                    .addComponent(btnAddAppointment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCrudLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(panelCrudLayout.createSequentialGroup()
                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelCrudLayout.createSequentialGroup()
                                        .addComponent(rdoCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdoCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoDone, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(btnChangeAppointmentStatus)
                                        .addGap(20, 20, 20)
                                        .addComponent(btnUpdateDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelCrudLayout.createSequentialGroup()
                                        .addComponent(lblTitle2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(chkToday)))
                                .addGap(18, 18, 18)
                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCrudLayout.createSequentialGroup()
                                        .addComponent(lblTitle3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(chkChooseAll))
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelCrudLayout.createSequentialGroup()
                                        .addComponent(rdoInProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoIsDone, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoCancelDetail)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnChangeDetailStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(16, 16, 16))
        );
        panelCrudLayout.setVerticalGroup(
            panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrudLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCrudLayout.createSequentialGroup()
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTitle1)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnChooseDate)
                            .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAppointmentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAppointmentTime)
                            .addComponent(cboTimeRange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblServiceCategory)
                            .addComponent(cboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblService))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGetListBarber)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnChooseBarber)
                        .addComponent(lblNote))
                    .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnChooseCustomer)
                        .addComponent(lblCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelCrudLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelCrudLayout.createSequentialGroup()
                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblBarberName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBarberName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCrudLayout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(txtBarberPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelCrudLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(lblBarberPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(17, 17, 17)
                                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblQuantity)
                                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAddService, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCrudLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCustomerPhone)
                            .addComponent(txtCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalAmount4)
                            .addComponent(txtTotalDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalAmount)
                            .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddAppointment)))
                .addGap(11, 11, 11)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle2)
                    .addComponent(lblTitle3)
                    .addComponent(chkChooseAll)
                    .addComponent(chkToday))
                .addGap(18, 18, 18)
                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoCheckIn)
                    .addComponent(rdoCancel)
                    .addComponent(btnUpdateDetails)
                    .addComponent(btnChangeAppointmentStatus)
                    .addComponent(btnChangeDetailStatus)
                    .addComponent(rdoInProcess)
                    .addComponent(rdoIsDone)
                    .addComponent(rdoCancelDetail)
                    .addComponent(rdoDone))
                .addContainerGap(11, Short.MAX_VALUE))
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
            .addComponent(Tabbs)
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
        Object cell = tblCalendar.getValueAt(row, col);

        if (col <= 0 || row == -1) {
            return;
        }

        if (cell == null || cell.equals("")) {
            XDialog.alert("Ô ko có lịch!");
            return;
        }

        if (evt.getClickCount() == 2) {
            try {
                String timeStr = tblCalendar.getValueAt(row, 0).toString() + ":00";
                java.sql.Time targetTime = java.sql.Time.valueOf(timeStr);

                String header = tblCalendar.getColumnName(col);
                String dateStr = header.substring(header.lastIndexOf("-") + 1).trim();

                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
                java.util.Date parsedDate = sdf.parse(dateStr);
                java.sql.Date targetDate = new java.sql.Date(parsedDate.getTime());

                List<String> details = serAppointment.getAppointmentHtmlDetails(targetDate, targetTime);

                if (details != null && !details.isEmpty()) {
                    Object[] message = details.toArray();
                    JOptionPane.showMessageDialog(this,
                            message,
                            "Chi tiết lịch hẹn [" + dateStr + " " + timeStr.substring(0, 5) + "]",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Không có lịch hẹn trong khung giờ này.");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi lấy chi tiết: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_tblCalendarMouseClicked

    private void btnAddAppointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAppointActionPerformed
        Tabbs.setSelectedIndex(1);
    }//GEN-LAST:event_btnAddAppointActionPerformed

    private void rdoPendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoPendingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoPendingActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        resetForm();
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

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

                modelBarber = (DefaultTableModel) tblBarber.getModel();
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

    private void btnAddAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAppointmentActionPerformed
        boolean answer = XDialog.confirm("Bạn có chắc chắn muốn xác nhận đặt lịch này không?", "Xác nhân đặt lịch.");
        if (answer) {
            try {
                addAppAndAppDetails();
                resetForm();
                fillToTable(serAppointment.getAll());
                fillToTableAppointment(serAppointment.getAllWhereStatusIsWaiting(chkToday.isSelected()));
            } catch (Exception e) {
                XDialog.alert("Lỗi hệ thống: Không thể lưu lịch hẹn.");
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnAddAppointmentActionPerformed

    private void txtAppointmentDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAppointmentDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAppointmentDateActionPerformed

    private void txtCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerNameActionPerformed

    }//GEN-LAST:event_txtCustomerNameActionPerformed

    private void btnChooseBarberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseBarberActionPerformed
        int index = tblBarber.getSelectedRow();

        if (index < 0) {
            XDialog.alert("Chưa chọn dòng trên bảng trên!");
            return;
        }

        String barberName = tblBarber.getValueAt(index, 0) + "";
        String barberPositionName = tblBarber.getValueAt(index, 1) + "";

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

    private void btnUpdateDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDetailsActionPerformed
        int index = tblAppointment.getSelectedRow();

        if (index == -1) {
            XDialog.alert("Chưa chọn dòng ở bảng trên!");
            return;
        }

        int appointmentID = Integer.parseInt(tblAppointment.getValueAt(index, 0) + "");
        String status = tblAppointment.getValueAt(index, 4) + "";

        if (status.trim().equalsIgnoreCase("Đã đến")) {
            fillToTableAppDetail(serAppointmentDetail.getAllByAppID(appointmentID));
        } else {
            XDialog.alert("Phải cập nhật trạng thái thành đã đến mới được sửa!");
        }
    }//GEN-LAST:event_btnUpdateDetailsActionPerformed

    private void rdoCancelDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoCancelDetailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoCancelDetailActionPerformed

    private void btnChangeAppointmentStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeAppointmentStatusActionPerformed
        int index = tblAppointment.getSelectedRow();

        if (index == -1) {
            XDialog.alert("Chưa chọn dòng ở bảng trên!");
            return;
        }

        if (!rdoCheckIn.isSelected() && !rdoCancel.isSelected() && !rdoDone.isSelected()) {
            XDialog.alert("Chưa chọn trạng thái!");
            return;
        }

        try {
            if (rdoCheckIn.isSelected()) {
                boolean answer = XDialog.confirm("Bạn có chắc thay đổi trạng thái lịch thành ĐÃ ĐẾN không?", "Thay đổi trạng thái lịch");
                if (answer) {
                    int appointmentID = Integer.parseInt(tblAppointment.getValueAt(index, 0) + "");
                    serAppointment.updateStatus(appointmentID, 2);
                    // Đã đến
                    fillToTableAppointment(serAppointment.getAllWhereStatusIsWaiting(chkToday.isSelected()));
                }
            } else if (rdoCancel.isSelected()) {
                boolean answer = XDialog.confirm("Bạn có chắc thay đổi trạng thái lịch thành HỦY LỊCH không?", "Thay đổi trạng thái lịch");
                if (answer) {
                    int appointmentID = Integer.parseInt(tblAppointment.getValueAt(index, 0) + "");
                    serAppointment.updateStatus(appointmentID, 3);
                    // Hủy lịch
                    serAppointmentDetail.updateStatusByAppID(4, appointmentID);
                    fillToTableAppointment(serAppointment.getAllWhereStatusIsWaiting(chkToday.isSelected()));
                }
            } else if (rdoDone.isSelected()) {
                boolean answer = XDialog.confirm("Bạn có chắc thay đổi trạng thái lịch thành ĐÃ XONG không?", "Thay đổi trạng thái lịch");
                if (answer) {
                    int appointmentID = Integer.parseInt(tblAppointment.getValueAt(index, 0) + "");
                    serAppointment.updateStatus(appointmentID, 5);
                    // Đã xong
                    serAppointmentDetail.updateStatusByAppID(2, appointmentID);
                    fillToTableAppointment(serAppointment.getAllWhereStatusIsWaiting(chkToday.isSelected()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnChangeAppointmentStatusActionPerformed

    private void btnChangeDetailStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeDetailStatusActionPerformed
        int index = tblAppointmentDetail.getSelectedRow();

        if (tblAppointmentDetail.getRowCount() <= 0) {
            XDialog.alert("Chưa chọn lịch để sửa chi tiết!");
            return;
        }

        if (index == -1 && !chkChooseAll.isSelected()) {
            XDialog.alert("Chưa chọn dòng ở bảng trên hoặc chưa tích 'Chọn tất cả'!");
            return;
        }

        try {
            int[] rowsToProcess;
            if (chkChooseAll.isSelected()) {
                rowsToProcess = new int[tblAppointmentDetail.getRowCount()];
                for (int i = 0; i < tblAppointmentDetail.getRowCount(); i++) {
                    rowsToProcess[i] = i;
                }
            } else {
                rowsToProcess = new int[]{index};
            }

            if (!rdoInProcess.isSelected() && !rdoIsDone.isSelected() && !rdoCancelDetail.isSelected()) {
                XDialog.alert("Chưa chọn trạng thái!");
                return;
            }

            String message = "";
            int status = 0;
            if (rdoInProcess.isSelected()) {
                message = "Bạn có chắc thay đổi trạng thái thành ĐANG LÀM?";
                status = 1;
            } else if (rdoIsDone.isSelected()) {
                message = "Bạn có chắc thay đổi trạng thái thành ĐÃ XONG?";
                status = 2;
            } else if (rdoCancelDetail.isSelected()) {
                message = "Bạn có chắc thay đổi trạng thái thành HỦY DỊCH VỤ?";
                status = 4;
            }

            if (XDialog.confirm(message, "Xác nhận thay đổi")) {
                for (int row : rowsToProcess) {
                    String serviceName = tblAppointmentDetail.getValueAt(row, 0) + "";
                    int serviceID = serService.getOneByName(serviceName.trim()).getServiceID();
                    int appointmentID = Integer.parseInt(tblAppointmentDetail.getValueAt(row, 1) + "");

                    serAppointmentDetail.updateStatus(status, appointmentID, serviceID);
                }

                int currentAppID = Integer.parseInt(tblAppointmentDetail.getValueAt(rowsToProcess[0], 1) + "");
                fillToTableAppDetail(serAppointmentDetail.getAllByAppID(currentAppID));
                XDialog.alert("Cập nhật thành công " + rowsToProcess.length + " dòng!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            XDialog.alert("Có lỗi xảy ra: " + e.getMessage());
        }
    }//GEN-LAST:event_btnChangeDetailStatusActionPerformed

    private void rdoDoneStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDoneStatusActionPerformed
        fillToTable(serAppointment.getAll());
    }//GEN-LAST:event_rdoDoneStatusActionPerformed

    private void btnReloadTablleCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadTablleCalendarActionPerformed
        cboWeek.setSelectedIndex(1);
        System.out.println("Trước lệnh");
        refreshCalendarOnTabChange();
        System.out.println("Sau lệnh");
        fillToTable(serAppointment.getAll());

    }//GEN-LAST:event_btnReloadTablleCalendarActionPerformed

    private void chkTodayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTodayActionPerformed
        if (chkToday.isSelected()) {
            fillToTableAppointment(serAppointment.getAllWhereStatusIsWaiting(chkToday.isSelected()));
        } else {
            fillToTableAppointment(serAppointment.getAllWhereStatusIsWaiting(false));
        }
    }//GEN-LAST:event_chkTodayActionPerformed

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
        // App lịch
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
        // Phần đóng lịch
        popCalendar.add(cal);
        // Set tuần này
        cboWeek.setSelectedIndex(1);
        // set header của lịch
        this.setCalendarHeaderTables(serAppointment.getCalendarHeaderTables(1));
        // gán model cho bảng lịch hẹn
        modelAppointment = (DefaultTableModel) tblAppointment.getModel();
        // 
        fillToTableAppointment(serAppointment.getAllWhereStatusIsWaiting(chkToday.isSelected()));

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
        } else if (rdoDoneStatus.isSelected()) {
            status = 5; // Đã xong
        } else if (rdoPending.isSelected()) {
            status = 4; // Đã xong
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

    private String getAppointmentStatusText(int status) {
        switch (status) {
            case 1:
                return "Chưa đến";
            case 2:
                return "Đã đến";
            case 3:
                return "Đã hủy";
            case 4:
                return "Đang chờ";
            case 5:
                return "Đã xong";
            default:
                return "Khác";
        }
    }

    private String getAppointmentDetailStatusText(int status) {
        switch (status) {
            case 0:
                return "Chờ";
            case 1:
                return "Đang làm";
            case 2:
                return "Xong";
            case 3:
                return "Tạm dừng";
            case 4:
                return "Hủy";
            default:
                return "Khác";
        }
    }

    private void fillToTableAppointment(List<Appointment> lst) {
        modelAppointment.setRowCount(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        for (Appointment a : lst) {
            LocalDateTime dateTime = a.getAppointmentDateTime();
            LocalTime time = dateTime.toLocalTime();

//            String formatterTime = time.format(formatter);
            String status = getAppointmentStatusText(a.getStatus());

            String customerName = serCustomer.getOne(a.getCustomerID()).getFullname();
            String customerPhone = serCustomer.getOne(a.getCustomerID()).getPhone();

            modelAppointment.addRow(new Object[]{
                a.getAppointmentID(),
                customerName,
                customerPhone,
                time,
                status
            });
        }
    }

    private void fillToTableAppDetail(List<AppointmentDetail> lst) {
        modelAppointmentDetail.setRowCount(0);

        modelAppointmentDetail = (DefaultTableModel) tblAppointmentDetail.getModel();

        for (AppointmentDetail ad : lst) {
            String serviceName = serService.getOne(ad.getServiceID()).getServiceName();
            BigDecimal price = new BigDecimal(ad.getPrice() + "");
            String barberName = serBarber.getOne(ad.getBarberID()).getLastname() + " " + serBarber.getOne(ad.getBarberID()).getFirstname();
            String status = getAppointmentDetailStatusText(ad.getStatus());

            modelAppointmentDetail.addRow(new Object[]{
                serviceName,
                ad.getAppointmentID(),
                ad.getDuration(),
                price,
                ad.getQuantity(),
                barberName,
                status,
                false
            });
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

    }

    public void resetForm() {
        txtTotalDuration.setText("");
        txtTotalPrice.setText("");
        txtAppointmentDate.setText("");
        cboTimeRange.setSelectedIndex(0);
        modelService.setRowCount(0);
        txtCustomerName.setText("");
        txtCustomerPhone.setText("");
        clear();
        dichVu.clear();
    }

    @Override
    public void setEditable(boolean editable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void checkAll() {
        this.setCheckedAll(true);
    }

    @Override
    public void uncheckAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setCheckedAll(boolean b) {
        for (int i = 0; i < tblAppointmentDetail.getRowCount(); i++) {
            tblAppointmentDetail.setValueAt(b, i, 7);
        }
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

            LocalDate appointmentDate = LocalDate.parse(txtAppointmentDate.getText(), dateFormatter);
            LocalTime appointmentTime = LocalTime.parse(cboTimeRange.getSelectedItem().toString(), timeFormatter);
            LocalDateTime dateTime = LocalDateTime.of(appointmentDate, appointmentTime);

            var customer = serCustomer.getOneByNameAndPhone(txtCustomerName.getText(), txtCustomerPhone.getText());
            if (customer == null) {
                XDialog.alert("Không tìm thấy khách hàng!");
                return;
            }
            int customerID = customer.getCustomerID();
            int totalDuration = Integer.parseInt(txtTotalDuration.getText());

            if (serAppointment.isConflict(customerID, appointmentDate, appointmentTime, totalDuration)) {
                XDialog.alert("Khách hàng này đã có một lịch hẹn khác trong khung giờ này!", "Cảnh báo trùng lịch");
                return;
            }

            Appointment apNew = new Appointment(dateTime, txtNote.getText(), totalDuration, 1, customerID);
            Appointment apReturn = serAppointment.addAndReturn(apNew);

            List<AppointmentDetail> list = new ArrayList<>();
            for (int i = 0; i < tblSercive.getRowCount(); i++) {
                int serviceID = serService.getOneByName(tblSercive.getValueAt(i, 2).toString()).getServiceID();
                int appointmentID = apReturn.getAppointmentID();
                int duration = Integer.parseInt(tblSercive.getValueAt(i, 4).toString());

                Object valPrice = tblSercive.getValueAt(i, 6);
                BigDecimal price = (valPrice != null) ? new BigDecimal(valPrice.toString()) : BigDecimal.ZERO;
                int quantity = Integer.parseInt(tblSercive.getValueAt(i, 5).toString());

                String barberName = tblSercive.getValueAt(i, 3).toString();
                int barberID = serBarber.getOneByName(barberName).getBarberID();

                list.add(new AppointmentDetail(serviceID, appointmentID, duration, price, quantity, barberID));
            }

            for (AppointmentDetail aD : list) {
                serAppointmentDetail.add(aD);
            }

            XDialog.alert("Lưu lịch hẹn thành công!");

        } catch (Exception e) {
            XDialog.alert("Có lỗi xảy ra: " + e.getMessage());
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

    private void refreshCalendarOnTabChange() {
        List<Appointment> lst = serAppointment.getAll();
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        int count = 0;

        for (Appointment a : lst) {
            LocalDate dateApp = a.getAppointmentDateTime().toLocalDate();
            LocalTime timeApp = a.getAppointmentDateTime().toLocalTime();

            if (a.getStatus() == 1 && dateApp.equals(today)) {
                if (timeApp.isBefore(now)) {
                    serAppointment.updateStatus(a.getAppointmentID(), 4);
                    count++;
                }
            }
        }

        fillToTable(serAppointment.getAll());

        if (count > 0) {
            XDialog.alert("Đã tự động chuyển " + count + " lịch sang trạng thái 'Đang xử lý'!");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Tabbs;
    private javax.swing.JButton btnAddAppoint;
    private javax.swing.JButton btnAddAppointment;
    private javax.swing.JButton btnAddService;
    private javax.swing.JButton btnCancelFilter;
    private javax.swing.JButton btnChangeAppointmentStatus;
    private javax.swing.JButton btnChangeDetailStatus;
    private javax.swing.JButton btnChooseBarber;
    private javax.swing.JButton btnChooseCustomer;
    private javax.swing.JButton btnChooseDate;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnGetListBarber;
    private javax.swing.ButtonGroup btnGroupAppointment;
    private javax.swing.ButtonGroup btnGroupDetail;
    private javax.swing.ButtonGroup btnGroupFilterStatus;
    private javax.swing.JButton btnReloadTablleCalendar;
    private javax.swing.JButton btnUpdateDetails;
    private javax.swing.JComboBox<String> cboBarber;
    private javax.swing.JComboBox<String> cboCategory;
    private javax.swing.JComboBox<String> cboService;
    private javax.swing.JComboBox<String> cboTimeRange;
    private javax.swing.JComboBox<String> cboWeek;
    private javax.swing.JCheckBox chkChooseAll;
    private javax.swing.JCheckBox chkToday;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
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
    private javax.swing.JLabel lblTitle3;
    private javax.swing.JLabel lblTotalAmount;
    private javax.swing.JLabel lblTotalAmount4;
    private javax.swing.JPanel panelCalendar;
    private javax.swing.JPanel panelCrud;
    private javax.swing.JRadioButton rdoAll;
    private javax.swing.JRadioButton rdoCancel;
    private javax.swing.JRadioButton rdoCancelDetail;
    private javax.swing.JRadioButton rdoCanceled;
    private javax.swing.JRadioButton rdoCheckIn;
    private javax.swing.JRadioButton rdoCheckIned;
    private javax.swing.JRadioButton rdoDone;
    private javax.swing.JRadioButton rdoDoneStatus;
    private javax.swing.JRadioButton rdoInProcess;
    private javax.swing.JRadioButton rdoIsDone;
    private javax.swing.JRadioButton rdoPending;
    private javax.swing.JRadioButton rdoWaiting;
    private javax.swing.JTable tblAppointment;
    private javax.swing.JTable tblAppointmentDetail;
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
