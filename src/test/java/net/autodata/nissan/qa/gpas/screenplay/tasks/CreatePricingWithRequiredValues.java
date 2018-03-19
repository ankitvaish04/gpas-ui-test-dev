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
import static net.autodata.nissan.qa.gpas.screenplay.features.steps.CreateModelStyleSteps.createPricingInformationList;


public class CreatePricingWithRequiredValues implements Task {

    private final String priceState;
    private final String modelPricing;
    private final String effectiveDate;
    private final String nonEffectiveDate;
    public static boolean flag = true;


    public CreatePricingWithRequiredValues(String priceState, String modelPricing, String effectiveDate, String nonEffectiveDate) {
        this.priceState = priceState;
        this.modelPricing = modelPricing;
        this.effectiveDate = effectiveDate;
        this.nonEffectiveDate = nonEffectiveDate;
    }

    @Override
    @Step("{0} looks to create pricing for a style")
    public <T extends Actor> void performAs(T actor) {
        if (createPricingInformationList.size() == 1) {
            actor.attemptsTo(

                    DoubleClick.on(EditModelPage.PRICING_TABLE_ROW1),
                    SelectFromOptions.byVisibleText(priceState).from(EditModelPage.PRICE_STATE),
                    Enter.theValue(modelPricing).into(EditModelPage.PRICE_USD),
                    Enter.theValue(effectiveDate).into(EditModelPage.EFFECTIVE_DATE),
                    Enter.theValue(nonEffectiveDate).into(EditModelPage.NON_EFFECTIVE_DATE),
                    Click.on(EditModelPage.BUTTON_TARGET("Submit Button", "Submit"))
            );
        }
        else {
            if (flag) {
                actor.attemptsTo(DoubleClick.on(EditModelPage.PRICING_TABLE_ROW1));
                flag = false;
            }
            else { actor.attemptsTo(
                        RightClick.on(EditModelPage.PRICING_TABLE_ROW1),
                        Click.on(EditModelPage.STYLE_MENU_OPTION("Insert New Record"))
                    );
            }

                actor.attemptsTo(

                        SelectFromOptions.byVisibleText(priceState).from(EditModelPage.PRICE_STATE),
                        Enter.theValue(modelPricing).into(EditModelPage.PRICE_USD),
                        Enter.theValue(effectiveDate).into(EditModelPage.EFFECTIVE_DATE),
                        Enter.theValue(nonEffectiveDate).into(EditModelPage.NON_EFFECTIVE_DATE),
                        Click.on(EditModelPage.BUTTON_TARGET("Submit Button", "Submit"))

                );
        }

    }
}