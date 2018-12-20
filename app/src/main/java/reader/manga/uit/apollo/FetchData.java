package reader.manga.uit.apollo;

import java.util.Objects;

import apollographql.apollo.MangaQuery;
import apollographql.apollo.MangasQuery;
import io.realm.Realm;
import io.realm.RealmList;
import model.model.Chapter;
import model.model.Genre;
import model.model.Image;
import model.model.Manga;
import reader.manga.uit.activity.AppActivity;
import reader.manga.uit.apollo.ApolloClientHelper.OnFailure;
import reader.manga.uit.utils.Callback;

public class FetchData {
    public static void FetchMangas(AppActivity activity, Realm realm) {
        FetchMangas(activity, realm, null, null, null);
    }

    public static void FetchMangas(AppActivity activity, Realm realm, Callback onSuccess, OnFailure onFail, Callback after) {
        ApolloClientHelper.Query(
                activity,
                MangasQuery.builder().build(),
                response -> {
                    realm.executeTransaction(r -> {
                        assert response.data() != null;

                        realm.where(Manga.class).findAll().deleteAllFromRealm();
                        response.data().mangas().forEach(manga -> {
                            final Manga m = new Manga();

                            m.setId(manga.id());
                            m.setName(manga.name());
                            m.setAuthors(manga.authors());
                            m.setDescription(manga.description());
                            m.setStatus(manga.status().ordinal());
                            m.setImageUrl(manga.image().url());

                            final RealmList<Genre> genres = m.getGenres();
                            manga.genres().forEach(rawGenre -> {
                                final Genre genre = new Genre();
                                genre.setName(rawGenre.name());

                                final Genre g = r.copyToRealmOrUpdate(genre);

                                genres.add(g);
                            });

                            r.copyToRealmOrUpdate(m);
                        });
                    });
                    if (onSuccess != null) onSuccess.call();
                    if (after != null) after.call();
                },
                e -> {
                    if (onFail != null) onFail.call(e);
                    if (after != null) after.call();
                }
        );
    }

    public static void FetchManga(AppActivity activity, Realm realm, int id) {
        FetchManga(activity, realm, id, null, null, null);
    }

    public static void FetchManga(AppActivity activity, Realm realm, int id, Callback onSuccess, OnFailure onFail, Callback after) {
        ApolloClientHelper.Query(
                activity,
                MangaQuery.builder().id(id).build(),
                response -> {
                    realm.executeTransaction(r -> {
                        assert response.data() != null;
                        MangaQuery.Manga manga = Objects.requireNonNull(response.data().manga());

                        Manga m = r.where(Manga.class).equalTo("id", manga.id()).findFirst();
                        if (m == null) {
                            m = new Manga();
                            m.setId(manga.id());
                        }

                        for (Chapter c : m.getChapters()) {
                            c.getImages().deleteAllFromRealm();
                            c.deleteFromRealm();
                        }

                        m.setName(manga.name());
                        m.setAuthors(manga.authors());
                        m.setDescription(manga.description());
                        m.setStatus(manga.status().ordinal());
                        m.setImageUrl(manga.image().url());

                        final RealmList<Genre> genres = m.getGenres();
                        manga.genres().forEach(genre -> {
                            Genre g = new Genre();
                            g.setName(genre.name());
                            g = r.copyToRealmOrUpdate(g);
                            genres.add(g);
                        });

                        for (MangaQuery.Chapter chapter : manga.chapters()) {
                            final Chapter c = new Chapter();
                            c.setId(chapter.id());
                            c.setName(chapter.name());
                            c.setManga(m);
                            final Chapter chapterInRealm = r.copyToRealmOrUpdate(c);

                            chapter.images().forEach(image -> {
                                Image i = new Image();
                                i.setId(image.id());
                                i.setName(image.name());
                                i.setHeight(image.height());
                                i.setWidth(image.width());
                                i.setUrl(image.url());
                                i.setChapter(chapterInRealm);
                                r.copyToRealmOrUpdate(i);
                            });
                        }

                        r.copyToRealmOrUpdate(m);
                    });
                    if (onSuccess != null) onSuccess.call();
                    if (after != null) after.call();
                },
                e -> {
                    if (onFail != null) onFail.call(e);
                    if (after != null) after.call();
                }
        );
    }
}
