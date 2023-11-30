/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.HoaDon;
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
public class HoaDonDAO {
    private List<HoaDon> list;

    public List<HoaDon> getAll() throws SQLException {
        list = new ArrayList<>();
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "select * from HoaDon where TrangThaiXoa = 0";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {            
            int id = rs.getInt("ID");
            int nhanVienID = rs.getInt("NhanVienID");
            int khachHangID  = rs.getInt("KhachHangID");
            int KhuyenMaiID = rs.getInt("KhuyenMaiID");
            int TongTienHang = rs.getInt("TongTienHang");
            int TongTienDuocGiam = rs.getInt("TongTienDuocGiam");
            int TongTienPhaiTra = rs.getInt("TongTienPhaiTra");
            int Trangthai = rs.getInt("Trangthai");
            int TrangThaiXoa = rs.getInt("TrangThaiXoa");
            
            
            HoaDon hoadon = new HoaDon(id, nhanVienID, khachHangID, KhuyenMaiID, TongTienHang, TongTienDuocGiam, TongTienPhaiTra, Trangthai, TrangThaiXoa);
            list.add(hoadon);
        }
        rs.close();
        st.close();
        conn.close();
        return list;
    }
}
