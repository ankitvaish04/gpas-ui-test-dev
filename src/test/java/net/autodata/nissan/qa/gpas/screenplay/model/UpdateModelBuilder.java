package net.autodata.nissan.qa.gpas.screenplay.model;

import net.autodata.nissan.qa.gpas.screenplay.tasks.UpdateModelWithRequiredValues;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class UpdateModelBuilder {

    private String effectiveDate;
    private String languages;
    private String currencies;
    private String priceTypes;
    private String modelKind;
    private String modelLineCode;
    private String program;
    private String commercialKind;
    private String clientType;
    private String phase;
    private String comment;
    private String tarrif;
    private String modelName;

    public UpdateModelBuilder withEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
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

    public UpdateModelBuilder andModelKind(String modelKind) {
        this.modelKind = modelKind;
        return this;
    }

    public UpdateModelBuilder andModelLineCode(String modelLineCode) {
        this.modelLineCode = modelLineCode;
        return this;
    }

    public UpdateModelBuilder andProgram(String program) {
        this.program = program;
        return this;
    }

    public UpdateModelBuilder andCommercialKind(String commercialKind) {
        this.commercialKind = commercialKind;
        return this;
    }

    public UpdateModelBuilder andClientType(String clientType) {
        this.clientType = clientType;
        return this;
    }

    public UpdateModelBuilder andPhase(String phase) {
        this.phase = phase;
        return this;
    }

    public UpdateModelBuilder andComment(String comment) {
        this.comment = comment;
        return this;
    }

    public UpdateModelBuilder andTarrif(String tarrif) {
        this.tarrif = tarrif;
        return this;
    }

    public UpdateModelBuilder andModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }
    public Performable updateModel() {
        return Instrumented.instanceOf(UpdateModelWithRequiredValues.class)
                .withProperties(effectiveDate, languages, currencies, priceTypes, modelKind, modelLineCode, program, commercialKind, clientType, phase, comment, tarrif, modelName);
    }
}
