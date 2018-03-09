package net.autodata.nissan.qa.gpas.screenplay.customactions;

import net.autodata.nissan.qa.gpas.screenplay.ui.EditModelPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

/**
 * Created by ankit.vaish on 07-03-2018.
 */
public class SelectLanguages implements Interaction{

   private static String languagesList[]=null;
    @Override
    public <T extends Actor> void performAs(T actor) {

        if (languagesList!=null&&languagesList.length>0) {
            for (String language : languagesList) {
                if (!language.equalsIgnoreCase("")) {
                    theActorInTheSpotlight().attemptsTo(
                            SelectFromOptions.byValue(language).from(EditModelPage.DIALOGBOX_AVAIABLE_LIST_TARGET("Select & Order Languages")),
                            Click.on(EditModelPage.BUTTON_TARGET("> Button", ">"))
                    );
                }
            }
        }
    }

    public static SelectLanguages byValue(String languages){
        if(!languages.equalsIgnoreCase(""))
            languagesList =languages.trim().split(",");
        return new SelectLanguages();
    }

}
