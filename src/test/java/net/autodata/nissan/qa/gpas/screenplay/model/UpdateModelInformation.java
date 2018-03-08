package net.autodata.nissan.qa.gpas.screenplay.model;

import lombok.Value;

@Value
public class UpdateModelInformation {

    private final String effectivedate;
    private final String languages;
    private final String currencies;
    //private final String currenciesToRem;
    private final String priceTypes;
    private final String modelLineCode;
    private final String comment;

}
