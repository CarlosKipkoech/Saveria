package com.moringaschool.newscout;
import io.realm.RealmObject;



public class Note extends RealmObject {
    private  String title;
    private String description;

    public Note() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
