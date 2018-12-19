package reader.manga.uit.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.os.Bundle;
import android.view.View;

import java.util.Observable;

import model.model.Manga;
import reader.manga.uit.R;
import reader.manga.uit.databinding.ActivityMangaDetailBinding;

public class MangaDetailActivity extends AppActivity {
    public static final int LAYOUT = R.layout.activity_manga_detail;
    public static final String MANGA_ID = "MANGA_ID";
    private Manga manga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        initializeData();
        initializeDataBinding();
    }

    private void initializeData() {
        final Intent intent = getIntent();
        int mangaId = intent.getIntExtra(MANGA_ID, -1);
        if (mangaId == -1) finish();
        manga = realm.where(Manga.class).equalTo("id", mangaId).findFirst();
    }

    private void initializeDataBinding() {
        ActivityMangaDetailBinding binding = DataBindingUtil.setContentView(this, LAYOUT);
        binding.setManga(manga);
    }

    public void back(View view) {
        finish();
    }

    public class State extends Observable {
        public final ObservableBoolean isOpenDrawer = new ObservableBoolean(false);
    }
}
