package reader.manga.uit.apollo;

import apollographql.apollo.MangasQuery;
import io.realm.Realm;
import model.model.Manga;
import reader.manga.uit.activity.AppActivity;

public class FetchData {
    public static void FetchManga(AppActivity activity, Realm realm) {
        ApolloClientHelper.Query(
                activity,
                MangasQuery.builder().build(),
                response -> {
                    realm.executeTransaction(r -> {
                        assert response.data() != null;
                        response.data().mangas().forEach(manga -> {
                            final Manga m = new Manga();
                            m.setId(manga.id());
                            m.setName(manga.name());
                            m.setDescription(manga.description());
                            m.setStatus(manga.status().ordinal());
                            m.setImageUrl(manga.image().url());

                            r.copyToRealmOrUpdate(m);
                        });
                    });
                }
        );
    }
}
