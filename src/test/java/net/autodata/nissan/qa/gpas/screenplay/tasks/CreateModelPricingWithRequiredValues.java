package net.autodata.nissan.qa.gpas.screenplay.tasks;

import net.autodata.nissan.qa.gpas.screenplay.customactions.DoubleClick;
import net.autodata.nissan.qa.gpas.screenplay.customactions.RightClick;
import net.autodata.nissan.qa.gpas.screenplay.ui.EditModelPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


public class CreateModelPricingWithRequiredValues implements Task {

    private final String orderCode;
    private final String priceState;
    private final String retailFleetStatus;
    private final String condition;
    private final String pricing;
    private final String effectiveDate;
    private final String nonEffectiveDate;


    public CreateModelPricingWithRequiredValues(String orderCode,String priceState,String retailFleetStatus,String condition,String pricing,String effectiveDate,String nonEffectiveDate) {
        this.orderCode = orderCode;
        this.priceState = priceState;
        this.retailFleetStatus = retailFleetStatus;
        this.condition = condition;
        this.pricing = pricing;
        this.effectiveDate = effectiveDate;
        this.nonEffectiveDate = nonEffectiveDate;
    }

    @Override
    @Step("{0} looks to create model pricing")
    public <T extends Actor> void performAs(T actor) {

        if(getDriver().findElements(By.xpath("//div[@role='tabpanel']/div[5]/div/div/table/tbody/tr")).size()==0)
            actor.attemptsTo(RightClick.on(EditModelPage.PRICE_TABLE));
        else
            actor.attemptsTo(RightClick.on(EditModelPage.PRICE_TABLE_ROW1));

        actor.attemptsTo(
                Click.on(EditModelPage.STYLE_MENU_OPTION("Insert New Record")),
                Enter.theValue(orderCode).into(EditModelPage.INPUT_BOX_TITLED("Order Code", "Order Code"))
        );

        if(getDriver().findElements(By.xpath("(//table[@class='r-border'])[last()]/tbody/tr[2]/td/table/tbody/tr")).size()==0)
        {
            actor.attemptsTo(
                    RightClick.on(EditModelPage.PRICING_TABLE),
                    Click.on(EditModelPage.STYLE_MENU_OPTION("Insert New Record"))
            );
        }
        if(getDriver().findElements(net.serenitybdd.core.annotations.findby.By.xpath("(//table[@class='r-border'])[last()]/tbody/tr[2]/td/table/tbody/tr")).size()==1)
            actor.attemptsTo(DoubleClick.on(EditModelPage.PRICING_TABLE_ROW1));

        actor.attemptsTo(

                SelectFromOptions.byVisibleText(priceState).from(EditModelPage.PRICE_STATE),
                Enter.theValue(retailFleetStatus).into(EditModelPage.INPUT_BOX_TITLED("R/F", "Retail Fleet Status")),
                Enter.theValue(condition).into(EditModelPage.INPUT_BOX_NAMED("Condition", "Condition")),
                Enter.theValue(pricing).into(EditModelPage.PRICE_USD),
                Enter.theValue(effectiveDate).into(EditModelPage.EFFECTIVE_DATE),
                Enter.theValue(nonEffectiveDate).into(EditModelPage.NON_EFFECTIVE_DATE),
                Click.on(EditModelPage.BUTTON_TARGET("Submit Button", "Submit")),
                Click.on(EditModelPage.BUTTON_TARGET("Submit Button", "Submit"))
        );


    }

}