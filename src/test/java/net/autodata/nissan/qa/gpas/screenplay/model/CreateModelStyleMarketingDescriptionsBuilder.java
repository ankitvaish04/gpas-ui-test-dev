package net.autodata.nissan.qa.gpas.screenplay.model;

import net.autodata.nissan.qa.gpas.screenplay.tasks.CreateModelStyleMarketingDescriptionsWithRequiredValues;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class CreateModelStyleMarketingDescriptionsBuilder {

    private String descriptionType;
    private String description;

    public CreateModelStyleMarketingDescriptionsBuilder withDescriptionTypeId(String descriptionType) {
        this.descriptionType = descriptionType;
        return this;
    }

    public CreateModelStyleMarketingDescriptionsBuilder andDescription(String description) {
        this.description = description;
        return this;
    }

    public Performable createMarketingDescriptions() {
        return Instrumented.instanceOf(CreateModelStyleMarketingDescriptionsWithRequiredValues.class)
                .withProperties(descriptionType,description);
    }
}
