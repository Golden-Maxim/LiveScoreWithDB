package features;

import pages.EventPage;
import pages.MainPage;

public class EventFeature {
    private final MainPage mainPage;
    private final EventPage eventPage;

    public EventFeature() {
        this.mainPage = new MainPage();
        this.eventPage = new EventPage();
    }

    public void openFirstEvent() {
        mainPage.openFirstEvent();
    }

    public String getEventTime() {
        return eventPage.getTime();
    }

    public String getEventDay() {
        return eventPage.getDay();
    }
}
