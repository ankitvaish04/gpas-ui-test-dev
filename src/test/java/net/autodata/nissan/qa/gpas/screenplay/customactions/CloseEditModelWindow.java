package net.autodata.nissan.qa.gpas.screenplay.customactions;

import net.autodata.nissan.qa.gpas.screenplay.ui.EditModelPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;


public class CloseEditModelWindow implements Interaction{

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(EditModelPage.MODELACTION_LISTBOX),
                SelectFromOptions.byValue("Close").from(EditModelPage.MODELACTION_LISTBOX),
                SwitchToParentWindow.parent()
        );
    }

    public static CloseEditModelWindow close(){
        return new CloseEditModelWindow();
    }
}
