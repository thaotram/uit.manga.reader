package reader.manga.uit.activity;

import android.content.Context;
import android.os.Bundle;

import com.apollographql.apollo.ApolloClient;

import reader.manga.uit.R;

public class MainActivity extends AppActivity {
    private ApolloClient apolloClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apolloClient = getApolloClient();
        Context context = this;

//        apolloClient.query(
//                MangasQuery
//                        .builder().build()
//        ).enqueue(new ApolloCall.Callback<MangasQuery.Data>() {
//            @Override
//            public void onResponse(@NotNull Response<MangasQuery.Data> response) {
//                //ConstantConditions
//                final List<MangasQuery.Manga> mangas = response.data().mangas();
//
//                runOnUiThread(() -> OpenConfirm(
//                        context,
//                        "Số truyện trong hệ thống là: " + mangas.size(),
//                        (() -> {
//                        })
//                ));
//            }
//
//            @Override
//            public void onFailure(@NotNull ApolloException e) {
//            }
//        });
    }
}
