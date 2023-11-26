/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Thuylq
 */
public class NhanVien {

    private int ID;
    private String UserName;
    private String MatKhau;
    private String HoTen;
    private int ChucVu;
    private String SoDienThoai;

    public NhanVien(int ID, String UserName, String MatKhau, String HoTen, int ChucVu, String SoDienThoai) {
        this.ID = ID;
        this.UserName = UserName;
        this.MatKhau = MatKhau;
        this.HoTen = HoTen;
        this.ChucVu = ChucVu;
        this.SoDienThoai = SoDienThoai;
    }

    public NhanVien() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public int getChucVu() {
        return ChucVu;
    }

    public void setChucVu(int ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "ID=" + ID + ", UserName=" + UserName + ", MatKhau=" + MatKhau + ", HoTen=" + HoTen + ", ChucVu=" + ChucVu + ", SoDienThoai=" + SoDienThoai + '}';
    }

}
