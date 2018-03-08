package net.autodata.nissan.qa.gpas.screenplay.model;

import net.autodata.nissan.qa.gpas.screenplay.tasks.UpdateModelWithRequiredValues;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class UpdateModelBuilder {

    private String effectivedate;
    private String languages;
    private String currencies;
    //private final String currenciesToRem;
    private String priceTypes;
    private String modelLineCode;

    public UpdateModelBuilder withEffectiveDate(String effectivedate) {
        this.effectivedate = effectivedate;
        return this;
    }

    public UpdateModelBuilder forLanguages(String languages) {
        this.languages = languages;
        return this;
    }

    public UpdateModelBuilder andCurrencies(String currencies) {
        this.currencies = currencies;
        return this;
    }

    public UpdateModelBuilder andPriceTypes(String priceTypes) {
        this.priceTypes = priceTypes;
        return this;
    }

    public UpdateModelBuilder andModelLineCode(String modelLineCode) {
        this.modelLineCode = modelLineCode;
        return this;
    }

    public Performable updateModel() {
        return Instrumented.instanceOf(UpdateModelWithRequiredValues.class)
                .withProperties(effectivedate, languages, currencies, priceTypes, modelLineCode);
    }
}
