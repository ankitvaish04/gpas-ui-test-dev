package net.autodata.nissan.qa.gpas.screenplay.model;

import net.autodata.nissan.qa.gpas.screenplay.tasks.CreateModelEquipmentWithRequiredValues;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class CreateModelEquipmentBuilder {

    private String isHeader;
    private String isSpec;
    private String isMostPopular;
    private String orderCode;
    private String optionKind;
    private String utf;
    private String flags;
    private String filterRules;

    public CreateModelEquipmentBuilder withHeader(String isHeader) {
        this.isHeader = isHeader;
        return this;
    }

    public CreateModelEquipmentBuilder andSpec(String isSpec) {
        this.isSpec = isSpec;
        return this;
    }

    public CreateModelEquipmentBuilder andMostPopular(String isMostPopular) {
        this.isMostPopular = isMostPopular;
        return this;
    }

    public CreateModelEquipmentBuilder andOrderCode(String orderCode) {
        this.orderCode = orderCode;
        return this;
    }

    public CreateModelEquipmentBuilder andOptionKind(String optionKind) {
        this.optionKind = optionKind;
        return this;
    }

    public CreateModelEquipmentBuilder andUtf(String utf) {
        this.utf = utf;
        return this;
    }

    public CreateModelEquipmentBuilder andFlags(String flags) {
        this.flags = flags;
        return this;
    }

    public CreateModelEquipmentBuilder andFilterRules(String filterRules) {
        this.filterRules = filterRules;
        return this;
    }


    public Performable createModelEquipments() {
        return Instrumented.instanceOf(CreateModelEquipmentWithRequiredValues.class)
                .withProperties(isHeader,isSpec,isMostPopular,orderCode,optionKind,utf,flags,filterRules);
    }
}
