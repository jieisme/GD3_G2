/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author zudd4
 */
public class SanPhamChiTietVER2 {

    public SanPhamChiTietVER2() {
    }

    public SanPhamChiTietVER2(int id, SanPham sp, MauSac mau, ChatLieu cl, int kichThuocID, int DonGia, int soLuong, int trangThaiXoa) {
        this.id = id;
        this.sp = sp;
        this.mau = mau;
        this.cl = cl;
        this.kichThuocID = kichThuocID;
        this.DonGia = DonGia;
        this.soLuong = soLuong;
        this.trangThaiXoa = trangThaiXoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SanPham getSp() {
        return sp;
    }

    public void setSp(SanPham sp) {
        this.sp = sp;
    }

    public MauSac getMau() {
        return mau;
    }

    public void setMau(MauSac mau) {
        this.mau = mau;
    }

    public ChatLieu getCl() {
        return cl;
    }

    public void setCl(ChatLieu cl) {
        this.cl = cl;
    }

    public int getKichThuocID() {
        return kichThuocID;
    }

    public void setKichThuocID(int kichThuocID) {
        this.kichThuocID = kichThuocID;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTrangThaiXoa() {
        return trangThaiXoa;
    }

    public void setTrangThaiXoa(int trangThaiXoa) {
        this.trangThaiXoa = trangThaiXoa;
    }
     private int id;
    private SanPham sp;
    private MauSac mau;
    private ChatLieu cl;
    private int kichThuocID;
    private int DonGia;
    private int soLuong;
    private int trangThaiXoa;
}
