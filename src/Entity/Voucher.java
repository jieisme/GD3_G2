/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Admin
 */
public class Voucher {
    private int id;
    private int LoaiKhuyenMai;
    private int GiamTheoPhanTram;
    private int GiamtheoGiaTien;
    private int SoLuong;
    private String ThoiGianBatDau;
    private String ThoiGianKetThuc;
    private int TrangThai;
    private String MoTa;

    public Voucher() {
    }

    public Voucher(int id, int LoaiKhuyenMai, int GiamTheoPhanTram, int GiamtheoGiaTien, int SoLuong, String ThoiGianBatDau, String ThoiGianKetThuc, int TrangThai, String MoTa) {
        this.id = id;
        this.LoaiKhuyenMai = LoaiKhuyenMai;
        this.GiamTheoPhanTram = GiamTheoPhanTram;
        this.GiamtheoGiaTien = GiamtheoGiaTien;
        this.SoLuong = SoLuong;
        this.ThoiGianBatDau = ThoiGianBatDau;
        this.ThoiGianKetThuc = ThoiGianKetThuc;
        this.TrangThai = TrangThai;
        this.MoTa = MoTa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLoaiKhuyenMai() {
        return LoaiKhuyenMai;
    }

    public void setLoaiKhuyenMai(int LoaiKhuyenMai) {
        this.LoaiKhuyenMai = LoaiKhuyenMai;
    }

    public int getGiamTheoPhanTram() {
        return GiamTheoPhanTram;
    }

    public void setGiamTheoPhanTram(int GiamTheoPhanTram) {
        this.GiamTheoPhanTram = GiamTheoPhanTram;
    }

    public int getGiamtheoGiaTien() {
        return GiamtheoGiaTien;
    }

    public void setGiamtheoGiaTien(int GiamtheoGiaTien) {
        this.GiamtheoGiaTien = GiamtheoGiaTien;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getThoiGianBatDau() {
        return ThoiGianBatDau;
    }

    public void setThoiGianBatDau(String ThoiGianBatDau) {
        this.ThoiGianBatDau = ThoiGianBatDau;
    }

    public String getThoiGianKetThuc() {
        return ThoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String ThoiGianKetThuc) {
        this.ThoiGianKetThuc = ThoiGianKetThuc;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
 
}