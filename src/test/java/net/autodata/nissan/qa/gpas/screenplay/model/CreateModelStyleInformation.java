package net.autodata.nissan.qa.gpas.screenplay.model;

import lombok.Value;

@Value
public class CreateModelStyleInformation {

    private final String styleID;
    private final String styleCode;
    private final String mfrStyleCode;
    private final String nCode;
    private final String styleName;
    private final String trim;
    private final String trimPlus;
    private final String versionName;
    private final String styleSetName;

}
