package co.com.sofka.webopencart.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccountPage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"content\"]/h1")
    WebElement YourAccount;

    public WebElement getYourAccount() {
        return YourAccount;
    }

    public YourAccountPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
