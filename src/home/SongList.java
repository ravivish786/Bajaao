/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author VICKY
 */
public class SongList {
    private final SimpleStringProperty name;
    private final SimpleStringProperty title;
    private final SimpleStringProperty album;
    private final SimpleStringProperty time;
    private final SimpleStringProperty location;


    public SongList(String name, String  title, String album, String time ,String location) 
    {
        this.name = new SimpleStringProperty(name);
        this.title = new SimpleStringProperty(title);
        this.album = new SimpleStringProperty(album);
        this.time = new SimpleStringProperty(time);
        this.location = new SimpleStringProperty(location);
       
    }

    public String getName() {
        return name.get();
    }

    public String getTitle() {
        return title.get();
    }

    public String getAlbum() {
        return album.get();
    }

    public String getTime() {
        return time.get();
    }

    public String getLocation() {
        return location.get();
    }
    

    }
