package utils;

import listener.WebDriverListener;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static DriverManager driverManager;
    private static WebDriver driver = null;
    WebDriverListener webDriverListener = null;

    private DriverManager() {

    }

    public static DriverManager getInstance(){
        if(driverManager == null) {
            driverManager = new DriverManager();
        }
        return driverManager;
    }

    public void setDriver(WebDriver driver) {
        this.driver=driver;
    }

    public WebDriver getDriver () {
        if (driver == null) {
            throw new IllegalStateException("Driver should have not been null!!");
        }
        return driver;
    }

    public void setWebDriverListener (WebDriverListener webDriverListener) {
        this.webDriverListener = webDriverListener;
    }

    public WebDriverListener getWebDriverListener () {
        if (webDriverListener == null) {
            throw new IllegalStateException("WebDriverListener should have not been null!!");
        }
        return webDriverListener;
    }


}
