package net.autodata.nissan.qa.gpas.screenplay.model;

import net.autodata.nissan.qa.gpas.screenplay.tasks.CheckCVCOptKindsWithRequiredValues;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class CheckCVCOptKindsBuilder {

    private String optkinds;

    public CheckCVCOptKindsBuilder withOptKinds(String optkinds) {
        this.optkinds = optkinds;
        return this;
    }

    public Performable getCVCOptKinds() {
        return Instrumented.instanceOf(CheckCVCOptKindsWithRequiredValues.class)
                .withProperties(optkinds);
    }
}
