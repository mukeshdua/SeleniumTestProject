package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;

public class Login {
    WebDriver driver;
    public Login()
    {
        driver= DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='username']")
    private WebElement txtUserName;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement txtPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSubmit;

    public void login(String userName, String password)
    {
        txtUserName.sendKeys(userName);
        txtUserName.sendKeys(userName);
        btnSubmit.click();

        driver.findElement(By.)
    }


}
