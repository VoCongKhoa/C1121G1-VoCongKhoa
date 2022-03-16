package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/furama_management_system_database?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    private Connection connection;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
