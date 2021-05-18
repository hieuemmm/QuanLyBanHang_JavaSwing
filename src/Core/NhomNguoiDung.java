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

    int MaNhomNguoiDung;
    String TenNhomNguoiDung;

    public NhomNguoiDung() {
    }

    public NhomNguoiDung(NhomNguoiDung NND) {
        this.MaNhomNguoiDung = NND.getMaNhomNguoiDung();
        this.TenNhomNguoiDung = NND.getTenNhomNguoiDung();
    }

    public NhomNguoiDung(int MaNhomNguoiDung, String TenNhomNguoiDung) {
        this.MaNhomNguoiDung = MaNhomNguoiDung;
        this.TenNhomNguoiDung = TenNhomNguoiDung;
    }

    public int getMaNhomNguoiDung() {
        return MaNhomNguoiDung;
    }

    public void setMaNhomNguoiDung(int MaNhomNguoiDung) {
        this.MaNhomNguoiDung = MaNhomNguoiDung;
    }

    public String getTenNhomNguoiDung() {
        return TenNhomNguoiDung;
    }

    public void setTenNhomNguoiDung(String TenNhomNguoiDung) {
        this.TenNhomNguoiDung = TenNhomNguoiDung;
    }

}
