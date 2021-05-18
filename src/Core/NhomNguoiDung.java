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
public class NhomNguoiDung {

    int MaNguoiDung;
    String TenNhomNguoiDung;

    public NhomNguoiDung() {
    }

    public NhomNguoiDung(int MaNguoiDung, String TenNhomNguoiDung) {
        this.MaNguoiDung = MaNguoiDung;
        this.TenNhomNguoiDung = TenNhomNguoiDung;
    }

    public int getMaNguoiDung() {
        return MaNguoiDung;
    }

    public void setMaNguoiDung(int MaNguoiDung) {
        this.MaNguoiDung = MaNguoiDung;
    }

    public String getTenNhomNguoiDung() {
        return TenNhomNguoiDung;
    }

    public void setTenNhomNguoiDung(String TenNhomNguoiDung) {
        this.TenNhomNguoiDung = TenNhomNguoiDung;
    }

}
