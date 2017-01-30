package db.dao;

import db.dao.core.DAO;
import db.res.Resource;
import de.springboot.model.Album;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zdebskyi on 27.01.17.
 */
public class AlbumDAO implements DAO<Album> {
    Statement statement;
    Connection connection;

    public AlbumDAO(Statement statement, Connection connection) {
        this.statement = statement;
        this.connection = connection;
    }


    @Override
    public List<Album> getAll() {
        List<Album> albums = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM " + Resource.Album.table + ";");
            while (rs.next()) {
                int id = rs.getInt(Resource.Album.id);
                String path = rs.getString(Resource.Album.path);
                int idP = rs.getInt(Resource.Album.idPlace);

                albums.add(new Album(id, path, idP));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return albums;
    }

    public List<Album> getListById(int idPlace, boolean close) {
        List<Album> albums = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM " + Resource.Album.table + " WHERE " + Resource.Album.idPlace + " = " + idPlace + ";");
            while (rs.next()) {
                int id = rs.getInt(Resource.Album.id);
                String path = rs.getString(Resource.Album.path);
                int idP = rs.getInt(Resource.Album.idPlace);

                albums.add(new Album(id, path, idP));
            }
            if (close)
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return albums;
    }

    @Override
    public Album getById(int id, boolean close) {
        Album album = new Album(222,"111",222);
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM " + Resource.Album.table + " WHERE " + Resource.Album.id + " = " + id + ";");
            if (rs.next()) {
                int idImage = rs.getInt(Resource.Album.id);
                String path = rs.getString(Resource.Album.path);
                int idP = rs.getInt(Resource.Album.idPlace);

                album.setId(idImage);
                album.setPath(path);
                album.setIdPlace(idP);
            }
            if (close)
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return album;
    }


    @Override
    public int add(Album album) {
        try {
            String sql = "INSERT INTO " + Resource.Album.table + " (" + Resource.Album.path + "," + Resource.Album.idPlace + ") "
                    + "VALUES ('" + album.getPath() + "', " + album.getIdPlace() + ");";
            int res = statement.executeUpdate(sql);
            connection.commit();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void delete(Album album) {
        try {
            statement.executeUpdate("DELETE FROM " + Resource.Album.table + " WHERE " + Resource.Album.id + "=" + album.getId() + ";");
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
