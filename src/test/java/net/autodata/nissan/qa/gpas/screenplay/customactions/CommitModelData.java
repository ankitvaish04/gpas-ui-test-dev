package net.autodata.nissan.qa.gpas.screenplay.customactions;

import net.autodata.nissan.qa.gpas.screenplay.ui.EditModelPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.autodata.nissan.qa.gpas.screenplay.features.steps.UserLoginSteps.actor;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class CommitModelData implements Interaction{

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(EditModelPage.MODELACTION_LISTBOX),
                SelectFromOptions.byVisibleText("Commit").from(EditModelPage.MODELACTION_LISTBOX)
        );
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actor.attemptsTo(ClickOkOn.commitAlerts());

    }


    public static CommitModelData commit(){
        return new CommitModelData();
    }
}
