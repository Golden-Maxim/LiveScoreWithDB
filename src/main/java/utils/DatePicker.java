package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.$x;

public class DatePicker {

    private final SelenideElement datePickerLocator = $x("//div[@id = 'match-calendar-date-picker']");
    private final String dayLocator = ".//div[@class = 'Ak']//a[@href = '/en/football/%s/']";

    private final SelenideElement calendarBody = $x("//div[@id = 'match-calendar-dp-trigger']");


    public void verifyCalendarIsOpened(){
        WaitsUtils.untilElementsAppearInDom();
        calendarBody.shouldHave(Condition.attribute("class", "Pc isActive"));
    }
    public void selectDayInThisMonth(LocalDate localDate){
        verifyCalendarIsOpened();
        datePickerLocator.$x(String.format(dayLocator, localDate)).shouldBe(Condition.enabled).click();
    }

}
