package db.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by zdebskyi on 27.01.17.
 */
public class OpenHelper {
//    Connection connection = null;
//    Statement stmt = null;
//
//    public Statement getStmt() {
//        return stmt;
//    }
//
//    public Connection getConnection() {
//        return connection;
//    }
//
//    public Statement connectDB() {
//
//        try {
//            Driver driver = new FabricMySQLDriver();
//            DriverManager.registerDriver(driver);
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?useSSL=false", "root", "1111");
//            connection.setAutoCommit(false);
//            System.out.println("Opened database successfully");
//            stmt = connection.createStatement();
//  //          stmt.executeQuery("select * from myDataBase");
//
//        } catch (SQLException e) {e.printStackTrace();
//        }
//        return stmt;
//    }
//
//    public void closeDB() {
//        try {
//            if (connection != null && stmt != null && !connection.isClosed()
//                    && !stmt.isClosed()) {
//                connection.close();
//                stmt.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

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

            String nameBD = "postgres";
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/" + nameBD,
                            nameBD, "11111");

            connection.setAutoCommit(false);


            System.out.println("Opened database successfully");


            stmt = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return stmt;
    }

    public void closeDB() {
        try {
            if (connection != null
                    && stmt != null
                    && !connection.isClosed()
                    && !stmt.isClosed()) {
                connection.close();
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
