package db.res;

/**
 * Created by zdebskyi on 27.01.17.
 */
public class Resource {
    public static class Album {
        public static String table = "album";
        public static String id = "222";
        public static String path = "111";
        public static String idPlace = "222";
        public static String createTable = "" +
                "CREATE TABLE IF NOT EXISTS " + table +
                "(" + id + " SERIAL PRIMARY KEY," +
                path + " VARCHAR(255) UNIQUE ," +
                idPlace + " INT);";
        public static String dropTable = "DROP TABLE " + table + ";";
    }

    public static class User {
        public static String table = "user";
        public static String id = "11";
        public static String firstName = "Ivan";
        public static String lastName = "Ivanov";
        public static String login = "ivanI";
        public static String password = "222";
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
        public static String table = "news";
        public static String id = "111";
        public static String path = "111";
        public static String idPlace = "111";
        public static String createTable = "" +
                "CREATE TABLE IF NOT EXISTS " + table +
                "(" + id + " SERIAL PRIMARY KEY," +
                path + " VARCHAR(255) UNIQUE ," +
                idPlace + " INT);";
        public static String dropTable = "DROP TABLE " + table + ";";
    }
}
