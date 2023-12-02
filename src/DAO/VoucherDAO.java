/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Voucher;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

/**
 *
 * @author Thuylq
 */
public class VoucherDAO {

    private List<Voucher> list;

    public List<Voucher> getAll() throws SQLException {
        list = new ArrayList<>();
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "select * from KhuyenMai where TrangThaiXoa = 0";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("ID");
            int LoaiKhuyenMai = rs.getInt("LoaiKhuyenMai");
            int GiamTheoPhanTram = rs.getInt("GiamTheoPhamTram");
            int GiamTheoGiaTien = rs.getInt("GiamTheoGiaTien");
            int SoLuong = rs.getInt("SoLuong");
            String ThoiGianBatDau = rs.getString("ThoigianBatDau");
            String ThoiGianKetThuc = rs.getString("ThoiGianKetThuc");
            int trangThai = rs.getInt("Trangthai");
            String MoTa = rs.getString("MoTa");
            Voucher voucher = new Voucher(id, LoaiKhuyenMai, GiamTheoPhanTram, GiamTheoGiaTien, SoLuong, ThoiGianBatDau, ThoiGianKetThuc, trangThai, MoTa);
            list.add(voucher);
        }
        rs.close();
        st.close();
        conn.close();
        return list;
    }

    public String addData(int LoaiKhuyenMai, int GiamTheoPhanTram, int GiamTheoGiaTien, int SoLuong, String ThoiGianBatDau, String ThoiGianKetThuc, int TrangThai, String MoTa) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "insert into KhuyenMai(LoaiKhuyenMai,GiamTheoPhanTram,GiamTheoGiaTien,SoLuong,ThoiGianBatDau,ThoiGianKetThuc,TrangThai,MoTa,TrangThaiXoa) values (?,?,?,?,?,?,?,?,0);";
        PreparedStatement preSt = conn.prepareCall(sql);

        preSt.setInt(1, LoaiKhuyenMai);
        preSt.setInt(2, GiamTheoPhanTram);
        preSt.setInt(3, GiamTheoGiaTien);
        preSt.setInt(4, SoLuong);
        preSt.setString(5, ThoiGianBatDau);
        preSt.setString(6, ThoiGianKetThuc);
        preSt.setInt(7, TrangThai);
        preSt.setString(8, MoTa);
        int rs = preSt.executeUpdate();
        preSt.close();
        conn.close();
        return "Thêm thành công!";
    }

    public String updateData(int id, int LoaiKhuyenMai, int GiamTheoPhanTram, int GiamTheoGiaTien, int SoLuong, String ThoiGianBatDau, String ThoiGianKetThuc, int TrangThai, String MoTa) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "update KhuyenMai set LoaiKhuyenMai = ? , GiamtheoPhanTram=?, GiamTheoGiaTien=?, SoLuong = ?, ThoiGianBatDau  = ?, ThoiGianKetThuc = ?, TrangThai = ?,Mota=? where id=?";
        PreparedStatement preSt = conn.prepareCall(sql);

        preSt.setInt(1, LoaiKhuyenMai);
        preSt.setInt(2, GiamTheoPhanTram);
        preSt.setInt(3, GiamTheoGiaTien);
        preSt.setInt(4, SoLuong);
        preSt.setString(5, ThoiGianBatDau);
        preSt.setString(6, ThoiGianKetThuc);
        preSt.setInt(7, TrangThai);
        preSt.setString(8, MoTa);
        preSt.setInt(9, id);
        // Execute the update query
        int rowsUpdated = preSt.executeUpdate();

        preSt.close();
        conn.close();

        if (rowsUpdated > 0) {
            return "Sửa thành công!";
        } else {
            return "Không có sản phẩm nào được sửa!";
        }
    }

    public List<Voucher> searchDataByID(int id) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "select * from KhuyenMai where id = ? ";
        PreparedStatement preSt = conn.prepareCall(sql);
        preSt.setInt(1, id);
        ResultSet rs = preSt.executeQuery();

        while (rs.next()) {
            int LoaiKhuyenMai = rs.getInt("LoaiKhuyenMai");
            int SoLuong = rs.getInt("Soluong");
            String ThoiGianBatDau = rs.getString("ThoiGianBatDau");
            String ThoiGianKetThuc = rs.getString("ThoiGianKetThuc");
            int TrangThai = rs.getInt("TrangThai");
            String MoTa = rs.getString("MoTa");

            Voucher voucher = new Voucher(id, LoaiKhuyenMai, TrangThai, TrangThai, SoLuong, ThoiGianBatDau, ThoiGianKetThuc, TrangThai, MoTa);
            list.add(voucher);
        }
        rs.close();
        preSt.close();
        conn.close();
        return list;

    }

    public String DeleteData(int id) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "update  KhuyenMai set TrangThaiXoa = 1 where ID = ?";
        PreparedStatement preSt = conn.prepareCall(sql);

        preSt.setInt(1, id);

        // Execute the update query
        int rowsUpdated = preSt.executeUpdate();

        preSt.close();
        conn.close();

        if (rowsUpdated > 0) {
            return "Xóa thành công!";
        } else {
            return "Không có nhân viên để xóa";
        }
    }

    public double giamTheoPhanTram(int id) throws SQLException {
        try (Connection conn = ConnnectToSQLServer.getConnection(); 
            PreparedStatement ps = conn.prepareStatement("SELECT GiamTheoPhanTram FROM KhuyenMai WHERE ID = ?");) {
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("GiamTheoPhanTram") / 100;
                }
            }
        }
        return 0;
    }

    public int giamTheoGiaTien(int id) throws SQLException {
        try (Connection conn = ConnnectToSQLServer.getConnection(); 
            PreparedStatement ps = conn.prepareStatement("SELECT GiamTheoGiaTien FROM KhuyenMai WHERE ID = ?");) {
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("GiamTheoGiaTien");
                }
            }
        }
        return 0;
    }
    
    public String getMoTaVoucher(int voucherID) throws SQLException {
        try (Connection conn = ConnnectToSQLServer.getConnection(); 
            PreparedStatement ps = conn.prepareStatement("SELECT MoTa FROM KhuyenMai WHERE ID = ?");) {
            ps.setInt(1, voucherID);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("MoTa");
                }
            }
        }
        return null;
    }
}
