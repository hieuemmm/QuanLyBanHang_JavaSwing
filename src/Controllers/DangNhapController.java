/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Core.ConnectMySQL.getJDBCConnection;
import Core.TaiKhoan;
import Models.TaiKhoanModel;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class DangNhapController {

    private final TaiKhoanModel taikhoanModel;

    public DangNhapController() {
        taikhoanModel = new TaiKhoanModel();
    }

    public boolean CheckDangNhap(TaiKhoan TK) throws ClassNotFoundException, SQLException {
        return taikhoanModel.DemTaiKhoanByAccPass(TK) > 0;
    }
    public TaiKhoan LayThongTinDangNhap(TaiKhoan TK) throws ClassNotFoundException, SQLException {
        return taikhoanModel.getTaiKhoanByTaiKhoan(TK);
    }
}
