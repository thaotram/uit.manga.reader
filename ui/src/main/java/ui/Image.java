package ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.squareup.picasso.Picasso;

import ui.ui.R;

import static ui.utils.Const.HEIGHT;
import static ui.utils.Const.WIDTH;

public class Image extends android.support.v7.widget.AppCompatImageView {
    private String source;
    private int by;
    private Uri src;

    public Image(Context context) {
        super(context);
        initialize(context, null);
    }

    private void initialize(Context context, @Nullable AttributeSet attrs) {
        initializeAttr(context, attrs);
        initializeImage();
    }

    private void initializeAttr(@NonNull Context context, @Nullable AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Image);
        source = typedArray.getString(R.styleable.Image__source);
        by = typedArray.getInt(R.styleable.Image__by, -1);
        typedArray.recycle();
    }

    private void initializeImage() {
        if (source == null) return;
        src = Uri.parse(source);
    }

    public Image(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize(context, attrs);
    }

    public Image(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context, attrs);
    }

    /**
     * Data binding: set_source
     *
     * @param source String
     */
    public void set_source(String source) {
        this.source = source;
        initializeImage();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int width = MeasureSpec.getSize(widthMeasureSpec);
        final int height = MeasureSpec.getSize(heightMeasureSpec);

        final Picasso picasso = Picasso.with(getContext());
        picasso.setIndicatorsEnabled(true);

        switch (by) {
            case WIDTH:
                picasso.load(src)
                        .resize(width, 0)
                        .into(this);
                break;
            case HEIGHT:
                picasso.load(src)
                        .resize(0, height)
                        .into(this);
                break;
            default:
                picasso.load(src)
                        .resize(width, height)
                        .centerCrop()
                        .into(this);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null) return;

        Bitmap source = ((BitmapDrawable) drawable).getBitmap();
        canvas.drawBitmap(source, 0, 0, null);
    }
}