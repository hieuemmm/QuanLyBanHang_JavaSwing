/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Core.ChiTietDonHang;
import static Core.ConnectMySQL.getJDBCConnection;
import Core.DanhMucSanPham;
import Core.DonHang;
import Core.SanPham;
import Core.TaiKhoan;
import Core.TrangThaiDonHang;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class DonHangModel {

    public List<TrangThaiDonHang> getAllTrangThaiDonHang() throws ClassNotFoundException, SQLException {
        List<TrangThaiDonHang> TrangThaiDonHangs = new ArrayList<TrangThaiDonHang>();
        Connection connection = getJDBCConnection();
        String Sql = "SELECT * FROM TrangThaiDonHang;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                TrangThaiDonHang TTDH = new TrangThaiDonHang();
                TTDH.setMaTrangThai(rs.getInt("MaTrangThai"));
                TTDH.setTenTrangThai(rs.getString("TenTrangThai"));
                TrangThaiDonHangs.add(TTDH);
            }
        } catch (SQLException e) {
        }
        return TrangThaiDonHangs;
    }

    public List<ChiTietDonHang> getAllChiTietDonHangByDonHang(DonHang DH) throws ClassNotFoundException, SQLException {
        List<ChiTietDonHang> ChiTietDonHangs = new ArrayList<ChiTietDonHang>();
        Connection connection = getJDBCConnection();
        String Sql = "SELECT * FROM ChiTietDonHang "
                + " INNER JOIN SanPham ON ChiTietDonHang.MaSP = SanPham.MaSanPham "
                + " WHERE ChiTietDonHang.MaDH = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            preparedStatement.setInt(1, DH.getMaDonHang());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ChiTietDonHang CTDH = new ChiTietDonHang();
                CTDH.setID(rs.getInt("ID"));
                CTDH.setMaSanPham(rs.getInt("MaSanPham"));
                CTDH.setSoLuongMua(rs.getInt("SoLuongMua"));
                CTDH.setGiaBan(rs.getInt("GiaBan"));
                CTDH.setTenSanPham(rs.getString("TenSanPham"));
                ChiTietDonHangs.add(CTDH);
            }
            return ChiTietDonHangs;
        } catch (SQLException e) {
        }
        return null;

    }

    public TrangThaiDonHang getTrangThaiDonHangByDH(DonHang DH) throws ClassNotFoundException, SQLException {
        Connection connection = getJDBCConnection();
        String Sql = "SELECT * FROM TrangThaiDonHang "
                + " WHERE MaTrangThai = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            preparedStatement.setInt(1, DH.getMaTrangThai());
            ResultSet rs = preparedStatement.executeQuery();
            rs.first();
            TrangThaiDonHang TTDH = new TrangThaiDonHang();
            TTDH.setMaTrangThai(rs.getInt("MaTrangThai"));
            TTDH.setTenTrangThai(rs.getString("TenTrangThai"));
            return TTDH;
        } catch (SQLException e) {
        }
        return null;
    }

    public List<DonHang> getAllDonHang() throws ClassNotFoundException, SQLException {
        List<DonHang> DonHangs = new ArrayList<DonHang>();
        Connection connection = getJDBCConnection();
        String Sql = "SELECT * FROM DonHang "
                + "INNER JOIN TrangThaiDonHang ON TrangThaiDonHang.MaTrangThai = DonHang.MaTT "
                + "ORDER BY DonHang.MaTT;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                DonHang DH = new DonHang();
                DH.setMaDonHang(rs.getInt("MaDonHang"));
                DH.setMaTrangThai(rs.getInt("MaTT"));
                DH.setTenTrangThai(rs.getString("TenTrangThai"));
                DH.setSDT(rs.getString("SDT"));
                DH.setDiaChiNhanHang(rs.getString("DiaChiNhanHang"));
                DH.setNgayTao(rs.getString("NgayTao"));
                DonHangs.add(DH);
            }
        } catch (SQLException e) {
        }
        return DonHangs;
    }

    public DonHang LayThongTinDonHang(DonHang donhang) throws ClassNotFoundException, SQLException {
        Connection connection = getJDBCConnection();
        String Sql = "SELECT * FROM DonHang "
                + "WHERE MaDonHang = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            preparedStatement.setInt(1, donhang.getMaDonHang());
            ResultSet rs = preparedStatement.executeQuery();
            rs.first();
            DonHang DH = new DonHang();
            DH.setMaDonHang(rs.getInt("MaDonHang"));
            DH.setMaTrangThai(rs.getInt("MaTT"));
            DH.setSDT(rs.getString("SDT"));
            DH.setDiaChiNhanHang(rs.getString("DiaChiNhanHang"));
            DH.setNgayTao(rs.getString("NgayTao"));
            return DH;
        } catch (SQLException e) {
        }
        return null;
    }

    public TaiKhoan LayThongTinTaiKhoanCuaDonHang(DonHang donhang) throws ClassNotFoundException, SQLException {
        Connection connection = getJDBCConnection();
        String Sql = "SELECT * FROM DonHang "
                + "WHERE MaDonHang = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            preparedStatement.setInt(1, donhang.getMaDonHang());
            ResultSet rs = preparedStatement.executeQuery();
            rs.first();
            TaiKhoan TK = new TaiKhoan();
            TK.setTaiKhoan(rs.getString("TK"));
            return TK;
        } catch (SQLException e) {
        }
        return null;
    }

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

    public void updateDonHang(DonHang DH) throws ClassNotFoundException, SQLException {
        Connection connection = getJDBCConnection();
        String Sql = "UPDATE DonHang SET SDT = ?, DiaChiNhanHang = ?,MaTT = ? WHERE MaDonHang = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            preparedStatement.setString(1, DH.getSDT());
            preparedStatement.setString(2, DH.getDiaChiNhanHang());
            preparedStatement.setInt(3, DH.getMaTrangThai());
            preparedStatement.setInt(4, DH.getMaDonHang());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
