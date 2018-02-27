package net.autodata.nissan.qa.gpas.screenplay.model;

import net.autodata.nissan.qa.gpas.screenplay.tasks.CreateModelWithRequiredValues;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class CreateModelBuilder {

    private String country;
    private String year;
    private String subDivision;
    private String modelName;
    private String modelId;

    public CreateModelBuilder onCountry(String country) {
        this.country = country;
        return this;
    }

    public CreateModelBuilder andYear(String year) {
        this.year = year;
        return this;
    }

    public CreateModelBuilder forSubdivision(String subDivision) {
        this.subDivision = subDivision;
        return this;
    }

    public CreateModelBuilder withModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public CreateModelBuilder andModelId(String modelId) {
        this.modelId = modelId;
        return this;
    }

    public Performable createNewModel() {
        return Instrumented.instanceOf(CreateModelWithRequiredValues.class)
                .withProperties(country, year, subDivision, modelName, modelId);
    }
}
