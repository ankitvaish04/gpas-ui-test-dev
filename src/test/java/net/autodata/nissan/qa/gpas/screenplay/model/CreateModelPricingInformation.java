package net.autodata.nissan.qa.gpas.screenplay.model;

import lombok.Value;

@Value
public class CreateModelPricingInformation {

    private final String orderCode;
    private final String priceState;
    private final String retailFleetStatus;
    private final String condition;
    private final String pricing;
    private final String effectiveDate;
    private final String nonEffectiveDate;

}
