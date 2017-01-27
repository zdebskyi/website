package db.dao;

import db.dao.core.DAO;
import db.res.Resource;
import de.springboot.model.News;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zdebskyi on 27.01.17.
 */
public class NewsDAO implements DAO<News> {
    Statement statement;
    Connection connection;

    public NewsDAO(Statement statement, Connection connection) {
        this.statement = statement;
        this.connection = connection;
    }


    @Override
    public List<News> getAll() {
        List<News> newss = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM " + Resource.News.table + ";");
            while (rs.next()) {
                int id = rs.getInt(Resource.News.id);
                String path = rs.getString(Resource.News.path);
                int idP = rs.getInt(Resource.News.idPlace);

                newss.add(new News(id, path, idP));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newss;
    }

    public List<News> getListById(int idPlace, boolean close) {
        List<News> images = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM " + Resource.News.table + " WHERE " + Resource.News.idPlace + " = " + idPlace + ";");
            while (rs.next()) {
                int id = rs.getInt(Resource.News.id);
                String path = rs.getString(Resource.News.path);
                int idP = rs.getInt(Resource.News.idPlace);

                images.add(new News(id, path, idP));
            }
            if (close)
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return images;
    }

    @Override
    public News getById(int id, boolean close) {
        News news = new News(111, "111", 111);
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM " + Resource.News.table + " WHERE " + Resource.News.id + " = " + id + ";");
            if (rs.next()) {
                int idImage = rs.getInt(Resource.News.id);
                String path = rs.getString(Resource.News.path);
                int idP = rs.getInt(Resource.News.idPlace);

                news.setId(idImage);
                news.setPath(path);
                news.setIdPlace(idP);
            }
            if (close)
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }


    @Override
    public int add(News news) {
        try {
            String sql = "INSERT INTO " + Resource.News.table + " (" + Resource.News.path + "," + Resource.News.idPlace + ") "
                    + "VALUES ('" + news.getPath() + "', " + news.getIdPlace() + ");";
            int res = statement.executeUpdate(sql);
            connection.commit();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void delete(News news) {
        try {
            statement.executeUpdate("DELETE FROM " + Resource.News.table + " WHERE " + Resource.News.id + "=" + news.getId() + ";");
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
