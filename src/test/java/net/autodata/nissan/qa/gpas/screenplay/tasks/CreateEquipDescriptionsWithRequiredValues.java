package net.autodata.nissan.qa.gpas.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;


public class CreateEquipDescriptionsWithRequiredValues implements Task {

    private final String descriptionType;
    private final String description;


    public CreateEquipDescriptionsWithRequiredValues(String descriptionType, String description) {
        this.descriptionType = descriptionType;
        this.description = description;
    }

    @Override
    @Step("{0} looks to create equipment descriptions")
    public <T extends Actor> void performAs(T actor) {

/*        if(getDriver().findElements(By.xpath("//div[@role='tabpanel']/div[2]/div/div/table/tbody/tr")).size()==0)
            actor.attemptsTo(RightClick.on(EditModelPage.STYLE_TABLE));
        else
            actor.attemptsTo(RightClick.on(EditModelPage.STYLE_TABLE_ROW1));

            actor.attemptsTo(

                    Click.on(EditModelPage.STYLE_MENU_OPTION("Insert New Record")),
                    Enter.theValue(styleID).into(EditModelPage.INPUT_BOX_TARGET("pStyle Id", "StylePermId")),
                    Enter.theValue(styleCode).into(EditModelPage.INPUT_BOX_TARGET("Style Code", "Style Code")),
                    Enter.theValue(mfrStyleCode).into(EditModelPage.INPUT_BOX_TARGET("Mfr Style Code", "Mfr Style Code")),
                    Enter.theValue(nCode).into(EditModelPage.INPUT_BOX_TARGET("NCode", "NCode")),
                    Enter.theValue(styleName).into(EditModelPage.INPUT_BOX_TARGET("Style Name", "Style Name")),
                    Enter.theValue(trim).into(EditModelPage.INPUT_BOX_TARGET("Trim", "Trim")),
                    Enter.theValue(trimPlus).into(EditModelPage.INPUT_BOX_TARGET("Trim Plus", "Trim Plus")),
                    Enter.theValue(versionName).into(EditModelPage.INPUT_BOX_TARGET("Version Name", "Version Name")),
                    Click.on(EditModelPage.TRANSLATE_BUTTON_EN)

            );*/
    }

}