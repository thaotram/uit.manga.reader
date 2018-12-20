package reader.manga.uit.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import model.model.Manga;
import reader.manga.uit.R;
import reader.manga.uit.apollo.FetchData;
import reader.manga.uit.databinding.ActivityMangaDetailBinding;
import ui.Swipe;

public class MangaDetailActivity extends AppActivity {
    public static final int LAYOUT = R.layout.activity_manga_detail;
    public static final String MANGA_ID = "MANGA_ID";
    private Manga manga;
    private ActivityMangaDetailBinding binding;

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
        if (manga == null) {
            finish();
            return;
        }
        FetchData.FetchManga(this, realm, manga.getId(),
                () -> {
                    showToast(R.string.fetch_mangas_done);
                    binding.setManga(manga);
                },
                e -> showToast(R.string.fetch_mangas_fail),
                null
        );
    }

    private void initializeDataBinding() {
        binding = DataBindingUtil.setContentView(this, LAYOUT);
        binding.setManga(manga);
    }

    public void back(View view) {
        finish();
    }

    @SuppressWarnings("unused")
    public void onRefresh(Swipe swipe) {
        FetchData.FetchManga(this, realm, manga.getId(),
                () -> {
                    showToast(R.string.fetch_mangas_done);
                    binding.setManga(manga);
                },
                e -> showToast(R.string.fetch_mangas_fail),
                () -> swipe.setRefreshing(false)
        );
    }
}
