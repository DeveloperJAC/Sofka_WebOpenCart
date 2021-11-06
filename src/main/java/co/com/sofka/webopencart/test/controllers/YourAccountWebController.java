package co.com.sofka.webopencart.test.controllers;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import co.com.sofka.webopencart.test.page.YourAccountPage;

public class YourAccountWebController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String yourRegisterAccount(){
        String cuenta = "Your Account Has Been Created!";

        try{
            YourAccountPage yourAccount = new YourAccountPage(webAction.getDriver());
            cuenta = webAction.getText(yourAccount.getYourAccount(), 2, true);

        } catch (WebActionsException e)
        {
            Report.reportFailure("Ocurrio un error al intentar validar la creación de un cuenta.", e);
        }

        return cuenta;
    }
}
