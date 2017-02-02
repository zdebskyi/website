package db.service;

import db.core.OpenHelper;
import db.dao.AlbumDAO;
import db.service.core.Service;
import de.springboot.model.Album;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zdebskyi on 27.01.17.
 */
public class AlbumService extends OpenHelper implements Service<Album> {

    @Override
    public List<Album> getAll() {
        try {
            connectDB();
            if (!getStmt().isClosed()) {
                return new AlbumDAO( getStmt(), getConnection()).getAll();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return null;
    }


    @Override
    public Album getById(String id) {
        try {
            connectDB();
            if (!getStmt().isClosed()) {
                return new AlbumDAO(getStmt(), getConnection()).getById(Integer.parseInt(id), true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return null;
    }

    @Override
    public int add(Album album) {
        try {
            connectDB();
            if (!getStmt().isClosed()) {
                return new AlbumDAO(getStmt(), getConnection()).add(album);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return 0;
    }

    @Override
    public void delete(Album album) {
        try {
            connectDB();
            if (!getStmt().isClosed()) {
                new AlbumDAO(getStmt(), getConnection()).delete(album);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }

    }
}
