/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DAO.SanPhamDAO;
import Entity.SanPham;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zudd4
 */
public class QuanLySanPham extends javax.swing.JFrame {

    /**
     * Creates new form QuanLySanPham
     */
    
    DefaultTableModel dtm = new DefaultTableModel();
    List<SanPham> list = new ArrayList<>();
    SanPhamDAO sanPhamDAO = new SanPhamDAO();
    
    public QuanLySanPham() throws SQLException {
        initComponents();
        dtm = (DefaultTableModel) tblQuanLySanPham.getModel();
        dtm.setRowCount(0);
        list = sanPhamDAO.getAll();
        showData(list);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgDonViTinh = new javax.swing.ButtonGroup();
        btgTrangThaiBan = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtErrorID = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTenSanPham = new javax.swing.JTextField();
        txtErrorTenSanPham = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rdChiec = new javax.swing.JRadioButton();
        rdCai = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        JScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        cboLoaiSanPham = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQuanLySanPham = new javax.swing.JTable();
        btnTimByID = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnTimByName = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        rdDangBan = new javax.swing.JRadioButton();
        rdNgungBan = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý sản phẩm");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ SẢN PHẨM");

        jLabel2.setText("ID:");

        txtErrorID.setForeground(new java.awt.Color(255, 0, 0));
        txtErrorID.setText(" ");

        jLabel4.setText("Tên:");

        txtErrorTenSanPham.setForeground(new java.awt.Color(255, 0, 0));
        txtErrorTenSanPham.setText(" ");

        jLabel6.setText("Đơn vị tính:");

