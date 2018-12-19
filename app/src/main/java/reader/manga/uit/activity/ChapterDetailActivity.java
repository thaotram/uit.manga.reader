package reader.manga.uit.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import model.model.Chapter;
import reader.manga.uit.R;
import reader.manga.uit.databinding.ActivityChapterDetailBinding;

public class ChapterDetailActivity extends AppActivity {
    public static final int LAYOUT = R.layout.activity_chapter_detail;
    public static final String CHAPTER_ID = "CHAPTER_ID";
    private Chapter chapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        initializeData();
        initializeDataBinding();
    }

    private void initializeData() {
        final Intent intent = getIntent();
        int chapterId = intent.getIntExtra(CHAPTER_ID, -1);
        if (chapterId == -1) finish();
        chapter = realm.where(Chapter.class).equalTo("id", chapterId).findFirst();
        if (chapter == null) finish();
    }

    private void initializeDataBinding() {
        ActivityChapterDetailBinding binding = DataBindingUtil.setContentView(this, LAYOUT);
        binding.setChapter(chapter);
    }

    public void back(View view) {
        finish();
    }
}
