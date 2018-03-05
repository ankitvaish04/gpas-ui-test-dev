package net.autodata.nissan.qa.gpas.screenplay.tasks;

import net.autodata.nissan.qa.gpas.screenplay.mappers.SubdivisionMapper;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;

public class SearchModelWithRequiredValues implements Task {

    private final String country;
    private final String year;
    private final String subDivision;
    private final String subDivisionInInt;
    private final String modelName;

    public SearchModelWithRequiredValues(String country, String year, String subDivision, String modelName) {
        this.country = country;
        this.year = year;
        this.subDivision = subDivision;
        this.modelName = modelName;
        this.subDivisionInInt = SubdivisionMapper.subdivisionMapper.valueOf(
                subDivision.replaceAll("[ |/]", "_").toUpperCase()
        ).toString();
    }

    @Override
    @Step("{0} looks to create a model on #country and #year for #subDivision")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byValue(country).from(ModelDetails.SELECT_COUNTRY),
                SelectFromOptions.byValue(year).from(ModelDetails.SELECT_MODEL_YEAR),
                SelectFromOptions.byVisibleText(subDivision).from(ModelDetails.SELECT_SUBDIVISION)
                //SelectFromOptions.byVisibleText(modelName).from(ModelDetails.SELECT_MODEL_YMMID)

//                SelectFromOptions.byValue(country).from(ModelDetails.SELECT_COUNTRY),
//                SelectFromOptions.byValue(year).from(ModelDetails.SELECT_MODEL_YEAR),
//                SelectFromOptions.byVisibleText(subDivision).from(ModelDetails.SELECT_SUBDIVISION),
//                Click.on(ModelDetails.CREATE_MODEL_BUTTON)
        );
    }
}
