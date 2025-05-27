package java_web.connection;

import java.sql.CallableStatement;
import java.sql.Connection;

public class ConnectionDB {

    private static String URL = "jdbc:mysql://localhost:3306/quanlysanpham";
    private static String USER = "root";
    private static String PASSWORD = "a@1234";


    public static Connection openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return java.sql.DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(Connection conn, CallableStatement callst) {
        if (conn != null){
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (callst != null){
            try {
                callst.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
