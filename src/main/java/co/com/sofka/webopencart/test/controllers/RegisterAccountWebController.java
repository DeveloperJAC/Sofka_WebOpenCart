package co.com.sofka.webopencart.test.controllers;

import co.com.sofka.webopencart.test.models.Customer;
import co.com.sofka.webopencart.test.page.RegisterAccountPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.sofka.webopencart.test.helpers.Dictionary.*;
import static co.com.sofka.webopencart.test.helpers.Helper.generateCustomer;

public class RegisterAccountWebController {
    private WebAction webAction;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void crearUnaCuenta(){
        try{
            customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);

            RegisterAccountPage registerAccountPage = new RegisterAccountPage(webAction.getDriver());


            webAction.sendText(registerAccountPage.getFirstname(), customer.getFirstname(), true);
            webAction.sendText(registerAccountPage.getLastname(), customer.getLastname(), true);
            webAction.sendText(
                    registerAccountPage.getEmail(),
                    customer.getEmail(),
                    2,
                    true
            );
            webAction.sendText(registerAccountPage.getTelephone(), customer.getTelephone(), true);
            webAction.sendText(registerAccountPage.getPassword(), customer.getPassword(), true);
            webAction.sendText(registerAccountPage.getConfirm(), customer.getConfirm(), true);
            webAction.click(registerAccountPage.getYes(), 10, true);
            webAction.click(registerAccountPage.getPolicy(), 10, true);
            webAction.click(registerAccountPage.getContinue(), 10,true);
        } catch (WebActionsException e)
        {
            Report.reportFailure("Ocurrio un error al intentar crear una cuenta.", e);
        }
    }
}
