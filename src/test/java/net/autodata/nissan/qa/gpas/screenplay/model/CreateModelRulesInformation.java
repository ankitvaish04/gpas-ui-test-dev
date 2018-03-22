package net.autodata.nissan.qa.gpas.screenplay.model;

import lombok.Value;

@Value
public class CreateModelRulesInformation {

    private final String orderCode;
    private final String operator;
    private final String operand;

}
