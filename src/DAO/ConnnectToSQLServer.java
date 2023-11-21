package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnnectToSQLServer {

    private static String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=PRO1041_SD18320_G2_AO_2Clothes;user=sa;password=kakiethy12;";
    
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL);
            return conn;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Connect Successfully!");
        } catch (Exception ex) {
            System.out.println("Connect Failure!");
            ex.printStackTrace();
        }
    }
}
