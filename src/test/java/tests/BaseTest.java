package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

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

        System.out.println(1);

        var options = new ChromeOptions();
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVideo", false);
        selenoidOptions.put("enableVNC", true);
        //  selenoidOptions.put("screenResolution", ConfigProvider.CONFIG_PROPS.selenideScreenResolution());
        selenoidOptions.put("enableLog", true);
        selenoidOptions.put("version", "116");
        options.setCapability("selenoid:options", selenoidOptions);
        options.setCapability("browserName", "chrome");
        System.setProperty("selenide.browser", "chrome");

       // Configuration.baseUrl = "https://www.wikipedia.org/";
        Configuration.browserCapabilities = options;
        Configuration.headless =false;
        Configuration.remote = "http://localhost:4445/wd/hub";

        ChromeDriver driver = new ChromeDriver(options);
        driver.get(BASE_URL);
        driver.getCurrentUrl();
        WebDriverRunner.getWebDriver().manage().window().maximize();
        handleCookies();
    }

    @AfterClass
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}
