package Entity;

import java.util.Vector;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Thuylq
 */
public class SanPhamChiTietV3 {
    private int id;
    private String tenSp;
    private String mauSac;
    private String kichThuoc;
    private String donGia;
    private int soLuong;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getDonGia() {
        return donGia;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public SanPhamChiTietV3(int id, String tenSp, String mauSac, String kichThuoc, String donGia, int soLuong) {
        this.id = id;
        this.tenSp = tenSp;
        this.mauSac = mauSac;
        this.kichThuoc = kichThuoc;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public SanPhamChiTietV3() {
    }

    public Object[] toDatarow() {
        return new Object[] {this.id, this.tenSp, this.mauSac, this.kichThuoc, this.donGia, this.soLuong};
    }
}
