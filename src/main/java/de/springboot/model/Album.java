package de.springboot.model;

import java.io.Serializable;

/**
 * Created by zdebskyi on 27.01.17.
 */
public class Album implements Serializable{
    private int id;
    private String path;
    private int idPlace;

    public Album(int id, String path, int idPlace) {
        this.id = id;
        this.path = path;
        this.idPlace = idPlace;
    }
    public Album (String path, int idPlace){
        this.path=path;
        this.idPlace=idPlace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(int idPlace) {
        this.idPlace = idPlace;
    }
}
