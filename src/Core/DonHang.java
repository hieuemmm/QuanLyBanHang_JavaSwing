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
public class DonHang extends TrangThaiDonHang{
    int MaDonHang;
    String SDT;
    String DiaChiNhanHang;
    String NgayTao;

    public DonHang() {
    }

    public DonHang(int MaDonHang, String SDT, String DiaChiNhanHang, String NgayTao) {
        this.MaDonHang = MaDonHang;
        this.SDT = SDT;
        this.DiaChiNhanHang = DiaChiNhanHang;
        this.NgayTao = NgayTao;
    }

    public DonHang(int MaDonHang, String SDT, String DiaChiNhanHang, String NgayTao, int MaTrangThai, String TenTrangThai) {
        super(MaTrangThai, TenTrangThai);
        this.MaDonHang = MaDonHang;
        this.SDT = SDT;
        this.DiaChiNhanHang = DiaChiNhanHang;
        this.NgayTao = NgayTao;
    }

    public int getMaDonHang() {
        return MaDonHang;
    }

    public void setMaDonHang(int MaDonHang) {
        this.MaDonHang = MaDonHang;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChiNhanHang() {
        return DiaChiNhanHang;
    }

    public void setDiaChiNhanHang(String DiaChiNhanHang) {
        this.DiaChiNhanHang = DiaChiNhanHang;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    @Override
    public int getMaTrangThai() {
        return MaTrangThai;
    }

    @Override
    public void setMaTrangThai(int MaTrangThai) {
        this.MaTrangThai = MaTrangThai;
    }

    @Override
    public String getTenTrangThai() {
        return TenTrangThai;
    }

    @Override
    public void setTenTrangThai(String TenTrangThai) {
        this.TenTrangThai = TenTrangThai;
    }
}
