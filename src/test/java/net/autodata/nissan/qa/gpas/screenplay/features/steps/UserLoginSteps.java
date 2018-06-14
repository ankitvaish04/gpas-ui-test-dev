package net.autodata.nissan.qa.gpas.screenplay.features.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.autodata.nissan.qa.gpas.screenplay.tasks.LoginUsingPageUrl;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class UserLoginSteps {

    public static Actor actor;


    public static WebDriver theBrowser;

    @Before
    public void set_the_stage() {
        //OnStage.setTheStage(new OnlineCast());
        System.out.println("hi");

        String path = "C:\\Users\\ankit.vaish\\Desktop\\New folder\\geckodriver-v0.20.1-win64\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", path);
        DesiredCapabilities ffCapabilities = DesiredCapabilities.firefox();
        ffCapabilities.setCapability("marionette", true);
        theBrowser = new FirefoxDriver();
        theBrowser.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
        theBrowser.manage().window().maximize();
    }

    @After
    public void release_the_stage() {
        theBrowser.quit();

    }
    @Given("^(.*) is logged in as (.*)$")
    public void login_to_app(Actor persona, String username) throws Throwable {
        this.actor = persona;
        givenThat(actor).can(BrowseTheWeb.with(theBrowser));
        actor.attemptsTo(LoginUsingPageUrl.withLoginUrl());
    }

}
