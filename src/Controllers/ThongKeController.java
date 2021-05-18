/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.TaiKhoanModel;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class ThongKeController {
    private final TaiKhoanModel taikhoanmodel ;

    public ThongKeController() {
        taikhoanmodel = new TaiKhoanModel();
    }
    public int DemTongTaiKhoan(int MaNhomND) throws ClassNotFoundException, SQLException {
        return taikhoanmodel.DemTongByMaNhomNguoiDung(MaNhomND);
    }
}
