package reader.manga.uit.utils;

public class Timer {
    public static void setTimeout(Runnable runnable, int delay) {
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            } catch (Exception ignored) {

            }
        }).start();
    }
}
