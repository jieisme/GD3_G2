/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.MauSac;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author zudd4
 */
public class MauSacDAO {
   private List<MauSac> list;
   
   public List<MauSac> getAll() throws SQLException {
       list = new ArrayList<>();
       Connection conn = ConnnectToSQLServer.getConnection();
       String sql = "SELECT [ID]\n" +
                    "      ,[Ten]\n" +
                    "  FROM [dbo].[MauSac]";
       Statement st = conn.createStatement();
       ResultSet rs = st.executeQuery(sql);
       
       while(rs.next()) {
           int id = rs.getInt("ID");
           String ten = rs.getString("Ten");
           
           MauSac mauSac = new MauSac(id, ten);
           list.add(mauSac);
       }
       rs.close();
       st.close();
       conn.close();
       return null;
   }
}
