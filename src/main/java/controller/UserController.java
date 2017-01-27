package controller;

import model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zdebskyi on 27.01.17.
 */
@RestController
public class UserController {
    @RequestMapping("/user")
    public ResponseEntity<List<User>> subTypeGetId(@RequestParam(value = "id", defaultValue = "0") String id) {
        if (id.equals("0")) {
            return new ResponseEntity<>(new UserService().getAll(), HttpStatus.OK);
        }
        List<User> users = new ArrayList<>();
        users.add(new UserService().getById(id));
        if (users.get(0).getLogin() != null)
            return new ResponseEntity<>(users, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/add/user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> addUser(@RequestBody final User entity) {
        int res = new UserService().add(entity);
        if (res != 0)
            return new ResponseEntity<>(entity, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
