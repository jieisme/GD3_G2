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
}
