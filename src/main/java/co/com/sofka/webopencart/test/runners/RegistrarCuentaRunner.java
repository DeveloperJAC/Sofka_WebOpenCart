package co.com.sofka.webopencart.test.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = SnippetType.CAMELCASE,
        features = {"src/main/resources/features/RegistrarCuenta.feature"},
        glue = {"co.com.sofka.webopencart.test.stepdefinition"},
        plugin = {
                "pretty",
                "html:target/cucumber"
        }



)

public class RegistrarCuentaRunner {

}
