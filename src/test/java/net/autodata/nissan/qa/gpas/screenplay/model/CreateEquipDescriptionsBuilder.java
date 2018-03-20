package net.autodata.nissan.qa.gpas.screenplay.model;

import net.autodata.nissan.qa.gpas.screenplay.tasks.CreateEquipDescriptionsWithRequiredValues;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class CreateEquipDescriptionsBuilder {

    private String descriptionType;
    private String description;

    public CreateEquipDescriptionsBuilder withDescriptionType(String descriptionType) {
        this.descriptionType = descriptionType;
        return this;
    }

    public CreateEquipDescriptionsBuilder andDescription(String description) {
        this.description = description;
        return this;
    }


    public Performable CreateEquipDescriptionsBuilder() {
        return Instrumented.instanceOf(CreateEquipDescriptionsWithRequiredValues.class)
                .withProperties(descriptionType,description);
    }
}
