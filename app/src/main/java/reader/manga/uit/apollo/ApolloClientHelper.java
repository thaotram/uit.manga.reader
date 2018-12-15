package reader.manga.uit.apollo;

import com.apollographql.apollo.ApolloClient;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import reader.manga.uit.R;

public class ApolloClientHelper {
    private static final ApolloClient INSTANCE;

    static {
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
                .serverUrl(String.valueOf(R.string.server_url))
                .okHttpClient(okHttpClient)
                .build();
    }

    public static ApolloClient getInstance() {
        return INSTANCE;
    }
}
