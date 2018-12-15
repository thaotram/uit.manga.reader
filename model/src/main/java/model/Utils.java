package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {
    private static final DateFormat HOUR = new SimpleDateFormat("HH:mm", new Locale("vi"));
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm' - 'dd/MM/yyyy", new Locale("vi"));

    public static String getTime(Date time) {
        return HOUR.format(time);
    }

    public static String getDateTime(Date time) {
        return DATE_FORMAT.format(time);
    }
}
