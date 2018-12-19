package model.model;

import android.text.TextUtils;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;
import io.realm.model_model_MangaRealmProxy;

@Parcel(implementations = {model_model_MangaRealmProxy.class},
        value = Parcel.Serialization.BEAN,
        analyze = {Manga.class})
public class Manga extends RealmObject {
    @LinkingObjects("manga")
    private final RealmResults<Chapter> chapters = null;
    @PrimaryKey
    private int id;
    private String name;
    private RealmList<String> associatedNames = new RealmList<>();
    private int type;
    private int status;
    private Date publishedFrom;
    private Date publishedTo;
    private RealmList<Genre> genres = new RealmList<>();
    private String authors;
    private String description;
    private String imageUrl;

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

    public RealmList<String> getAssociatedNames() {
        return associatedNames;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getPublishedFrom() {
        return publishedFrom;
    }

    public void setPublishedFrom(Date publishedFrom) {
        this.publishedFrom = publishedFrom;
    }

    public Date getPublishedTo() {
        return publishedTo;
    }

    public void setPublishedTo(Date publishedTo) {
        this.publishedTo = publishedTo;
    }

    public RealmList<Genre> getGenres() {
        return genres;
    }

    public String getGenresString() {
        List<String> list = new ArrayList<>();
        for (Genre genre : genres) {
            list.add(genre.getName());
        }
        return TextUtils.join(", ", list);
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public RealmResults<Chapter> getChapters() {
        return chapters;
    }
}
