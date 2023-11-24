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
        String sql = "select * from NhanVien";
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
    
    
     public String addData(int id, String tenDangNhap, String matKhau, String hoVaTen, int chucVu, String soDienThoai) throws SQLException{
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "insert into NhanVien values (?,?,?,?,?,?);";
        PreparedStatement preSt = conn.prepareCall(sql);
        preSt.setInt(1, id);
        preSt.setString(2,tenDangNhap);
        preSt.setString(3, matKhau);
        preSt.setString(4, hoVaTen);
        preSt.setInt(5, chucVu);
        preSt.setString(6, soDienThoai);
        int rs = preSt.executeUpdate();
        preSt.close();
        conn.close();
        return "Thêm thành công!";
    }
     public String updateData(int id, String tenDangNhap, String matKhau, String hoVaTen, int chucVu, String soDienThoai) throws SQLException{
         Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "update NhanVien set Username = ? , MatKhau = ?, HoVaTen  = ?, ChucVu = ?, SoDienThoai = ? where ID = ?";
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
        String sql = "Delete NhanVien where ID = ?";
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
     
}
