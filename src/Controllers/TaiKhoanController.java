/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Core.ConnectMySQL.getJDBCConnection;
import Core.NhomNguoiDung;
import Core.TaiKhoan;
import Models.TaiKhoanModel;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class TaiKhoanController {

    private final TaiKhoanModel taikhoanModel;

    public TaiKhoanController() {
        taikhoanModel = new TaiKhoanModel();
    }

    public List<TaiKhoan> getAllTaiKhoan() throws ClassNotFoundException, SQLException {
        return taikhoanModel.getAllTaiKhoan();
    }

    public List<NhomNguoiDung> getAllNhomNguoiDung() throws ClassNotFoundException, SQLException {
        return taikhoanModel.getAllNhomNguoiDung();
    }

    public NhomNguoiDung getNhomNguoiDungByTaiKhoan(TaiKhoan TK) throws ClassNotFoundException, SQLException {
        return taikhoanModel.getNhomNguoiDungByTaiKhoan(TK);
    }

    public boolean CheckDangNhap(TaiKhoan TK) throws ClassNotFoundException, SQLException {
        return taikhoanModel.DemTaiKhoanByAccPass(TK) > 0;
    }

    public TaiKhoan LayThongTinDangNhap(TaiKhoan TK) throws ClassNotFoundException, SQLException {
        return taikhoanModel.getTaiKhoanByTaiKhoan(TK);
    }

    public boolean addTaiKhoan(TaiKhoan TK) throws ClassNotFoundException, SQLException {
        if (taikhoanModel.KiemTraTaiKhoanTonTai(TK) < 1) {
            taikhoanModel.addTaiKhoan(TK);
            return true;
        }
        return false;
    }

    public void updateTaiKhoan(TaiKhoan TK) throws ClassNotFoundException, SQLException {
        taikhoanModel.updateTaiKhoan(TK);
    }
}
