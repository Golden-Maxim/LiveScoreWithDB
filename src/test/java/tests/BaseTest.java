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


    public void handleCookies() {
        if (cookies.isDisplayed()) {
            cookies.click();
        }
    }


    @BeforeTest(alwaysRun = true)
    public void openBaseURL() throws MalformedURLException {
        //Selenide options
        var options = new ChromeOptions();
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVideo", false);
        selenoidOptions.put("enableVNC", true);
        //  selenoidOptions.put("screenResolution", ConfigProvider.CONFIG_PROPS.selenideScreenResolution());
        selenoidOptions.put("enableLog", true);
        selenoidOptions.put("version", "116");
        options.setCapability("selenoid:options", selenoidOptions);
        options.setCapability("browserName", "chrome");
        options.setCapability("browserVersion", "116");
        //System.setProperty("selenide.browser", "chrome");

        Configuration.browserCapabilities = options;
        Configuration.headless = false;
       // Configuration.remote = "http://localhost:4445/wd/hub";

        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        remoteWebDriver.setFileDetector(new LocalFileDetector());
        remoteWebDriver.get(BASE_URL);

       // Selenide.open(BASE_URL);
        // WebDriverRunner.getWebDriver().manage().window().maximize();
        handleCookies();
    }

    @AfterClass
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}
