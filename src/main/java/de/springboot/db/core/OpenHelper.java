package db.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by zdebskyi on 27.01.17.
 */
public class OpenHelper {
    Connection connection = null;
    Statement stmt = null;

    public Statement getStmt() {
        return stmt;
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement connectDB() {

        try {
            Class.forName("org.postgresql.Driver");
            String nameBD = "zdebskyi";
            connection = DriverManager
//                    .getConnection("jdbc:postgresql://xfuzhwmbcdpytz:-50012RYkHCbWnZSvOY3p2PtcC@ec2-54-217-231-152.eu-west-1.compute.amazonaws.com:5432/dfharpin4q0e8s",
//                            "xfuzhwmbcdpytz", "-50012RYkHCbWnZSvOY3p2PtcC");
                    .getConnection("jdbc:postgresql://localhost:5432/db" + nameBD,
                            nameBD, "1111");

            connection.setAutoCommit(false);

            System.out.println("Opened database successfully");


            stmt = connection.createStatement();
        } catch (SQLException e) {e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
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
