package net.autodata.nissan.qa.gpas.screenplay.model;

import lombok.Value;

@Value
public class CreateModelEquipmentInformation {

    private final String isHeader;
    private final String isSpec;
    private final String isMostPopular;
    private final String orderCode;
    private final String optionKind;
    private final String utf;
    private final String flags;
    private final String filterRules;

}
