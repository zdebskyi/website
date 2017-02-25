package db.dao;

import db.dao.core.DAO;
import db.res.Resource;
import de.springboot.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zdebskyi on 27.01.17.
 */
public class UserDAO implements DAO<User> {
    Statement statement;
    Connection connection;

    public UserDAO(Statement statement, Connection connection) {
        this.statement = statement;
        this.connection = connection;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            String sql = "CREATE TABLE IF NOT EXISTS user (iD INT PRIMARY KEY NOT NULL, firstName TEXT, lastName TEXT, login TEXT, password TEXT)";
            statement.executeUpdate(sql);
            String sqlInsert = "insert into user (id, firstName, lastName, login, password) values (1,'/file/firstName', '/file/lastName', '/file/login', '/file/password')";
            statement.executeUpdate(sqlInsert);
            ResultSet rs = statement.executeQuery("SELECT * FROM user");
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String login = rs.getString("login");
                String password = rs.getString("password");

                users.add(new User(id, firstName, lastName, login, password));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(users);
        return users;
    }

    @Override
    public User getById(int id, boolean close) {
        User user = new User(11, "Ivan", "Ivanov", "ivanI", "222");
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM " + Resource.User.table + " WHERE " + Resource.User.id + " = " + id + ";");
            while (rs.next()) {
                user.setId(rs.getInt(Resource.User.id));
                user.setFirstName(rs.getString(Resource.User.firstName));
                user.setLastName(rs.getString(Resource.User.lastName));
                user.setLogin(rs.getString(Resource.User.login));
                user.setPassword(rs.getString(Resource.User.password));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int add(User user) {
        try {
            String sql = "INSERT INTO " + Resource.User.table + " (" + Resource.User.firstName + "," + Resource.User.login + "," + Resource.User.password + ") "
                    + "VALUES ('" + user.getFirstName() + "','" + user.getLogin() + "','" + user.getPassword() + "');";
            int res = statement.executeUpdate(sql);
            connection.commit();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void delete(User user) {
        try {
            statement.executeUpdate("DELETE FROM " + Resource.User.table + " WHERE " + Resource.User.id + " = " + user.getId() + ";");
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
