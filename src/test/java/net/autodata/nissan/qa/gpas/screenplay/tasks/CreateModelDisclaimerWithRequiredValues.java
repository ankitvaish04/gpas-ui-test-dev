package net.autodata.nissan.qa.gpas.screenplay.tasks;

import net.autodata.nissan.qa.gpas.screenplay.customactions.DoubleClick;
import net.autodata.nissan.qa.gpas.screenplay.customactions.RightClick;
import net.autodata.nissan.qa.gpas.screenplay.ui.EditModelPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


public class CreateModelDisclaimerWithRequiredValues implements Task {

    private final String refCode;
    private final String shortName;
    private final String description;

    public CreateModelDisclaimerWithRequiredValues(String refCode, String shortName, String description) {
        this.refCode = refCode;
        this.shortName = shortName;
        this.description = description;
    }

    @Override
    @Step("{0} looks to create model disclaimers")
    public <T extends Actor> void performAs(T actor) {

        if(getDriver().findElements(By.xpath("//div[@role='tabpanel']/div[9]/div/div/table/tbody/tr")).size()==0)
            actor.attemptsTo(RightClick.on(EditModelPage.DISCLAIMER_TABLE));
        else
            actor.attemptsTo(RightClick.on(EditModelPage.DISCLAIMER_TABLE_ROW1));

            actor.attemptsTo(

                    Click.on(EditModelPage.STYLE_MENU_OPTION("Insert New Record")),
                    Enter.theValue(refCode).into(EditModelPage.INPUT_BOX_TITLED("Ref Code","Ref Code")),
                    Enter.theValue(shortName).into(EditModelPage.INPUT_BOX_TITLED("Short Name","Short Name")),
                    DoubleClick.on(EditModelPage.DISCLAIMER_DESC_TABLE_ROW1),
                    Enter.theValue(description).into(EditModelPage.DISCLAIMER_DESCRIPTION_TEXT),
                    Click.on(EditModelPage.TRANSLATE_BUTTON_EN),
                    Click.on(EditModelPage.BUTTON_TARGET("Submit Button","Submit")),
                    Click.on(EditModelPage.BUTTON_TARGET("Submit Button","Submit"))
            );
        }

}
