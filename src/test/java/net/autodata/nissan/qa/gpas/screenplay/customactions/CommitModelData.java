package net.autodata.nissan.qa.gpas.screenplay.customactions;

import net.autodata.nissan.qa.gpas.screenplay.ui.EditModelPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CommitModelData implements Interaction{

    @Override
    public <T extends Actor> void performAs(T actor) {

        theActorInTheSpotlight().attemptsTo(
                Click.on(EditModelPage.MODELACTION_LISTBOX),
                SelectFromOptions.byValue("Commit").from(EditModelPage.MODELACTION_LISTBOX)
        );
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        theActorInTheSpotlight().attemptsTo(ClickOkOn.commitAlerts());
        theActorInTheSpotlight().attemptsTo(ClickOkOn.commitAlerts());
    }


    public static CommitModelData commit(){
        return new CommitModelData();
    }
}
