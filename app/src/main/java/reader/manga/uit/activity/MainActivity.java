package reader.manga.uit.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.os.Bundle;
import android.view.View;

import java.util.Observable;

import reader.manga.uit.R;
import reader.manga.uit.apollo.FetchData;
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
        FetchData.FetchManga(this, realm);
    }

    private void initializeDataBinding() {
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, LAYOUT);
        binding.setState(state);
    }

    public void openDrawer(View view) {
        state.isOpenDrawer.set(true);
    }

    public void exit(View view) {
        finish();
    }

    public class State extends Observable {
        public final ObservableBoolean isOpenDrawer = new ObservableBoolean(false);
    }
}
