/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Core.ChiTietDonHang;
import Core.DonHang;
import Core.SanPham;
import Core.TaiKhoan;
import Core.TrangThaiDonHang;
import Models.DonHangModel;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class DonHangController {

    private final DonHangModel DHModel;

    public DonHangController() {
        DHModel = new DonHangModel();
    }

    public List<TrangThaiDonHang> getAllTrangThaiDonHang() throws ClassNotFoundException, SQLException {
        return DHModel.getAllTrangThaiDonHang();
    }

    public List<DonHang> getAllDonHang(int MaTT) throws ClassNotFoundException, SQLException {
        return DHModel.getAllDonHang(MaTT);
    }

    public List<DonHang> getAllDonHangByTaiKhoan(String TK) throws ClassNotFoundException, SQLException {
        return DHModel.getAllDonHangByTaiKhoan(TK);
    }

    public List<ChiTietDonHang> getAllChiTietDonHangByDonHang(DonHang DH) throws ClassNotFoundException, SQLException {
        return DHModel.getAllChiTietDonHangByDonHang(DH);
    }

    public int DemTongSoDonHangChuaXuLy() throws ClassNotFoundException, SQLException {
        return DHModel.DemTongSoDonHangChuaXuLy();
    }

    public int TinhDoanhThu() throws ClassNotFoundException, SQLException {
        return DHModel.TinhDoanhThu();
    }

    public int TongGiaTriDonHang(int MaDH) throws ClassNotFoundException, SQLException {
        return DHModel.TongGiaTriDonHang(MaDH);
    }

    public DonHang LayThongTinDonHang(DonHang donHang) throws ClassNotFoundException, SQLException {
        return DHModel.LayThongTinDonHang(donHang);
    }

    public TrangThaiDonHang getTrangThaiDonHangByDH(DonHang DH) throws ClassNotFoundException, SQLException {
        return DHModel.getTrangThaiDonHangByDH(DH);
    }

    public TaiKhoan LayThongTinTaiKhoanCuaDonHang(DonHang DH) throws ClassNotFoundException, SQLException {
        return DHModel.LayThongTinTaiKhoanCuaDonHang(DH);
    }

    public void updateDonHang(DonHang DH) throws ClassNotFoundException, SQLException {
        DHModel.updateDonHang(DH);
    }
}
