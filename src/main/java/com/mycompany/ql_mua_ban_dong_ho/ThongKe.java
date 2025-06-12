package com.mycompany.ql_mua_ban_dong_ho;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableRowSorter;
public class ThongKe extends javax.swing.JFrame {
private DefaultTableModel originalModel; 
    private TableRowSorter<DefaultTableModel> sorter;
    /**
     * Creates new form Giao_dien_chính
     */
    public ThongKe() {
         initComponents(); // Khởi tạo thành phần giao diện
    DefaultTableModel modelFromMain = null;
        this.originalModel = modelFromMain; // Lưu model gốc
        bang1.setModel(this.originalModel); // lập model cho bảng bang1

        // Khởi tạo, thiết lập sorter cho bảng 
        sorter = new TableRowSorter<>(this.originalModel);
        bang1.setRowSorter(sorter);
        // Thiết lập căn giữa cho cửa sổ 
        this.setLocationRelativeTo(null);
    }
    // </editor-fold>
    public ThongKe(DefaultTableModel model) {
        initComponents();
        this.originalModel = model; // dc truyền từ Giao_dien_chinh
        bang1.setModel(this.originalModel);
        sorter = new TableRowSorter<>(this.originalModel);
        bang1.setRowSorter(sorter);
        this.setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reset = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        tinh = new javax.swing.JButton();
        tinhtoan = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        tim = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        timmucgia = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        timthuonghieu = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        timdongho = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        thoat1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bangketqua = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        bang1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset);
        reset.setBounds(40, 530, 60, 30);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Kết quả");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(250, 380, 60, 20);

