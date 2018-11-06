package shoppinglist.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class JDBCConnection {

    private String driver = "com.mysql.jdbc.Driver";
    private String connectionURL = "jdbc:mysql://localhost:3306/java2" +
            "?verifyServerCertificate=false" +
            "&useSSL=true" +
            "&requireSSL=true";
    private String user = "root";
    private String password = "1234";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(connectionURL, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
