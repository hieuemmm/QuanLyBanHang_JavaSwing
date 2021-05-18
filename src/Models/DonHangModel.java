/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import static Core.ConnectMySQL.getJDBCConnection;
import Core.DonHang;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class DonHangModel {

    public int DemTongSoDonHangChuaXuLy() throws ClassNotFoundException, SQLException {
        Connection connection = getJDBCConnection();
        String Sql = "SELECT COUNT(MaDonHang)AS TongSoLuong FROM DonHang WHERE MaTT = 1;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            ResultSet rs = preparedStatement.executeQuery();
            rs.first();
            return rs.getInt("TongSoLuong");
        } catch (SQLException e) {
        }
        return 0;
    }

    public int TinhDoanhThu() throws ClassNotFoundException, SQLException {
        Connection connection = getJDBCConnection();
        String Sql = "SELECT SUM(chitietdonhang.SoLuongMua * sanpham.DonGia) AS DoanhThu "
                + "FROM donhang "
                + "INNER JOIN chitietdonhang ON donhang.MaDonHang = chitietdonhang.MaDH "
                + "INNER JOIN sanpham ON chitietdonhang.MaSP = sanpham.MaSanPham "
                + "WHERE donhang.MaTT = 4;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            ResultSet rs = preparedStatement.executeQuery();
            rs.first();
            return rs.getInt("DoanhThu");
        } catch (SQLException e) {
        }
        return 0;
    }
}
