/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.ChatLieu;
import Entity.HoaDon;
import Entity.HoaDonChiTietVER2;
import Entity.MauSac;
import Entity.SanPham;
import Entity.SanPhamChiTietVER2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zudd4
 */
public class HoaDonChiTietDAO {
    private List<HoaDonChiTietVER2> listV2;

    public List<HoaDonChiTietVER2> getSPCTByHDID(int hoaDonID) throws SQLException {
        listV2 = new ArrayList<>();
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = """
                     SELECT HoaDonChiTiet.ID, SanPham.Ten, MauSac.Ten, SanPhamChiTiet.KichThuoc, HoaDonChiTiet.SoLuong, SanPhamChiTiet.DonGia
                     FROM HoaDonChiTiet
                          INNER JOIN SanPhamChiTiet ON HoaDonChiTiet.SanPhamChiTietId = SanPhamChiTiet.ID
                          INNER JOIN HoaDon ON HoaDonChiTiet.HoaDonId = HoaDon.ID
                          INNER JOIN MauSac ON SanPhamChiTiet.MauSacID = MauSac.ID
                          INNER JOIN SanPham ON SanPhamChiTiet.SanPhamID = SanPham.ID
                     WHERE HoaDon.ID = """ + hoaDonID;
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("ID");
            int GiaBan = rs.getInt("DonGia");
            int SoLuong = rs.getInt("SoLuong");
            SanPham sanPham = new SanPham(id, rs.getString(2), sql, sql, GiaBan, GiaBan);
            MauSac mauSac = new MauSac(id, rs.getString(3));
            ChatLieu chatLieu = new ChatLieu(id, sql);
            HoaDon hoaDon = new HoaDon(id, hoaDonID, hoaDonID, hoaDonID, GiaBan, SoLuong, GiaBan, GiaBan, GiaBan);
            SanPhamChiTietVER2 sanPhamChiTietVER2 = new SanPhamChiTietVER2(id, sanPham, mauSac, chatLieu, rs.getInt(4), GiaBan, SoLuong, GiaBan);
            listV2.add(new HoaDonChiTietVER2(rs.getInt(1), hoaDon, sanPhamChiTietVER2, rs.getInt(5)));
        }
        return listV2;
    }

    public String addData(int hoaDonID, int sanPhamChiTietID, int soLuong) throws SQLException {
        int rs;
        try (Connection conn = ConnnectToSQLServer.getConnection()) {
            String sql = """
                         INSERT INTO [dbo].[HoaDonChiTiet]
                                    ([HoaDonId]
                                    ,[SanPhamChiTietId]
                                    ,[SoLuong])
                              VALUES
                                    (?
                                    ,?
                                    ,?)""";
            try (PreparedStatement preSt = conn.prepareStatement(sql)) {
                preSt.setInt(1, hoaDonID);
                preSt.setInt(2, sanPhamChiTietID);
                preSt.setInt(3, soLuong);
                rs = preSt.executeUpdate();
            }
        }

        if (rs > 0) {
            return "Thêm thành công!";
        }
        return null;
    }

    public int getIDSPCTByHDCTID(int id) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "SELECT SanPhamChiTietId FROM HoaDonChiTiet WHERE ID = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    return rs.getInt("SanPhamChiTietId");
                }
            }
        }
        return 0;
    }

    public String removeData(int hoaDonChiTietID) throws SQLException {
        int rs;
        try (Connection conn = ConnnectToSQLServer.getConnection()) {
            String sql = """
                         DELETE FROM [dbo].[HoaDonChiTiet]
                               WHERE HoaDonChiTiet.ID = ?""";
            try (PreparedStatement preSt = conn.prepareCall(sql)) {
                preSt.setInt(1, hoaDonChiTietID);
                rs = preSt.executeUpdate();
            }
        }

        if (rs > 0) {
            return "Xóa thành công!";
        }
        return null;
    }
    
    public String updateSoLuong(int SoLuong, int hoaDonChiTietID) throws SQLException {
        int rs;
        try (Connection conn = ConnnectToSQLServer.getConnection()) {
            String sql = """
                         UPDATE [dbo].[HoaDonChiTiet] SET SoLuong = ?
                               WHERE HoaDonChiTiet.ID = ?""";
            try (PreparedStatement preSt = conn.prepareCall(sql)) {
                preSt.setInt(1, SoLuong);
                preSt.setInt(2, hoaDonChiTietID);
                rs = preSt.executeUpdate();
            }
        }

        if (rs > 0) {
            return "Cập nhật số lượng thành công!";
        }
        return null;
    }
}
