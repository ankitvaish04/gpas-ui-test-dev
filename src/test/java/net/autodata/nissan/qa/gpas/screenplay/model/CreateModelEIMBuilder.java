package net.autodata.nissan.qa.gpas.screenplay.model;

import net.autodata.nissan.qa.gpas.screenplay.tasks.CreateModelEIMWithRequiredValues;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class CreateModelEIMBuilder {

    private String position;
    private String character;
    private String condition;

    public CreateModelEIMBuilder withPosition(String position) {
        this.position = position;
        return this;
    }

    public CreateModelEIMBuilder andCharacter(String character) {
        this.character = character;
        return this;
    }

    public CreateModelEIMBuilder andCondition(String condition) {
        this.condition = condition;
        return this;
    }

    public Performable createModelEIM() {
        return Instrumented.instanceOf(CreateModelEIMWithRequiredValues.class)
                .withProperties(position,character,condition);
    }
}
