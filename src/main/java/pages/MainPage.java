package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static utils.VerifyUtils.verifyElementAttribute;

public class MainPage {

    private final SelenideElement datePicker = $x("//div[@id = 'match-calendar-dp-trigger']");
    private final SelenideElement burgerMenu = $x("//span[@id = 'burger-menu-open']");
    private final SelenideElement burgerMenuBody = $x("//div[@id = 'burger-menu-body']");
    private final ElementsCollection events = $$x("//div[contains(@id, 'match-row-favorite-wrapper')]/ancestor::a");

    public MainPage clickToDatePicker() {
        datePicker.click();
        return this;
    }

    public MainPage verifyDatePickerIsOpened() {
        verifyElementAttribute(datePicker);
        return this;
    }

    public EventPage openFirstEvent() {
        events.first().click();
        return new EventPage();
    }

    public void openBurgerMenu() {
        burgerMenu.click();
    }

    public void verifyBurgerMenuIsOpened() {
        verifyElementAttribute(burgerMenuBody);
    }

}
