package reader.manga.uit.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;
import android.os.Bundle;
import android.view.View;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Observable;

import apollographql.apollo.MangasQuery;
import reader.manga.uit.R;
import reader.manga.uit.apollo.ApolloClientHelper;
import reader.manga.uit.databinding.ActivityMainBinding;

public class MainActivity extends AppActivity {
    public static final int LAYOUT = R.layout.activity_main;

    private State state = new State();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        initializeData();
        initializeDataBinding();
    }

    private void initializeData() {
        ApolloClient apolloClient = ApolloClientHelper.getInstance();

        apolloClient.query(
                MangasQuery.builder().build()
        ).enqueue(new ApolloCall.Callback<MangasQuery.Data>() {
            @Override
            public void onResponse(@NotNull Response<MangasQuery.Data> response) {
                final List<MangasQuery.Manga> mangas = response.data().mangas();
                state.theNumber.set(mangas.size());
            }

            @Override
            public void onFailure(@NotNull ApolloException e) {
                state.theNumber.set(-1);
            }
        });
    }

    private void initializeDataBinding() {
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, LAYOUT);
        binding.setState(state);
    }

    public void openDrawer(View view) {
        state.isOpenDrawer.set(true);
    }

    public class State extends Observable {
        public final ObservableBoolean isOpenDrawer = new ObservableBoolean(false);
        public final ObservableInt theNumber = new ObservableInt(0);
    }
}
