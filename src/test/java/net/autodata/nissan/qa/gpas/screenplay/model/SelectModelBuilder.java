package net.autodata.nissan.qa.gpas.screenplay.model;

import net.autodata.nissan.qa.gpas.screenplay.tasks.SearchModelWithRequiredValues;
import net.autodata.nissan.qa.gpas.screenplay.tasks.SelectModelWithRequiredValues;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class SelectModelBuilder {

    private String country;
    private String year;
    private String subDivision;
    private String modelPermID;

    public SelectModelBuilder onCountry(String country) {
        this.country = country;
        return this;
    }

    public SelectModelBuilder andYear(String year) {
        this.year = year;
        return this;
    }

    public SelectModelBuilder forSubdivision(String subDivision) {
        this.subDivision = subDivision;
        return this;
    }
    public SelectModelBuilder withModelPermID(String modelPermId) {
        this.modelPermID=modelPermId;
        return this;
    }
    public Performable selectModel() {
        return Instrumented.instanceOf(SelectModelWithRequiredValues.class)
                .withProperties(country, year, subDivision,modelPermID);
    }


}
