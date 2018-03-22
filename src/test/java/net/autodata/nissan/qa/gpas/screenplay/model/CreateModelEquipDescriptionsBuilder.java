package net.autodata.nissan.qa.gpas.screenplay.model;

import net.autodata.nissan.qa.gpas.screenplay.tasks.CreateModelEquipDescriptionsWithRequiredValues;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class CreateModelEquipDescriptionsBuilder {

    private String descriptionType;
    private String description;

    public CreateModelEquipDescriptionsBuilder withDescriptionType(String descriptionType) {
        this.descriptionType = descriptionType;
        return this;
    }

    public CreateModelEquipDescriptionsBuilder andDescription(String description) {
        this.description = description;
        return this;
    }


    public Performable createEquipDescriptions() {
        return Instrumented.instanceOf(CreateModelEquipDescriptionsWithRequiredValues.class)
                .withProperties(descriptionType,description);
    }
}
