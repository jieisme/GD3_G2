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

    private int ID;
    private int NhanVienID;
    private int KhachHangID;
    private int KhuyenMaiID;
    private int TongTienHang;
    private int TongTienDuocGiam;
    private int TongTienPhaiTra;
    private int Trangthai;
    private int TrangThaiXoa;

    public HoaDon(int ID, int NhanVienID, int KhachHangID, int KhuyenMaiID, int TongTienHang, int TongTienDuocGiam, int TongTienPhaiTra, int Trangthai, int TrangThaiXoa) {
        this.ID = ID;
        this.NhanVienID = NhanVienID;
        this.KhachHangID = KhachHangID;
        this.KhuyenMaiID = KhuyenMaiID;
        this.TongTienHang = TongTienHang;
        this.TongTienDuocGiam = TongTienDuocGiam;
        this.TongTienPhaiTra = TongTienPhaiTra;
        this.Trangthai = Trangthai;
        this.TrangThaiXoa = TrangThaiXoa;
    }

    public HoaDon() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNhanVienID() {
        return NhanVienID;
    }

    public void setNhanVienID(int NhanVienID) {
        this.NhanVienID = NhanVienID;
    }

    public int getKhachHangID() {
        return KhachHangID;
    }

    public void setKhachHangID(int KhachHangID) {
        this.KhachHangID = KhachHangID;
    }

    public int getKhuyenMaiID() {
        return KhuyenMaiID;
    }

    public void setKhuyenMaiID(int KhuyenMaiID) {
        this.KhuyenMaiID = KhuyenMaiID;
    }

    public int getTongTienHang() {
        return TongTienHang;
    }

    public void setTongTienHang(int TongTienHang) {
        this.TongTienHang = TongTienHang;
    }

    public int getTongTienDuocGiam() {
        return TongTienDuocGiam;
    }

    public void setTongTienDuocGiam(int TongTienDuocGiam) {
        this.TongTienDuocGiam = TongTienDuocGiam;
    }

    public int getTongTienPhaiTra() {
        return TongTienPhaiTra;
    }

    public void setTongTienPhaiTra(int TongTienPhaiTra) {
        this.TongTienPhaiTra = TongTienPhaiTra;
    }

    public int getTrangthai() {
        return Trangthai;
    }

    public void setTrangthai(int Trangthai) {
        this.Trangthai = Trangthai;
    }

    public int getTrangThaiXoa() {
        return TrangThaiXoa;
    }

    public void setTrangThaiXoa(int TrangThaiXoa) {
        this.TrangThaiXoa = TrangThaiXoa;
    }
}
