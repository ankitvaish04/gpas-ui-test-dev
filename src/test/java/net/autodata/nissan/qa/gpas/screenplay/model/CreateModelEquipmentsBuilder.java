package net.autodata.nissan.qa.gpas.screenplay.model;

import net.autodata.nissan.qa.gpas.screenplay.tasks.CreateModelEquipmentsWithRequiredValues;
import net.autodata.nissan.qa.gpas.screenplay.tasks.CreateModelStyleWithRequiredValues;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class CreateModelEquipmentsBuilder {

    private String isHeader;
    private String isSpec;
    private String isMostPopular;
    private String orderCode;
    private String optionKind;
    private String utf;
    private String flags;
    private String filterRules;

    public CreateModelEquipmentsBuilder withHeader(String isHeader) {
        this.isHeader = isHeader;
        return this;
    }

    public CreateModelEquipmentsBuilder andSpec(String isSpec) {
        this.isSpec = isSpec;
        return this;
    }

    public CreateModelEquipmentsBuilder andMostPopular(String isMostPopular) {
        this.isMostPopular = isMostPopular;
        return this;
    }

    public CreateModelEquipmentsBuilder andOrderCode(String orderCode) {
        this.orderCode = orderCode;
        return this;
    }

    public CreateModelEquipmentsBuilder andOptionKind(String optionKind) {
        this.optionKind = optionKind;
        return this;
    }

    public CreateModelEquipmentsBuilder andUtf(String utf) {
        this.utf = utf;
        return this;
    }

    public CreateModelEquipmentsBuilder andFlags(String flags) {
        this.flags = flags;
        return this;
    }

    public CreateModelEquipmentsBuilder andFilterRules(String filterRules) {
        this.filterRules = filterRules;
        return this;
    }


    public Performable CreateModelEquipmentsBuilder() {
        return Instrumented.instanceOf(CreateModelEquipmentsWithRequiredValues.class)
                .withProperties(isHeader,isSpec,isMostPopular,orderCode,optionKind,utf,flags,filterRules);
    }
}
