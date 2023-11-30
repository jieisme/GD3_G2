/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Thuylq
 */
public class HoaDon {

    private int id;
    private int nhanVienID;
    private int khachHangID;
    private int khuyenMaiID;
    private int tongTienHang;
    private int tongTienDuocGiam;
    private int tongTienPhaiTra;
    private int trangthai;
    private int trangThaiXoa;

    public HoaDon() {
    }

    public HoaDon(int id, int nhanVienID, int khachHangID, int khuyenMaiID, int tongTienHang, int tongTienDuocGiam, int tongTienPhaiTra, int trangthai, int trangThaiXoa) {
        this.id = id;
        this.nhanVienID = nhanVienID;
        this.khachHangID = khachHangID;
        this.khuyenMaiID = khuyenMaiID;
        this.tongTienHang = tongTienHang;
        this.tongTienDuocGiam = tongTienDuocGiam;
        this.tongTienPhaiTra = tongTienPhaiTra;
        this.trangthai = trangthai;
        this.trangThaiXoa = trangThaiXoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNhanVienID() {
        return nhanVienID;
    }

    public void setNhanVienID(int nhanVienID) {
        this.nhanVienID = nhanVienID;
    }

    public int getKhachHangID() {
        return khachHangID;
    }

    public void setKhachHangID(int khachHangID) {
        this.khachHangID = khachHangID;
    }

    public int getKhuyenMaiID() {
        return khuyenMaiID;
    }

    public void setKhuyenMaiID(int khuyenMaiID) {
        this.khuyenMaiID = khuyenMaiID;
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

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public int getTrangThaiXoa() {
        return trangThaiXoa;
    }

    public void setTrangThaiXoa(int trangThaiXoa) {
        this.trangThaiXoa = trangThaiXoa;
    }
}
