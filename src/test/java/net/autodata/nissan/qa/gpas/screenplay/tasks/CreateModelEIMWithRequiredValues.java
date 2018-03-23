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


public class CreateModelEIMWithRequiredValues implements Task {

    private final String position;
    private final String character;
    private final String condition;

    public CreateModelEIMWithRequiredValues(String position, String character, String condition) {
        this.position = position;
        this.character = character;
        this.condition = condition;
    }

    @Override
    @Step("{0} looks to create model EIMs")
    public <T extends Actor> void performAs(T actor) {

        if(getDriver().findElements(By.xpath("//div[@role='tabpanel']/div[6]/div/div/table/tbody/tr")).size()==0)
            actor.attemptsTo(RightClick.on(EditModelPage.EIM_TABLE));
        else
            actor.attemptsTo(RightClick.on(EditModelPage.EIM_TABLE_ROW1));

            actor.attemptsTo(

                    Click.on(EditModelPage.STYLE_MENU_OPTION("Insert New Record")),
                    Enter.theValue(position).into(EditModelPage.EIM_POSITION),
                    Enter.theValue(character).into(EditModelPage.EIM_CHARS),
                    Enter.theValue(condition).into(EditModelPage.EIM_CONDITION),
                    Click.on(EditModelPage.BUTTON_TARGET("Submit Button", "Submit"))

            );
    }

    }