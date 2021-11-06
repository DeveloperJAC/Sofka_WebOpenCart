package co.com.sofka.webopencart.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]")
    WebElement MyAccount;

   @CacheLookup
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
    WebElement Register;

    public WebElement getMyAccount() {
        return MyAccount;
    }

   public WebElement getRegister() {
        return Register;
    }

    public LandingPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
