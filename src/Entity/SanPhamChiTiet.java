/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author zudd4
 */
public class SanPhamChiTiet {

    private int id;
    private int sanPhamID;
    private int mauSacID;
    private int chatLieuID;
    private int kichThuocID;
    private int DonGia;
    private int soLuong;
    private int trangThaiXoa;

    public SanPhamChiTiet(int id, int sanPhamID, int mauSacID, int chatLieuID, int kichThuocID, int DonGia, int soLuong, int trangThaiXoa) {
        this.id = id;
        this.sanPhamID = sanPhamID;
        this.mauSacID = mauSacID;
        this.chatLieuID = chatLieuID;
        this.kichThuocID = kichThuocID;
        this.DonGia = DonGia;
        this.soLuong = soLuong;
        this.trangThaiXoa = trangThaiXoa;
    }

    public SanPhamChiTiet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSanPhamID() {
        return sanPhamID;
    }

    public void setSanPhamID(int sanPhamID) {
        this.sanPhamID = sanPhamID;
    }

    public int getMauSacID() {
        return mauSacID;
    }

    public void setMauSacID(int mauSacID) {
        this.mauSacID = mauSacID;
    }

    public int getChatLieuID() {
        return chatLieuID;
    }

    public void setChatLieuID(int chatLieuID) {
        this.chatLieuID = chatLieuID;
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
    
    
}
