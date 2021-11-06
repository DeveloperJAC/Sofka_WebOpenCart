package co.com.sofka.webopencart.test.controllers;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import co.com.sofka.webopencart.test.page.RegisterPage;

public class MyAccountWebController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String obtenerRegisterAccount(){
        String registro = "Register Account";

        try{
            RegisterPage registerPage = new RegisterPage(webAction.getDriver());
            registro = webAction.getText(registerPage.getRegisterAccount(), 2, true);

        } catch (WebActionsException e)
        {
            Report.reportFailure("Ocurrio un error al intentar validar la creación de un cuenta.", e);
        }

        return registro;
    }
}
