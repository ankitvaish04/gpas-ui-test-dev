package net.autodata.nissan.qa.gpas.screenplay.model;

import lombok.Value;

@Value
public class FavoriteModelInformation {

    private final String ymmId;
    private final String country;
    private final String modelYear;
    private final String subDivision;
    private final String modelName;

}
