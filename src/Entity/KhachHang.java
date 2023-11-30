/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author zudd4
 */
public class KhachHang {

    private int id;
    private String hoVaTen;
    private String soDienThoai;
    private String diaChi;
    private int trangThaiXoa;

    public KhachHang() {
    }

    public KhachHang(int id, String hoVaTen, String soDienThoai, String diaChi, int trangThaiXoa) {
        this.id = id;
        this.hoVaTen = hoVaTen;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.trangThaiXoa = trangThaiXoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getTrangThaiXoa() {
        return trangThaiXoa;
    }

    public void setTrangThaiXoa(int trangThaiXoa) {
        this.trangThaiXoa = trangThaiXoa;
    }
}
