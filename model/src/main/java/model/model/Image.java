package model.model;

import org.parceler.Parcel;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.model_model_ImageRealmProxy;

@Parcel(implementations = {model_model_ImageRealmProxy.class},
        value = Parcel.Serialization.BEAN,
        analyze = {Image.class})
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
