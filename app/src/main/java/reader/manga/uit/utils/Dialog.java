package reader.manga.uit.utils;

import android.content.Context;
import android.support.v7.app.AlertDialog;

import reader.manga.uit.R;

public class Dialog {
    public static void OpenConfirm(Context context, String message, Callback yes) {
        new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton(R.string.dialog_yes, (dialog, which) -> yes.call())
                .setNegativeButton(R.string.dialog_no, (dialog, which) -> dialog.cancel())
                .show();
    }

    public static void OpenConfirm(Context context, String message, Callback yes, Callback no) {
        new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton(R.string.dialog_yes, (dialog, which) -> yes.call())
                .setNegativeButton(R.string.dialog_no, (dialog, which) -> no.call())
                .show();
    }
}
