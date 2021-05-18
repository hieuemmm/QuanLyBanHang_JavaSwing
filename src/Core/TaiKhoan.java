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
public class TaiKhoan extends NhomNguoiDung{
    String TaiKhoan;
    String MatKhau;
    String Ten;

    public TaiKhoan() {
    }
    public TaiKhoan(String TaiKhoan, String MatKhau, String Ten) {
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
        this.Ten = Ten;
    }

    public TaiKhoan(String TaiKhoan, String MatKhau, String Ten, int MaNguoiDung, String TenNhomNguoiDung) {
        super(MaNguoiDung, TenNhomNguoiDung);
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
        this.Ten = Ten;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    @Override
    public int getMaNguoiDung() {
        return MaNguoiDung;
    }

    @Override
    public void setMaNguoiDung(int MaNguoiDung) {
        this.MaNguoiDung = MaNguoiDung;
    }

    @Override
    public String getTenNhomNguoiDung() {
        return TenNhomNguoiDung;
    }

    @Override
    public void setTenNhomNguoiDung(String TenNhomNguoiDung) {
        this.TenNhomNguoiDung = TenNhomNguoiDung;
    }
    
}
