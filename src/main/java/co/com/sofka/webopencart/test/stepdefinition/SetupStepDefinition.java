package co.com.sofka.webopencart.test.stepdefinition;

import co.com.sofka.test.automationtools.selenium.Browser;
import co.com.sofka.webopencart.test.helpers.TestInfo;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetupStepDefinition {
    protected TestInfo testInfo;

    public Browser browser(){
        Browser browserConfigiguration = new Browser();
        browserConfigiguration.setBrowser(Browser.Browsers.CHROME);
        browserConfigiguration.setIncognito(false);
        browserConfigiguration.setDriverVersion("95.0.4638.54");

        browserConfigiguration.setChromeOptions(chromeOptions());

        return browserConfigiguration;
    }

    private ChromeOptions chromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return options;
    }
}
