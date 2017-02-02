package db.service;

import db.core.OpenHelper;
import db.dao.NewsDAO;
import db.service.core.Service;
import de.springboot.model.News;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zdebskyi on 27.01.17.
 */
public class NewsService extends OpenHelper implements Service<News> {

    @Override
    public List<News> getAll() {
        try {
            connectDB();
            if (!getStmt().isClosed()) {
                return new NewsDAO(getStmt(), getConnection()) .getAll();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {

        } finally {
            closeDB();
        }
        return null;
    }


    @Override
    public News getById(String id) {
        try {
            connectDB();
            if (!getStmt().isClosed()) {
                return new NewsDAO(getStmt(), getConnection()).getById(Integer.parseInt(id), true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
        } finally {
            closeDB();
        }
        return null;
    }

    @Override
    public int add(News news) {
        try {
            connectDB();
            if (!getStmt().isClosed()) {
                return new NewsDAO(getStmt(), getConnection()).add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
        } finally {
            closeDB();
        }
        return 0;
    }

    @Override
    public void delete(News news) {
        try {
            connectDB();
            if (!getStmt().isClosed()) {
                new NewsDAO(getStmt(), getConnection()).delete(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
        } finally {
            closeDB();
        }
    }
    }

