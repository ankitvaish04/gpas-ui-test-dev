package net.autodata.nissan.qa.gpas.screenplay.model;

import lombok.Value;

@Value
public class ModelInformation {

    private final String country;
    private final String modelYear;
    private final String subdivision;
    private final String modelName;
    private final String modelId;

}
