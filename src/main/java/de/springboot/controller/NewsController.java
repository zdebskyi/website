package de.springboot.controller;

import db.service.NewsService;
import de.springboot.model.News;
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
public class NewsController {
    @RequestMapping("/news")
    public ResponseEntity<List<News>> subTypeGetId(@RequestParam(value = "id", defaultValue = "0") String id) {
        if (id.equals("0")) {
            return new ResponseEntity<>(new NewsService().getAll(), HttpStatus.OK);
        }
        List<News> newss = new ArrayList<>();
        newss.add(new NewsService().getById(id));
        if (newss.get(0).getPath() != null && newss.get(0).getPath() != null)
            return new ResponseEntity<>(newss, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
