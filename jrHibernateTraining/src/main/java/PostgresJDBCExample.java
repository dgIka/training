import java.sql.*;

public class PostgresJDBCExample {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/javarush_training_db";
        String user = "postgres";
        String password = "ImodiumExpress1";

        try (Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from person")) {

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                String columnType = rsmd.getColumnTypeName(i);
                int nullable = rsmd.isNullable(i);

                System.out.println(columnName + "\t" + columnType + "\t" + nullable);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
