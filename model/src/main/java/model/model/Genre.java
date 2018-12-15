package model.model;

import org.parceler.Parcel;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;
import io.realm.model_model_GenreRealmProxy;

@Parcel(implementations = {model_model_GenreRealmProxy.class},
        value = Parcel.Serialization.BEAN,
        analyze = {Genre.class})
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
