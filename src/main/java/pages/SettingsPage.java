package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

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

}
