package reader.manga.uit.adapter;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.realm.RealmRecyclerViewAdapter;
import model.model.Chapter;
import model.model.Manga;
import reader.manga.uit.R;
import reader.manga.uit.activity.AppActivity;
import reader.manga.uit.activity.ChapterDetailActivity;
import reader.manga.uit.databinding.ItemChapterBinding;

public class ChapterRecyclerViewAdapter extends RealmRecyclerViewAdapter<Chapter, ChapterRecyclerViewAdapter.ViewHolder> {
    public ChapterRecyclerViewAdapter(Manga manga) {
        super(manga.getChapters().sort("name"), true);
    }

    public static ChapterRecyclerViewAdapter getInstance(Manga manga) {
        return new ChapterRecyclerViewAdapter(manga);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemChapterBinding viewDataBinding = DataBindingUtil.inflate(
                layoutInflater,
                R.layout.item_chapter,
                parent, false
        );
        return new ViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemChapterBinding binding;

        ViewHolder(ItemChapterBinding binding) {
            super(binding.getRoot());
            binding.getRoot().setLayoutParams(new RecyclerView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            this.binding = binding;
        }

        void bind(Chapter chapter) {
            binding.setChapter(chapter);
            binding.setState(new State(chapter));
            binding.executePendingBindings();
        }
    }

    public static class State {
        private Chapter chapter;

        State(Chapter chapter) {
            this.chapter = chapter;
        }

        public void select(View view) {
            AppActivity activity = (AppActivity) view.getContext();

            final Intent intent = new Intent(activity, ChapterDetailActivity.class);
            intent.putExtra(ChapterDetailActivity.CHAPTER_ID, chapter.getId());

            activity.startActivity(intent);
        }
    }
}