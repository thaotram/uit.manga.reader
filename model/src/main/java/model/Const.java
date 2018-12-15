package model;

import android.content.res.Resources;
import android.support.annotation.StringRes;

public final class Const {
    private static Resources resource;

    public static Resources getResource() {
        return resource;
    }

    public static void setResource(Resources resource) {
        Const.resource = resource;
    }

    public static String getString(@StringRes int id) {
        return resource.getString(id);
    }
}