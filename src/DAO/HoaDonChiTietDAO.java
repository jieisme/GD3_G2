/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Entity.HoaDonChiTiet;
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
public class HoaDonChiTietDAO {
    private List<HoaDonChiTiet> list;
    
    public List<HoaDonChiTiet> getAll() throws SQLException {
        list = new ArrayList<>();
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "SELECT * FROM HoaDonChiTiet WHERE TrangThaiXoa = 0";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {            
            int id = rs.getInt("ID");
            int hoaDonID = rs.getInt("HoaDonId");
            int sanPhamChiTietID = rs.getInt("SanPhamChiTietId");
            int GiaBan = rs.getInt("GiaBan");
            int SoLuong = rs.getInt("SoLuong");
            int TrangThaiXoa = rs.getInt("TrangThaiXoa");
            
            list.add(new HoaDonChiTiet(id, hoaDonID, sanPhamChiTietID, GiaBan, SoLuong, TrangThaiXoa));
        }
        return list;
    }
}
