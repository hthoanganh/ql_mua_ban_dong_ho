package com.mycompany.ql_mua_ban_dong_ho;
import com.mycompany.ql_mua_ban_dong_ho.DatabaseConnection;
import com.mycompany.ql_mua_ban_dong_ho.Giao_dien_chính;
import com.mycompany.ql_mua_ban_dong_ho.mua;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


/**
 *
 * @author ASUS
 */
public class Hoadon extends javax.swing.JFrame {
    private Giao_dien_chính mainForm;
    private mua muaForm;
    private String maDongHo;
    private int soLuongMua;

    /**
     * Creates new form hoadon1
     */
    public Hoadon() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public Hoadon(Giao_dien_chính mainForm, mua muaForm, String maDongHo, String tenDongHo, String thuongHieu, double gia, int soLuongMua) {
        initComponents();
         JPanel contentPanel = (JPanel) this.getContentPane();
        // 2. Chuyển tất cả các component từ cửa sổ chính vào trong contentPanel
        // Bằng cách này, chúng ta không làm hỏng file thiết kế .form của bạn
        int requiredHeight = 0;
        for (Component c : contentPanel.getComponents()) {
            if (c.getY() + c.getHeight() > requiredHeight) {
                requiredHeight = c.getY() + c.getHeight();
            }
        }
        contentPanel.setPreferredSize(new Dimension(600, requiredHeight + 40));
        // 3. Tạo một JScrollPane và đặt contentPanel vào trong đó
JScrollPane mainScrollPane = new JScrollPane(contentPanel);
        mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainScrollPane.getVerticalScrollBar().setUnitIncrement(16);

        // 4. Đặt JScrollPane làm nội dung chính cho cửa sổ JFrame
        this.setContentPane(mainScrollPane);
        // **KẾT THÚC PHẦN SỬA LỖI CUỘN**

        // --- Các phần code xử lý logic còn lại giữ nguyên ---
        this.pack(); // Tự động điều chỉnh kích thước
        this.setSize(630, 750); // Đặt kích thước cửa sổ hợp lý
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        this.mainForm = mainForm;
        this.muaForm = muaForm;
        this.maDongHo = maDongHo;
        this.soLuongMua = soLuongMua;

        // Điền ngày tháng năm hiện tại
        java.util.Calendar cal = java.util.Calendar.getInstance();
        ngay.setText(String.valueOf(cal.get(java.util.Calendar.DATE)));
        thang.setText(String.valueOf(cal.get(java.util.Calendar.MONTH) + 1));
        nam.setText(String.valueOf(cal.get(java.util.Calendar.YEAR)));

        // Điền thông tin vào bảng chi tiết hóa đơn
        DefaultTableModel model = (DefaultTableModel) chitiethoadon.getModel();
        model.setRowCount(0); // Xóa các dòng mẫu

        DecimalFormat df = new DecimalFormat("#,##0");
        double thanhTien = gia * soLuongMua;

        Object[] rowData = { maDongHo, tenDongHo, thuongHieu, df.format(gia), soLuongMua, df.format(thanhTien) };
        model.addRow(rowData);
        
        // Điền tổng tiền
        tongtienso.setText(df.format(thanhTien) + " VNĐ");
        long tongTienLong = (long) thanhTien;
String soTienBangChu = convertNumberToWords(tongTienLong);
tongtienchu.setText( soTienBangChu + " đồng.");
        
        // Xử lý sự kiện đóng cửa sổ
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                quayLaiFormMua();
            }
        });
    }
    
           private void quayLaiFormMua() {
        this.dispose();
        if (muaForm != null) {
            muaForm.enableMuaForm();
        }
    }
        private void showQrDialog() {
        try {
            // Đường dẫn tới ảnh trong thư mục resources
            URL qrUrl = getClass().getResource("/images/qr.jpg");
            if (qrUrl == null) {
                JOptionPane.showMessageDialog(this, "Lỗi: Không tìm thấy tệp qr.jpg trong resources/images", "Lỗi tệp", JOptionPane.ERROR_MESSAGE);
                return;
            }
            ImageIcon qrIcon = new ImageIcon(qrUrl);
            
            // Thay đổi kích thước ảnh để hiển thị tốt hơn, ví dụ 250x250
            Image image = qrIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(image);

            JLabel qrLabel = new JLabel(resizedIcon);
            
            // Tạo một dialog mới để chứa ảnh QR
            JDialog qrDialog = new JDialog(this, "Quét mã QR để thanh toán", true); // true = modal
            qrDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            qrDialog.getContentPane().add(qrLabel);
            qrDialog.pack(); // Tự động điều chỉnh kích thước dialog cho vừa với ảnh
            qrDialog.setLocationRelativeTo(this); // Hiển thị dialog ở giữa form hóa đơn
            qrDialog.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi hiển thị mã QR.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ngay = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        thang = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        nam = new javax.swing.JTextField();
        tenkh = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        diachi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ngaysinhkh = new javax.swing.JTextField();
        sdtemail = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        sonam = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        makh = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chitiethoadon = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        tongtienso = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tongtienchu = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        ptthanhtoan = new javax.swing.JComboBox<>();
        nutthhanhtoan = new javax.swing.JButton();
        thongtinthanhtoan = new javax.swing.JLabel();
        quaylai = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel9.setBackground(new java.awt.Color(27, 69, 25));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("        CỬA HÀNG MUA BÁN ĐỒNG HỒ APACHE");
        jLabel9.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Địa chỉ: Phương Trà, Cao Lãnh, Đồng Tháp");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Số điện thoại: 0788968277");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Email: htha4067@gmail.com");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Fanpage: Huỳnh Thanh Hoàng Anh (Facebook)");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("ahth4067 (Instagram)");

        jLabel8.setBackground(new java.awt.Color(158, 186, 155));
        jLabel8.setOpaque(true);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 0));
        jLabel13.setText("HÓA ĐƠN BÁN HÀNG");

        ngay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ngayActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel14.setText("Ngày");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel15.setText("tháng");

        thang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thangActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel16.setText("năm");

        nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namActionPerformed(evt);
            }
        });

        tenkh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tenkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenkhActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Họ tên KH:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Địa chỉ: ");

        diachi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        diachi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diachiActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Ngày sinh: ");

        ngaysinhkh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ngaysinhkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ngaysinhkhActionPerformed(evt);
            }
        });

        sdtemail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sdtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sdtemailActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("SĐT hoặc Email:");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Thời gian bảo hành");

        sonam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sonam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sonamActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("(năm) tính từ ngày in hóa đơn.");

        makh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        makh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makhActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Mã KH:");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("Chi tiết hóa đơn");

        chitiethoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên đồng hồ", "Thương hiệu", "Giá", "Số lượng", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        chitiethoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chitiethoadonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(chitiethoadon);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Tổng tiền:");

        tongtienso.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tongtienso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tongtiensoActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Bằng chữ:");

        tongtienchu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tongtienchu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tongtienchuActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("Phương thức thanh toán");

        ptthanhtoan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn thanh toán", "Tiền mặt", "Chuyển khoản" }));
        ptthanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptthanhtoanActionPerformed(evt);
            }
        });

        nutthhanhtoan.setText("Thanh toán");
        nutthhanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutthhanhtoanActionPerformed(evt);
            }
        });

        thongtinthanhtoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                thongtinthanhtoanMouseClicked(evt);
            }
        });

        quaylai.setText("Quay lại");
        quaylai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quaylaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addGap(16, 16, 16)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(thang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(nam, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(ngaysinhkh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(sdtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(sonam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(makh, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(tongtienso, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(tongtienchu, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ptthanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nutthhanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quaylai, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(thongtinthanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel12))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel5)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ngaysinhkh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sdtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sonam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(makh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tongtienso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tongtienchu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(ptthanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nutthhanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(quaylai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(thongtinthanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ngayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ngayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ngayActionPerformed

    private void thangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thangActionPerformed

    private void namActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namActionPerformed

    private void tenkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenkhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenkhActionPerformed

    private void diachiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diachiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diachiActionPerformed

    private void ngaysinhkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ngaysinhkhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ngaysinhkhActionPerformed

    private void sdtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sdtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sdtemailActionPerformed

    private void sonamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sonamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sonamActionPerformed

    private void makhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_makhActionPerformed

    private void chitiethoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chitiethoadonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_chitiethoadonMouseClicked

    private void tongtiensoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tongtiensoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tongtiensoActionPerformed

    private void tongtienchuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tongtienchuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tongtienchuActionPerformed

    private void nutthhanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutthhanhtoanActionPerformed
        // TODO add your handling code here:
        if (tenkh.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập họ tên khách hàng.", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (ptthanhtoan.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phương thức thanh toán.", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String sql = "UPDATE dongho SET `Số lượng` = `Số lượng` - ?, `Đã bán` = `Đã bán` + ? WHERE `Mã sản phẩm` = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            if (conn == null) {
                JOptionPane.showMessageDialog(this, "Lỗi kết nối CSDL.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            pstmt.setInt(1, this.soLuongMua);
            pstmt.setInt(2, this.soLuongMua);
            pstmt.setString(3, this.maDongHo);

            if (pstmt.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(this, "Thanh toán thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                if (this.muaForm != null) this.muaForm.dispose();
                if (this.mainForm != null) this.mainForm.enableMainForm();
            } else {
                JOptionPane.showMessageDialog(this, "Thanh toán thất bại. Không tìm thấy sản phẩm để cập nhật.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi CSDL khi cập nhật sản phẩm: " + e.getMessage(), "Lỗi CSDL", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    
    
    }//GEN-LAST:event_nutthhanhtoanActionPerformed

    private void quaylaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quaylaiActionPerformed
        // TODO add your handling code here:
              quayLaiFormMua();
    
    // Các event handler khác (nếu có)
    }//GEN-LAST:event_quaylaiActionPerformed

    private void thongtinthanhtoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thongtinthanhtoanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_thongtinthanhtoanMouseClicked

    private void ptthanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptthanhtoanActionPerformed
        // TODO add your handling code here:
String selectedMethod = (String) ptthanhtoan.getSelectedItem();
        if (selectedMethod == null) return;

        switch (selectedMethod) {
            case "Chuyển khoản":
                thongtinthanhtoan.setText(""); // Xóa văn bản
                // Tải ảnh QR
                try {
                    URL qrUrl = getClass().getResource("/images/qr.jpg");
                    if (qrUrl == null) {
                        thongtinthanhtoan.setText("Lỗi: Không tìm thấy qr.jpg");
                        return;
                    }
                    ImageIcon originalIcon = new ImageIcon(qrUrl);
                    
                    // Lấy kích thước của JLabel để thay đổi kích thước ảnh
                    int labelWidth = thongtinthanhtoan.getWidth();
                    int labelHeight = thongtinthanhtoan.getHeight();

                    // Đảm bảo không chia cho 0 nếu label chưa được vẽ
                    if (labelWidth == 0 || labelHeight == 0) {
                        labelWidth = 150; // Kích thước mặc định
                        labelHeight = 150;
                    }

                    // Thay đổi kích thước ảnh
                    Image image = originalIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(image);
                    
                    thongtinthanhtoan.setIcon(scaledIcon);
                } catch (Exception e) {
                    thongtinthanhtoan.setText("Lỗi tải ảnh QR");
                }
                break;
            case "Tiền mặt":
                thongtinthanhtoan.setIcon(null); // Xóa ảnh
                thongtinthanhtoan.setText("Vui lòng thanh toán tại quầy.");
                break;
            default: // Trường hợp "Chọn thanh toán"
                thongtinthanhtoan.setIcon(null);
                thongtinthanhtoan.setText("");
                break;
        }
    }
        //<editor-fold defaultstate="collapsed" desc="PHƯƠNG THỨC ĐỌC SỐ TIỀN BẰNG CHỮ">
    private static final String[] so = { "không", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín" };
    private static final String[] hang = { "", "nghìn", "triệu", "tỷ" };

    private static String readGroupOfThree(String group) {
        java.util.List<String> result = new java.util.ArrayList<>();
        int tram = Integer.parseInt(group.substring(0, 1));
        int chuc = Integer.parseInt(group.substring(1, 2));
        int donvi = Integer.parseInt(group.substring(2, 3));

        if (tram != 0 || chuc != 0 || donvi != 0) {
            if (tram != 0) {
                result.add(so[tram]);
                result.add("trăm");
            }

            if (chuc == 0 && donvi != 0 && tram != 0) {
                result.add("linh");
            }

            if (chuc == 1) {
                result.add("mười");
            } else if (chuc > 1) {
                result.add(so[chuc]);
                result.add("mươi");
            }

            if (donvi == 1 && chuc > 1) {
                result.add("mốt");
            } else if (donvi == 5 && chuc > 0) {
                result.add("lăm");
            } else if (donvi > 0) {
                result.add(so[donvi]);
            }
        }
        return String.join(" ", result);
    }

    private static String convertNumberToWords(long number) {
        if (number == 0) {
            return "Không";
        }

        String numStr = String.valueOf(number);
        java.util.List<String> groups = new java.util.ArrayList<>();

        while (numStr.length() > 3) {
            groups.add(numStr.substring(numStr.length() - 3));
            numStr = numStr.substring(0, numStr.length() - 3);
        }
        groups.add(numStr);

        java.util.Collections.reverse(groups);
        java.util.List<String> result = new java.util.ArrayList<>();

        for (int i = 0; i < groups.size(); i++) {
            String groupStr = groups.get(i);
            while (groupStr.length() < 3) {
                groupStr = "0" + groupStr;
            }
            String readGroup = readGroupOfThree(groupStr);
            if (!readGroup.isEmpty()) {
                result.add(readGroup);
                if (i < groups.size() -1) {
                     result.add(hang[groups.size() - 1 - i]);
                }
            }
        }

        String finalResult = String.join(" ", result).trim().replaceAll("\\s+", " ");
        return finalResult.substring(0, 1).toUpperCase() + finalResult.substring(1);
    
    //</editor-fold>
    
    }//GEN-LAST:event_ptthanhtoanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
java.awt.EventQueue.invokeLater(() -> new Hoadon().setVisible(true));
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable chitiethoadon;
    private javax.swing.JTextField diachi;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField makh;
    private javax.swing.JTextField nam;
    private javax.swing.JTextField ngay;
    private javax.swing.JTextField ngaysinhkh;
    private javax.swing.JButton nutthhanhtoan;
    private javax.swing.JComboBox<String> ptthanhtoan;
    private javax.swing.JButton quaylai;
    private javax.swing.JTextField sdtemail;
    private javax.swing.JTextField sonam;
    private javax.swing.JTextField tenkh;
    private javax.swing.JTextField thang;
    private javax.swing.JLabel thongtinthanhtoan;
    private javax.swing.JTextField tongtienchu;
    private javax.swing.JTextField tongtienso;
    // End of variables declaration//GEN-END:variables
}