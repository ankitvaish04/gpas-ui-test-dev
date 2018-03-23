package net.autodata.nissan.qa.gpas.screenplay.tasks;

import net.autodata.nissan.qa.gpas.screenplay.customactions.RightClick;
import net.autodata.nissan.qa.gpas.screenplay.ui.EditModelPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


public class CheckCVCOptKindsWithRequiredValues implements Task {

    private final String optkinds;

    public CheckCVCOptKindsWithRequiredValues(String optkinds) {
        this.optkinds = optkinds;
    }

    @Override
    @Step("{0} looks to verify Option Kinds under CVC for a model")
    public <T extends Actor> void performAs(T actor) {

        if(getDriver().findElements(By.xpath("//div[@role='tabpanel']/div[7]/div/div/table/tbody/tr")).size()==0)
            actor.attemptsTo(RightClick.on(EditModelPage.CVC_TABLE));
        else
            actor.attemptsTo(RightClick.on(EditModelPage.CVC_TABLE_ROW1));

            actor.attemptsTo(

                    Click.on(EditModelPage.STYLE_MENU_OPTION("Insert New Record")),
                    Enter.theValue(optkinds).into(EditModelPage.OPT_KINDS),
                    Click.on(EditModelPage.BUTTON_TARGET("Generate Buttom","Generate")),
                    Click.on(EditModelPage.BUTTON_TARGET("Submit Button", "Submit"))

            );
    }

    }