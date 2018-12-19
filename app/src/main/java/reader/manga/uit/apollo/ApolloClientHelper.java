package reader.manga.uit.apollo;

import android.support.v7.app.AppCompatActivity;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Query;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import org.jetbrains.annotations.NotNull;

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

    static <D extends Query.Data, T, V extends Query.Variables>
    void Query(AppCompatActivity activity,
               Query<D, T, V> build,
               OnResponse<T> __onResponse__
    ) {
        Query(activity, build, __onResponse__, error -> {
        });
    }

    static <D extends Query.Data, T, V extends Query.Variables>
    void Query(AppCompatActivity activity,
               Query<D, T, V> build,
               OnResponse<T> onResponse,
               OnFailure onFailure
    ) {
        INSTANCE
                .query(build)
                .enqueue(new ApolloCall.Callback<T>() {
                    @Override
                    public void onResponse(@NotNull Response<T> response) {
                        activity.runOnUiThread(() -> onResponse.call(response));
                    }

                    @Override
                    public void onFailure(@NotNull ApolloException e) {
                        activity.runOnUiThread(() -> onFailure.call(e));
                    }
                });
    }

    public interface OnResponse<T> {
        void call(@NotNull Response<T> response);
    }

    public interface OnFailure {
        void call(@NotNull ApolloException error);
    }
}
