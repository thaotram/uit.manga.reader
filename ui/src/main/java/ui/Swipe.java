package ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.MessageFormat;

import ui.ui.R;

@BindingMethods(
        @BindingMethod(type = Swipe.class, attribute = "onRefresh", method = "setOnRefreshListener")
)
public class Swipe extends SwipeRefreshLayout {
    private Method handler;
    private String onRefresh;

    public Swipe(@NonNull Context context) {
        super(context);
        initialize(context, null);
    }

    private void initialize(@NonNull Context context, @Nullable AttributeSet attrs) {
        initializeAttrs(context, attrs);
        initializeHandle();
    }

    private void initializeAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray;
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.Swipe);

        onRefresh = typedArray.getString(R.styleable.Swipe__onRefresh);

        typedArray.recycle();
    }

    private void initializeHandle() {
        try {
            handler = getContext().getClass().getMethod(onRefresh, Swipe.class);
        } catch (NoSuchMethodException e) {
            int id = getId();
            final String exception = MessageFormat.format(
                    "Could not find a method {0} (View) in the activity {1} for onRefresh handler on view {2}",
                    onRefresh,
                    getContext().getClass(),
                    id == NO_ID ? "" : "with id " + getContext().getResources().getResourceEntryName(id)
            );
            throw new IllegalStateException(exception);
        }

        this.setOnRefreshListener(() -> {
            try {
                handler.invoke(getContext(), Swipe.this);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non public method of the activity", e);
            } catch (InvocationTargetException e) {
                throw new IllegalStateException("Could not execute method of the activity", e);
            }

            this.setRefreshing(false);
        });
    }

    public Swipe(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize(context, attrs);
    }
}
