/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Core.DanhMucSanPham;
import Core.SanPham;
import Models.SanPhamModel;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class SanPhamController {

    private final SanPhamModel SPModel;

    public SanPhamController() {
        SPModel = new SanPhamModel();
    }

    public List<SanPham> getAllSanPham() throws ClassNotFoundException, SQLException {
        return SPModel.getAllSanPham();
    }

    public List<DanhMucSanPham> getAllDanhMucSanPham() throws ClassNotFoundException, SQLException {
        return SPModel.getAllDanhMucSanPham();
    }
    public DanhMucSanPham getDanhMucBySanPham(SanPham SP) throws ClassNotFoundException, SQLException {
        return SPModel.getDanhMucBySanPham(SP);
    }
    public DanhMucSanPham LayThongTinDanhMuc(DanhMucSanPham DMSP) throws ClassNotFoundException, SQLException {
        return SPModel.LayThongTinDanhMuc(DMSP);
    }

    public SanPham LayThongTinSanPham(SanPham SP) throws ClassNotFoundException, SQLException {
        return SPModel.LayThongTinSanPham(SP);
    }

    public int DemTongSoSanPham() throws ClassNotFoundException, SQLException {
        return SPModel.DemTongSoSanPham();
    }

    public void updateDanhMuc(DanhMucSanPham DMSP) throws ClassNotFoundException, SQLException {
        SPModel.updateDanhMuc(DMSP);
    }

    public void updateSanPham(SanPham SP) throws ClassNotFoundException, SQLException {
        SPModel.updateSanPham(SP);
    }

    public void addDanhMucSanPham(DanhMucSanPham DMSP) throws ClassNotFoundException, SQLException {
        SPModel.addDanhMucSanPham(DMSP);
    }
    public void addSanPham(SanPham SP) throws ClassNotFoundException, SQLException {
        SPModel.addSanPham(SP);
    }
}
