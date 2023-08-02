package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.$x;

public class SettingsPage {

    private final SelenideElement timeZoneElement = $x("//div[@id='TZ_SELECT']");
    private final SelenideElement dropDown = $x("//div[@id='TZ_SELECT']//div[contains(@class , 'selectItems')]");
    private final SelenideElement applyButton = $x("//div[@id='settings-modal-apply-wrapper']/button");

    public void clickOnDropDown() {
        timeZoneElement.click();
    }

    public void verifyDropDownIsOpened() {
        dropDown.shouldBe(Condition.visible);
    }

    public void selectTimeZone(String option) {
        clickOnDropDown();
        verifyDropDownIsOpened();
        dropDown.$x(String.format("./div[text() = '%s']", option)).click();
        applyButton.click();
    }

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
