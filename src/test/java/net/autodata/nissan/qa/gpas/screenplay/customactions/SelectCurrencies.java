package net.autodata.nissan.qa.gpas.screenplay.customactions;

import net.autodata.nissan.qa.gpas.screenplay.ui.EditModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

/**
 * Created by ankit.vaish on 07-03-2018.
 */
public class SelectCurrencies implements Interaction{

   private static String currencyList[]=null;
    @Override
    public <T extends Actor> void performAs(T actor) {

        if (currencyList!=null&&currencyList.length>0) {
            for (String currency : currencyList) {
                if (!currency.equalsIgnoreCase("")) {
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byValue(currency).from(EditModel.DIALOGBOX_AVAIABLE_LIST_TARGET("Select & Order Currencies")),
                            Click.on(EditModel.BUTTON_TARGET("> Button", ">"))
                    );
                }
            }
        }
    }

    public static SelectCurrencies byValue(String currencies){
        if(!currencies.equalsIgnoreCase(""))
            currencyList =currencies.trim().split(",");
        return new SelectCurrencies();
    }

}
