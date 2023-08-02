package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EventPage {

    private final SelenideElement eventTime = $x("//span[@id = 'score-or-time']");
    private final SelenideElement eventDay = $x("//span[@id = 'SEV__status']");


    public String getTime() {
        return eventTime.getText();
    }

    public String getDay() {
        return eventDay.getText();
    }

}
