package net.autodata.nissan.qa.gpas.screenplay.features.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.autodata.nissan.qa.gpas.screenplay.tasks.LoginUsingPageUrl;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class UserLoginSteps {

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) is logged in as (.*)$")
    public void login_to_app(String persona, String username) throws Throwable {
        theActorCalled(persona).attemptsTo(LoginUsingPageUrl.withLoginUrl());
    }

}
