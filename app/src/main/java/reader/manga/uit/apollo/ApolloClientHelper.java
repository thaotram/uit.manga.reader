package reader.manga.uit.apollo;

import com.apollographql.apollo.ApolloClient;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import reader.manga.uit.R;
import reader.manga.uit.app.App;

public class ApolloClientHelper {
    private static ApolloClient INSTANCE;

    public static void Initialize(App app) {
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
        INSTANCE = ApolloClient.builder()
                .serverUrl(app.getString(R.string.server_url))
                .okHttpClient(okHttpClient)
                .build();
    }

    public static ApolloClient getInstance() {
        return INSTANCE;
    }
}
