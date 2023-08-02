package tests;

import features.CalendarFeature;
import features.EventFeature;
import features.SettingsFeature;
import features.SideMenuFeature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SettingsPage;

import java.time.LocalDate;

public class TimeZoneTest extends BaseTest {

    @Test
    public void verifyTimeChangeAccordinglyTest() {
        new CalendarFeature().openDatePicker()
                .selectFollowingDateInThisMonth(LocalDate.now().plusDays(1));
        new EventFeature().openFirstEvent();
        String day = new EventFeature().getEventDay();
        String time = new EventFeature().getEventTime();
        String originalTimeZone = "UTC+03:00";
        String targetTimeZone = "UTC +14:00";

        new SideMenuFeature().openBurgerMenu()
                .verifyBurgerMenu()
                .openSettingsPage();
        new SettingsFeature().selectTimeZone(targetTimeZone);

        String updatedDay = new EventFeature().getEventDay();
        String updatedTime = new EventFeature().getEventTime();

        var whiteSpaceLessTimeZone = targetTimeZone.replaceAll("\\s+", "");
        var zonedDateTime = SettingsPage.convertTimeZone(time, day, originalTimeZone, whiteSpaceLessTimeZone);

        Assert.assertEquals(updatedDay + " " + updatedTime, zonedDateTime);

    }

}
