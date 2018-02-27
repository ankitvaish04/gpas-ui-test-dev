package net.autodata.nissan.qa.gpas.screenplay.tasks;

import net.autodata.nissan.qa.gpas.screenplay.ui.Refresh;
import net.autodata.nissan.qa.gpas.screenplay.ui.ApplicationHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginUsingPageUrl implements Task {

    private ApplicationHomePage applicationHomePage;

    public static LoginUsingPageUrl withLoginUrl() {
        return instrumented(LoginUsingPageUrl.class);
    }

    @Override
    @Step("{0} logs in")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(applicationHomePage)
        );
    }
}
