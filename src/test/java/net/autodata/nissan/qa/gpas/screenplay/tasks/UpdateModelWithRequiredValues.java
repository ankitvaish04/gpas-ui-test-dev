package net.autodata.nissan.qa.gpas.screenplay.tasks;

import net.autodata.nissan.qa.gpas.screenplay.customactions.*;
import net.autodata.nissan.qa.gpas.screenplay.ui.ApplicationHomePage;
import net.autodata.nissan.qa.gpas.screenplay.ui.EditModelPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;


public class UpdateModelWithRequiredValues implements Task {

    private final String effectiveDate;
    private final String languages;
    private final String currencies;
    private final String priceTypes;
    private final String modelKind;
    private final String modelLineCode;
    private final String program;
    private final String commercialKind;
    private final String clientType;
    private final String phase;
    private final String comment;
    private final String tarrif;
    private final String modelName;


    public UpdateModelWithRequiredValues(String effectiveDate, String languages, String currencies, String priceTypes, String modelKind, String modelLineCode, String program, String commercialKind, String clientType, String phase, String comment, String tarrif, String modelName) {
        this.effectiveDate = effectiveDate;
        this.languages = languages;
        this.currencies = currencies;
        this.priceTypes = priceTypes;
        this.modelKind = modelKind;
        this.modelLineCode = modelLineCode;
        this.program = program;
        this.commercialKind = commercialKind;
        this.clientType = clientType;
        this.phase = phase;
        this.comment = comment;
        this.tarrif = tarrif;
        this.modelName = modelName;
    }

    @Override
    @Step("{0} looks to update a model with Effective Date as #effectiveDate, Languages #languages, Currencies #currencies and Price Types #priceTypes and translate model information")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                    Click.on(ApplicationHomePage.BUTTON_TARGET("Edit Button","Edit")),
                    SwitchToChildWindow.edit(),
                    RetrieveModelYear.fromHeader(),
                    DoubleClick.on(EditModelPage.MODEL_NAME_HEADER),
                    Enter.theValue(effectiveDate).into(EditModelPage.INPUT_BOX_TITLED("Effective Date","Effective Date")),
                    Enter.theValue(modelKind).into(EditModelPage.INPUT_BOX_TITLED("Model Kind", "Model Kind")),
                    Enter.theValue(modelLineCode).into(EditModelPage.INPUT_BOX_TITLED("Model Line Code","Model Line Code")),
                    Enter.theValue(program).into(EditModelPage.INPUT_BOX_TITLED("Program","Program")),
                    Enter.theValue(commercialKind).into(EditModelPage.INPUT_BOX_TITLED("Commercial Kind","Commercial Kind")),
                    Enter.theValue(clientType).into(EditModelPage.INPUT_BOX_TITLED("Client Type","Client Type")),
                    Enter.theValue(phase).into(EditModelPage.INPUT_BOX_TITLED("Phase","Phase")),
                    Enter.theValue(comment).into(EditModelPage.INPUT_BOX_TITLED("Comment","Comment")),
                    Enter.theValue(tarrif).into(EditModelPage.INPUT_BOX_TITLED("Tarrif","Tarrif")),
                    Enter.theValue(modelName).into(EditModelPage.MODEL_NAME),
                    Click.on(EditModelPage.INPUT_BOX_TITLED("Languages", "Languages")),
                    SelectLanguages.byValue(languages),
                    Click.on(EditModelPage.BUTTON_TARGET("OK Button","OK")),
                    Click.on(EditModelPage.INPUT_BOX_TITLED("Currencies","Currencies")),
                    SelectCurrencies.byValue(currencies),
                    Click.on(EditModelPage.BUTTON_TARGET("OK Button","OK")),
                    Click.on(EditModelPage.BUTTON_TARGET("Submit Button","Submit"))

                );
    }
}