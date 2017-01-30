package db.service;

import db.core.OpenHelper;
import db.dao.UserDAO;
import db.service.core.Service;
import de.springboot.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zdebskyi on 27.01.17.
 */
public class UserService extends OpenHelper implements Service<User> {
    @Override
    public List<User> getAll() {
        try {
            connectDB();
            if (!getStmt().isClosed()) {
                return new UserDAO(getStmt(), getConnection()).getAll();
            }
        } catch (SQLException e) {
        } finally {
            closeDB();
        }
        return null;
    }


    @Override
    public User getById(String id) {
        try {
            connectDB();
            if (!getStmt().isClosed()) {
                return new UserDAO(getStmt(), getConnection()).getById(Integer.parseInt(id), true);
            }
        } catch (SQLException e) {
        } finally {
            closeDB();
        }
        return null;
    }

    @Override
    public int add(User user) {
        try {
            connectDB();
            if (!getStmt().isClosed()) {
                return new UserDAO(getStmt(), getConnection()).add(user);
            }
        } catch (SQLException e) {
        } finally {
            closeDB();
        }
        return 0;
    }

    @Override
    public void delete(User user) {
        try {
            connectDB();
            if (!getStmt().isClosed()) {
                new UserDAO(getStmt(), getConnection()).delete(user);
            }
        } catch (SQLException e) {
        } finally {
            closeDB();
        }

    }
}
