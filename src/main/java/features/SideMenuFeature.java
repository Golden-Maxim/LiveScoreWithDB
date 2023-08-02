package features;

import pages.BurgerMenu;
import pages.MainPage;

public class SideMenuFeature {

    private MainPage mainPage;
    private BurgerMenu burgerMenu;

    public SideMenuFeature() {
        this.mainPage = new MainPage();
        this.burgerMenu = new BurgerMenu();
    }

    public SideMenuFeature openBurgerMenu() {
        mainPage.openBurgerMenu();
        return this;
    }

    public SideMenuFeature verifyBurgerMenu() {
        mainPage.verifyBurgerMenuIsOpened();
        return this;
    }

    public SideMenuFeature openSettingsPage(){
        burgerMenu.openSettingsPage();
        return this;
    }


}
