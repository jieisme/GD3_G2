/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.NhanVien;
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
public class NhanVienDAO {

    ArrayList<NhanVien> list = new ArrayList<>();

    public List<NhanVien> getAll() throws SQLException {
        list = new ArrayList<>();
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "select * from NhanVien where TrangThaiXoa = 0";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("ID");
            String userName = rs.getString("Username");
            String matKhau = rs.getString("MatKhau");
            String hoVaTen = rs.getString("HoVaTen");
            int chucVu = rs.getInt("ChucVu");
            String soDienThoai = rs.getString("SoDienThoai");
            NhanVien nhanVien = new NhanVien(id, userName, matKhau, hoVaTen, chucVu, soDienThoai);
            list.add(nhanVien);
        }
        rs.close();
        st.close();
        conn.close();
        return list;
    }
    
    
     public String addData( String tenDangNhap, String matKhau, String hoVaTen, int chucVu, String soDienThoai) throws SQLException{
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "insert into  NHANVIEN(Username,MatKhau,HoVaTen,ChucVu,SoDienThoai,TrangThaiXoa) values (?,?,?,?,?,0);";
        PreparedStatement preSt = conn.prepareCall(sql);
     
        preSt.setString(1,tenDangNhap);
        preSt.setString(2, matKhau);
        preSt.setString(3, hoVaTen);
        preSt.setInt(4, chucVu);
        preSt.setString(5, soDienThoai);
        int rs = preSt.executeUpdate();
        preSt.close();
        conn.close();
        return "Thêm thành công!";
    }
     public String updateData(int id ,String tenDangNhap, String matKhau, String hoVaTen, int chucVu, String soDienThoai) throws SQLException{
         Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "update NhanVien set Username = ? , MatKhau = ?, HoVaTen  = ?, ChucVu = ?, SoDienThoai = ? where id = ?";
        PreparedStatement preSt = conn.prepareCall(sql);
        
        preSt.setString(1,tenDangNhap);
        preSt.setString(2, matKhau);
        preSt.setString(3, hoVaTen);
        preSt.setInt(4, chucVu);
        preSt.setString(5, soDienThoai);
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
     public String DeleteData(int id) throws SQLException{
         Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "update  NhanVien set TrangThaiXoa = 1 where ID = ?";
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
     public List<NhanVien> searchDataByID(int id) throws SQLException{
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "select * from NhanVien where ID = ?";
        PreparedStatement preSt = conn.prepareCall(sql);
        preSt.setInt(1, id);
        ResultSet rs = preSt.executeQuery();
        
        while (rs.next()) {            
            
            String userName = rs.getString("Username");
            String matKhau = rs.getString("MatKhau");
            String hoVaTen = rs.getString("HoVaTen");
            int chucVu = rs.getInt("ChucVu");
            String soDienThoai = rs.getString("SoDienThoai");
            NhanVien nhanVien = new NhanVien(id, userName, matKhau, hoVaTen, chucVu, soDienThoai);
            list.add(nhanVien);
        }
        rs.close();
        preSt.close();
        conn.close();
        return list;
    }
     public String forgotPassword(String username, String newPassword) throws SQLException{
         Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "update NhanVien set Username = ? , MatKhau = ?";
        PreparedStatement preSt = conn.prepareCall(sql);
        
        preSt.setString(1,username);
        preSt.setString(2, newPassword);

        // Execute the update query
        int rowsUpdated = preSt.executeUpdate();

        preSt.close();
        conn.close();

        if (rowsUpdated > 0) {
            return "Đổi mật khẩu thành công!";
        } else {
            return null;
        }
    }
     
    public String searchChucVu(String username) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "SELECT ChucVu FROM NHANVIEN WHERE USERNAME = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("ChucVu");
            }
        }
        return null;
    }
    
    public String changePassword(String username, String currentPassword, String newPassword) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "update NhanVien set MatKhau = ? WHERE MatKhau = ? AND Username = ?";
        PreparedStatement preSt = conn.prepareCall(sql);
        preSt.setString(1,newPassword);
        preSt.setString(2, currentPassword);
        preSt.setString(3,username);

        // Execute the update query
        int rowsUpdated = preSt.executeUpdate();

        preSt.close();
        conn.close();

        if (rowsUpdated > 0) {
            return "Đổi mật khẩu thành công!";
        } else {
            return "Sai mật khẩu hiện tại, vui lòng nhập lại!";
        }
    }
    
    public String searchHoVaTen(String username) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "SELECT HoVaTen FROM NHANVIEN WHERE USERNAME = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("HoVaTen");
            }
        }
        return null;
    }
    
    public String getTenNhanVien(int nhanVienID) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "SELECT HoVaTen FROM NhanVien WHERE ID = " + nhanVienID;
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            String tenNhanVien = rs.getString("HoVaTen");
            return tenNhanVien;
        }
        return null;
    }
}
