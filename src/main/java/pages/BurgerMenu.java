package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BurgerMenu {

    private final SelenideElement settingLink = $x("//a[@id = 'burger-menu__settings']");


    public SettingsPage openSettingsPage() {
        settingLink.click();
        return new SettingsPage();
    }

}
