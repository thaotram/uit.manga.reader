package model.model;

import org.parceler.Parcel;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;
import io.realm.model_model_ChapterRealmProxy;

@Parcel(implementations = {model_model_ChapterRealmProxy.class},
        value = Parcel.Serialization.BEAN,
        analyze = {Chapter.class})
public class Chapter extends RealmObject {
    @PrimaryKey
    private int id;
    private String name;
    private Date date;
    private Manga manga;

    @LinkingObjects("chapter")
    private final RealmResults<Image> images = null;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Manga getManga() {
        return manga;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
    }

    public RealmResults<Image> getImages() {
        return images;
    }
}
