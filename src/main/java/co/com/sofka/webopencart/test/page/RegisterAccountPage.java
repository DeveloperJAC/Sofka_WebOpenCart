package co.com.sofka.webopencart.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccountPage {



    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstname;

    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastname;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephone;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;

    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirm;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")
    WebElement yes;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")
    WebElement no;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[1]")
    WebElement policy;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
    WebElement Continue;

    public WebElement getFirstname() {
        return firstname;
    }

    public WebElement getLastname() {
        return lastname;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getTelephone() {
        return telephone;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getConfirm() {
        return confirm;
    }

    public WebElement getYes() {
        return yes;
    }

    public WebElement getNo() {
        return no;
    }

    public WebElement getPolicy() {
        return policy;
    }

    public WebElement getContinue() {
        return Continue;
    }

    public RegisterAccountPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
