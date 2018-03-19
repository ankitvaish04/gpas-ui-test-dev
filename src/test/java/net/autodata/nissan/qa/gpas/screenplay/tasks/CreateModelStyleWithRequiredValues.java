package net.autodata.nissan.qa.gpas.screenplay.tasks;

import net.autodata.nissan.qa.gpas.screenplay.customactions.RightClick;
import net.autodata.nissan.qa.gpas.screenplay.ui.EditModelPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;

import static net.autodata.nissan.qa.gpas.screenplay.features.steps.CreateModelStyleSteps.createMarketingDescriptionsInformationList;
import static net.autodata.nissan.qa.gpas.screenplay.features.steps.CreateModelStyleSteps.createModelStyleInformationList;


public class CreateModelStyleWithRequiredValues implements Task {

    private final String styleID;
    private final String styleCode;
    private final String mfrStyleCode;
    private final String nCode;
    private final String styleName;
    private final String trim;
    private final String trimPlus;
    private final String versionName;
    private final String styleSetName;

    public static boolean flag = true;


    public CreateModelStyleWithRequiredValues(String styleID,String styleCode,String mfrStyleCode,String nCode,String styleName,String trim,String trimPlus,String versionName,String styleSetName) {
        this.styleID = styleID;
        this.styleCode = styleCode;
        this.mfrStyleCode = mfrStyleCode;
        this.nCode = nCode;
        this.styleName = styleName;
        this.trim = trim;
        this.trimPlus = trimPlus;
        this.versionName = versionName;
        this.styleSetName = styleSetName;

    }

    @Override
    @Step("{0} looks to create a model style")
    public <T extends Actor> void performAs(T actor) {

            actor.attemptsTo(

                    RightClick.on(EditModelPage.STYLE_TABLE),
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

            );

    }

}