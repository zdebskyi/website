package db;

import db.core.OpenHelper;
import db.res.Resource;
import db.service.AlbumService;
import db.service.NewsService;
import db.service.UserService;
import de.springboot.model.Album;
import de.springboot.model.News;
import de.springboot.model.User;

import java.sql.Statement;

/**
 * Created by zdebskyi on 27.01.17.
 */
public class DBPostSql {

    public void createTable() {
        OpenHelper openHelper = new OpenHelper();
        try {
            Statement statement = openHelper.connectDB();

            statement.executeUpdate(Resource.Album.createTable);
            statement.executeUpdate(Resource.User.createTable);
            statement.executeUpdate(Resource.News.createTable);

            openHelper.getConnection().commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ":  -----  " + e.getMessage());
        } finally {
            openHelper.closeDB();
        }
        initInsert();
    }

    public void initInsert() {

        new UserService().add(new User(11, "Ivan", "Ivanov", "ivanI", "222"));
        new AlbumService().add(new Album(222,"111",222));
        new NewsService().add(new News(111, "111", 111));


    }
}
