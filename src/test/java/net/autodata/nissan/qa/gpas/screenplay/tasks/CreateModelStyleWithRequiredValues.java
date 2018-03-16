package net.autodata.nissan.qa.gpas.screenplay.tasks;

import net.autodata.nissan.qa.gpas.screenplay.customactions.RightClick;
import net.autodata.nissan.qa.gpas.screenplay.customactions.SwitchToChildWindow;
import net.autodata.nissan.qa.gpas.screenplay.ui.ApplicationHomePage;
import net.autodata.nissan.qa.gpas.screenplay.ui.EditModelPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;


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

                Click.on(ApplicationHomePage.BUTTON_TARGET("Edit Button","Edit")),
                SwitchToChildWindow.edit(),
                Click.on(EditModelPage.TABS_TARGET("Style Tab", "Style")),
                RightClick.on(EditModelPage.STYLE_TABLE_ROW),
                Click.on(EditModelPage.STYLE_MENU_OPTION("Insert New Record"))

/*
                SelectFromOptions.byValue(country).from(ModelDetails.SELECT_COUNTRY),
                Click.on(ModelDetails.CREATE_MODEL_BUTTON),
                SelectFromOptions.byValue(year).from(ModelDetails.SELECT_MODEL_YEAR_FROM_OPTION),
                SelectFromOptions.byValue(subDivisionInInt).from(ModelDetails.SELECT_SUBDIVISION_FROM_OPTION),
                Enter.theValue(modelPermId).into(ModelDetails.CREATE_MODEL_PERM_ID),
                Enter.theValue(modelName).into(ModelDetails.CREATE_MODEL_NAME),
                Enter.theValue(modelPermId).into(ModelDetails.CREATE_MODEL_SEQUENCE),
                Click.on(ModelDetails.MODEL_SUBMIT_BUTTON),
                SwitchToChildWindow.edit(),
                Click.on(EditModelPage.MODELACTION_LISTBOX),
                SelectFromOptions.byValue("Close").from(EditModelPage.MODELACTION_LISTBOX),
                SwitchToParentWindow.parent()
*/

        );
    }
}