        btgDonViTinh.add(rdChiec);
        rdChiec.setSelected(true);
        rdChiec.setText("Chiếc");
        rdChiec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdChiecActionPerformed(evt);
            }
        });

        btgDonViTinh.add(rdCai);
        rdCai.setText("Cái");
        rdCai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdCaiActionPerformed(evt);
            }
        });

        jLabel7.setText("Mô tả");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        JScrollPane1.setViewportView(txtMoTa);

        jLabel8.setText("Loại sản phẩm");

        cboLoaiSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Áo Thun", "Áo Polo", "Áo Sơ Mi", "Áo Hoodie" }));
        cboLoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiSanPhamActionPerformed(evt);
            }
        });

        tblQuanLySanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID", "Tên sản phẩm", "Đơn vị tính", "Mô tả", "Loại sản phẩm", "Trạng thái bán"
            }
        ));
        tblQuanLySanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuanLySanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblQuanLySanPham);

        btnTimByID.setText("Tìm ID");
        btnTimByID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimByIDActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnTimByName.setText("Tìm Tên");
        btnTimByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimByNameActionPerformed(evt);
            }
        });

        jLabel9.setText("Trạng thái bán:");

        btgTrangThaiBan.add(rdDangBan);
        rdDangBan.setSelected(true);
        rdDangBan.setText("Đang bán");
        rdDangBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdDangBanActionPerformed(evt);
            }
        });

        btgTrangThaiBan.add(rdNgungBan);
        rdNgungBan.setText("Ngừng bán");
        rdNgungBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNgungBanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdChiec)
                                .addGap(18, 18, 18)
                                .addComponent(rdCai))
                            .addComponent(JScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtErrorTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnTimByName))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(txtErrorID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnTimByID)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSua))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdDangBan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdNgungBan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTimByID))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtErrorID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimByName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtErrorTenSanPham)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(rdChiec)
                            .addComponent(rdCai))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(JScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cboLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(rdDangBan)
                            .addComponent(rdNgungBan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnSua))
                        .addGap(68, 68, 68))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdChiecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdChiecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdChiecActionPerformed

    private void rdCaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdCaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdCaiActionPerformed

    private void cboLoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboLoaiSanPhamActionPerformed

    private void btnTimByIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimByIDActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblQuanLySanPham.getModel();
        model.setRowCount(0);
        
        try {
            list = sanPhamDAO.searchDataByID(Integer.parseInt(txtID.getText()));  
            customShowData(model, list);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTimByIDActionPerformed

    private void btnTimByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimByNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimByNameActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        try {
            int id = Integer.parseInt(txtID.getText());
            list = sanPhamDAO.getAll();

            boolean isIdDuplicated = false;

            for (SanPham sanPham : list) {
                if (id == sanPham.getId()) {
                    isIdDuplicated = true;
                    break;
                }
            }

            if (isIdDuplicated) {
                JOptionPane.showMessageDialog(this, "Trùng mã ID sản phẩm!");
            } else {
                String ten = txtTenSanPham.getText();
                String donViTinh = "";
                String moTa = txtMoTa.getText();
                int loaiSanPham = cboLoaiSanPham.getSelectedIndex();

                if (rdChiec.isSelected()) {
                    donViTinh = "Chiếc";
                } else {
                    donViTinh = "Cái";
                }
                
                int trangThaiBan;
                if(rdDangBan.isSelected()) {
                    trangThaiBan = 0;
                } else {
                    trangThaiBan = 1;
                }
            
                JOptionPane.showMessageDialog(this, sanPhamDAO.addData(id, ten, donViTinh, moTa, loaiSanPham, trangThaiBan));
                showData(sanPhamDAO.getAll());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblQuanLySanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuanLySanPhamMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblQuanLySanPham.getSelectedRow();
        try {
            detailData(sanPhamDAO.getAll().get(selectedRow));
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblQuanLySanPhamMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblQuanLySanPham.getSelectedRow();
        if(selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng để sửa!");
        } else {
            try {
                int id = Integer.parseInt(txtID.getText());
                list = sanPhamDAO.getAll();

                boolean isIdDuplicated = false;

                for (SanPham sanPham : list) {
                    if (id == sanPham.getId()) {
                        isIdDuplicated = true;
                        break; 
                    }
                }

                if (isIdDuplicated == false) {
                    JOptionPane.showMessageDialog(this, "Không có mã sản phẩm cần sửa!");
                } else {
                    String ten = txtTenSanPham.getText();
                    String donViTinh = "";
                    String moTa = txtMoTa.getText();
                    int loaiSanPham = cboLoaiSanPham.getSelectedIndex();

                    if (rdChiec.isSelected()) {
                        donViTinh = "Chiếc";
                    } else {
                        donViTinh = "Cái";
                    }
                    
                    int trangThaiBan;
                    if(rdDangBan.isSelected()) {
                        trangThaiBan = 0;
                    } else {
                        trangThaiBan = 1;
                    }
                    JOptionPane.showMessageDialog(this, sanPhamDAO.updateData(id, ten, donViTinh, moTa, loaiSanPham,trangThaiBan));
                    showData(sanPhamDAO.getAll());
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void rdDangBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdDangBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdDangBanActionPerformed

    private void rdNgungBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNgungBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdNgungBanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new QuanLySanPham().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void detailData(SanPham sanPham) {
        txtID.setText(String.valueOf(sanPham.getId()));
        txtTenSanPham.setText(sanPham.getTen());
        txtMoTa.setText(sanPham.getMoTa());
        if(sanPham.getDonViTinh().equalsIgnoreCase("Chiếc")) {
            rdChiec.setSelected(true);
        } else {
            rdCai.setSelected(true);
        }
        cboLoaiSanPham.setSelectedIndex(sanPham.getLoaiSanPham());
        if(sanPham.getTrangThaiBan() == 0) {
            rdDangBan.setSelected(true);
        } else {
            rdNgungBan.setSelected(true);
        }
    }
    
    private void customShowData(DefaultTableModel model, List<SanPham> list) {
        int stt = 1;
        model.setRowCount(0);
        
        for (SanPham sanPham : list) {
            Object obj[] = {
                stt++,
                sanPham.getId(),
                sanPham.getTen(),
                sanPham.getDonViTinh(),
                sanPham.getMoTa(),
                getLoaiSanPhamName(sanPham.getLoaiSanPham()),
                getTrangThaiBan(sanPham.getTrangThaiBan())
            };
            model.addRow(obj);
        }
    }
    
    private void showData(List<SanPham> list) {
        int stt = 1;
        dtm.setRowCount(0);
        
        for (SanPham sanPham : list) {
            Object data[] = {
                stt++,
                sanPham.getId(),
                sanPham.getTen(),
                sanPham.getDonViTinh(),
                sanPham.getMoTa(),
                getLoaiSanPhamName(sanPham.getLoaiSanPham()),
                getTrangThaiBan(sanPham.getTrangThaiBan())
            };
            dtm.addRow(data);
        }
    }
    
    private String getTrangThaiBan(int trangThaiBan) {
        switch (trangThaiBan) {
            case 0:
                return "Đang bán";
            case 1:
                return "Ngừng bán";
            default:
                return "";

        }
    }
    
    private String getLoaiSanPhamName(int loaiSanPham) {
        switch (loaiSanPham) {
            case 0:
                return "Áo Thun";
            case 1:
                return "Áo Polo";
            case 2:
                return "Áo Sơ Mi";
            case 3:
                return "Áo Hoodie";
            default:
                return "";
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPane1;
    private javax.swing.ButtonGroup btgDonViTinh;
    private javax.swing.ButtonGroup btgTrangThaiBan;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimByID;
    private javax.swing.JButton btnTimByName;
    private javax.swing.JComboBox<String> cboLoaiSanPham;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdCai;
    private javax.swing.JRadioButton rdChiec;
    private javax.swing.JRadioButton rdDangBan;
    private javax.swing.JRadioButton rdNgungBan;
    private javax.swing.JTable tblQuanLySanPham;
    private javax.swing.JLabel txtErrorID;
    private javax.swing.JLabel txtErrorTenSanPham;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtTenSanPham;
    // End of variables declaration//GEN-END:variables
}
