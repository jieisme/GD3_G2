/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.SanPham;
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
public class SanPhamDAO {

    private List<SanPham> list;

    public List<SanPham> getAll() throws SQLException {
        list = new ArrayList<>();
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "SELECT [ID]\n" +
        "      ,[Ten]\n" +
        "      ,[DonViTinh]\n" +
        "      ,[MoTa]\n" +
        "      ,[LoaiSanPhamID]\n" +
        "      ,[TrangThaiBan]\n" +
        "  FROM [dbo].[SanPham] WHERE TRANGTHAIXOA = 0";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()) {            
            int id = rs.getInt("ID");
            String ten = rs.getString("TEN");
            String donViTinh = rs.getString("DonViTinh");
            String moTa = rs.getString("MoTa");
            int loaiSanPham = rs.getInt("LoaiSanPhamID");
            int trangThaiBan = rs.getInt("TrangThaiBan");
            SanPham sanPham = new SanPham(id, ten, donViTinh, moTa, loaiSanPham, trangThaiBan);
            list.add(sanPham);
        }
        rs.close();
        st.close();
        conn.close();
        return list;
    }
    
    public String addData(String ten, String donViTinh, String moTa, int loaiSanPham, int trangThaiBan) throws SQLException{
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "INSERT INTO [dbo].[SanPham]\n" +
                    "           [Ten]\n" +
                    "           ,[DonViTinh]\n" +
                    "           ,[MoTa]\n" +
                    "           ,[LoaiSanPhamID]\n" +
                    "           ,[TrangThaiBan])\n" +
                    "     VALUES\n" +
                    "           (?, ?, ?, ?, ?)";
        PreparedStatement preSt = conn.prepareCall(sql);
        preSt.setString(1, ten);
        preSt.setString(2, donViTinh);
        preSt.setString(3, moTa);
        preSt.setInt(4, loaiSanPham);
        preSt.setInt(5, trangThaiBan);
        int rs = preSt.executeUpdate();
        preSt.close();
        conn.close();
        return "Thêm thành công!";
    }
    
    public String updateData(int id, String ten, String donViTinh, String moTa, int loaiSanPham, int trangThaiBan) throws SQLException{
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "UPDATE [dbo].[SanPham]\n" +
                    "   SET [Ten] = ?\n" +
                    "      ,[DonViTinh] = ?\n" +
                    "      ,[MoTa] = ?\n" +
                    "      ,[LoaiSanPhamID] = ?\n" +
                    "      ,[TrangThaiBan] = ?\n" +
                    " WHERE ID = ?";
        PreparedStatement preSt = conn.prepareCall(sql);
        preSt.setString(1, ten);
        preSt.setString(2, donViTinh);
        preSt.setString(3, moTa);
        preSt.setInt(4, loaiSanPham);
        preSt.setInt(5, trangThaiBan);
        preSt.setInt(6, id);

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
    
    public String removeData(int id) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "UPDATE SANPHAM SET TRANGTHAIXOA = 1 WHERE ID = ?";
        PreparedStatement preSt = conn.prepareCall(sql);
        preSt.setInt(1, id);
        int rs = preSt.executeUpdate();
        return "Xóa thành công!";
    }
    
    public List<SanPham> searchDataByID(int id) throws SQLException{
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "SELECT [ID]\n" +
                    "      ,[Ten]\n" +
                    "      ,[DonViTinh]\n" +
                    "      ,[MoTa]\n" +
                    "      ,[LoaiSanPhamID]\n" +
                    "      ,[TrangThaiBan]\n" +
                    "  FROM [dbo].[SanPham]\n" +
                    "  WHERE ID = ?";
        PreparedStatement preSt = conn.prepareCall(sql);
        preSt.setInt(1, id);
        ResultSet rs = preSt.executeQuery();
        
        while (rs.next()) {            
            String ten = rs.getString("TEN");
            String donViTinh = rs.getString("DonViTinh");
            String moTa = rs.getString("MoTa");
            int loaiSanPham = rs.getInt("LoaiSanPhamID");
            int trangThaiBan = rs.getInt("TrangThaiBan");
            SanPham sanPham = new SanPham(id, ten, donViTinh, moTa, loaiSanPham, trangThaiBan);
            list.add(sanPham);
        }
        rs.close();
        preSt.close();
        conn.close();
        return list;
        
    }
    
    public String getTenSanPham(int sanPhamID) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "SELECT TEN FROM SANPHAM WHERE ID = " + sanPhamID;
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            String tenSanPham = rs.getString("TEN");
            return tenSanPham;
        }
        return null;
    }
}
