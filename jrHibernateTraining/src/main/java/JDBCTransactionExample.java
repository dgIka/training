import java.sql.*;

public class JDBCTransactionExample {
    private static final String url = "jdbc:postgresql://localhost:5432/javarush_training_db";
    private static final String user = "postgres";
    private static final String password = "ImodiumExpress1";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            conn.setAutoCommit(false);
            System.out.println("Transaction started");
            System.out.println("Autocommit disabled");

            try {
                String insertPerson = "insert into person(first_name, second_name, birth_date) values (?, ?, ?)";

                try (PreparedStatement ps = conn.prepareStatement(insertPerson)) {
                    ps.setString(1, "Valeriy");
                    ps.setString(2, "Solovey");
                    ps.setDate(3, Date.valueOf("1966-11-18"));
                    int i = ps.executeUpdate();
                    if (i == 0) {
                        System.out.println("Insert failed");
                    }
                    System.out.println("Insert successful");

                }
            } catch (SQLException e) {
                throw new RuntimeException("Problem with SQL syntax.", e);
            }
            conn.commit();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
