package co.com.sofka.webopencart.test.stepdefinition;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.webopencart.test.controllers.IrRegisterPageWebController;
import co.com.sofka.webopencart.test.controllers.RegisterAccountWebController;
import co.com.sofka.webopencart.test.controllers.YourAccountWebController;
import co.com.sofka.webopencart.test.controllers.openwebpage.StartBrowserWebController;
import co.com.sofka.webopencart.test.helpers.TestInfo;
import co.com.sofka.webopencart.test.models.Customer;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

public class RegistrarCuentaStepsDefinition extends SetupStepDefinition {

    private WebAction webAction;
    private Customer customer;

    @Before
    public void setup(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que el cliente esta en la página de registrar cuenta.")
    public void queElClienteEstaEnLaPáginaDeRegistrarCuenta() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();

    }

    @Cuando("el cliente registra sus datos para una cuenta en línea de forma exitosa.")
    public void elClienteRegistraSusDatosParaUnaCuentaEnLíneaDeFormaExitosa() {
        IrRegisterPageWebController irRegisterPageWebController = new IrRegisterPageWebController();
        irRegisterPageWebController.setWebAction(webAction);
        irRegisterPageWebController.irHaciaRegisterPage();

        RegisterAccountWebController registerAccountWebController = new RegisterAccountWebController();
        registerAccountWebController.setWebAction(webAction);
        registerAccountWebController.crearUnaCuenta();
        customer = registerAccountWebController.getCustomer();



    }

    @Entonces("como resultado el usuario quedará logueado dentro de su respectiva sesión.")
    public void comoResultadoElUsuarioQuedaráLogueadoDentroDeSuRespectivaSesión() {
        YourAccountWebController yourAccountWebController  = new YourAccountWebController();
        yourAccountWebController.setWebAction(webAction);
        Assert.Hard
                .thatString(yourAccountWebController.yourRegisterAccount());

    }

    @After
    public void cerrarDriver() throws InterruptedException {
        Thread.sleep(2000);

        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }
}
