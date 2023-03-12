package base;

import listener.WebDriverListener;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utils.ConfigReader;
import utils.DriverManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class TestBase {

    @BeforeEach
    public void browserSetup() {
        launchBrowser(ConfigReader.getProperty("appUrl"));
    }

    @AfterEach
    public void browserTeardown() {
        WebDriver driver = DriverManager.getInstance().getDriver();
        closeBrowser(driver);
    }

    public WebDriver launchBrowser(String url){
        System.out.println("Launching Browser.");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-infobars");
        option.addArguments("--incognito");
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/driver/chromedriver");
        WebDriver driver = new ChromeDriver(option);
        EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver);
        WebDriverListener listener = new WebDriverListener();
        eventHandler.register(listener);
        driver = eventHandler;
        DriverManager.getInstance().setWebDriverListener(listener);
        DriverManager.getInstance().setDriver(driver);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigReader.getProperty("implicitlyWaitTime")), TimeUnit.SECONDS);
        return driver;
    }

    public void closeBrowser(WebDriver driver){
        System.out.println("Closing Browser.");
        driver.quit();
    }

}
