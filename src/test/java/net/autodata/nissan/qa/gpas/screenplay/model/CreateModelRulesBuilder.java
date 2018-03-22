package net.autodata.nissan.qa.gpas.screenplay.model;

import net.autodata.nissan.qa.gpas.screenplay.tasks.CreateModelRulesWithRequiredValues;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class CreateModelRulesBuilder {

    private String orderCode;
    private String operator;
    private String operand;

    public CreateModelRulesBuilder withOrderCode(String orderCode) {
        this.orderCode = orderCode;
        return this;
    }

    public CreateModelRulesBuilder andOperator(String operator) {
        this.operator = operator;
        return this;
    }

    public CreateModelRulesBuilder andOperand(String operand) {
        this.operand = operand;
        return this;
    }

    public Performable createModelRules() {
        return Instrumented.instanceOf(CreateModelRulesWithRequiredValues.class)
                .withProperties(orderCode,operator,operand);
    }
}
