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
public class DanhMucSanPham {

    int MaDanhMuc;
    String TenDanhMuc;

    public DanhMucSanPham() {
    }

    public DanhMucSanPham(int MaDanhMuc) {
        this.MaDanhMuc = MaDanhMuc;
    }

    public DanhMucSanPham(String TenDanhMuc) {
        this.TenDanhMuc = TenDanhMuc;
    }

    public DanhMucSanPham(int MaDanhMuc, String TenDanhMuc) {
        this.MaDanhMuc = MaDanhMuc;
        this.TenDanhMuc = TenDanhMuc;
    }

    public DanhMucSanPham(DanhMucSanPham DMSP) {
        this.MaDanhMuc = DMSP.getMaDanhMuc();
        this.TenDanhMuc = DMSP.getTenDanhMuc();
    }

    public int getMaDanhMuc() {
        return MaDanhMuc;
    }

    public void setMaDanhMuc(int MaDanhMuc) {
        this.MaDanhMuc = MaDanhMuc;
    }

    public String getTenDanhMuc() {
        return TenDanhMuc;
    }

    public void setTenDanhMuc(String TenDanhMuc) {
        this.TenDanhMuc = TenDanhMuc;
    }

}
