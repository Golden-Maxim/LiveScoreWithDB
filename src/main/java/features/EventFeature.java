package features;

import pages.EventPage;
import pages.MainPage;

public class EventFeature {
    private MainPage mainPage;
    private EventPage eventPage;

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
