package features;

import pages.MainPage;
import utils.DatePicker;

import java.time.LocalDate;

public class CalendarFeature {
    private final MainPage mainPage;
    private final DatePicker datePicker;


    public CalendarFeature() {
        this.datePicker = new DatePicker();
        this.mainPage = new MainPage();
    }

    public CalendarFeature openDatePicker() {
        mainPage.clickToDatePicker()
                .verifyDatePickerIsOpened();

        return this;
    }

    public CalendarFeature selectFollowingDateInThisMonth(LocalDate localDate){
        datePicker.selectDayInThisMonth(localDate);
        return this;
    }

}
