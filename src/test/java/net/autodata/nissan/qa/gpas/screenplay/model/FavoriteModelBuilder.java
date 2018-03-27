package net.autodata.nissan.qa.gpas.screenplay.model;

import net.autodata.nissan.qa.gpas.screenplay.tasks.OpenModelWithRequiredValues;
import net.autodata.nissan.qa.gpas.screenplay.tasks.RemoveModelWithRequiredValues;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class FavoriteModelBuilder {

    private String ymmId;
    private String country;
    private String modelYear;
    private String subDivision;
    private String modelName;

    public FavoriteModelBuilder withYmmId(String ymmId) {
        this.ymmId = ymmId;
        return this;
    }

    public FavoriteModelBuilder onCountry(String country) {
        this.country = country;
        return this;
    }

    public FavoriteModelBuilder andYear(String modelYear) {
        this.modelYear = modelYear;
        return this;
    }

    public FavoriteModelBuilder forSubdivision(String subDivision) {
        this.subDivision = subDivision;
        return this;
    }

    public FavoriteModelBuilder withModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public Performable openModel() {
        return Instrumented.instanceOf(OpenModelWithRequiredValues.class)
                .withProperties(ymmId, country, modelYear, subDivision, modelName);
    }

    public Performable removeModel() {
        return Instrumented.instanceOf(RemoveModelWithRequiredValues.class)
                .withProperties(ymmId, country, modelYear, subDivision, modelName);
    }
}
