/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utils.ConnnectToSQLServer;
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
            int donGia = rs.getInt("DonGia");
            int soLuong = rs.getInt("soLuong");

            SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet(id, sanPhamId, mauSacId, chatLieuId, kichThuoc, donGia, soLuong, sanPhamId);
            list.add(sanPhamChiTiet);
        }
        rs.close();
        st.close();
        conn.close();
        return list;
    }
    
    public List<SanPhamChiTiet> getAllbySanPhamID(int sanPhamID) throws SQLException {
        list = new ArrayList<>();
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "SELECT * FROM SANPHAMCHITIET where TrangThaiXoa = 0 AND SanPhamID = " + sanPhamID;
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("ID");
            int sanPhamId = rs.getInt("SanPhamID");
            int mauSacId = rs.getInt("MauSacID");
            int chatLieuId = rs.getInt("ChatLieuID");
            int kichThuoc = rs.getInt("KichThuoc");
            int donGia = rs.getInt("DonGia");
            int soLuong = rs.getInt("soLuong");

            SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet(id, sanPhamId, mauSacId, chatLieuId, kichThuoc, donGia, soLuong, sanPhamId);
            list.add(sanPhamChiTiet);
        }
        rs.close();
        st.close();
        conn.close();
        return list;
    }

    public List<SanPhamChiTiet> getAllDuDieuKien() throws SQLException {
        list = new ArrayList<>();
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "SELECT * FROM SANPHAMCHITIET where TrangThaiXoa = 0 AND SoLuong > 0;";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("ID");
            int sanPhamId = rs.getInt("SanPhamID");
            int mauSacId = rs.getInt("MauSacID");
            int chatLieuId = rs.getInt("ChatLieuID");
            int kichThuoc = rs.getInt("KichThuoc");
            int donGia = rs.getInt("DonGia");
            int soLuong = rs.getInt("soLuong");

            SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet(id, sanPhamId, mauSacId, chatLieuId, kichThuoc, donGia, soLuong, sanPhamId);
            list.add(sanPhamChiTiet);
        }
        rs.close();
        st.close();
        conn.close();
        return list;
    }

    public String addData(int sanPhamId, int mauSacId, int chatLieuId, int kichThuoc, int donGia, int soLuong) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "insert into SanPhamChiTiet\n"
                + "values ( ?, ?, ?, ?, ?, ?,0)";
        PreparedStatement preSt = conn.prepareCall(sql);

        preSt.setInt(1, sanPhamId);
        preSt.setInt(2, mauSacId);
        preSt.setInt(3, chatLieuId);
        preSt.setInt(4, kichThuoc);
        preSt.setInt(5, donGia);
        preSt.setInt(6, soLuong);

        int rs = preSt.executeUpdate();
        preSt.close();
        conn.close();
        return "Thêm thành công!";
    }

    public String updateData(int id,int mauSacId, int chatLieuId, int kichThuoc, int donGia, int soLuong) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "update SanPhamChiTiet set MauSacID = ?,ChatLieuID = ?, KichThuoc = ?,DonGia = ?,SoLuong = ? where ID = ?";
        PreparedStatement preSt = conn.prepareCall(sql);
        preSt.setInt(1, mauSacId);
        preSt.setInt(2, chatLieuId);
        preSt.setInt(3, kichThuoc);
        preSt.setInt(4, donGia);
        preSt.setInt(5, soLuong);
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

    public String removeData(String id) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "UPDATE [dbo].[SanPhamChiTiet]\n"
                + "   SET [TrangThaiXoa] = 1\n"
                + " WHERE ID = ?";
        PreparedStatement preSt = conn.prepareCall(sql);
        preSt.setString(1, id);
        int rs = preSt.executeUpdate();
        preSt.close();
        conn.close();
        return "Xóa thành công!";
    }

    public SanPhamChiTiet getSPCTbyID(int idSPCT) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "SELECT * FROM SANPHAMCHITIET where ID = " + idSPCT;
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("ID");
            int sanPhamId = rs.getInt("SanPhamID");
            int mauSacId = rs.getInt("MauSacID");
            int chatLieuId = rs.getInt("ChatLieuID");
            int kichThuoc = rs.getInt("KichThuoc");
            int donGia = rs.getInt("DonGia");
            int soLuong = rs.getInt("SoLuong");

            return new SanPhamChiTiet(id, sanPhamId, mauSacId, chatLieuId, kichThuoc, donGia, soLuong, donGia);
        }
        rs.close();
        st.close();
        conn.close();
        return null;
    }

    public int getIDSPbyIDSPCT(int id) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "SELECT SanPhamID FROM SanPhamChiTiet WHERE ID = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    return rs.getInt("SanPhamID");
                }
            }
        }
        return 0;
    }

    public int getIDMauSacbyIDSPCT(int id) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "SELECT MauSacID FROM SanPhamChiTiet WHERE ID = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    return rs.getInt("MauSacID");
                }
            }
        }
        return 0;
    }

    public int getKichThuocbyIDSPCT(int id) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "SELECT KichThuoc FROM SanPhamChiTiet WHERE ID = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    return rs.getInt("KichThuoc");
                }
            }
        }
        return 0;
    }

    public int getDonGiabyIDSPCT(int id) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "SELECT DonGia FROM SanPhamChiTiet WHERE ID = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    return rs.getInt("DonGia");
                }
            }
        }
        return 0;
    }

    public int getSoLuongByIDSPCT(int id) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "SELECT SoLuong FROM SanPhamChiTiet WHERE ID = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    return rs.getInt("SoLuong");
                }
            }
        }
        return 0;
    }

    public int getIDSPByHDCTID(int id) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sql = "SELECT SanPhamID FROM SanPhamChiTiet WHERE ID = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    return rs.getInt("SanPhamID");
                }
            }
        }
        return 0;
    }

    public void updateSoLuong(int hoaDonID) throws SQLException {
        Connection conn = ConnnectToSQLServer.getConnection();
        String sqlSelect = "SELECT SanPhamChiTietID, SoLuong FROM HoaDonChiTiet WHERE HoaDonID = ?";
        PreparedStatement preStSelect = conn.prepareStatement(sqlSelect);
        preStSelect.setInt(1, hoaDonID);
        ResultSet rs = preStSelect.executeQuery();
        
        String sqlUpdate = "UPDATE SanPhamChiTiet SET SoLuong = SoLuong - ? WHERE ID = ?";
        PreparedStatement preStUpdate = conn.prepareStatement(sqlUpdate);
        
        while (rs.next()) {
            int sanPhamChiTietID = rs.getInt("SanPhamChiTietID");
            int soLuongMua = rs.getInt("SoLuong");
            
            preStUpdate.setInt(1, soLuongMua);
            preStUpdate.setInt(2, sanPhamChiTietID);
            preStUpdate.executeUpdate();
        }
        
        rs.close();
        preStSelect.close();
        preStUpdate.close();
        conn.close();
    }
}
    
