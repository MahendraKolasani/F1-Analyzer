import java.sql.*;
public class ConnectSQLite {
    public static void main(String[] args) {
        // Change this path to your actual DB file from DB Browser
        String url = "jdbc:sqlite:/home/mahikolasani/Documents/Projects/F1 Analyzer/F1";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Connected to SQLite DB!");

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT name FROm sqlite_master WHERE type='table'");

                while (rs.next()) {
                    System.out.println(rs.getString("name"));

                }
            }
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }
}
