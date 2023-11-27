/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import View.DangNhapJFrame;
import View.TrangChuJFrame;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author zudd4
 */
public class MainApp {
    public static void main(String[] args) throws SQLException {
        SwingUtilities.invokeLater(() -> {
            DangNhapJFrame dangNhapFrame = null;
            try {
                dangNhapFrame = new DangNhapJFrame();
            } catch (SQLException ex) {
                Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
            }
            dangNhapFrame.setVisible(true);
        });
    }
    
    public static void showTrangChu() {
        SwingUtilities.invokeLater(() -> {
            TrangChuJFrame trangChuFrame = null;
            try {
                trangChuFrame = new TrangChuJFrame();
            } catch (SQLException ex) {
                Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
            }
            trangChuFrame.setVisible(true);
        });
    }
}
