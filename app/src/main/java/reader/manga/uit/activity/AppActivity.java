package reader.manga.uit.activity;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;

import com.apollographql.apollo.ApolloClient;

import io.realm.Realm;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@SuppressLint("Registered")
public class AppActivity extends AppCompatActivity {
    private ApolloClient apolloClient = null;

    private void setupApollo() {
        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .addInterceptor(chain -> {
                    final Request request = chain.request();
                    final Request.Builder builder = request.newBuilder().method(
                            request.method(),
                            request.body()
                    );
                    return chain.proceed(builder.build());
                })
                .build();
        apolloClient = ApolloClient.builder()
                .serverUrl("http://localhost:3000/api/graphql")
                .okHttpClient(okHttpClient)
                .build();
    }

    protected final Realm realm = Realm.getDefaultInstance();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    protected ApolloClient getApolloClient() {
        if (apolloClient == null) setupApollo();
        return apolloClient;
    }
}
