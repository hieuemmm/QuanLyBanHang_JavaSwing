/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import static Core.ConnectMySQL.getJDBCConnection;
import Core.TaiKhoan;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class TaiKhoanModel {

    public int DemTaiKhoanByAccPass(TaiKhoan TK) throws ClassNotFoundException, SQLException {
        Connection connection = getJDBCConnection();
        String Sql = "SELECT Count(*) AS DemTaiKhoan FROM TaiKhoan WHERE TaiKhoan = ? AND MatKhau = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            preparedStatement.setString(1, TK.getTaiKhoan());
            preparedStatement.setString(2, TK.getMatKhau());
            ResultSet rs = preparedStatement.executeQuery();
            rs.first();
            return rs.getInt("DemTaiKhoan");
        } catch (SQLException e) {
        }
        return 0;
    }

    public TaiKhoan getTaiKhoanByTaiKhoan(TaiKhoan TK) throws ClassNotFoundException, SQLException {
        Connection connection = getJDBCConnection();
        String Sql = "SELECT * FROM TaiKhoan WHERE TaiKhoan = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            preparedStatement.setString(1, TK.getTaiKhoan());
            ResultSet rs = preparedStatement.executeQuery();
            rs.first();
            TaiKhoan taikhoan = new TaiKhoan();
            taikhoan.setTaiKhoan(rs.getString("TaiKhoan"));
            taikhoan.setMatKhau(rs.getString("MatKhau"));
            taikhoan.setMaNguoiDung(rs.getInt("MaNhomND"));
            taikhoan.setTen(rs.getString("Ten"));
            return taikhoan;
        } catch (SQLException e) {
        }
        return null;
    }
    public int DemTongByMaNhomNguoiDung(int MaNhomNguoiDung) throws ClassNotFoundException, SQLException {
        Connection connection = getJDBCConnection();
        String Sql = "SELECT Count(*) AS DemTaiKhoan FROM TaiKhoan WHERE MaNhomND = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            preparedStatement.setInt(1, MaNhomNguoiDung);
            ResultSet rs = preparedStatement.executeQuery();
            rs.first();
            return rs.getInt("DemTaiKhoan");
        } catch (SQLException e) {
        }
        return 0;
    }
}
