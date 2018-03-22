package net.autodata.nissan.qa.gpas.screenplay.model;

import net.autodata.nissan.qa.gpas.screenplay.tasks.CreateModelStylePricingWithRequiredValues;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class CreateModelStylePricingBuilder {

    private String priceState;
    private String modelPricing;
    private String effectiveDate;
    private String nonEffectiveDate;

    public CreateModelStylePricingBuilder withPriceState(String priceState) {
        this.priceState = priceState;
        return this;
    }

    public CreateModelStylePricingBuilder andModelPricing(String modelPricing) {
        this.modelPricing = modelPricing;
        return this;
    }

    public CreateModelStylePricingBuilder withEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
        return this;
    }

    public CreateModelStylePricingBuilder andNonEffectiveDate(String nonEffectiveDate) {
        this.nonEffectiveDate = nonEffectiveDate;
        return this;
    }

    public Performable createPricing() {
        return Instrumented.instanceOf(CreateModelStylePricingWithRequiredValues.class)
                .withProperties(priceState,modelPricing,effectiveDate,nonEffectiveDate);
    }
}
