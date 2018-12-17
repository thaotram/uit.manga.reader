package ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;

import ui.ui.R;

public class Scroll extends NestedScrollView {
    private int scrollX;
    private int scrollY;

    public Scroll(@NonNull Context context) {
        super(context);
        initialize(context, null);
    }

    public Scroll(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize(context, attrs);
    }

    public Scroll(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context, null);
    }

    private void initialize(Context context, @Nullable AttributeSet attrs) {
        initializeAttr(context, attrs);
    }

    @Override
    protected void onScrollChanged(int scrollX, int scrollY, int oldX, int oldY) {
        super.onScrollChanged(scrollX, scrollY, oldX, oldY);
    }

    private void initializeAttr(Context context, AttributeSet attrs) {
        if (attrs == null) return;

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Scroll);

        scrollX = typedArray.getInt(R.styleable.Scroll__scrollX, 0);
        scrollY = typedArray.getInt(R.styleable.Scroll__scrollY, 0);

        typedArray.recycle();
    }

//    @BindingAdapter("_scrollX")
//    public void set_scrollX(int scrollX) {
//        this.scrollX = scrollX;
//    }
//
//    @BindingAdapter("_scrollY")
//    public void set_scrollY(int scrollY) {
//        this.scrollY = scrollY;
//    }
//    @InverseBindingAdapter(attribute = "_isOpen")
//    public int getScrollX() {
//        return scrollX;
//    }
}
