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
    private int ID ;
    private int NhanVienID ;
    private int KhachHangID ;
    private int TrangThaiHoaDon;

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

    public int getTrangThaiHoaDon() {
        return TrangThaiHoaDon;
    }

    public void setTrangThaiHoaDon(int TrangThaiHoaDon) {
        this.TrangThaiHoaDon = TrangThaiHoaDon;
    }

    public HoaDon() {
    }

    public HoaDon(int ID, int NhanVienID, int KhachHangID, int TrangThaiHoaDon) {
        this.ID = ID;
        this.NhanVienID = NhanVienID;
        this.KhachHangID = KhachHangID;
        this.TrangThaiHoaDon = TrangThaiHoaDon;
    }
    
}
