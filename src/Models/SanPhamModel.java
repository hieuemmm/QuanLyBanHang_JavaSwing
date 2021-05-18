/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import static Core.ConnectMySQL.getJDBCConnection;
import com.mysql.jdbc.Connection;
import Core.SanPham;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class SanPhamModel {
//    public List<SanPham> getAllSanPham() throws ClassNotFoundException, SQLException {
//        List<SanPham> SanPhams = new ArrayList<SanPham>();
//        Connection connection = getJDBCConnection();
//        String Sql = "SELECT SUM(SoLuong)AS TongSoLuong FROM SanPham;";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                SanPham user = new SanPham();
//                user.setId(rs.getInt("id"));
//                user.setName(rs.getString("name"));
//                user.setPhone(rs.getString("phone"));
//                user.setSanPhamname(rs.getString("username"));
//                user.setPassword(rs.getString("password"));
//                user.setRole(rs.getString("role"));
//                user.setFavorites(rs.getString("favorites"));
//                user.setAbout(rs.getString("about"));
//                SanPhams.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return SanPhams;
//    }

    public int DemTongSoSanPham() throws ClassNotFoundException, SQLException {
        Connection connection = getJDBCConnection();
        String Sql = "SELECT SUM(SoLuong)AS TongSoLuong FROM SanPham;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            ResultSet rs = preparedStatement.executeQuery();
            rs.first();
            return rs.getInt("TongSoLuong");
        } catch (SQLException e) {
        }
        return 0;
    }
}
