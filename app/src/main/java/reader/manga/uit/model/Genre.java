package reader.manga.uit.model;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class Genre extends RealmObject {
    @PrimaryKey
    private String name;
    private String description;

    @LinkingObjects("genres")
    private final RealmResults<Manga> mangas = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RealmResults<Manga> getMangas() {
        return mangas;
    }
}
