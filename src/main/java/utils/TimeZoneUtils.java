package utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeZoneUtils {

    public static String convertTimeZone(String time, String date, String originalTimeZone, String targetTimeZone) {
        String inputDateTimeString = date + " " + time + " " + "2023";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM HH:mm yyyy");

        // Parse the original date and time with the original time zone
        LocalDateTime localDateTime = LocalDateTime.parse(inputDateTimeString, formatter);
        ZoneId originalZoneId = ZoneId.of(originalTimeZone);
        ZonedDateTime originalZonedDateTime = ZonedDateTime.of(localDateTime, originalZoneId);

        // Convert to the target time zone
        ZoneId targetZoneId = ZoneId.of(targetTimeZone);
        ZonedDateTime targetZonedDateTime = originalZonedDateTime.withZoneSameInstant(targetZoneId);

        // Format the final date and time as desired
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd MMM HH:mm");
        return targetZonedDateTime.format(outputFormatter);
    }
}
