package net.autodata.nissan.qa.gpas.screenplay.model;

import net.autodata.nissan.qa.gpas.screenplay.tasks.CreateModelPricingWithRequiredValues;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

    public class CreateModelPricingBuilder {

    private String orderCode;
    private String priceState;
    private String retailFleetStatus;
    private String condition;
    private String pricing;
    private String effectiveDate;
    private String nonEffectiveDate;

    public CreateModelPricingBuilder withOrderCode(String orderCode) {
        this.orderCode = orderCode;
        return this;
    }

    public CreateModelPricingBuilder andPriceState(String priceState) {
        this.priceState = priceState;
        return this;
    }

    public CreateModelPricingBuilder andRetailFleetStatus(String retailFleetStatus) {
        this.retailFleetStatus = retailFleetStatus;
        return this;
    }

    public CreateModelPricingBuilder andCondition(String condition) {
        this.condition = condition;
        return this;
    }

    public CreateModelPricingBuilder andPricing(String pricing) {
        this.pricing = pricing;
        return this;
    }

    public CreateModelPricingBuilder andEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
        return this;
    }

    public CreateModelPricingBuilder andNonEffectiveDate(String nonEffectiveDate) {
        this.nonEffectiveDate = nonEffectiveDate;
        return this;
    }

    public Performable createModelPricing() {
        return Instrumented.instanceOf(CreateModelPricingWithRequiredValues.class)
                .withProperties(orderCode,priceState,retailFleetStatus,condition,pricing,effectiveDate,nonEffectiveDate);
    }
}
