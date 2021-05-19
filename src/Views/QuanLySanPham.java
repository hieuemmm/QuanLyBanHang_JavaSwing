/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.SanPhamController;
import Core.DanhMucSanPham;
import Core.MyObjectListCellRenderer;
import Core.SanPham;
import Core.TaiKhoan;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class QuanLySanPham extends javax.swing.JPanel {

    private static SanPhamController SPController;
    private final DefaultTableModel defaultTableModel;
    private List<DanhMucSanPham> DMSanPhams;

    /**
     * Creates new form QuanLyNhomNguoiDung
     */
    public QuanLySanPham() throws ClassNotFoundException, SQLException {
        initComponents();
        SPController = new SanPhamController();
        DMSanPhams = new ArrayList<DanhMucSanPham>();
        jTextFieldMaSanPham.setEditable(false);
        jLabelTrangThaiChucNang.setVisible(false);
        jLabelTrangThaiChucNang.setText("New");
        jTextFieldMaSanPham.setText("Tự động");
        jTextFieldTenSanPham.setText("");
        jTextFieldSoLuong.setText("");
        jTextFieldGiaMua.setText("");
        jTextFieldGiaBan.setText("");
        jTextAreaMoTa.setText("");
        jTextFieldTenSanPham.requestFocus();
        LoadComboboxDanhMucSP();
        defaultTableModel = new DefaultTableModel() {
            //không cho phép sửa dữ liệu trên table
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //thông qua dữ liệu trong defaultTableModel để set data cho table
        jTableSanPham.setModel(defaultTableModel);
        //set giá trị cột
        defaultTableModel.addColumn("Mã SP");
        defaultTableModel.addColumn("Tên SP");
        defaultTableModel.addColumn("Danh Mục");
        defaultTableModel.addColumn("Số Lượng");
        jTableSanPham.setRowHeight(30);
        setTableData(SPController.getAllSanPham());

        jTableSanPham.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    try {
                        jLabelTrangThaiChucNang.setText("Edit");
                        SanPham SanPhamSelect = LayDuLieuChon();
                        jTextFieldMaSanPham.setText(String.valueOf(SanPhamSelect.getMaSanPham()));
                        jTextFieldTenSanPham.setText(SanPhamSelect.getTenSanPham());
                        jComboBoxDanhMucSanPham.getModel().setSelectedItem(SPController.getDanhMucBySanPham(SanPhamSelect));
                        jTextFieldSoLuong.setText(String.valueOf(SanPhamSelect.getSoLuong()));
                        jTextFieldGiaMua.setText(String.valueOf(SanPhamSelect.getGiaMua()));
                        jTextFieldGiaBan.setText(String.valueOf(SanPhamSelect.getGiaBan()));
                        jTextFieldMaSanPham.setText(String.valueOf(SanPhamSelect.getMaDanhMuc()));
                        jTextAreaMoTa.setText(SanPhamSelect.getMoTa());
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(QuanLyNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    public static SanPham LayDuLieuChon() throws ClassNotFoundException, SQLException {
        int row = jTableSanPham.getSelectedRow();
        int MaSP = Integer.parseInt(String.valueOf(jTableSanPham.getValueAt(row, 0)));
        return SPController.LayThongTinSanPham(new SanPham(MaSP));
    }

    private void setTableData(List<SanPham> SanPhams) throws ClassNotFoundException, SQLException {
        defaultTableModel.setRowCount(0);
        SanPhams.forEach(x -> {
            //set giá trị hàng
            defaultTableModel.addRow(new Object[]{
                x.getMaSanPham(),
                x.getTenSanPham(),
                x.getTenDanhMuc(),
                x.getSoLuong()
            });
        });
    }

    private void LoadComboboxDanhMucSP() throws ClassNotFoundException, SQLException {
        DMSanPhams = SPController.getAllDanhMucSanPham();
        jComboBoxDanhMucSanPham.removeAllItems();
        DMSanPhams.forEach(DMSP -> {
            jComboBoxDanhMucSanPham.addItem(new DanhMucSanPham(DMSP));
        });
        jComboBoxDanhMucSanPham.setRenderer(new MyObjectListCellRenderer());
    }

    private int ReadComboxDMSP() {
        DanhMucSanPham DMSP = (DanhMucSanPham) (jComboBoxDanhMucSanPham.getSelectedItem());
        return DMSP.getMaDanhMuc();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSanPham = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldMaSanPham = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldTenSanPham = new javax.swing.JTextField();
        jButtonThemMoi = new javax.swing.JButton();
        jButtonLuu = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();
        jButtonQuayLai = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldSoLuong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldGiaMua = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaMoTa = new javax.swing.JTextArea();
        jComboBoxDanhMucSanPham = new javax.swing.JComboBox<>();
        jLabelTrangThaiChucNang = new javax.swing.JLabel();
        jTextFieldGiaBan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(988, 531));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setVerifyInputWhenFocusTarget(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTableSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Admin", "1"},
                {"Nhân Viên", "2"},
                {"User", null}
            },
            new String [] {
                "Tên Nhóm người dùng", "Mã Nhóm người dùng"
            }
        ));
        jScrollPane1.setViewportView(jTableSanPham);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("QUẢN LÝ NHÓM SẢN PHẨM");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã Sản Phẩm:");

        jTextFieldMaSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên Sản Phẩm:");

        jTextFieldTenSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButtonThemMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonThemMoi.setText("Thêm Mới");
        jButtonThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemMoiActionPerformed(evt);
            }
        });

        jButtonLuu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonLuu.setText("Lưu");
        jButtonLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLuuActionPerformed(evt);
            }
        });

        jButtonXoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonXoa.setText("Xóa");
        jButtonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaActionPerformed(evt);
            }
        });

        jButtonQuayLai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonQuayLai.setText("Quay Lại");
        jButtonQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuayLaiActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Danh Mục Sản Phẩm:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Số Lượng:");

        jTextFieldSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Giá Mua:");

        jTextFieldGiaMua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Mô Tả:");

        jTextAreaMoTa.setColumns(20);
        jTextAreaMoTa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextAreaMoTa.setRows(5);
        jScrollPane2.setViewportView(jTextAreaMoTa);

        jComboBoxDanhMucSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldGiaBan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Giá Bán:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jTextFieldTenSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jTextFieldSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jTextFieldGiaMua, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)))
                            .addComponent(jComboBoxDanhMucSanPham, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonThemMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(jButtonLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonQuayLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldMaSanPham))
                                .addGap(20, 20, 20)
                                .addComponent(jLabel3))
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabelTrangThaiChucNang))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxDanhMucSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldGiaMua, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTrangThaiChucNang)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLuuActionPerformed
        switch (jLabelTrangThaiChucNang.getText()) {
            case "Edit":
            try {
                if (!jTextFieldTenSanPham.getText().equals("") && !jTextFieldSoLuong.getText().equals("") && !jTextFieldGiaMua.getText().equals("") && !jTextFieldGiaBan.getText().equals("")) {
                    SPController.updateSanPham(new SanPham(Integer.parseInt(jTextFieldMaSanPham.getText()),jTextFieldTenSanPham.getText(), Integer.parseInt(jTextFieldSoLuong.getText()), Integer.parseInt(jTextFieldGiaMua.getText()), Integer.parseInt(jTextFieldGiaBan.getText()), jTextAreaMoTa.getText(), ReadComboxDMSP()));
                    JOptionPane.showMessageDialog(this, "Sửa thành công!", "Sửa Sản Phẩm", JOptionPane.DEFAULT_OPTION);
                    setTableData(SPController.getAllSanPham());
                } else {
                    JOptionPane.showMessageDialog(this, "Chỉ Mô Tả mới được phép rỗng", "Sửa Sản Phẩm", JOptionPane.WARNING_MESSAGE);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(QuanLyNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Edit");
            break;

            case "New":
                if (!jTextFieldTenSanPham.getText().equals("") && !jTextFieldSoLuong.getText().equals("") && !jTextFieldGiaMua.getText().equals("") && !jTextFieldGiaBan.getText().equals("")) {
                    try {
                        SPController.addSanPham(new SanPham(jTextFieldTenSanPham.getText(), Integer.parseInt(jTextFieldSoLuong.getText()), Integer.parseInt(jTextFieldGiaMua.getText()), Integer.parseInt(jTextFieldGiaBan.getText()), jTextAreaMoTa.getText(), ReadComboxDMSP()));
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(QuanLyDanhMuc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(this, "Thêm Thành công!", "Thêm mới danh mục", JOptionPane.DEFAULT_OPTION);
                    try {
                        setTableData(SPController.getAllSanPham());
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(QuanLyDanhMuc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    jTextFieldMaSanPham.setText("Tự động");
                    jTextFieldTenSanPham.setText("");
                    jTextFieldSoLuong.setText("");
                    jTextFieldGiaMua.setText("");
                    jTextFieldGiaBan.setText("");
                    jTextAreaMoTa.setText("");
                    jLabelTrangThaiChucNang.setText("New");
                    jTextFieldTenSanPham.requestFocus();

                } else {
                    JOptionPane.showMessageDialog(this, "Chỉ Mô Tả mới được phép rỗng", "Thêm Sản Phẩm", JOptionPane.WARNING_MESSAGE);
                }
                System.out.println("New");
                break;
        }        // TODO         // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLuuActionPerformed

    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonXoaActionPerformed

    private void jButtonQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuayLaiActionPerformed
        try {
            MasterLayout.it.showDashbroad();        // TODO add your handling code here:
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonQuayLaiActionPerformed

    private void jButtonThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemMoiActionPerformed
        jTextFieldMaSanPham.setText("Tự động");
        jTextFieldTenSanPham.setText("");
        jTextFieldSoLuong.setText("");
        jTextFieldGiaMua.setText("");
        jTextFieldGiaBan.setText("");
        jTextAreaMoTa.setText("");
        jLabelTrangThaiChucNang.setText("New");
        jTextFieldTenSanPham.requestFocus();
    }//GEN-LAST:event_jButtonThemMoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLuu;
    private javax.swing.JButton jButtonQuayLai;
    private javax.swing.JButton jButtonThemMoi;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JComboBox<DanhMucSanPham> jComboBoxDanhMucSanPham;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelTrangThaiChucNang;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTable jTableSanPham;
    private javax.swing.JTextArea jTextAreaMoTa;
    private javax.swing.JTextField jTextFieldGiaBan;
    private javax.swing.JTextField jTextFieldGiaMua;
    private javax.swing.JTextField jTextFieldMaSanPham;
    private javax.swing.JTextField jTextFieldSoLuong;
    private javax.swing.JTextField jTextFieldTenSanPham;
    // End of variables declaration//GEN-END:variables
}
