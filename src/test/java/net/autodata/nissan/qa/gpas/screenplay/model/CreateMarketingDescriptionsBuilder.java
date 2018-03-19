package net.autodata.nissan.qa.gpas.screenplay.model;

import net.autodata.nissan.qa.gpas.screenplay.tasks.CreateMarketingDescriptionsWithRequiredValues;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class CreateMarketingDescriptionsBuilder {

    private String descriptionType;
    private String description;

    public CreateMarketingDescriptionsBuilder withDescriptionTypeId(String descriptionType) {
        this.descriptionType = descriptionType;
        return this;
    }

    public CreateMarketingDescriptionsBuilder andDescription(String description) {
        this.description = description;
        return this;
    }

    public Performable createMarketingDescriptions() {
        return Instrumented.instanceOf(CreateMarketingDescriptionsWithRequiredValues.class)
                .withProperties(descriptionType,description);
    }
}