        tinh.setText("Tính");
        tinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tinhActionPerformed(evt);
            }
        });
        getContentPane().add(tinh);
        tinh.setBounds(560, 330, 70, 40);

        tinhtoan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tính tất cả", "Tổng doanh thu", "Tổng giá trị tồn kho", "Tính lượng hàng còn lại", "Thống kê sau khi lọc", " " }));
        getContentPane().add(tinhtoan);
        tinhtoan.setBounds(270, 320, 180, 50);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Thống kê ");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(250, 290, 140, 20);

        tim.setText("Tìm");
        tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timActionPerformed(evt);
            }
        });
        getContentPane().add(tim);
        tim.setBounds(150, 530, 60, 30);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel9.setText("(Tìm theo mức giá)");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(40, 490, 130, 20);

        timmucgia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn mức giá", "Dưới 2 triệu", "Từ 5 - 10 triệu", "Từ 10 - 50 triệu" }));
        getContentPane().add(timmucgia);
        timmucgia.setBounds(30, 450, 150, 40);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel8.setText("(Tìm theo thương hiệu)");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(40, 420, 130, 20);

        timthuonghieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn thương hiệu", "Rolex", "Omega", "Patek Philippe", "Audemars Piguet", "Cartier", "Longines", "Citizen" }));
        getContentPane().add(timthuonghieu);
        timthuonghieu.setBounds(30, 380, 150, 40);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel7.setText("(Tìm theo tên sản phẩm)");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 350, 130, 20);
        getContentPane().add(timdongho);
        timdongho.setBounds(30, 320, 150, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Tìm kiếm sản phẩm");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 280, 160, 40);

        thoat1.setText("Thoát");
        thoat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thoat1ActionPerformed(evt);
            }
        });
        getContentPane().add(thoat1);
        thoat1.setBounds(620, 540, 72, 40);

        jLabel2.setBackground(new java.awt.Color(27, 69, 25));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("     THỐNG KÊ VÀ TÌM KIẾM");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 2, 740, 50);

        bangketqua.setColumns(20);
        bangketqua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bangketqua.setRows(5);
        jScrollPane2.setViewportView(bangketqua);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(260, 410, 320, 160);

        bang1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên đồng hồ", "Thương hiệu", "Giá", "Đã bán", "Số lượng ", "Ngày nhập hàng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bang1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bang1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 50, 740, 230);

        jLabel1.setBackground(new java.awt.Color(185, 199, 185));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-3, -4, 750, 610);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void thoat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thoat1ActionPerformed
        // TODO add your handling code here:
     this.dispose();
    }//GEN-LAST:event_thoat1ActionPerformed

    private void timActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timActionPerformed
        // TODO add your handling code here:    
        // các tiêu chí tìm kiếm từ các ô nhập liệu và cb box
    String tenDongHoSearch = timdongho.getText().trim(); 
    String thuongHieuSearch = (String) timthuonghieu.getSelectedItem(); 
    String mucGiaSearch = (String) timmucgia.getSelectedItem(); 

    // Tạo danh sách các bộ lọc 
    List<RowFilter<Object, Object>> filters = new ArrayList<>();

    // bộ lọc theo Tên đồng hồ 
    if (!tenDongHoSearch.isEmpty()) {
        // Regex filter là case-insensitive, Pattern.quote xử lý các ký tự đặc biệt trong chuỗi tìm kiếm
        filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(tenDongHoSearch), 1)); 
    }

    // Kiểm tra chọn một thương hiệu cụ thể chưa khác với mục mặc định Chọn thương hiệu
    if (thuongHieuSearch != null && !thuongHieuSearch.equals("Chọn thương hiệu")) {
        filters.add(RowFilter.regexFilter("(?i)" + Pattern.quote(thuongHieuSearch), 2));
    }

    // giá cần parse để lọc theo khoảng số, tạo một RowFilter tùy chỉnh hoặc parse giá trị, bảng hiển thị chuỗi định dạng;
    // tạo một RowFilter tùy chỉnh trên việc parse giá trị string.
    if (mucGiaSearch != null && !mucGiaSearch.equals("Chọn mức giá")) {
        // Xác định khoảng giá min,max dựa trên lựa chọn
        double minGia = 0;
        double maxGia = Double.MAX_VALUE; 
        boolean validRange = true;

        if (mucGiaSearch.equals("Dưới 2 triệu")) {
            minGia = 0;
            maxGia = 2000000;
        } else if (mucGiaSearch.equals("Từ 5 - 10 triệu")) {
            minGia = 5000000;
            maxGia = 10000000;
        } else if (mucGiaSearch.equals("Từ 10 - 50 triệu")) {
            minGia = 10000000;
            maxGia = 50000000;
        } else {
            validRange = false; // Không dùng filter nếu chọn mặc định
        }
        
        if (validRange) {
             final double fMinGia = minGia; // Cần final cho lớp ẩn danh
             final double fMaxGia = maxGia;

             // RowFilter lọc theo khoảng giá
             filters.add(new RowFilter<Object, Object>() {
                 DecimalFormat parser = new DecimalFormat("#,##0.###"); 

                 @Override
                 public boolean include(RowFilter.Entry<? extends Object, ? extends Object> entry) {
                     Object giaObj = entry.getValue(3); // Lấy giá trị ở cột gia

                     if (giaObj == null) {
                         return false; 
                     }
                     try {
                         // giá trị string sang double
                         Number number = parser.parse(giaObj.toString().trim());
                         double gia = number.doubleValue();

                         // Kiểm tra giá có nằm trong khoảng đã chọn không
                         return gia >= fMinGia && gia <= fMaxGia;
                     } catch (ParseException ex) {
                         // Nếu không parse được giá, dòng đó không hợp lệ và không được hiển thị
                         System.err.println("Lỗi parse giá khi lọc: " + giaObj + ". Chi tiết: " + ex.getMessage());
                         return false; 
                     }
                 }
             });
         }
    }

    // Áp dụng các bộ lọc đã tạo
    if (filters.isEmpty()) {
        // Nếu không có tiêu chí tìm kiếm, reset hiển thị tất cả
        sorter.setRowFilter(null);
    } else {
        // Kết hợp tất cả các bộ lọc lại và dùng tất cả tiêu chí
        RowFilter<Object, Object> combinedFilter = RowFilter.andFilter(filters);
        sorter.setRowFilter(combinedFilter);
        int ketQuaCount = sorter.getViewRowCount(); // Lấy số lượng dòng hiển thị sau khi lọc

        if (ketQuaCount > 0) {
            JOptionPane.showMessageDialog(this, "Tìm thấy " + ketQuaCount + " sản phẩm phù hợp.", "Tìm kiếm thành công", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm nào phù hợp với tiêu chí tìm kiếm.", "Không tìm thấy", JOptionPane.INFORMATION_MESSAGE);
        
        }
    }
    // Xóa kết quả tính toán cũ sau khi tìm kiếm/lọc
    bangketqua.setText("");
    }//GEN-LAST:event_timActionPerformed

    private void tinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tinhActionPerformed
        // TODO add your handling code here:
    bangketqua.setText(""); // Reset kết quả trước khi tính toán mới
    String luaChon = (String) tinhtoan.getSelectedItem();
    StringBuilder ketQua = new StringBuilder();
    DecimalFormat parser = new DecimalFormat("#,##0.###"); // Parser để đọc số từ chuỗi (ví dụ: giá)

    if (luaChon == null) {
        ketQua.append("Vui lòng chọn một loại thống kê.");
        bangketqua.setText(ketQua.toString());
        return;
    }

    if (luaChon.equals("Thống kê sau khi lọc")) {
        // Lấy thông tin bộ lọc hiện tại để hiển thị
        String thuongHieuChon = (String) timthuonghieu.getSelectedItem();
        if (timthuonghieu.getSelectedIndex() == 0 || "Chọn thương hiệu".equals(thuongHieuChon)) {
            thuongHieuChon = "Tất cả"; // để trống tùy theo yêu cầu hiển thị
        }

        String mucGiaChon = (String) timmucgia.getSelectedItem();
        if (timmucgia.getSelectedIndex() == 0 || "Chọn mức giá".equals(mucGiaChon)) {
            mucGiaChon = "Tất cả"; // để trống
        }

        int soMauTimThay = bang1.getRowCount(); // Số lượng hàng hiển thị trong bảng (đã lọc)
        double tongDoanhThuLoc = 0;
        int tongDaBanLoc = 0;
        int tongSoLuongGocLoc = 0; // Giả định cột "Số lượng" là số lượng gốc/ban đầu

        // Lặp qua các hàng ĐANG HIỂN THỊ trong bảng (dữ liệu đã lọc)
        for (int i = 0; i < soMauTimThay; i++) {
            try {
                // Lấy giá trị từ các cột của hàng đang hiển thị (view row)
                Object giaObj = bang1.getValueAt(i, 3);        // Cột "Giá" (index 3)
                Object daBanObj = bang1.getValueAt(i, 4);      // Cột "Đã bán" (index 4)
                Object soLuongGocObj = bang1.getValueAt(i, 5); // Cột "Số lượng " (index 5) - giả định là số lượng gốc

                // Kiểm tra null hoặc rỗng trước khi parse
                if (giaObj == null || daBanObj == null || soLuongGocObj == null ||
                    giaObj.toString().trim().isEmpty() ||
                    daBanObj.toString().trim().isEmpty() ||
                    soLuongGocObj.toString().trim().isEmpty()) {
                    System.err.println("Thống kê sau lọc: Dữ liệu rỗng/null ở dòng view " + i + ". Bỏ qua.");
                    continue; 
                }

                // Parse giá trị
                Number number = parser.parse(giaObj.toString().trim());
                double gia = number.doubleValue();
                int daban = Integer.parseInt(daBanObj.toString().trim());
                int soluongGoc = Integer.parseInt(soLuongGocObj.toString().trim());

                // Kiểm tra tính hợp lệ của dữ liệu (số lượng bán không thể lớn hơn số lượng gốc)
                if (daban < 0 || soluongGoc < 0) {
                     System.err.println("Thống kê sau lọc: Số âm không hợp lệ cho đã bán hoặc số lượng ở dòng view " + i + ". Bỏ qua.");
                     continue;
                }


                // Tính toán cho thống kê sau lọc
                tongDoanhThuLoc += gia * daban;
                tongDaBanLoc += daban;
                tongSoLuongGocLoc += soluongGoc;

            } catch (ParseException | NumberFormatException ex) {
                System.err.println("Thống kê sau lọc: Lỗi parse dữ liệu ở dòng view " + i + ". Chi tiết: " + ex.getMessage());
                // Thông báo cho người dùng hoặc bỏ qua dòng bị lỗi
            }
        }

        double tyLeTieuThuLoc = 0;
        if (tongSoLuongGocLoc > 0) { // Tránh chia cho 0
            tyLeTieuThuLoc = ((double) tongDaBanLoc / tongSoLuongGocLoc) * 100;
        } else if (tongDaBanLoc > 0 && tongSoLuongGocLoc == 0) {
             // Trường hợp bán được hàng nhưng số lượng gốc ghi là 0 (dữ liệu có vấn đề)
            System.err.println("Thống kê sau lọc: Có sản phẩm đã bán nhưng tổng số lượng gốc là 0.");
            // tyLeTieuThuLoc có thể để là 0 hoặc một giá trị đặc biệt như NaN, hoặc hiển thị "N/A"
        }


        // Xây dựng chuỗi kết quả
        ketQua.append("Thương hiệu: ").append(thuongHieuChon).append(" | Tầm giá: ").append(mucGiaChon).append("\n");
        ketQua.append("Số mẫu tìm thấy: ").append(soMauTimThay).append("\n");
        ketQua.append("Tổng doanh thu: ").append(String.format("%,.0f", tongDoanhThuLoc)).append(" VNĐ\n");
        ketQua.append("Tỷ lệ tiêu thụ: ").append(String.format("%.2f", tyLeTieuThuLoc)).append("%");

    } else {
        // Các tính toán này dựa trên originalModel (all dữ liệu)
        double tongDoanhThuGlobal = 0;
        double tongGiaTriTonKhoGlobal = 0;
        int tongHangConLaiGlobal = 0;

        // Lặp qua TOÀN BỘ DỮ LIỆU GỐC trong originalModel
        for (int i = 0; i < originalModel.getRowCount(); i++) {
            try {
                Object giaObj = originalModel.getValueAt(i, 3); 
                Object daBanObj = originalModel.getValueAt(i, 4);
                Object soLuongObj = originalModel.getValueAt(i, 5); // "Số lượng " (ví dụ là số lượng gốc,ban đầu)

                if (giaObj == null || daBanObj == null || soLuongObj == null || 
                    giaObj.toString().trim().isEmpty() || 
                    daBanObj.toString().trim().isEmpty() || 
                    soLuongObj.toString().trim().isEmpty()) {
                    System.err.println("Global stats: Dữ liệu rỗng/null ở dòng model " + i + ". Bỏ qua.");
                    continue;
                }

                Number number = parser.parse(giaObj.toString().trim());
                double gia = number.doubleValue();
                int daban = Integer.parseInt(daBanObj.toString().trim());
                int soluong = Integer.parseInt(soLuongObj.toString().trim());

                if (soluong < daban) {
                    System.err.println("Global stats: Lỗi dữ liệu - Số lượng (" + soluong + ") < Đã bán (" + daban + ") ở dòng model " + i + ". Bỏ qua dòng này.");
                    continue; 
                }
                 if (daban < 0 || soluong < 0) {
                     System.err.println("Global stats: Số âm không hợp lệ cho đã bán hoặc số lượng ở dòng model " + i + ". Bỏ qua.");
                     continue;
                }

                tongDoanhThuGlobal += gia * daban;
                tongGiaTriTonKhoGlobal += gia * (soluong - daban); // Giá trị hàng tồn kho
                tongHangConLaiGlobal += (soluong - daban);       // Số lượng hàng còn lại

            } catch (ParseException | NumberFormatException ex) {
                System.err.println("Global stats: Lỗi định dạng/parse ở dòng model " + i + ". Chi tiết: " + ex.getMessage());
            } catch (Exception ex) { // Bắt các lỗi không xác định 
                System.err.println("Global stats: Lỗi không xác định khi xử lý dòng model " + i + ": " + ex.getMessage());
            }
        }

        // Hiển thị kết quả thống kê tổng thể dựa trên luaChon
        if (luaChon.equals("Tính tất cả")) {
            ketQua.append("Tổng doanh thu: ").append(String.format("%,.0f", tongDoanhThuGlobal)).append(" VNĐ\n");
            ketQua.append("Tổng giá trị tồn kho: ").append(String.format("%,.0f", tongGiaTriTonKhoGlobal)).append(" VNĐ\n");
            ketQua.append("Tổng lượng hàng còn lại: ").append(tongHangConLaiGlobal);
        } else if (luaChon.equals("Tổng doanh thu")) {
            ketQua.append("Tổng doanh thu: ").append(String.format("%,.0f", tongDoanhThuGlobal)).append(" VNĐ");
        } else if (luaChon.equals("Tổng giá trị tồn kho")) {
            ketQua.append("Tổng giá trị tồn kho: ").append(String.format("%,.0f", tongGiaTriTonKhoGlobal)).append(" VNĐ");
        } else if (luaChon.equals("Tính lượng hàng còn lại")) {
            ketQua.append("Tổng lượng hàng còn lại: ").append(tongHangConLaiGlobal);
        } else if (luaChon.trim().isEmpty()) { // Xử lý mục rỗng trong combobox
             ketQua.append("Vui lòng chọn một loại thống kê hợp lệ.");
        } else {
            // Trường hợp lựa chọn không hợp lệ khác 
            ketQua.append("Lựa chọn thống kê không hợp lệ: ").append(luaChon);
        }
    }
    bangketqua.setText(ketQua.toString());
        
    }//GEN-LAST:event_tinhActionPerformed
private void bang1MouseClicked(java.awt.event.MouseEvent evt) {
    
}
    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        if (sorter != null) {
            sorter.setRowFilter(null);
        }
        // Đặt lại các trường tìm kiếm về giá trị mặc định
        timdongho.setText("");
        timthuonghieu.setSelectedIndex(0); // Chọn "Tất cả thương hiệu"
        timmucgia.setSelectedIndex(0);    // Chọn "Tất cả mức giá"
        // Xóa kết quả tính toán cũ
        bangketqua.setText("");
   
    }//GEN-LAST:event_resetActionPerformed

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
            java.util.logging.Logger.getLogger(Giao_dien_chính.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Giao_dien_chính.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Giao_dien_chính.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Giao_dien_chính.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Giao_dien_chính().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bang1;
    private javax.swing.JTextArea bangketqua;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton reset;
    private javax.swing.JButton thoat1;
    private javax.swing.JButton tim;
    private javax.swing.JTextField timdongho;
    private javax.swing.JComboBox<String> timmucgia;
    private javax.swing.JComboBox<String> timthuonghieu;
    private javax.swing.JButton tinh;
    private javax.swing.JComboBox<String> tinhtoan;
    // End of variables declaration//GEN-END:variables

}
