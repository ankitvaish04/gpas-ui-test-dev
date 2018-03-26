package net.autodata.nissan.qa.gpas.screenplay.model;

import net.autodata.nissan.qa.gpas.screenplay.tasks.CreateModelDisclaimerWithRequiredValues;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

    public class CreateModelDisclaimerBuilder {

    private String refCode;
    private String shortName;
    private String description;

    public CreateModelDisclaimerBuilder withRefCode(String refCode) {
        this.refCode = refCode;
        return this;
    }

    public CreateModelDisclaimerBuilder andShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public CreateModelDisclaimerBuilder andDescription(String description) {
        this.description = description;
        return this;
    }

    public Performable createModelDisclaimer() {
        return Instrumented.instanceOf(CreateModelDisclaimerWithRequiredValues.class)
                .withProperties(refCode,shortName,description);
    }
}
