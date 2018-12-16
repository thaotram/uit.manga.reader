package reader.manga.uit.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.realm.Realm;
import io.realm.RealmRecyclerViewAdapter;
import model.model.Manga;
import reader.manga.uit.R;
import reader.manga.uit.databinding.ItemMangaBinding;

public class MangaRecyclerViewAdapter extends RealmRecyclerViewAdapter<Manga, MangaRecyclerViewAdapter.ViewHolder> {
    public MangaRecyclerViewAdapter() {
        super(Realm.getDefaultInstance().where(Manga.class).findAll(), true);
    }

    public static MangaRecyclerViewAdapter getInstance() {
        return new MangaRecyclerViewAdapter();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemMangaBinding viewDataBinding = DataBindingUtil.inflate(
                layoutInflater,
                R.layout.item_manga,
                parent, false
        );
        return new ViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemMangaBinding binding;

        ViewHolder(ItemMangaBinding binding) {
            super(binding.getRoot());
            binding.getRoot().setLayoutParams(new RecyclerView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            this.binding = binding;
        }

        void bind(Manga manga) {
//            manga.initialize();
            binding.setManga(manga);
            binding.setAction(new Action(manga));
            binding.executePendingBindings();
        }
    }

    public static class Action {
        private Manga manga;

        Action(Manga manga) {
            this.manga = manga;
        }

        public void select(View view) {
//            Manga.setCurrentWallet(manga);
//            Activity activity = (Activity) view.getContext();
//            activity.setResult(Activity.RESULT_OK);
//            activity.finish();
        }
    }
}