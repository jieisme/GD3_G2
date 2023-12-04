/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DAO.SanPhamChiTietDAO;
import DAO.SanPhamDAO;
import DAO.MauSacDAO;
import DAO.ChatLieuDAO;
import Entity.SanPhamChiTiet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thuylq
 */
public class QuanLySanPhamChiTietJFrame extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    List<SanPhamChiTiet> list = new ArrayList<>();
    SanPhamChiTietDAO sanPhamChiTietDAO = new SanPhamChiTietDAO();
    private int index = -1;
    private SanPhamDAO sanPhamDAO = new SanPhamDAO();
    private MauSacDAO mauSacDAO = new MauSacDAO();
    private ChatLieuDAO chatLieuDAO = new ChatLieuDAO();
    private DecimalFormat decimalFormat = new DecimalFormat("#,###");

    /**
     * Creates new form QuanLySanPhamChiTietJFrame
     */
    public QuanLySanPhamChiTietJFrame() throws SQLException {
        initComponents();
        dtm = (DefaultTableModel) tblSanPhamChiTiet.getModel();
        dtm.setRowCount(0);
        list = sanPhamChiTietDAO.getAll();
        showData(list);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void showData(List<SanPhamChiTiet> list) throws SQLException {
        int stt = 1;
        dtm.setRowCount(0);

        for (SanPhamChiTiet sanPhamChiTiet : list) {
            Object data[] = {
                stt++,
                sanPhamChiTiet.getId(),
                sanPhamDAO.getTenSanPham(sanPhamChiTiet.getSanPhamID()),
                mauSacDAO.getTenMauSac(sanPhamChiTiet.getMauSacID()),
                chatLieuDAO.getTenChatLieu(sanPhamChiTiet.getChatLieuID()),
                getKichThuocName(sanPhamChiTiet.getKichThuocID()),
                sanPhamChiTiet.getDonGia(),
                sanPhamChiTiet.getSoLuong(),};
            dtm.addRow(data);
        }
    }

    private String getKichThuocName(int kichThuoc) {
        switch (kichThuoc) {
            case 0:
                return "X";
            case 1:
                return "S";
            case 2:
                return "M";
            case 3:
                return "L";
            default:
                return "";
        }
    }
    
    private String getMau(int mauSacID) {
        switch (mauSacID) {
            case 0:
                return "Đen";
            case 1:
                return "Trắng";
            case 2:
                return "Đỏ";
            case 3:
                return "Hồng";
            case 4:
                return "Xanh lá";
            case 5:
                return "Xanh dương";
            default:
                return "";
        }
    }
    
    private String getChatLieu(int chatLieuID) {
        switch (chatLieuID) {
            case 0:
                return "Vải Cotton";
            case 1:
                return "Vải Kaki";
            case 2:
                return "Vải Jeans";
            case 3:
                return "Vải Ren";
            case 4:
                return "Vải Lanh";
            case 5:
                return "Vải Waffle";
            case 6:
                return "Vải Nỉ bông";
            default:
                return "";
        }
    }

    private void detailData(SanPhamChiTiet sanPhamChiTiet) {
        txtID.setText(String.valueOf(sanPhamChiTiet.getId()));
        txtSanPhamID.setText(String.valueOf(sanPhamChiTiet.getSanPhamID()));
        cboMauSac.setSelectedIndex(sanPhamChiTiet.getMauSacID());
        cboChatLieu.setSelectedIndex(sanPhamChiTiet.getChatLieuID());
        cboKichThuoc.setSelectedIndex(sanPhamChiTiet.getKichThuocID());
        txtDonGia.setText(String.valueOf(sanPhamChiTiet.getDonGia()));
        txtSoLuong.setText(String.valueOf(sanPhamChiTiet.getSoLuong()));
    }

    public String layThongTinBanGhi() {
        return "Record :" + (index + 1) + " of " + list.size();
    }

    public void firstNV() throws SQLException {

        index = 0;

        tblSanPhamChiTiet.setRowSelectionInterval(index, index);
        SanPhamChiTiet sanPhamChiTiet = sanPhamChiTietDAO.getAll().get(index);
            detailDataD(sanPhamChiTiet);
        lblbanghi.setText(layThongTinBanGhi());
    }

    public void lastNV() throws SQLException {
        index = list.size() - 1;

        tblSanPhamChiTiet.setRowSelectionInterval(index, index);
        SanPhamChiTiet sanPhamChiTiet = sanPhamChiTietDAO.getAll().get(index);
            detailDataD(sanPhamChiTiet);
        lblbanghi.setText(layThongTinBanGhi());

    }

    public void PreNV() throws SQLException {
        if (index == 0) {
            lastNV();
        } else {
            index--;
            tblSanPhamChiTiet.setRowSelectionInterval(index, index);
            SanPhamChiTiet sanPhamChiTiet = sanPhamChiTietDAO.getAll().get(index);
            detailDataD(sanPhamChiTiet);
            lblbanghi.setText(layThongTinBanGhi());
        }

    }

    public void NextNV() throws SQLException {
        if (index == list.size()) {
            firstNV();
        } else {
            index++;
            tblSanPhamChiTiet.setRowSelectionInterval(index, index);
            SanPhamChiTiet sanPhamChiTiet = sanPhamChiTietDAO.getAll().get(index);
            detailDataD(sanPhamChiTiet);
            lblbanghi.setText(layThongTinBanGhi());

        }

    }

    public void detailDataD(SanPhamChiTiet sanPhamChiTiet) throws SQLException {
        txtID.setText(String.valueOf(sanPhamChiTiet.getId()));
        txtSanPhamID.setText(sanPhamDAO.getTenSanPham(sanPhamChiTiet.getId()));
        cboMauSac.setSelectedItem(getMau(sanPhamChiTiet.getMauSacID()));
        cboChatLieu.setSelectedItem(getChatLieu(sanPhamChiTiet.getChatLieuID()));
        cboKichThuoc.setSelectedItem(getKichThuocName(sanPhamChiTiet.getKichThuocID()));
        txtDonGia.setText(decimalFormat.format(sanPhamChiTiet.getDonGia()) + " VNĐ");
        txtSoLuong.setText(String.valueOf(sanPhamChiTiet.getSoLuong()));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        btnTaiKhoan = new javax.swing.JButton();
        btnDoiMatKhau = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        txtTile = new javax.swing.JLabel();
        txtLogo = new javax.swing.JLabel();
        btnBanHang = new javax.swing.JButton();
        btnQuanLySanPham = new javax.swing.JButton();
        btnQuanLyKhachHang = new javax.swing.JButton();
        btnQuanLyHoaDon = new javax.swing.JButton();
        btnQuanLyNhanVien = new javax.swing.JButton();
        btnQuanLyVoucher = new javax.swing.JButton();
        btnTrangChu = new javax.swing.JButton();
        btnQuanLyThuocTinh = new javax.swing.JButton();
        txtSoLuong = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        txtErrorTenSanPham = new javax.swing.JLabel();
        txtSanPhamID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtErrorID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblbanghi = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPhamChiTiet = new javax.swing.JTable();
        cboKichThuoc = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();
        btnTimID1 = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTimID4 = new javax.swing.JButton();
        btnTimID5 = new javax.swing.JButton();
        btnTimID7 = new javax.swing.JButton();
        txtXinChao = new javax.swing.JLabel();
        txtChucVu = new javax.swing.JLabel();
        txtDongHo = new javax.swing.JLabel();
        cboMauSac = new javax.swing.JComboBox<>();
        cboChatLieu = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background.setBackground(new java.awt.Color(166, 227, 233));
        Background.setForeground(new java.awt.Color(253, 247, 228));

        btnTaiKhoan.setBackground(new java.awt.Color(203, 241, 245));
        btnTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Gear.png"))); // NOI18N
        btnTaiKhoan.setText("TÀI KHOẢN");
        btnTaiKhoan.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 72, 99), 1, true));
        btnTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiKhoanActionPerformed(evt);
            }
        });

        btnDoiMatKhau.setBackground(new java.awt.Color(203, 241, 245));
        btnDoiMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Key.png"))); // NOI18N
        btnDoiMatKhau.setText("ĐỔI MẬT KHẨU");
        btnDoiMatKhau.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 72, 99), 1, true));
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });

        btnDangXuat.setBackground(new java.awt.Color(203, 241, 245));
        btnDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Exit.png"))); // NOI18N
        btnDangXuat.setText("ĐĂNG XUẤT");
        btnDangXuat.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 72, 99), 1, true));
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        txtTile.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        txtTile.setText("HỆ THỐNG QUẢN LÝ BẢN ÁO");

        txtLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo2Clothes.png"))); // NOI18N

        btnBanHang.setBackground(new java.awt.Color(203, 241, 245));
        btnBanHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBanHang.setText("BÁN HÀNG");
        btnBanHang.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 72, 99), 1, true));
        btnBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHangActionPerformed(evt);
            }
        });

        btnQuanLySanPham.setBackground(new java.awt.Color(203, 241, 245));
        btnQuanLySanPham.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnQuanLySanPham.setText("QUẢN LÝ SẢN PHẨM");
        btnQuanLySanPham.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 72, 99), 1, true));
        btnQuanLySanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLySanPhamActionPerformed(evt);
            }
        });

        btnQuanLyKhachHang.setBackground(new java.awt.Color(203, 241, 245));
        btnQuanLyKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnQuanLyKhachHang.setText("QUẢN LÝ KHÁCH HÀNG");
        btnQuanLyKhachHang.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 72, 99), 1, true));
        btnQuanLyKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyKhachHangActionPerformed(evt);
            }
        });

        btnQuanLyHoaDon.setBackground(new java.awt.Color(203, 241, 245));
        btnQuanLyHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnQuanLyHoaDon.setText("QUẢN LÝ HÓA ĐƠN");
        btnQuanLyHoaDon.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 72, 99), 1, true));
        btnQuanLyHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyHoaDonActionPerformed(evt);
            }
        });

        btnQuanLyNhanVien.setBackground(new java.awt.Color(203, 241, 245));
        btnQuanLyNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnQuanLyNhanVien.setText("QUẢN LÝ NHÂN VIÊN");
        btnQuanLyNhanVien.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 72, 99), 1, true));
        btnQuanLyNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyNhanVienActionPerformed(evt);
            }
        });

        btnQuanLyVoucher.setBackground(new java.awt.Color(203, 241, 245));
        btnQuanLyVoucher.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnQuanLyVoucher.setText("QUẢN LÝ VOUCHER");
        btnQuanLyVoucher.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 72, 99), 1, true));
        btnQuanLyVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyVoucherActionPerformed(evt);
            }
        });

        btnTrangChu.setBackground(new java.awt.Color(22, 72, 99));
        btnTrangChu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        btnTrangChu.setText("TRANG CHỦ");
        btnTrangChu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, -1, -1, new java.awt.Color(0, 0, 0)));
        btnTrangChu.setBorderPainted(false);
        btnTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangChuActionPerformed(evt);
            }
        });

        btnQuanLyThuocTinh.setBackground(new java.awt.Color(203, 241, 245));
        btnQuanLyThuocTinh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnQuanLyThuocTinh.setText("QUẢN LÝ THUỘC TÍNH");
        btnQuanLyThuocTinh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 72, 99), 1, true));
        btnQuanLyThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyThuocTinhActionPerformed(evt);
            }
        });

        txtErrorTenSanPham.setForeground(new java.awt.Color(255, 0, 0));
        txtErrorTenSanPham.setText(" ");

        txtSanPhamID.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("TÊN SẢN PHẨM:");

        txtErrorID.setForeground(new java.awt.Color(255, 0, 0));
        txtErrorID.setText(" ");

        txtID.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("ID SPCT:");

        lblbanghi.setText("Record : 3 of 4");

        tblSanPhamChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID SPCT", "TÊN SẢN PHẨM", "MÀU SẮC", "CHẤT LIỆU", "KÍCH THƯỚC", "ĐƠN GIÁ", "SỐ LƯỢNG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPhamChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamChiTietMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPhamChiTiet);

        cboKichThuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "X", "S", "M", "L" }));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("SỐ LƯỢNG:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("ĐƠN GIÁ:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("KÍCH THƯỚC:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("CHẤT LIỆU:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("MÀU SẮC:");

        btnSua.setBackground(new java.awt.Color(22, 72, 99));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnTimID1.setBackground(new java.awt.Color(22, 72, 99));
        btnTimID1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimID1.setForeground(new java.awt.Color(255, 255, 255));
        btnTimID1.setText(">>");
        btnTimID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimID1ActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(22, 72, 99));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(22, 72, 99));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnTimID4.setBackground(new java.awt.Color(22, 72, 99));
        btnTimID4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimID4.setForeground(new java.awt.Color(255, 255, 255));
        btnTimID4.setText("|<");
        btnTimID4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimID4ActionPerformed(evt);
            }
        });

        btnTimID5.setBackground(new java.awt.Color(22, 72, 99));
        btnTimID5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimID5.setForeground(new java.awt.Color(255, 255, 255));
        btnTimID5.setText("<<");
        btnTimID5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimID5ActionPerformed(evt);
            }
        });

        btnTimID7.setBackground(new java.awt.Color(22, 72, 99));
        btnTimID7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimID7.setForeground(new java.awt.Color(255, 255, 255));
        btnTimID7.setText(">>");
        btnTimID7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimID7ActionPerformed(evt);
            }
        });

        txtXinChao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtXinChao.setText("Xin chào,");

        txtChucVu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtChucVu.setText("Chức vụ: ");

        txtDongHo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtDongHo.setForeground(new java.awt.Color(22, 72, 99));
        txtDongHo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Alarm.png"))); // NOI18N
        txtDongHo.setText("09:11:2001");

        cboMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đen", "Trắng", "Đỏ", "Hồng", "Xanh lá", "Xanh dương" }));

        cboChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vải Cotton", "Vải Kaki", "Vải Jeans", "Vải Ren", "Vải Lanh", "Vải Waffle", "Vải Nỉ bông" }));

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtXinChao)
                            .addComponent(txtChucVu))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(txtDongHo))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnQuanLySanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(256, 256, 256)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTile)
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(txtLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                        .addComponent(btnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(BackgroundLayout.createSequentialGroup()
                                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnQuanLyThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnQuanLyKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnQuanLyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnQuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnQuanLyVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel15)
                                            .addGroup(BackgroundLayout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(jLabel11))
                                            .addComponent(jLabel12))
                                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(BackgroundLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtSanPhamID, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cboKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                                                            .addComponent(btnThem)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(btnSua)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(btnXoa)))))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cboMauSac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtErrorID)
                                            .addComponent(txtErrorTenSanPham)
                                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btnTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(BackgroundLayout.createSequentialGroup()
                                        .addComponent(btnTimID4)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnTimID5)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnTimID7)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnTimID1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblbanghi))
                                    .addComponent(jScrollPane2))))
                        .addContainerGap())))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnQuanLySanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTile)
                            .addComponent(btnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(txtLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtErrorID)
                            .addComponent(txtErrorTenSanPham)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSanPhamID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(BackgroundLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel12))
                                    .addGroup(BackgroundLayout.createSequentialGroup()
                                        .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTimID4)
                                    .addComponent(btnTimID5)
                                    .addComponent(btnTimID7)
                                    .addComponent(btnTimID1)
                                    .addComponent(lblbanghi)))))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(btnQuanLyKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnQuanLyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnQuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnQuanLyVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnQuanLyThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnDoiMatKhau)))
                .addGap(12, 12, 12)
                .addComponent(btnDangXuat)
                .addGap(27, 27, 27)
                .addComponent(txtXinChao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtChucVu)
                    .addComponent(txtDongHo)))
        );

        BackgroundLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSua, btnThem, btnXoa});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiKhoanActionPerformed
        // TODO add your handling code here:
        if (!btnDoiMatKhau.isVisible() && !btnDangXuat.isVisible()) {
            btnDoiMatKhau.setVisible(true);
            btnDangXuat.setVisible(true);
        } else {
            btnDoiMatKhau.setVisible(false);
            btnDangXuat.setVisible(false);
        }
    }//GEN-LAST:event_btnTaiKhoanActionPerformed

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        // TODO add your handling code here:
        DoiMatKhauJFrame doiMatKhauJFrame = null;
        try {
            doiMatKhauJFrame = new DoiMatKhauJFrame();
        } catch (SQLException ex) {
            Logger.getLogger(BanHangJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        doiMatKhauJFrame.setVisible(true);
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
        DangNhapJFrame dangNhapJFrame = null;
        try {
            dangNhapJFrame = new DangNhapJFrame();
        } catch (SQLException ex) {
            Logger.getLogger(BanHangJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        dangNhapJFrame.setVisible(true);
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed
        // TODO add your handling code here:
        BanHangJFrame banHangJFrame = null;
        try {
            banHangJFrame = new BanHangJFrame();
        } catch (SQLException ex) {
            Logger.getLogger(BanHangJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        banHangJFrame.setVisible(true);
    }//GEN-LAST:event_btnBanHangActionPerformed

    private void btnQuanLySanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLySanPhamActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnQuanLySanPhamActionPerformed

    private void btnQuanLyKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyKhachHangActionPerformed
        // TODO add your handling code here:
        QuanLyKhachHangJFrame quanLyKhachHang = null;
        try {
            quanLyKhachHang = new QuanLyKhachHangJFrame();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPhamChiTietJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        quanLyKhachHang.setVisible(true);
    }//GEN-LAST:event_btnQuanLyKhachHangActionPerformed

    private void btnQuanLyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyHoaDonActionPerformed
        // TODO add your handling code here:
        QuanLyHoaDonJFrame quanLiHoaDon = null;
        try {
            quanLiHoaDon = new QuanLyHoaDonJFrame();
        } catch (SQLException ex) {
            Logger.getLogger(BanHangJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        quanLiHoaDon.setVisible(true);
    }//GEN-LAST:event_btnQuanLyHoaDonActionPerformed

    private void btnQuanLyNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyNhanVienActionPerformed
        // TODO add your handling code here:
        QuanLyNhanVienJFrame quanLiNhanVien = null;
        try {
            quanLiNhanVien = new QuanLyNhanVienJFrame();
        } catch (SQLException ex) {
            Logger.getLogger(BanHangJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        quanLiNhanVien.setVisible(true);
    }//GEN-LAST:event_btnQuanLyNhanVienActionPerformed

    private void btnQuanLyVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyVoucherActionPerformed
        // TODO add your handling code here:
//        QuanLiVoucher quanLiVoucher = null;
//        quanLiVoucher = new QuanLiVoucher();
//        this.setVisible(false);
//        quanLiVoucher.setVisible(true);
    }//GEN-LAST:event_btnQuanLyVoucherActionPerformed

    private void btnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangChuActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        TrangChuJFrame trangChuJFrame = null;
        try {
            trangChuJFrame = new TrangChuJFrame();
        } catch (SQLException ex) {
            Logger.getLogger(BanHangJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        trangChuJFrame.setVisible(true);
    }//GEN-LAST:event_btnTrangChuActionPerformed

    private void btnQuanLyThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyThuocTinhActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        QuanLyThuocTinhJFrame quanLiThuocTinh = null;
        try {
            quanLiThuocTinh = new QuanLyThuocTinhJFrame();
        } catch (SQLException ex) {
            Logger.getLogger(DoiMatKhauJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        quanLiThuocTinh.setVisible(true);
    }//GEN-LAST:event_btnQuanLyThuocTinhActionPerformed

    private void tblSanPhamChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamChiTietMouseClicked
        int selectedRow = tblSanPhamChiTiet.getSelectedRow();
        try {
            detailData(sanPhamChiTietDAO.getAll().get(selectedRow));
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPhamJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        index = tblSanPhamChiTiet.getSelectedRow();
        lblbanghi.setText(layThongTinBanGhi());
    }//GEN-LAST:event_tblSanPhamChiTietMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (checkForm()) {
            int selectedRow = tblSanPhamChiTiet.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Chưa chọn dòng để sửa!");
            } else {
                try {
                    int id = Integer.parseInt(txtID.getText());
                    list = sanPhamChiTietDAO.getAll();

                    boolean isIdDuplicated = false;

                    for (SanPhamChiTiet sanPhamChiTiet : list) {
                        if (id == sanPhamChiTiet.getId()) {
                            isIdDuplicated = true;
                            break;
                        }
                    }

                    if (isIdDuplicated == false) {
                        JOptionPane.showMessageDialog(this, "Không có mã sản phẩm cần sửa!");
                    } else {
                        int sanPhamId = Integer.parseInt(txtSanPhamID.getText());
                        int mauSacId = cboMauSac.getSelectedIndex();
                        int chatLieuId = cboChatLieu.getSelectedIndex();
                        int kichThuoc = cboKichThuoc.getSelectedIndex();
                        float donGia = Float.parseFloat(txtDonGia.getText());
                        int soLuong = Integer.parseInt(txtSoLuong.getText());
                        JOptionPane.showMessageDialog(this, sanPhamChiTietDAO.updateData(id, sanPhamId, mauSacId, chatLieuId, kichThuoc, donGia, soLuong));
                        showData(sanPhamChiTietDAO.getAll());
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTimID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimID1ActionPerformed
        try {
            // TODO add your handling code here:
            lastNV();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPhamChiTietJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTimID1ActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (checkForm()) {
            try {
                int id = Integer.parseInt(txtID.getText());
                list = sanPhamChiTietDAO.getAll();

                int sanPhamId = Integer.parseInt(txtSanPhamID.getText());
                int mauSacId = cboMauSac.getSelectedIndex();
                int chatLieuId = cboChatLieu.getSelectedIndex();
                int kichThuoc = cboKichThuoc.getSelectedIndex();
                int donGia = Integer.parseInt(txtDonGia.getText());
                int soLuong = Integer.parseInt(txtSoLuong.getText());
                JOptionPane.showMessageDialog(this, sanPhamChiTietDAO.addData(id, sanPhamId, mauSacId, chatLieuId, kichThuoc, donGia, soLuong));
                list = sanPhamChiTietDAO.getAll();
                showData(list);
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int chon = (JOptionPane.showConfirmDialog(this, "Delete ?", "Confrim", JOptionPane.YES_NO_OPTION));
        if (chon == JOptionPane.YES_OPTION) {
            try {
                JOptionPane.showMessageDialog(this, sanPhamChiTietDAO.removeData(txtID.getText()));
                showData(sanPhamChiTietDAO.getAll());
            } catch (SQLException ex) {
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimID4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimID4ActionPerformed
        try {
            // TODO add your handling code here:
            firstNV();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPhamChiTietJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTimID4ActionPerformed

    private void btnTimID5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimID5ActionPerformed
        try {
            // TODO add your handling code here:
            PreNV();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPhamChiTietJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTimID5ActionPerformed

    private void btnTimID7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimID7ActionPerformed
        try {
            // TODO add your handling code here:
            NextNV();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPhamChiTietJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTimID7ActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLySanPhamChiTietJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPhamChiTietJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPhamChiTietJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPhamChiTietJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new QuanLySanPhamChiTietJFrame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLySanPhamChiTietJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    boolean checkForm() {
        if (txtID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID không được để trống");
            txtID.requestFocus();
            return false;
        }
        if (txtSanPhamID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID sản phẩm không được để trống");
            txtSanPhamID.requestFocus();
            return false;
        }
        Pattern p = Pattern.compile("^[0-9]{1}$");
        if (!p.matcher(txtSanPhamID.getText()).find()) {
            JOptionPane.showMessageDialog(this, "ID sản phẩm  phải là số");
            txtSanPhamID.requestFocus();
            return false;
        }
        
        String donGiaString = txtDonGia.getText();
        if (donGiaString.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Đơn giá không được để trống");
            txtDonGia.requestFocus();
            return false;
        } else {
            try {
                int donGia = Integer.parseInt(donGiaString);
                if(donGia <= 0) {
                    JOptionPane.showMessageDialog(this, "Đơn giá phải > 0!");
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Đơn giá phải là số!");
                return false;
            }
        }
        
        String soLuongString = txtSoLuong.getText();
        if (soLuongString.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số lượng không được để trống");
            txtSoLuong.requestFocus();
            return false;
        } else {
            try {
                int soLuong = Integer.parseInt(soLuongString);
                if(soLuong <= 0) {
                    JOptionPane.showMessageDialog(this, "Số lượng phải > 0!");
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Đơn giá phải là số!");
                return false;
            }
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnQuanLyHoaDon;
    private javax.swing.JButton btnQuanLyKhachHang;
    private javax.swing.JButton btnQuanLyNhanVien;
    private javax.swing.JButton btnQuanLySanPham;
    private javax.swing.JButton btnQuanLyThuocTinh;
    private javax.swing.JButton btnQuanLyVoucher;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTaiKhoan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimID1;
    private javax.swing.JButton btnTimID4;
    private javax.swing.JButton btnTimID5;
    private javax.swing.JButton btnTimID7;
    private javax.swing.JButton btnTrangChu;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboChatLieu;
    private javax.swing.JComboBox<String> cboKichThuoc;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblbanghi;
    private javax.swing.JTable tblSanPhamChiTiet;
    private javax.swing.JLabel txtChucVu;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JLabel txtDongHo;
    private javax.swing.JLabel txtErrorID;
    private javax.swing.JLabel txtErrorTenSanPham;
    private javax.swing.JTextField txtID;
    private javax.swing.JLabel txtLogo;
    private javax.swing.JTextField txtSanPhamID;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JLabel txtTile;
    private javax.swing.JLabel txtXinChao;
    // End of variables declaration//GEN-END:variables
}
