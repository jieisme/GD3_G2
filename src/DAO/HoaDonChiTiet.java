/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author zudd4
 */
public class HoaDonChiTiet {

    private int id;
    private int hoadonID;
    private int sanPhamChiTietID;
    private int khuyenMaiID;
    private int giaBan;
    private int soLuong;
    private int tongTienHang;
    private int tongTienDuocGiam;
    private int tongTienPhaiTra;
    private int trangThaiXoa;

    public HoaDonChiTiet(int id, int hoadonID, int sanPhamChiTietID, int khuyenMaiID, int giaBan, int soLuong, int tongTienHang, int tongTienDuocGiam, int tongTienPhaiTra, int trangThaiXoa) {
        this.id = id;
        this.hoadonID = hoadonID;
        this.sanPhamChiTietID = sanPhamChiTietID;
        this.khuyenMaiID = khuyenMaiID;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.tongTienHang = tongTienHang;
        this.tongTienDuocGiam = tongTienDuocGiam;
        this.tongTienPhaiTra = tongTienPhaiTra;
        this.trangThaiXoa = trangThaiXoa;
    }

    public HoaDonChiTiet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHoadonID() {
        return hoadonID;
    }

    public void setHoadonID(int hoadonID) {
        this.hoadonID = hoadonID;
    }

    public int getSanPhamChiTietID() {
        return sanPhamChiTietID;
    }

    public void setSanPhamChiTietID(int sanPhamChiTietID) {
        this.sanPhamChiTietID = sanPhamChiTietID;
    }

    public int getKhuyenMaiID() {
        return khuyenMaiID;
    }

    public void setKhuyenMaiID(int khuyenMaiID) {
        this.khuyenMaiID = khuyenMaiID;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTongTienHang() {
        return tongTienHang;
    }

    public void setTongTienHang(int tongTienHang) {
        this.tongTienHang = tongTienHang;
    }

    public int getTongTienDuocGiam() {
        return tongTienDuocGiam;
    }

    public void setTongTienDuocGiam(int tongTienDuocGiam) {
        this.tongTienDuocGiam = tongTienDuocGiam;
    }

    public int getTongTienPhaiTra() {
        return tongTienPhaiTra;
    }

    public void setTongTienPhaiTra(int tongTienPhaiTra) {
        this.tongTienPhaiTra = tongTienPhaiTra;
    }

    public int getTrangThaiXoa() {
        return trangThaiXoa;
    }

    public void setTrangThaiXoa(int trangThaiXoa) {
        this.trangThaiXoa = trangThaiXoa;
    }
}
