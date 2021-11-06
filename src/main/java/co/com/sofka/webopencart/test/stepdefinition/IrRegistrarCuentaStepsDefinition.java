package co.com.sofka.webopencart.test.stepdefinition;


import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.webopencart.test.controllers.MyAccountWebController;
import co.com.sofka.webopencart.test.controllers.IrRegisterPageWebController;
import co.com.sofka.webopencart.test.controllers.openwebpage.StartBrowserWebController;
import co.com.sofka.webopencart.test.helpers.TestInfo;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

public class IrRegistrarCuentaStepsDefinition extends SetupStepDefinition {

    private WebAction webAction;
    //private Customer customer;

    @Before
    public void setup(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que el cliente esta en la página de inicio.")
    public void queElClienteEstaEnLaPaginaDeInicio() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();

    }

    @Cuando("el cliente ingresa al la seccion de mi cuenta da click en registrar.")
    public void elClienteIngresaAlLaSeccionDeMiCuentaDaClickEnRegistrar() {
        IrRegisterPageWebController irRegisterPageWebController = new IrRegisterPageWebController();
        irRegisterPageWebController.setWebAction(webAction);
        irRegisterPageWebController.irHaciaRegisterPage();

    }

    @Entonces("como resultado el usuario vera el formulario de registro.")
    public void comoResultadoElUsuarioVeraElFormularioDeRegistro() {

        MyAccountWebController myAccountWebController  = new MyAccountWebController();
        myAccountWebController.setWebAction(webAction);
        Assert.Hard
                .thatString(myAccountWebController.obtenerRegisterAccount());


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
