package features;

import pages.SettingsPage;

public class SettingsFeature {
    private final SettingsPage settingsPage;

    public SettingsFeature() {
        this.settingsPage = new SettingsPage();
    }

    public void selectTimeZone(String value) {
        settingsPage.selectTimeZone(value);
    }

}
