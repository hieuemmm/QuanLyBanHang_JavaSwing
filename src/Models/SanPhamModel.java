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

    public DanhMucSanPham getDanhMucBySanPham(SanPham SP) throws ClassNotFoundException, SQLException {
        Connection connection = getJDBCConnection();
        String Sql = "SELECT * FROM DanhMucSanPham WHERE MaDanhMuc = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(Sql);
        preparedStatement.setInt(1, SP.getMaDanhMuc());
        ResultSet rs = preparedStatement.executeQuery();
        rs.first();
        DanhMucSanPham DMSP = new DanhMucSanPham();
        DMSP.setMaDanhMuc(rs.getInt("MaDanhMuc"));
        DMSP.setTenDanhMuc(rs.getString("TenDanhMuc"));
        return DMSP;
    }

    public List<SanPham> getAllSanPham() throws ClassNotFoundException, SQLException {
        List<SanPham> SanPhams = new ArrayList<SanPham>();
        Connection connection = getJDBCConnection();
        String Sql = "SELECT * "
                + "FROM SanPham "
                + "INNER JOIN DanhMucSanPham ON DanhMucSanPham.MaDanhMuc = SanPham.MaDM "
                + "ORDER BY SanPham.MaDM;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                SanPham SP = new SanPham();
                SP.setMaSanPham(rs.getInt("MaSanPham"));
                SP.setMaDanhMuc(rs.getInt("MaDanhMuc"));
                SP.setTenDanhMuc(rs.getString("TenDanhMuc"));
                SP.setTenSanPham(rs.getString("TenSanPham"));
                SP.setSoLuong(rs.getInt("SoLuong"));
                SP.setGiaMua(rs.getInt("GiaMua"));
                SP.setGiaBan(rs.getInt("GiaBan"));
                SP.setMoTa(rs.getString("MoTa"));
                SanPhams.add(SP);
            }
        } catch (SQLException e) {
        }
        return SanPhams;
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

    public SanPham LayThongTinSanPham(SanPham sanpham) throws ClassNotFoundException, SQLException {
        Connection connection = getJDBCConnection();
        String Sql = "SELECT * "
                + "FROM SanPham "
                + "INNER JOIN DanhMucSanPham ON DanhMucSanPham.MaDanhMuc = SanPham.MaDM "
                + "WHERE SanPham.MaSanPham = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            preparedStatement.setInt(1, sanpham.getMaSanPham());
            ResultSet rs = preparedStatement.executeQuery();
            rs.first();
            SanPham SP = new SanPham();
            SP.setMaSanPham(rs.getInt("MaSanPham"));
            SP.setMaDanhMuc(rs.getInt("MaDanhMuc"));
            SP.setTenDanhMuc(rs.getString("TenDanhMuc"));
            SP.setTenSanPham(rs.getString("TenSanPham"));
            SP.setSoLuong(rs.getInt("SoLuong"));
            SP.setGiaMua(rs.getInt("GiaMua"));
            SP.setGiaBan(rs.getInt("GiaBan"));
            SP.setMoTa(rs.getString("MoTa"));
            return SP;
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

    public void addSanPham(SanPham SP) throws ClassNotFoundException, SQLException {
        Connection connection = getJDBCConnection();
        String Sql = "INSERT INTO `sanpham`(`MaDM`, `TenSanPham`, `SoLuong`, `GiaMua`, `GiaBan`, `MoTa`) VALUES (?,?,?,?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            //ResultSet rs = preparedStatement.executeQuery();
            preparedStatement.setInt(1, SP.getMaDanhMuc());
            preparedStatement.setString(2, SP.getTenSanPham());
            preparedStatement.setInt(3, SP.getSoLuong());
            preparedStatement.setInt(4, SP.getGiaMua());
            preparedStatement.setInt(5, SP.getGiaBan());
            preparedStatement.setString(6, SP.getMoTa());
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

    public void updateSanPham(SanPham SP) throws ClassNotFoundException, SQLException {
        Connection connection = getJDBCConnection();
        String Sql = "UPDATE SanPham SET MaDM = ?, TenSanPham = ?,SoLuong = ?,GiaBan = ?,MoTa = ? WHERE MaSanPham = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            preparedStatement.setInt(1, SP.getMaDanhMuc());
            preparedStatement.setString(2, SP.getTenSanPham());
            preparedStatement.setInt(3, SP.getSoLuong());
            preparedStatement.setInt(4, SP.getGiaBan());
            preparedStatement.setString(5, SP.getMoTa());
            preparedStatement.setInt(6, SP.getMaSanPham());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
