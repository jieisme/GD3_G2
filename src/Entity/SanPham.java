/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author zudd4
 */
public class SanPham {

    private int id;
    private String ten;
    private String donViTinh;
    private String moTa;
    private int loaiSanPham;
    private int trangThaiBan;

    public SanPham(int id, String ten, String donViTinh, String moTa, int loaiSanPham, int trangThaiBan) {
        this.id = id;
        this.ten = ten;
        this.donViTinh = donViTinh;
        this.moTa = moTa;
        this.loaiSanPham = loaiSanPham;
        this.trangThaiBan = trangThaiBan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(int loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public int getTrangThaiBan() {
        return trangThaiBan;
    }

    public void setTrangThaiBan(int trangThaiBan) {
        this.trangThaiBan = trangThaiBan;
    }

    public SanPham() {
    }
}
