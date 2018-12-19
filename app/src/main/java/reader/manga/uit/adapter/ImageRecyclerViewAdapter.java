package reader.manga.uit.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import io.realm.RealmRecyclerViewAdapter;
import model.model.Chapter;
import model.model.Image;
import reader.manga.uit.R;
import reader.manga.uit.databinding.ItemImageBinding;

public class ImageRecyclerViewAdapter extends RealmRecyclerViewAdapter<Image, ImageRecyclerViewAdapter.ViewHolder> {
    public ImageRecyclerViewAdapter(Chapter chapter) {
        super(chapter.getImages().sort("name"), true);
    }

    public static ImageRecyclerViewAdapter getInstance(Chapter chapter) {
        return new ImageRecyclerViewAdapter(chapter);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemImageBinding viewDataBinding = DataBindingUtil.inflate(
                layoutInflater,
                R.layout.item_image,
                parent, false
        );
        return new ViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemImageBinding binding;

        ViewHolder(ItemImageBinding binding) {
            super(binding.getRoot());
            binding.getRoot().setLayoutParams(new RecyclerView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            this.binding = binding;
        }

        void bind(Image image) {
            binding.setImage(image);
            binding.executePendingBindings();
        }
    }
}
