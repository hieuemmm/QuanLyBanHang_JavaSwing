/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.DonHangController;
import Controllers.SanPhamController;
import Core.ChiTietDonHang;
import Core.DanhMucSanPham;
import Core.DonHang;
import Core.MyObjectListCellRenderer;
import Core.SanPham;
import Core.TrangThaiDonHang;
import static Views.QuanLySanPham.LayDuLieuChon;
import java.awt.Dimension;
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
public class QuanLyDonHang extends javax.swing.JPanel {

    private static DonHangController DHController;
    private final DefaultTableModel defaultTableModel;
    private final DefaultTableModel defaultTableModel2;
    private List<TrangThaiDonHang> TTDonHangs;

    /**
     * Creates new form QuanLyNhomNguoiDung
     */
    public QuanLyDonHang() throws ClassNotFoundException, SQLException {
        initComponents();
        initComponents();
        DHController = new DonHangController();
        TTDonHangs = new ArrayList<TrangThaiDonHang>();
        jTextFieldMaDonHang.setEditable(false);
        jTextFieldTaiKhoan.setEditable(false);
        jLabelTrangThaiChucNang.setText("");
        jLabelTrangThaiChucNang.setVisible(false);
        jTextFieldTaiKhoan.setText("");
        jTextFieldSoDienThoai.setText("");
        jTextFieldDiaChiNhanHang.setText("");
        jTextFieldSoDienThoai.requestFocus();
        LoadComboboxTTDH();
        LoadComboboxLocTrangThaiDonHang();
        defaultTableModel = new DefaultTableModel() {
            //không cho phép sửa dữ liệu trên table
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        defaultTableModel2 = new DefaultTableModel() {
            //không cho phép sửa dữ liệu trên table
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //thông qua dữ liệu trong defaultTableModel để set data cho table
        jTableQuanLyDonHang.setModel(defaultTableModel);
        //set giá trị cột
        defaultTableModel.addColumn("Mã DH");
        defaultTableModel.addColumn("SDT");
        defaultTableModel.addColumn("DiaChi");
        defaultTableModel.addColumn("Trạng Thái Đơn");
        jTableQuanLyDonHang.setRowHeight(30);
        setTableData(DHController.getAllDonHang(ReadComboxLocTTDH()));

        jTableQuanLyDonHang.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    try {
                        jLabelTrangThaiChucNang.setText("XemChiTiet");
                        DonHang DonHangSelect = LayDuLieuChon();
                        jTextFieldMaDonHang.setText(String.valueOf(DonHangSelect.getMaDonHang()));
                        jTextFieldSoDienThoai.setText(String.valueOf(DonHangSelect.getSDT()));
                        jTextFieldDiaChiNhanHang.setText(String.valueOf(DonHangSelect.getDiaChiNhanHang()));
                        jTextFieldTaiKhoan.setText(DHController.LayThongTinTaiKhoanCuaDonHang(DonHangSelect).getTaiKhoan());
                        jComboBoxTrangThaiDonHang.getModel().setSelectedItem(DHController.getTrangThaiDonHangByDH(DonHangSelect));
                        //comboxbox select
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(QuanLyNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    public static DonHang LayDuLieuChon() throws ClassNotFoundException, SQLException {
        int row = jTableQuanLyDonHang.getSelectedRow();
        int MaDH = Integer.parseInt(String.valueOf(jTableQuanLyDonHang.getValueAt(row, 0)));
        return DHController.LayThongTinDonHang(new DonHang(MaDH));
    }

    private void setTableData(List<DonHang> DonHangs) throws ClassNotFoundException, SQLException {
        defaultTableModel.setRowCount(0);
        DonHangs.forEach(x -> {
            //set giá trị hàng
            defaultTableModel.addRow(new Object[]{
                x.getMaDonHang(),
                x.getSDT(),
                x.getDiaChiNhanHang(),
                x.getTenTrangThai()
            });
        });
    }

    private void setTableData2(List<ChiTietDonHang> ChiTietDonHangs) throws ClassNotFoundException, SQLException {
        defaultTableModel.setRowCount(0);
        ChiTietDonHangs.forEach(x -> {
            //set giá trị hàng
            defaultTableModel2.addRow(new Object[]{
                x.getMaSanPham(),
                x.getTenSanPham(),
                x.getSoLuongMua(),
                x.getGiaBan()
            });
        });
    }

    private void LoadComboboxTTDH() throws ClassNotFoundException, SQLException {
        TTDonHangs = DHController.getAllTrangThaiDonHang();
        jComboBoxTrangThaiDonHang.removeAllItems();
        TTDonHangs.forEach(TTDH -> {
            jComboBoxTrangThaiDonHang.addItem(new TrangThaiDonHang(TTDH));
        });
        jComboBoxTrangThaiDonHang.setRenderer(new MyObjectListCellRenderer());
    }

    private void LoadComboboxLocTrangThaiDonHang() throws ClassNotFoundException, SQLException {
        TTDonHangs = DHController.getAllTrangThaiDonHang();
        jComboBoxLocTrangThaiDonHnag.removeAllItems();
        jComboBoxLocTrangThaiDonHnag.addItem(new TrangThaiDonHang(0,"Tất Cả"));
        TTDonHangs.forEach(TTDH -> {
            jComboBoxLocTrangThaiDonHnag.addItem(new TrangThaiDonHang(TTDH));
        });
        jComboBoxLocTrangThaiDonHnag.setRenderer(new MyObjectListCellRenderer());
    }

    private int ReadComboxTTDH() {
        TrangThaiDonHang TTDH = (TrangThaiDonHang) (jComboBoxTrangThaiDonHang.getSelectedItem());
        return TTDH.getMaTrangThai();
    }
    private int ReadComboxLocTTDH() {
        TrangThaiDonHang TTDH = (TrangThaiDonHang) (jComboBoxLocTrangThaiDonHnag.getSelectedItem());
        return TTDH.getMaTrangThai();
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
        jTableQuanLyDonHang = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldMaDonHang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldSoDienThoai = new javax.swing.JTextField();
        jButtonLuu = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();
        jButtonQuayLai = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldTaiKhoan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldDiaChiNhanHang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxTrangThaiDonHang = new javax.swing.JComboBox<>();
        jLabelTrangThaiChucNang = new javax.swing.JLabel();
        jButtonQuayLaiXemChiTiet = new javax.swing.JButton();
        jComboBoxLocTrangThaiDonHnag = new javax.swing.JComboBox<>();
        jButtonLoc = new javax.swing.JButton();
        jTextFieldTimKiem = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(988, 531));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setVerifyInputWhenFocusTarget(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTableQuanLyDonHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableQuanLyDonHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Admin", "1"},
                {"Nhân Viên", "2"},
                {"User", null}
            },
            new String [] {
                "Tên Nhóm người dùng", "Mã Nhóm người dùng"
            }
        ));
        jScrollPane1.setViewportView(jTableQuanLyDonHang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("QUẢN LÝ ĐƠN HÀNG");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã Đơn Hàng:");

        jTextFieldMaDonHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Số Điện Thoại:");

        jTextFieldSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

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
        jLabel4.setText("Tài Khoản:");

        jTextFieldTaiKhoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Địa Chỉ Nhận Hàng:");

        jTextFieldDiaChiNhanHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Trạng Thái Đơn Hàng:");

        jComboBoxTrangThaiDonHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButtonQuayLaiXemChiTiet.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonQuayLaiXemChiTiet.setText("Xem Chi Tiết");
        jButtonQuayLaiXemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuayLaiXemChiTietActionPerformed(evt);
            }
        });

        jComboBoxLocTrangThaiDonHnag.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButtonLoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonLoc.setText("Lọc");
        jButtonLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLocActionPerformed(evt);
            }
        });

        jTextFieldTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Tìm Kiếm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabelTrangThaiChucNang)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldMaDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextFieldTaiKhoan)
                                .addContainerGap())))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxTrangThaiDonHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldDiaChiNhanHang)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButtonLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jTextFieldSoDienThoai)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jButtonQuayLaiXemChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                .addGap(10, 10, 10)
                                .addComponent(jButtonQuayLai))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBoxLocTrangThaiDonHnag, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldTimKiem))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonLoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonLoc, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jComboBoxLocTrangThaiDonHnag))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMaDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDiaChiNhanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTrangThaiDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonQuayLaiXemChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTrangThaiChucNang)
                .addContainerGap(229, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 64, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLuuActionPerformed
        if (jLabelTrangThaiChucNang.getText().equals("XemChiTiet")) {
            try {
                if (!jTextFieldSoDienThoai.getText().equals("") && !jTextFieldDiaChiNhanHang.getText().equals("")) {
                    DHController.updateDonHang(new DonHang(Integer.parseInt(jTextFieldMaDonHang.getText()), jTextFieldSoDienThoai.getText(), jTextFieldDiaChiNhanHang.getText(), ReadComboxTTDH()));
                    JOptionPane.showMessageDialog(this, "Sửa thành công!", "Sửa Sản Phẩm", JOptionPane.DEFAULT_OPTION);
                    setTableData(DHController.getAllDonHang(ReadComboxLocTTDH()));
                } else {
                    JOptionPane.showMessageDialog(this, "SDT và Địa Chỉ không được rỗng", "Sửa Đơn Hàng", JOptionPane.WARNING_MESSAGE);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(QuanLyNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonLuuActionPerformed

    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonXoaActionPerformed

    private void jButtonQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuayLaiActionPerformed
        jTableQuanLyDonHang.setModel(defaultTableModel);
        try {
            setTableData(DHController.getAllDonHang(ReadComboxLocTTDH()));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuanLyDonHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonQuayLaiActionPerformed

    private void jButtonQuayLaiXemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuayLaiXemChiTietActionPerformed
        if (jLabelTrangThaiChucNang.getText().equals("XemChiTiet")) {
            jTableQuanLyDonHang.setModel(defaultTableModel2);
            //set giá trị cột
            defaultTableModel2.addColumn("Mã Sản Phẩm");
            defaultTableModel2.addColumn("Tên Sản Phẩm");
            defaultTableModel2.addColumn("Số Lượng");
            defaultTableModel2.addColumn("Giá Bán");
            jTableQuanLyDonHang.setRowHeight(30);
            try {
                setTableData2(DHController.getAllChiTietDonHangByDonHang(new DonHang(Integer.parseInt(jTextFieldMaDonHang.getText()))));
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(QuanLyDonHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Phải chọn đơn hàng trước", "Xem chi tiết đơn hàng", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonQuayLaiXemChiTietActionPerformed

    private void jButtonLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLocActionPerformed
        try {
            List<DonHang> DHFind = new ArrayList<>(DHController.getAllDonHang(ReadComboxLocTTDH()));
            if (DHFind != null) {
                setTableData(DHFind);
            }
            else{
                JOptionPane.showMessageDialog(this, "Không tìm thấy đơn hàng của khách hàng này", "Tìm kiếm đơn hàng", JOptionPane.DEFAULT_OPTION);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuanLyDonHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonLocActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!jTextFieldTimKiem.getText().equals("")) {
            try {
                setTableData(DHController.getAllDonHangByTaiKhoan(jTextFieldTimKiem.getText()));
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(QuanLyDonHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonLoc;
    private javax.swing.JButton jButtonLuu;
    private javax.swing.JButton jButtonQuayLai;
    private javax.swing.JButton jButtonQuayLaiXemChiTiet;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JComboBox<TrangThaiDonHang> jComboBoxLocTrangThaiDonHnag;
    private javax.swing.JComboBox<TrangThaiDonHang> jComboBoxTrangThaiDonHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelTrangThaiChucNang;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTableQuanLyDonHang;
    private javax.swing.JTextField jTextFieldDiaChiNhanHang;
    private javax.swing.JTextField jTextFieldMaDonHang;
    private javax.swing.JTextField jTextFieldSoDienThoai;
    private javax.swing.JTextField jTextFieldTaiKhoan;
    private javax.swing.JTextField jTextFieldTimKiem;
    // End of variables declaration//GEN-END:variables
}
