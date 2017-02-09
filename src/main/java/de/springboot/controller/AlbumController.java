package de.springboot.controller;

import db.dao.AlbumDAO;
import db.service.AlbumService;
import de.springboot.model.Album;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by zdebskyi on 27.01.17.
 */
@RestController
public class AlbumController {

    private AlbumDAO albumTemplate;

    @RequestMapping("/album")
    public ResponseEntity<List<Album>> subTypeGetId(@RequestParam(value = "id", defaultValue = "0") String id) {
        if (id.equals("0")) {
            return new ResponseEntity<>(new AlbumService().getAll(), HttpStatus.OK);
        }
        List<Album> albums = new ArrayList<>();
        albums.add(new AlbumService().getById(id));
        if (albums.get(0).getPath() != null )
            return new ResponseEntity<>(albums, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity newAlbum(String[] base64s, int idPlace) {
        try
        {
            for(String base64 : base64s) {
                byte[] albumByte = Base64.decodeBase64(base64);

                String albumName = new Date().getTime() +
                        new Random().nextInt(255) + ".jpg";

                new FileOutputStream("src/main/resources/images/" + albumName).write(albumByte);

                Album album = new Album("images/" + albumName, idPlace);

                albumTemplate.add(album);
            }
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }


}
