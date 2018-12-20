package ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import ui.ui.R;

public class Picture extends com.facebook.drawee.view.SimpleDraweeView {
    private String source;
    private float ratio;

    public Picture(Context context) {
        super(context);
        initialize(context, null);
    }

    public Picture(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize(context, attrs);
    }

    private void initialize(Context context, @Nullable AttributeSet attrs) {
        initializeAttr(context, attrs);
        initializeImage();
    }

    private void initializeImage() {
        if (source == null) return;
        setImageURI(Uri.parse(source));
        setAspectRatio(ratio);
    }

    private void initializeAttr(@NonNull Context context, @Nullable AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Picture);
        source = typedArray.getString(R.styleable.Picture__source);
        ratio = typedArray.getFloat(R.styleable.Picture__ratio, 1);
        typedArray.recycle();
    }

    /**
     * Data binding: set_source
     */
    public void set_source(String source) {
        this.source = source;
        initializeImage();
    }

    /**
     * Data binding: set_ratio
     */
    public void set_ratio(float ratio) {
        this.ratio = ratio;
        initializeImage();
    }
}