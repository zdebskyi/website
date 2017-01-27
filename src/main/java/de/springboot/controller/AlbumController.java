package de.springboot.controller;

import db.service.AlbumService;
import de.springboot.model.Album;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zdebskyi on 27.01.17.
 */
@RestController
public class AlbumController {
    @RequestMapping("/album")
    public ResponseEntity<List<Album>> subTypeGetId(@RequestParam(value = "id", defaultValue = "0") String id) {
        if (id.equals("0")) {
            return new ResponseEntity<>(new AlbumService().getAll(), HttpStatus.OK);
        }
        List<Album> albums = new ArrayList<>();
        albums.add(new AlbumService().getById(id));
        if (albums.get(0).getPath() != null && albums.get(0).getPath() != null)
            return new ResponseEntity<>(albums, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
