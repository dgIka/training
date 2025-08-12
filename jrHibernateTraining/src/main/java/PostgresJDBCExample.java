import java.sql.*;

public class PostgresJDBCExample {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "ImodiumExpress1";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from person");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
