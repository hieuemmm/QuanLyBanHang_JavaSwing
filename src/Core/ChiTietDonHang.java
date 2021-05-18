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
public class ChiTietDonHang extends SanPham{
    int ID;
    int SoLuongMua;

    public ChiTietDonHang() {
    }

    public ChiTietDonHang(int ID, int SoLuongMua) {
        this.ID = ID;
        this.SoLuongMua = SoLuongMua;
    }

    public ChiTietDonHang(int ID, int SoLuongMua, int MaSanPham, String TenSanPham, int SoLuong, int GiaMua, int GiaBan, String MoTa) {
        super(MaSanPham, TenSanPham, SoLuong, GiaMua, GiaBan, MoTa);
        this.ID = ID;
        this.SoLuongMua = SoLuongMua;
    }

    public ChiTietDonHang(int ID, int SoLuongMua, int MaSanPham, String TenSanPham, int SoLuong, int GiaMua, int GiaBan, String MoTa, int MaDanhMuc, String TenDanhMuc) {
        super(MaSanPham, TenSanPham, SoLuong, GiaMua, GiaBan, MoTa, MaDanhMuc, TenDanhMuc);
        this.ID = ID;
        this.SoLuongMua = SoLuongMua;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSoLuongMua() {
        return SoLuongMua;
    }

    public void setSoLuongMua(int SoLuongMua) {
        this.SoLuongMua = SoLuongMua;
    }

    @Override
    public int getMaSanPham() {
        return MaSanPham;
    }

    @Override
    public void setMaSanPham(int MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    @Override
    public String getTenSanPham() {
        return TenSanPham;
    }

    @Override
    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    @Override
    public int getSoLuong() {
        return SoLuong;
    }

    @Override
    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    @Override
    public int getGiaMua() {
        return GiaMua;
    }

    @Override
    public void setGiaMua(int GiaMua) {
        this.GiaMua = GiaMua;
    }

    @Override
    public int getGiaBan() {
        return GiaBan;
    }

    @Override
    public void setGiaBan(int GiaBan) {
        this.GiaBan = GiaBan;
    }

    @Override
    public String getMoTa() {
        return MoTa;
    }

    @Override
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
