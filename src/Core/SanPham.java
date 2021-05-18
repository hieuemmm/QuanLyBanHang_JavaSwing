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
public class SanPham extends danhmucsanpham{
    int MaSanPham;
    String TenSanPham;
    int SoLuong;
    int GiaMua;
    int GiaBan;
    String MoTa;

    public SanPham() {
    }

    public SanPham(int MaSanPham, String TenSanPham, int SoLuong, int GiaMua, int GiaBan, String MoTa) {
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.SoLuong = SoLuong;
        this.GiaMua = GiaMua;
        this.GiaBan = GiaBan;
        this.MoTa = MoTa;
    }

    public SanPham(int MaSanPham, String TenSanPham, int SoLuong, int GiaMua, int GiaBan, String MoTa, int MaDanhMuc, String TenDanhMuc) {
        super(MaDanhMuc, TenDanhMuc);
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.SoLuong = SoLuong;
        this.GiaMua = GiaMua;
        this.GiaBan = GiaBan;
        this.MoTa = MoTa;
    }

    public int getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(int MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getGiaMua() {
        return GiaMua;
    }

    public void setGiaMua(int GiaMua) {
        this.GiaMua = GiaMua;
    }

    public int getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(int GiaBan) {
        this.GiaBan = GiaBan;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    @Override
    public int getMaDanhMuc() {
        return MaDanhMuc;
    }

    @Override
    public void setMaDanhMuc(int MaDanhMuc) {
        this.MaDanhMuc = MaDanhMuc;
    }

    @Override
    public String getTenDanhMuc() {
        return TenDanhMuc;
    }

    @Override
    public void setTenDanhMuc(String TenDanhMuc) {
        this.TenDanhMuc = TenDanhMuc;
    }
    
}
