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
        String sql = "select * from HoaDon";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()) {            
            int id = rs.getInt("ID");
            int nhanVienID = rs.getInt("NhanVienID");
            int khachHangID  = rs.getInt("KhachHangID");
            int trangThai = rs.getInt("Trangthai");
            
            HoaDon hoadon = new HoaDon(id, nhanVienID, khachHangID, trangThai);
            list.add(hoadon);
        }
        rs.close();
        st.close();
        conn.close();
        return list;
    }
    public String addData(int id , int nhanVienId ,int khachHangID , int trangThai ) throws SQLException{
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "insert into HoaDon values (?,?,?,?);";
        PreparedStatement preSt = conn.prepareCall(sql);
        preSt.setInt(1, id);
        preSt.setInt(2, nhanVienId);
        preSt.setInt(3, khachHangID);
        preSt.setInt(4, trangThai);
        int rs = preSt.executeUpdate();
        preSt.close();
        conn.close();
        return "Thêm thành công!";
    }
     public String updateData(int id, int nhanVienID, int khachHangID, int trangThai) throws SQLException{
         Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "update HoaDon set NhanVienId = ? , KhachHangID = ?, TrangThai = ? where ID = ?";
        PreparedStatement preSt = conn.prepareCall(sql);
        preSt.setInt(1, nhanVienID);
        preSt.setInt(2, khachHangID);
        preSt.setInt(3, trangThai);
        preSt.setInt(4, id);


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
      public List<HoaDon> searchDataByID(int id) throws SQLException{
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "select * from HoaDon where id = ? ";
        PreparedStatement preSt = conn.prepareCall(sql);
        preSt.setInt(1, id);
        ResultSet rs = preSt.executeQuery();
        
        while (rs.next()) {            
            int nhanVienID = rs.getInt("NhanVienID");
            int khachHangID = rs.getInt("KhachHangID");
            int trangThai = rs.getInt("TrangThai");
            
            HoaDon hoaDon = new HoaDon(id, nhanVienID, khachHangID, trangThai);
            list.add(hoaDon);
        }
        rs.close();
        preSt.close();
        conn.close();
        return list;
        
    }
       public List<HoaDon> searchDataByNhanVienID(int nhanVienID) throws SQLException{
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "select * from HoaDon where NhanVienID = ? ";
        PreparedStatement preSt = conn.prepareCall(sql);
        preSt.setInt(1, nhanVienID);
        ResultSet rs = preSt.executeQuery();
        
        while (rs.next()) {            
            int id = rs.getInt("ID");
            int khachHangID = rs.getInt("KhachHangID");
            int trangThai = rs.getInt("TrangThai");
            
            HoaDon hoaDon = new HoaDon(id, nhanVienID, khachHangID, trangThai);
            list.add(hoaDon);
        }
        rs.close();
        preSt.close();
        conn.close();
        return list;
        
    }
       public List<HoaDon> searchDataByKhachHangID(int khachHangID) throws SQLException{
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "select * from HoaDon where NhanVienID = ? ";
        PreparedStatement preSt = conn.prepareCall(sql);
        preSt.setInt(1, khachHangID);
        ResultSet rs = preSt.executeQuery();
        
        while (rs.next()) {            
            int id = rs.getInt("ID");
            int nhanVienID = rs.getInt("NhanVienID");
            int trangThai = rs.getInt("TrangThai");
            
            HoaDon hoaDon = new HoaDon(id, nhanVienID, khachHangID, trangThai);
            list.add(hoaDon);
        }
        rs.close();
        preSt.close();
        conn.close();
        return list;
        
    }
}
