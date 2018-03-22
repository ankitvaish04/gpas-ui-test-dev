package net.autodata.nissan.qa.gpas.screenplay.model;

import lombok.Value;

@Value
public class CreateModelStylePricingInformation {

    private final String priceState;
    private final String modelPricing;
    private final String effectiveDate;
    private final String nonEffectiveDate;

}
