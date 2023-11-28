/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.SanPhamChiTiet;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

/**
 *
 * @author zudd4
 */
public class SanPhamChiTietDAO {
    private List<SanPhamChiTiet> list;
    
    public List<SanPhamChiTiet> getAll() throws SQLException{
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "SELECT SanPhamChiTiet.ID, SanPham.Ten, MauSac.Ten, SanPhamChiTiet.KichThuoc, SanPhamChiTiet.DonGia, SanPhamChiTiet.SoLuong\n" +
                    "FROM SanPhamChiTiet\n" +
                    "JOIN MauSac ON MauSac.ID = SanPhamChiTiet.MauSacID\n" +
                    "JOIN SanPham ON SanPham.ID = SanPhamChiTiet.SanPhamID WHERE SanPhamChiTiet.TrangThaiXoa = 0";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()) {            
            int id = rs.getInt("SanPhamChiTiet.ID");
            String ten = rs.getString("SanPham.Ten");
            String mauSac = rs.getString("MauSac.Ten");
            String kichThuoc = rs.getString("SanPhamChiTiet.KichThuoc");
            int donGia = rs.getInt("SanPhamChiTiet.DonGia");
            int soLuong = rs.getInt("SanPhamChiTiet.SoLuong");
        }
    }
}
