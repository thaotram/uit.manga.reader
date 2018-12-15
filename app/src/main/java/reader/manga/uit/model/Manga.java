package reader.manga.uit.model;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Manga extends RealmObject {
    @PrimaryKey
    private int id;
    private String name;
    private RealmList<String> associatedNames;
    private int type;
    private int status;
    private Date publishedFrom;
    private Date publishedTo;
    private RealmList<Genre> genres;
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

    public void setAssociatedNames(RealmList<String> associatedNames) {
        this.associatedNames = associatedNames;
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

    public void setGenres(RealmList<Genre> genres) {
        this.genres = genres;
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
}
