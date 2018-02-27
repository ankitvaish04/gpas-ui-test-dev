package net.autodata.nissan.qa.gpas.screenplay.tasks;

import net.autodata.nissan.qa.gpas.screenplay.mappers.SubdivisionMapper;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateModelWithRequiredValues implements Task {

    private final String country;
    private final String year;
    private final String subDivision;
    private final String subDivisionInInt;
    private final String modelName;
    private final String modelId;

    public CreateModelWithRequiredValues(String country, String year, String subDivision, String modelName, String modelId) {
        this.country = country;
        this.year = year;
        this.subDivision = subDivision;
        this.modelName = modelName;
        this.modelId = modelId;
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
                Enter.theValue(modelId).into(ModelDetails.CREATE_MODEL_PERM_ID),
                Enter.theValue(modelName).into(ModelDetails.CREATE_MODEL_NAME),
                Enter.theValue(modelId).into(ModelDetails.CREATE_MODEL_SEQUENCE),
                Click.on(ModelDetails.MODEL_SUBMIT_BUTTON)
        );
    }
}
