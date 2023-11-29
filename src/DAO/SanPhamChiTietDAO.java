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
 * @author Thuylq
 */
public class SanPhamChiTietDAO {

    private List<SanPhamChiTiet> list;

    public List<SanPhamChiTiet> getAll() throws SQLException {
        list = new ArrayList<>();
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "SELECT * FROM SANPHAMCHITIET where TrangThaiXoa = 0;";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("ID");
            int sanPhamId = rs.getInt("SanPhamID");
            int mauSacId = rs.getInt("MauSacID");
            int chatLieuId = rs.getInt("ChatLieuID");
            int kichThuoc = rs.getInt("KichThuoc");
            float donGia = rs.getFloat("DonGia");
            int soLuong = rs.getInt("soLuong");

            SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet(id, sanPhamId, mauSacId, chatLieuId, kichThuoc, id, soLuong, sanPhamId);
            list.add(sanPhamChiTiet);
        }
        rs.close();
        st.close();
        conn.close();
        return list;
    }

    public String addData(int id ,int sanPhamId, int mauSacId, int chatLieuId, int kichThuoc, float donGia, int soLuong) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "insert into SanPhamChiTiet\n"
                + "values (?, ?, ?, ?, ?, ?, ?,0)";
        PreparedStatement preSt = conn.prepareCall(sql);
        
        preSt.setInt(1, id);
        preSt.setInt(2, sanPhamId);
        preSt.setInt(3, mauSacId);
        preSt.setInt(4, chatLieuId);
        preSt.setInt(5, kichThuoc);
        preSt.setFloat(6, donGia);
        preSt.setInt(7, soLuong);

        int rs = preSt.executeUpdate();
        preSt.close();
        conn.close();
        return "Thêm thành công!";
    }

    public String updateData(int id, int sanPhamId, int mauSacId, int chatLieuId, int kichThuoc, float donGia, int soLuong) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "update SanPhamChiTiet set SanPhamID = ? ,MauSacID = ?,ChatLieuID = ?, KichThuoc = ?,DonGia = ?,SoLuong = ? where ID = ?";
        PreparedStatement preSt = conn.prepareCall(sql);
        preSt.setInt(1, sanPhamId);
        preSt.setInt(2, mauSacId);
        preSt.setInt(3, chatLieuId);
        preSt.setInt(4, kichThuoc);
        preSt.setFloat(5, donGia);
        preSt.setInt(6, soLuong);
        preSt.setInt(7, id);

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
    public String removeData(String id) throws SQLException {
         Connection conn = ConnnectToSQLServer.getConnection();
         String sql = "UPDATE [dbo].[SanPhamChiTiet]\n" +
                    "   SET [TrangThaiXoa] = 1\n" +
                    " WHERE ID = ?";
         PreparedStatement preSt = conn.prepareCall(sql);
         preSt.setString(1, id);
         int rs = preSt.executeUpdate();
         preSt.close();
         conn.close();
         return "Xóa thành công!";
     }
}
