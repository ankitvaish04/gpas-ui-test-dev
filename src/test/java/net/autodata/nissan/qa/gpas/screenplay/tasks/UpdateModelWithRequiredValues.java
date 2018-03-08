package net.autodata.nissan.qa.gpas.screenplay.tasks;

import net.autodata.nissan.qa.gpas.screenplay.customactions.DoubleClick;
import net.autodata.nissan.qa.gpas.screenplay.customactions.RetrieveModelYear;
import net.autodata.nissan.qa.gpas.screenplay.ui.EditModel;
import net.autodata.nissan.qa.gpas.screenplay.utilities.GlobalVars;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class UpdateModelWithRequiredValues implements Task {

    private final String effectivedate;
    private final String languages;
    private final String currencies;
    //private final String currenciesToRem;
    private final String priceTypes;
    private final String modelLineCode;
    private final String comment;
    private final String ymmID = GlobalVars.ymmId;

    public UpdateModelWithRequiredValues(String effectivedate, String languages, String currencies, String priceTypes, String modelLineCode, String comment) {
        this.effectivedate = effectivedate;
        this.languages = languages;
        this.currencies = currencies;
        this.priceTypes = priceTypes;
        this.modelLineCode = modelLineCode;
        this.comment = comment;
    }

    @Override
    @Step("{0} looks to update a model with Effective Date as #effectivedate, Languages #languages, Currencies #currencies and Price Types #priceTypes for #ymmId and translate model information")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                RetrieveModelYear.fromHeader(),
                DoubleClick.on(EditModel.MODEL_NAME),
                Enter.theValue(effectivedate).into(EditModel.INPUT_BOX_TARGET("Effective Date","Effective Date")),
                Enter.theValue(modelLineCode).into(EditModel.INPUT_BOX_TARGET("Model Line Code","Model Line Code")),
                Enter.theValue(comment).into(EditModel.INPUT_BOX_TARGET("Comment","Comment"))

        );
    }
}