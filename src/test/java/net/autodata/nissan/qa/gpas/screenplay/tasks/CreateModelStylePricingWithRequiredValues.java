package net.autodata.nissan.qa.gpas.screenplay.tasks;

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


public class CreateModelStylePricingWithRequiredValues implements Task {

    private final String priceState;
    private final String modelPricing;
    private final String effectiveDate;
    private final String nonEffectiveDate;

    public CreateModelStylePricingWithRequiredValues(String priceState, String modelPricing, String effectiveDate, String nonEffectiveDate) {
        this.priceState = priceState;
        this.modelPricing = modelPricing;
        this.effectiveDate = effectiveDate;
        this.nonEffectiveDate = nonEffectiveDate;
    }

    @Override
    @Step("{0} looks to create pricing for a style")
    public <T extends Actor> void performAs(T actor) {

        if(getDriver().findElements(By.xpath("(//table[@class='r-border'])[last()]/tbody/tr[2]/td/table/tbody/tr")).size()==0)
            actor.attemptsTo(RightClick.on(EditModelPage.PRICING_TABLE));
        else
            actor.attemptsTo(RightClick.on(EditModelPage.PRICING_TABLE_ROW1));

        actor.attemptsTo(

                Click.on(EditModelPage.STYLE_MENU_OPTION("Insert New Record")),
                SelectFromOptions.byVisibleText(priceState).from(EditModelPage.PRICE_STATE),
                Enter.theValue(modelPricing).into(EditModelPage.PRICE_USD),
                Enter.theValue(effectiveDate).into(EditModelPage.EFFECTIVE_DATE),
                Enter.theValue(nonEffectiveDate).into(EditModelPage.NON_EFFECTIVE_DATE),
                Click.on(EditModelPage.BUTTON_TARGET("Submit Button", "Submit"))
        );
    }
}