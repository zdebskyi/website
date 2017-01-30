package de.springboot;

import db.DBPostSql;
import de.springboot.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by zdebskyi on 27.01.17.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private UserController userController;











    @Override
    public void run(String... strings) throws Exception {

        userController.getClass();

    }

   public static void main (String [] args) throws Exception {
        new DBPostSql().createTable();
        SpringApplication.run(Application.class, args);
    }

}
