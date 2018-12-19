package ui.utils;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;

import static android.graphics.Typeface.BOLD;

public class StringHelper {
    public static SpannableStringBuilder getBoldString(String bold, String normal) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bold + ": " + normal);
        spannableStringBuilder
                .setSpan(
                        new StyleSpan(BOLD),
                        0, bold.length() + 1,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
        return spannableStringBuilder;
    }
}
