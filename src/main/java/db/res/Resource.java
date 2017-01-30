package db.res;

/**
 * Created by zdebskyi on 27.01.17.
 */
public class Resource {
    public static class Album {
        public static String table = "album";
        public static String id = "id";
        public static String path = "path";
        public static String idPlace = "id_place";
        public static String createTable = "" +
                "CREATE TABLE IF NOT EXISTS " + table +
                "(" + id + " SERIAL PRIMARY KEY," +
                path + " VARCHAR(255) UNIQUE ," +
                idPlace + " INT);";
        public static String dropTable = "DROP TABLE " + table + ";";
    }

    public static class User {
        public static String table = "customer";
        public static String id = "id";
        public static String firstName = "name";
        public static String lastName = "email";
        public static String login = "email";
        public static String password = "password";
        public static String createTable = "" +
                "CREATE TABLE IF NOT EXISTS " + table +
                "(" + id + " SERIAL PRIMARY KEY, " +
                firstName + " VARCHAR(255) UNIQUE, " +
                lastName + " VARCHAR(255) UNIQUE, " +
                login + " VARCHAR(255) UNIQUE, " +
                password + " VARCHAR(255));";
        public static String dropTable = "DROP TABLE " + table + ";";
    }

    public static class News {
        public static String table = "album";
        public static String id = "id";
        public static String path = "path";
        public static String idPlace = "id_place";
        public static String createTable = "" +
                "CREATE TABLE IF NOT EXISTS " + table +
                "(" + id + " SERIAL PRIMARY KEY," +
                path + " VARCHAR(255) UNIQUE ," +
                idPlace + " INT);";
        public static String dropTable = "DROP TABLE " + table + ";";
    }
}
