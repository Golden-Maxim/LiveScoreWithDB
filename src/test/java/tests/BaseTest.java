package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.$;

public abstract class BaseTest {

    private final static String BASE_URL = "https://www.livescore.com/";
    private final SelenideElement cookies = $("#simpleCookieBarCloseButton");

    @SneakyThrows
    public void setUp() {
      /*  ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserVersion", "115");
        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL("http://172.17.0.1:4444"), chromeOptions);
        remoteWebDriver.setFileDetector(new LocalFileDetector());
        remoteWebDriver.get(BASE_URL);*/

        //Configuration.headless = true;
        //Configuration.browserSize = "1920x1080";
        //Configuration.remote = "http://172.17.0.1:4444";
    }

    public void handleCookies() {
        if (cookies.isDisplayed()) {
            cookies.click();
        }
    }

    @BeforeClass(alwaysRun = true)
    public void init() {
         setUp();
    }


    @BeforeTest(alwaysRun = true)
    public void openBaseURL() throws MalformedURLException {
      /*  ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserVersion", "115");
        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
        remoteWebDriver.setFileDetector(new LocalFileDetector());
        remoteWebDriver.get(BASE_URL);*/



        Configuration.headless =true;

        Selenide.open(BASE_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        handleCookies();
    }

    @AfterClass
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}
