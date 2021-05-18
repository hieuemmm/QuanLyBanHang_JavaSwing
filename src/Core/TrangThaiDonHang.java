/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

/**
 *
 * @author Administrator
 */
public class TrangThaiDonHang {
    int MaTrangThai;
    String TenTrangThai;

    public TrangThaiDonHang() {
    }

    public TrangThaiDonHang(int MaTrangThai, String TenTrangThai) {
        this.MaTrangThai = MaTrangThai;
        this.TenTrangThai = TenTrangThai;
    }

    public int getMaTrangThai() {
        return MaTrangThai;
    }

    public void setMaTrangThai(int MaTrangThai) {
        this.MaTrangThai = MaTrangThai;
    }

    public String getTenTrangThai() {
        return TenTrangThai;
    }

    public void setTenTrangThai(String TenTrangThai) {
        this.TenTrangThai = TenTrangThai;
    }
    
}
