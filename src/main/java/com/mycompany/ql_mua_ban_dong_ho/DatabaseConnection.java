package com.mycompany.ql_mua_ban_dong_ho;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class DatabaseConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/quanlidongho"; // Địa chỉ máy chủ XAMPP và tên CSDL
    private static final String USER = "root"; // Tên người dùng mặc định của MySQL trong XAMPP
    private static final String PASS = "";     

    /**
     * Phương thức để thiết lập và trả về một kết nối đến cơ sở dữ liệu.
     * @return Connection nếu kết nối thành công, hoặc null nếu có lỗi.
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Mở kết nối đến CSDL
            System.out.println("Đang cố gắng kết nối đến CSDL...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Kết nối CSDL thành công!");
            return conn;
        } catch (SQLException e) {
            // Xử lý lỗi liên quan đến CSDL 
            e.printStackTrace(); // In ra lỗi chi tiết 
            System.err.println("Lỗi kết nối CSDL: " + e.getMessage());
            return null; // Trả về null ko kn đc
        }
    }

    /**
     * Phương thức để đóng kết nối đến cơ sở dữ liệu.
     * @param conn Đối tượng Connection cần đóng.
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Đã đóng kết nối CSDL.");
            } catch (SQLException e) {
                e.printStackTrace(); // In ra lỗi chi tiết
                System.err.println("Lỗi khi đóng kết nối CSDL: " + e.getMessage());
            }
        }
    }
}
