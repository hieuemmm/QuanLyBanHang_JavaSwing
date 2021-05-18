/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.DonHangModel;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class DonHangController {

    private final DonHangModel DHModel;

    public DonHangController() {
        DHModel = new DonHangModel();
    }

    public int DemTongSoDonHangChuaXuLy() throws ClassNotFoundException, SQLException {
        return DHModel.DemTongSoDonHangChuaXuLy();
    }
    public int TinhDoanhThu()throws ClassNotFoundException, SQLException {
        return DHModel.TinhDoanhThu();
    }
}
