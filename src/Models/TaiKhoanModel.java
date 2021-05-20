/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import static Core.ConnectMySQL.getJDBCConnection;
import Core.DonHang;
import Core.NhomNguoiDung;
import Core.TaiKhoan;
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
public class TaiKhoanModel {

    public List<TaiKhoan> getAllTaiKhoan(int MaNND) throws ClassNotFoundException, SQLException {
        List<TaiKhoan> TaiKhoans = new ArrayList<TaiKhoan>();
        Connection connection = getJDBCConnection();
        String Sql;
        if (MaNND == 0) {
            Sql = "SELECT * "
                    + "FROM TaiKhoan "
                    + "INNER JOIN NhomNguoiDung ON TaiKhoan.MaNhomND = NhomNguoiDung.MaNhomNguoiDung ;";
        } else {
            Sql = "SELECT * "
                    + "FROM TaiKhoan "
                    + "INNER JOIN NhomNguoiDung ON TaiKhoan.MaNhomND = NhomNguoiDung.MaNhomNguoiDung "
                    + "WHERE TaiKhoan.MaNhomND = ? ;";
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            if (MaNND != 0) {
                preparedStatement.setInt(1, MaNND);
            }
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                TaiKhoan taikhoan = new TaiKhoan();
                taikhoan.setTaiKhoan(rs.getString("TaiKhoan"));
                taikhoan.setMatKhau(rs.getString("MatKhau"));
                taikhoan.setTen(rs.getString("Ten"));
                taikhoan.setMaNhomNguoiDung(rs.getInt("MaNhomNguoiDung"));
                taikhoan.setTenNhomNguoiDung(rs.getString("TenNhomNguoiDung"));
                TaiKhoans.add(taikhoan);
            }
        } catch (SQLException e) {
        }
        return TaiKhoans;
    }

    public List<NhomNguoiDung> getAllNhomNguoiDung() throws ClassNotFoundException, SQLException {
        List<NhomNguoiDung> NhomNguoiDungs = new ArrayList<NhomNguoiDung>();
        Connection connection = getJDBCConnection();
        String Sql = "SELECT * FROM NhomNguoiDung ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                NhomNguoiDung nhomNguoiDung = new NhomNguoiDung();
                nhomNguoiDung.setMaNhomNguoiDung(rs.getInt("MaNhomNguoiDung"));
                nhomNguoiDung.setTenNhomNguoiDung(rs.getString("TenNhomNguoiDung"));
                NhomNguoiDungs.add(nhomNguoiDung);
            }
        } catch (SQLException e) {
        }
        return NhomNguoiDungs;
    }

    public NhomNguoiDung getNhomNguoiDungByTaiKhoan(TaiKhoan TK) throws ClassNotFoundException, SQLException {
        Connection connection = getJDBCConnection();
        String Sql = "SELECT * FROM TaiKhoan "
                + " INNER JOIN NhomNguoiDung ON NhomNguoiDung.MaNhomNguoiDung = TaiKhoan.MaNhomND "
                + " WHERE TaiKhoan = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            preparedStatement.setString(1, TK.getTaiKhoan());
            ResultSet rs = preparedStatement.executeQuery();
            rs.first();
            NhomNguoiDung NND = new NhomNguoiDung();
            NND.setMaNhomNguoiDung(rs.getInt("MaNhomNguoiDung"));
            NND.setTenNhomNguoiDung(rs.getString("TenNhomNguoiDung"));
            return NND;
        } catch (SQLException e) {
        }
        return null;
    }

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
            taikhoan.setMaNhomNguoiDung(rs.getInt("MaNhomND"));
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

    public void addTaiKhoan(TaiKhoan taikhoan) throws ClassNotFoundException, SQLException {
        Connection connection = getJDBCConnection();
        String Sql = "INSERT INTO TaiKhoan VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            //ResultSet rs = preparedStatement.executeQuery();
            preparedStatement.setString(1, taikhoan.getTaiKhoan());
            preparedStatement.setString(2, taikhoan.getMatKhau());
            preparedStatement.setString(3, taikhoan.getTen());
            preparedStatement.setInt(4, taikhoan.getMaNhomNguoiDung());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public int KiemTraTaiKhoanTonTai(TaiKhoan taikhoan) throws ClassNotFoundException, SQLException {
        Connection connection = getJDBCConnection();
        String Sql = "SELECT Count(*) AS DemTaiKhoan FROM TaiKhoan WHERE TaiKhoan = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            preparedStatement.setString(1, taikhoan.getTaiKhoan());
            ResultSet rs = preparedStatement.executeQuery();
            rs.first();
            return rs.getInt("DemTaiKhoan");
        } catch (SQLException e) {
        }
        return 0;
    }

    public void updateTaiKhoan(TaiKhoan taikhoan) throws ClassNotFoundException, SQLException {
        Connection connection = getJDBCConnection();
        String Sql = "UPDATE TaiKhoan SET MatKhau = ?, Ten = ?, MaNhomND = ? WHERE TaiKhoan = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            preparedStatement.setString(1, taikhoan.getMatKhau());
            preparedStatement.setString(2, taikhoan.getTen());
            preparedStatement.setInt(3, taikhoan.getMaNhomNguoiDung());
            preparedStatement.setString(4, taikhoan.getTaiKhoan());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public static void DoiMatKhau(TaiKhoan taikhoan) throws ClassNotFoundException, SQLException {
        Connection connection = getJDBCConnection();
        String Sql = "UPDATE TaiKhoan SET MatKhau = ? WHERE TaiKhoan = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Sql);
            preparedStatement.setString(1, taikhoan.getMatKhau());
            preparedStatement.setString(2, taikhoan.getTaiKhoan());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
