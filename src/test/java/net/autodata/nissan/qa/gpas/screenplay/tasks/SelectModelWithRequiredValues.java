package net.autodata.nissan.qa.gpas.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;

public class SelectModelWithRequiredValues implements Task {

    private final String country;
    private final String year;
    private final String subDivision;
    private final String modelPermId;


    public SelectModelWithRequiredValues(String country, String year, String subDivision, String modelPermId) {
        this.country = country;
        this.year = year;
        this.subDivision = subDivision;
        this.modelPermId = modelPermId;
    }

    @Override
    @Step("{0} looks to select a model on #country and #year for #subDivision")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byValue(country).from(ModelDetails.SELECT_COUNTRY),
                SelectFromOptions.byValue(year).from(ModelDetails.SELECT_MODEL_YEAR),
                SelectFromOptions.byVisibleText(subDivision).from(ModelDetails.SELECT_SUBDIVISION),
                Click.on(ModelDetails.MODEL_NAME("Model Name", modelPermId))
        );
    }
}
