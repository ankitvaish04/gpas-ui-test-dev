package net.autodata.nissan.qa.gpas.screenplay.tasks;

import net.autodata.nissan.qa.gpas.screenplay.customactions.RightClick;
import net.autodata.nissan.qa.gpas.screenplay.ui.EditModelPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


public class CreateModelStyleMarketingDescriptionsWithRequiredValues implements Task {

    private final String descriptionType;
    private final String description;

    public CreateModelStyleMarketingDescriptionsWithRequiredValues(String descriptionType, String description) {
        this.descriptionType = descriptionType;
        this.description = description;
    }

    @Override
    @Step("{0} looks to create marketing descriptions for a style")
    public <T extends Actor> void performAs(T actor) {

        if(getDriver().findElements(By.xpath("(//table[@class='r-border'])[last()-1]/tbody/tr[2]/td/table/tbody/tr")).size()==0)
            actor.attemptsTo(RightClick.on(EditModelPage.MARKETING_DESCRIPTIONS_TABLE));
        else
            actor.attemptsTo(RightClick.on(EditModelPage.MARKETING_DESCRIPTIONS_ROW1));

            actor.attemptsTo(

                    Click.on(EditModelPage.STYLE_MENU_OPTION("Insert New Record")),
                    SelectFromOptions.byVisibleText(descriptionType).from(EditModelPage.MARKETING_DESCRIPTIONS_TYPE),
                    Enter.theValue(description).into(EditModelPage.MARKETING_DESCRIPTION_TEXT),
                    Click.on(EditModelPage.TRANSLATE_BUTTON_EN),
                    Click.on(EditModelPage.BUTTON_TARGET("Submit Button", "Submit"))
            );
    }
}