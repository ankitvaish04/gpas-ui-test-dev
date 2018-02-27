package net.autodata.nissan.qa.gpas.screenplay.model;

import net.autodata.nissan.qa.gpas.screenplay.tasks.SearchModelWithRequiredValues;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class SearchModelBuilder {

    private String country;
    private String year;
    private String subDivision;
    private String modelName;

    public SearchModelBuilder onCountry(String country) {
        this.country = country;
        return this;
    }

    public SearchModelBuilder andYear(String year) {
        this.year = year;
        return this;
    }

    public SearchModelBuilder forSubdivision(String subDivision) {
        this.subDivision = subDivision;
        return this;
    }

    public SearchModelBuilder withModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public Performable searchModel() {
        return Instrumented.instanceOf(SearchModelWithRequiredValues.class)
                .withProperties(country, year, subDivision, modelName);
    }
}
