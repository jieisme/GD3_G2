/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.text.DecimalFormat;

/**
 *
 * @author zudd4
 */
public class HoaDonChiTietVER2 {
    private DecimalFormat decimalFormat = new DecimalFormat("#,###");
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HoaDon getHd() {
        return hd;
    }

    public void setHd(HoaDon hd) {
        this.hd = hd;
    }

    public SanPhamChiTietVER2 getSpct() {
        return spct;
    }

    public void setSpct(SanPhamChiTietVER2 spct) {
        this.spct = spct;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    private int id;
    private HoaDon hd;
    private SanPhamChiTietVER2 spct;
    private int soluong;

    public HoaDonChiTietVER2() {
    }

    public HoaDonChiTietVER2(int id, HoaDon hd, SanPhamChiTietVER2 spct, int soluong) {
        this.id = id;
        this.hd = hd;
        this.spct = spct;
        this.soluong = soluong;
    }
    
    public Object[] toDatarow(){
       return new Object[]{
           id, spct.getSp().getTen(), spct.getMau().getTen(), getKichThuoc(spct.getKichThuocID()), decimalFormat.format(spct.getDonGia()) + " VNĐ", soluong
       };
    }
   
    private String getKichThuoc(int kichThuocID) {
        switch (kichThuocID) {
            case 0:
                return "X";
            case 1:
                return "S";
            case 2:
                return "M";
            case 3:
                return "L";
            default:
                return "";
        }
    }
}
