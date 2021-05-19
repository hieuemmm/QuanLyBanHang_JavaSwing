/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Core.DanhMucSanPham;
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

    public List<DanhMucSanPham> getAllDanhMucSanPham() throws ClassNotFoundException, SQLException {
        return SPModel.getAllDanhMucSanPham();
    }

    public DanhMucSanPham LayThongTinDanhMuc(DanhMucSanPham DMSP) throws ClassNotFoundException, SQLException {
        return SPModel.LayThongTinDanhMuc(DMSP);
    }

    public int DemTongSoSanPham() throws ClassNotFoundException, SQLException {
        return SPModel.DemTongSoSanPham();
    }

    public void updateDanhMuc(DanhMucSanPham DMSP) throws ClassNotFoundException, SQLException {
        SPModel.updateDanhMuc(DMSP);
    }

    public void addDanhMucSanPham(DanhMucSanPham DMSP) throws ClassNotFoundException, SQLException {
        SPModel.addDanhMucSanPham(DMSP);
    }
}
