package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.sleep;

public class WaitsUtils {

    public static void untilElementsAppearInDom() {
        Runnable runnable = () -> {
            long start = getDocumentElementsSize();
            sleep(500);
            long end = getDocumentElementsSize();
            if (start != end) {
                throw new RuntimeException("Page wasn't loaded");
            }
        };
        until(runnable);
    }

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

    public static void until(Runnable runnable) {
        until(Duration.ofMillis(Configuration.timeout), Duration.ofMillis(200), runnable);
    }

    private static boolean isNowBefore(long endInMillis) {
        return System.currentTimeMillis() < endInMillis;
    }

    private static long laterBy(long durationInMillis) {
        return System.currentTimeMillis() + durationInMillis;
    }

    private static long getDocumentElementsSize() {
        String script = "\tvar begin = document.all;\n" + "\treturn begin.length;";
        return Selenide.executeJavaScript(script);
    }
}
