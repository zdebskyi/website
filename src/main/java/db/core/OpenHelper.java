package db.core;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by zdebskyi on 27.01.17.
 */
public class OpenHelper {
    Connection connection = null;
    Statement stmt = null;
    Driver driver;

    public Statement getStmt() {
        return stmt;
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement connectDB() {

        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?useSSL=false", "root", "1111");
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = connection.createStatement();
            stmt.executeQuery("select * from myDataBase");

        } catch (SQLException e) {e.printStackTrace();
        }
        return stmt;
    }

    public void closeDB() {
        try {
            if (connection != null && stmt != null && !connection.isClosed()
                    && !stmt.isClosed()) {
                connection.close();
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
