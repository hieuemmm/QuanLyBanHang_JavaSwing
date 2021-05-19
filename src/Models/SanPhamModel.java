/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import static Core.ConnectMySQL.getJDBCConnection;
import com.mysql.jdbc.Connection;
import Core.SanPham;
import Core.DanhMucSanPham;
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

    public List<DanhMucSanPham> getAllDanhMucSanPham() throws ClassNotFoundException, SQLException {
        List<DanhMucSanPham> DanhMucSanPhams = new ArrayList<DanhMucSanPham>();
        Connection connection = getJDBCConnection();
        String Sql = "SELECT * FROM DanhMucSanPham;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                DanhMucSanPham DMSP = new DanhMucSanPham();
                DMSP.setMaDanhMuc(rs.getInt("MaDanhMuc"));
                DMSP.setTenDanhMuc(rs.getString("TenDanhMuc"));
                DanhMucSanPhams.add(DMSP);
            }
        } catch (SQLException e) {
        }
        return DanhMucSanPhams;
    }

    public DanhMucSanPham LayThongTinDanhMuc(DanhMucSanPham DanhMucSP) throws ClassNotFoundException, SQLException {
        Connection connection = getJDBCConnection();
        String Sql = "SELECT * FROM DanhMucSanPham WHERE MaDanhMuc = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            preparedStatement.setInt(1, DanhMucSP.getMaDanhMuc());
            ResultSet rs = preparedStatement.executeQuery();
            rs.first();
            DanhMucSanPham DMSP = new DanhMucSanPham();
            DMSP.setMaDanhMuc(rs.getInt("MaDanhMuc"));
            DMSP.setTenDanhMuc(rs.getString("TenDanhMuc"));
            return DMSP;
        } catch (SQLException e) {
        }
        return null;
    }

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

    public void addDanhMucSanPham(DanhMucSanPham DMSP) throws ClassNotFoundException, SQLException {
        Connection connection = getJDBCConnection();
        String Sql = "INSERT INTO DanhMucSanPham(TenDanhMuc) VALUES (?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            //ResultSet rs = preparedStatement.executeQuery();
            preparedStatement.setString(1, DMSP.getTenDanhMuc());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void updateDanhMuc(DanhMucSanPham DMSP) throws ClassNotFoundException, SQLException {
        Connection connection = getJDBCConnection();
        String Sql = "UPDATE DanhMucSanPham SET TenDanhMuc = ? WHERE MaDanhMuc = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            preparedStatement.setString(1, DMSP.getTenDanhMuc());
            preparedStatement.setInt(2, DMSP.getMaDanhMuc());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
