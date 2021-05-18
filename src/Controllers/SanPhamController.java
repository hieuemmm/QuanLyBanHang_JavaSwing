/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.SanPhamModel;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class SanPhamController {
    private final SanPhamModel SPModel;

    public SanPhamController() {
        SPModel = new SanPhamModel();
    }
    public int DemTongSoSanPham() throws ClassNotFoundException, SQLException {
        return SPModel.DemTongSoSanPham();
    }
}
