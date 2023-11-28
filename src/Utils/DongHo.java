/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author zudd4
 */

public class DongHo extends Thread {

    private JLabel lblTime;

    public DongHo(JLabel lblTime) {
        this.lblTime = lblTime;
    }

    @Override
    public void run() {
        while (true) {
            Date currentDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd/MM/yyyy - hh:mm:ss a");
            String formattedDateTime = dateFormat.format(currentDate);
            
            lblTime.setText(formattedDateTime);
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(DongHo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private String getTime(int time) {
        if(time < 10) {
            return "0" + time;
        } else {
            return String.valueOf(time);
        }
    } 
}
