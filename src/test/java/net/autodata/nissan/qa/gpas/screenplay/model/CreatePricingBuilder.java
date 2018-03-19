package net.autodata.nissan.qa.gpas.screenplay.model;

import net.autodata.nissan.qa.gpas.screenplay.tasks.CreateMarketingDescriptionsWithRequiredValues;
import net.autodata.nissan.qa.gpas.screenplay.tasks.CreatePricingWithRequiredValues;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class CreatePricingBuilder {

    private String priceState;
    private String modelPricing;
    private String effectiveDate;
    private String nonEffectiveDate;

    public CreatePricingBuilder withPriceState(String priceState) {
        this.priceState = priceState;
        return this;
    }

    public CreatePricingBuilder andModelPricing(String modelPricing) {
        this.modelPricing = modelPricing;
        return this;
    }

    public CreatePricingBuilder withEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
        return this;
    }

    public CreatePricingBuilder andNonEffectiveDate(String nonEffectiveDate) {
        this.nonEffectiveDate = nonEffectiveDate;
        return this;
    }

    public Performable createPricing() {
        return Instrumented.instanceOf(CreatePricingWithRequiredValues.class)
                .withProperties(priceState,modelPricing,effectiveDate,nonEffectiveDate);
    }
}
