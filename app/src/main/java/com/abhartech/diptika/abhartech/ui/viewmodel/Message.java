package com.abhartech.diptika.abhartech.ui.viewmodel;

/**
 * Created by Diptika on 06/09/16.
 */

public class Message {
    private int id;
    private int iconId;
    private String title;
    private String location;

    public Message(int id, int iconId, String title, String location) {
        this.id = id;
        this.iconId = iconId;
        this.title = title;
        this.location = location;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



}
