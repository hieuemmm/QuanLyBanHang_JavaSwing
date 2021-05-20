/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultCaret;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.undo.UndoManager;
import sun.applet.Main;

/**
 *
 * @author Administrator
 */
public final class MasterLayout extends javax.swing.JFrame {

    public static MasterLayout it;

    /**
     * Creates new form MasterLayout
     *
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public MasterLayout() throws ClassNotFoundException, SQLException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        it = this;
        initComponents();
        centerFrame();
        showDashbroad();
    }

    private void centerFrame() {
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTreeMenu = new javax.swing.JTree();
        panelControl = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        jTreeMenu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("QUẢN LÝ BÁN HÀNG");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Thống Kê");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Quản Lý Người Dùng");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Quản Lý Danh Mục");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Quản Lý Sản Phẩm");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Quản Lý Đơn Hàng");
        treeNode1.add(treeNode2);
        jTreeMenu.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTreeMenu.setRowHeight(26);
        jTreeMenu.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeMenuValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTreeMenu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );

        panelControl.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelControlLayout = new javax.swing.GroupLayout(panelControl);
        panelControl.setLayout(panelControlLayout);
        panelControlLayout.setHorizontalGroup(
            panelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 981, Short.MAX_VALUE)
        );
        panelControlLayout.setVerticalGroup(
            panelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jMenu1.setText("Tài Khoản");

        jMenuItem2.setText("Đổi mật khẩu");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Đăng Xuất");
        jMenuItem3.setToolTipText("");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jTreeMenuValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeMenuValueChanged
        DefaultMutableTreeNode selectNode = (DefaultMutableTreeNode) jTreeMenu.getLastSelectedPathComponent();
        switch (selectNode.getUserObject().toString()) {
            case "Quản Lý Người Dùng":
                ShowQuanLyNguoiDung();
                break;
            case "Quản Lý Danh Mục":
                panelControl.removeAll();
                QuanLyDanhMuc QLDM;
                try {
                    QLDM = new QuanLyDanhMuc();
                    QLDM.setSize(980, 531);
                    QLDM.setPreferredSize(new Dimension(980, 531));
                    panelControl.add(QLDM);
                    panelControl.updateUI();
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(MasterLayout.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Quản Lý Sản Phẩm":
                ShowQuanLySanPham();
                break;
            case "Quản Lý Đơn Hàng":
                ShowQuanLyDonHang();
                break;

            case "Thống Kê":
                panelControl.removeAll();
                ThongKe TKSP;
                try {
                    TKSP = new ThongKe();
                    TKSP.setSize(980, 531);
                    TKSP.setPreferredSize(new Dimension(980, 531));
                    panelControl.add(TKSP);
                    panelControl.updateUI();
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(MasterLayout.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            default:
                panelControl.removeAll();
                ThongKe DB = null;
                try {
                    DB = new ThongKe();
                    DB.setSize(980, 531);
                    DB.setPreferredSize(new Dimension(980, 531));
                    panelControl.add(DB);
                    panelControl.updateUI();
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(MasterLayout.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }//GEN-LAST:event_jTreeMenuValueChanged
    public void showDashbroad() throws ClassNotFoundException, SQLException {
        panelControl.removeAll();
        ThongKe DB = new ThongKe();
        DB.setSize(980, 531);
        DB.setPreferredSize(new Dimension(980, 531));
        panelControl.add(DB);
        panelControl.updateUI();
    }

    public void ShowQuanLyDonHang() {
        panelControl.removeAll();
        QuanLyDonHang QLDH;
        try {
            QLDH = new QuanLyDonHang();
            QLDH.setSize(980, 531);
            QLDH.setPreferredSize(new Dimension(980, 531));
            panelControl.add(QLDH);
            panelControl.updateUI();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MasterLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ShowQuanLySanPham() {
        panelControl.removeAll();
        QuanLySanPham QLSP;
        try {
            QLSP = new QuanLySanPham();
            QLSP.setSize(980, 531);
            QLSP.setPreferredSize(new Dimension(980, 531));
            panelControl.add(QLSP);
            panelControl.updateUI();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MasterLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ShowQuanLyNguoiDung() {
        panelControl.removeAll();
        QuanLyNguoiDung QLND = null;
        try {
            QLND = new QuanLyNguoiDung();
            QLND.setSize(980, 531);
            QLND.setPreferredSize(new Dimension(980, 531));
            panelControl.add(QLND);
            panelControl.updateUI();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MasterLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTreeMenu;
    private javax.swing.JPanel panelControl;
    // End of variables declaration//GEN-END:variables
}
