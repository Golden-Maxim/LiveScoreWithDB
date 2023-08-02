package utils;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.sleep;

public class WaitsUtils {

    public static void until(Duration duration, Duration polling, Runnable runnable) {
        long end = laterBy(duration.toMillis());
        while (true) {
            try {
                runnable.run();
                return;
            } catch (AssertionError | RuntimeException e) {
                if (!isNowBefore(end)) {
                    throw e;
                }
            }
            sleep(polling.toMillis());
        }
    }

    private static boolean isNowBefore(long endInMillis) {
        return System.currentTimeMillis() < endInMillis;
    }

    private static long laterBy(long durationInMillis) {
        return System.currentTimeMillis() + durationInMillis;
    }
}
