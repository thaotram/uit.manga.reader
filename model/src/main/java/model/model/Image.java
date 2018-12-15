package model.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Image extends RealmObject {
    @PrimaryKey
    private int id;
    private String name;
    private String url;
    private Chapter chapter;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }
}
