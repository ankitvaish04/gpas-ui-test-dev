package net.autodata.nissan.qa.gpas.screenplay.tasks;

import net.autodata.nissan.qa.gpas.screenplay.mappers.SubdivisionMapper;
import net.autodata.nissan.qa.gpas.screenplay.ui.EditModelPage;
import net.autodata.nissan.qa.gpas.screenplay.customactions.SwitchToChildWindow;
import net.autodata.nissan.qa.gpas.screenplay.customactions.SwitchToParentWindow;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;

public class CreateModelWithRequiredValues implements Task {

    private final String country;
    private final String year;
    private final String subDivision;
    private final String subDivisionInInt;
    private final String modelName;
    private final String modelPermId;


    public CreateModelWithRequiredValues(String country, String year, String subDivision, String modelName, String modelPermId) {
        this.country = country;
        this.year = year;
        this.subDivision = subDivision;
        this.modelName = modelName;
        this.modelPermId = modelPermId;
        this.subDivisionInInt = SubdivisionMapper.subdivisionMapper.valueOf(
                subDivision.replaceAll("[ |/]", "_").toUpperCase()
        ).toString();
    }

    @Override
    @Step("{0} looks to create a model on #country and #year for #subDivision")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byValue(country).from(ModelDetails.SELECT_COUNTRY),
                Click.on(ModelDetails.CREATE_MODEL_BUTTON),
                SelectFromOptions.byValue(year).from(ModelDetails.SELECT_MODEL_YEAR_FROM_OPTION),
                SelectFromOptions.byValue(subDivisionInInt).from(ModelDetails.SELECT_SUBDIVISION_FROM_OPTION),
                Enter.theValue(modelPermId).into(ModelDetails.CREATE_MODEL_PERM_ID),
                Enter.theValue(modelName).into(ModelDetails.CREATE_MODEL_NAME),
                Enter.theValue(modelPermId).into(ModelDetails.CREATE_MODEL_SEQUENCE),
                Click.on(ModelDetails.MODEL_SUBMIT_BUTTON),
//              Enter.theValue(GlobalVars.ymmId).into(ApplicationHomePage.INPUT_BOX_TARGET("ymmID","Enter Year Make ModelList Id")),
//              Click.on(ApplicationHomePage.BUTTON_TARGET("Edit Button","Edit")),
                SwitchToChildWindow.edit(),
                Click.on(EditModelPage.MODELACTION_LISTBOX),
                //RetrieveYmmId.fromUrl(),
                SelectFromOptions.byValue("Close").from(EditModelPage.MODELACTION_LISTBOX),
                SwitchToParentWindow.parent()

        );
    }
}