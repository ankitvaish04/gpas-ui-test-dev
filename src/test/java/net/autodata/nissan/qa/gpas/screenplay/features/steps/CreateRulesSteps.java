package net.autodata.nissan.qa.gpas.screenplay.features.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.autodata.nissan.qa.gpas.screenplay.customactions.CloseEditModelWindow;
import net.autodata.nissan.qa.gpas.screenplay.customactions.CommitModelData;
import net.autodata.nissan.qa.gpas.screenplay.customactions.SwitchToChildWindow;
import net.autodata.nissan.qa.gpas.screenplay.model.*;
import net.autodata.nissan.qa.gpas.screenplay.questions.CreatedModelRulesInfo;
import net.autodata.nissan.qa.gpas.screenplay.ui.ApplicationHomePage;
import net.autodata.nissan.qa.gpas.screenplay.ui.EditModelPage;
import net.serenitybdd.screenplay.actions.Click;
import java.util.List;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class CreateRulesSteps {

    public static List<CreateModelRulesInformation> createModelRulesInformationList;

    @When("^(?:.*) to create rules with basic information$")
    public void create_new_rules(List<CreateModelRulesInformation> createModelRulesInformationRequest) throws Exception {

        createModelRulesInformationList = createModelRulesInformationRequest;
        theActorInTheSpotlight().attemptsTo(
                Click.on(ApplicationHomePage.BUTTON_TARGET("Edit Button","Edit")),
                SwitchToChildWindow.edit(),
                Click.on(EditModelPage.TABS_TARGET("Rule Tab", "Rule"))
        );
        createModelRulesInformationList.forEach(
                modelRulesInfo ->
                        theActorInTheSpotlight().attemptsTo(
                                CreateModelRules.withInformation()
                                        .withOrderCode(modelRulesInfo.getOrderCode())
                                        .andOperator(modelRulesInfo.getOperator())
                                        .andOperand(modelRulesInfo.getOperand())
                                        .createModelRules()
                        )
        );
    }

    @Then("^s?he should see the created rules for the model$")
    public void verify_model_rules() throws Throwable {

        int index = 0;
        int j = createModelRulesInformationList.size();

        for (CreateModelRulesInformation el:createModelRulesInformationList){
            index = createModelRulesInformationList.indexOf(el)+ j;
            j = j-2;
            theActorInTheSpotlight().should(seeThat(CreatedModelRulesInfo.field("Code", index), is(el.getOrderCode())));
            theActorInTheSpotlight().should(seeThat(CreatedModelRulesInfo.field("O", index), is(el.getOperator())));
            theActorInTheSpotlight().should(seeThat(CreatedModelRulesInfo.field("Operand", index), is(el.getOperand())));
        }

        theActorInTheSpotlight().attemptsTo(CommitModelData.commit());
        theActorInTheSpotlight().attemptsTo(CloseEditModelWindow.close());
    }
}