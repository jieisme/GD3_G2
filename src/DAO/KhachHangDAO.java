/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utils.ConnnectToSQLServer;
import Entity.KhachHang;
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
public class KhachHangDAO {

    ArrayList<KhachHang> list = new ArrayList<>();

    public List<KhachHang> getAll() throws SQLException {
        list = new ArrayList<>();
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "SELECT * FROM KhachHang where TrangThaiXoa = 0;";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("ID");
            String HoTen = rs.getString("HoVaTen");
            String SDT = rs.getString("SoDienThoai");
            String DiaChi = rs.getString("DiaChi");
            int trangThaiXoa = rs.getInt("TrangThaiXoa");
            KhachHang khachHang = new KhachHang(id, HoTen, SDT, DiaChi, trangThaiXoa);
            list.add(khachHang);
        }
        rs.close();
        st.close();
        conn.close();
        return list;
    }

    public String addData(String HoTen, String SDT, String DiaChi) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "insert into  KhachHang(HoVaten,SoDienThoai,DiaChi,TrangThaiXoa) values (?,?,?,0);";
        PreparedStatement preSt = conn.prepareCall(sql);
        preSt.setString(1, HoTen);
        preSt.setString(2, SDT);
        preSt.setString(3, DiaChi);
        
        int rs = preSt.executeUpdate();
        preSt.close();
        conn.close();
        return "Thêm thành công!";
    }

    public String updateData(int id, String HoTen, String SDT, String DiaChi) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "update KhachHang set HoVaTen = ? , SoDienThoai = ?, DiaChi = ? where id = ?";
        PreparedStatement preSt = conn.prepareCall(sql);
        preSt.setString(1, HoTen);
        preSt.setString(2, SDT);
        preSt.setString(3, DiaChi);
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

    public String deleteData(int id) throws SQLException{
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "update KhachHang set TrangThaiXoa = 1 where ID = ?";
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

//    public List<KhachHang> searchDataByID(int id) throws SQLException{
//        Connection conn = ConnnectToSQLServer.getConnection();
//        String sql = "select * from KhachHang where ID = ?";
//        PreparedStatement preSt = conn.prepareCall(sql);
//        preSt.setInt(1, id);
//        ResultSet rs = preSt.executeQuery();
//        
//        while (rs.next()) {            
//            
//            String HoTen = rs.getString("HoVaTen");
//            String SDT = rs.getString("SoDienThoai");
//            String DiaChi = rs.getString("DiaChi");
//            KhachHang khachHang = new KhachHang(id, HoTen, SDT, DiaChi);
//            list.add(khachHang);
//        }
//        rs.close();
//        preSt.close();
//        conn.close();
//        return list;
//    }
    
    public String searchHoVaTen(String HoTen) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "SELECT HoVaTen FROM NhanVien WHERE USERNAME = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, HoTen);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("HoVaTen");
            }
        }
        return null;
    }
    
    public String getTenKhachHang(int khachHangID) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "SELECT HoVaten FROM KhachHang WHERE ID = " + khachHangID;
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            String hoVaTen = rs.getString("HoVaten");
            return hoVaTen;
        }
        return null;
    }
    
    public String getSDTKhachHang(int khachHangID) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "SELECT SoDienThoai FROM KhachHang WHERE ID = " + khachHangID;
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            String soDienThoai = rs.getString("SoDienThoai");
            return soDienThoai;
        }
        return null;
    }
    
    public int getIDBSoDienThoai(String soDienThoai) throws SQLException {
    Connection conn = ConnnectToSQLServer.getConnection();
    String sql = "SELECT id FROM KhachHang WHERE SoDienThoai = ?";
    
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, soDienThoai);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conn.close();
        }
        return 0;
    }
}
