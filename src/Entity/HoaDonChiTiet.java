/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author zudd4
 */
public class HoaDonChiTiet {

    private int id;
    private int hoaDonID;
    private int sanPhamChiTietID;
    private int giaBan;
    private int soLuong;
    private int trangThaiXoa;

    public HoaDonChiTiet(int id, int hoaDonID, int sanPhamChiTietID, int giaBan, int soLuong, int trangThaiXoa) {
        this.id = id;
        this.hoaDonID = hoaDonID;
        this.sanPhamChiTietID = sanPhamChiTietID;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
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

    public int getHoaDonID() {
        return hoaDonID;
    }

    public void setHoaDonID(int hoaDonID) {
        this.hoaDonID = hoaDonID;
    }

    public int getSanPhamChiTietID() {
        return sanPhamChiTietID;
    }

    public void setSanPhamChiTietID(int sanPhamChiTietID) {
        this.sanPhamChiTietID = sanPhamChiTietID;
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

    public int getTrangThaiXoa() {
        return trangThaiXoa;
    }

    public void setTrangThaiXoa(int trangThaiXoa) {
        this.trangThaiXoa = trangThaiXoa;
    }
}
