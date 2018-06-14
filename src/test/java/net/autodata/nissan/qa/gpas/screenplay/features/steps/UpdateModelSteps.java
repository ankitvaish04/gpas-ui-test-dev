package net.autodata.nissan.qa.gpas.screenplay.features.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.autodata.nissan.qa.gpas.screenplay.customactions.CommitModelData;
import net.autodata.nissan.qa.gpas.screenplay.customactions.CloseEditModelWindow;
import net.autodata.nissan.qa.gpas.screenplay.model.*;
import net.autodata.nissan.qa.gpas.screenplay.questions.UpdatedModelInfo;
import java.util.List;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.autodata.nissan.qa.gpas.screenplay.features.steps.UserLoginSteps.actor;
import static org.hamcrest.Matchers.*;

public class UpdateModelSteps {

    private List<UpdateModelInformation> updateModelInformationList;

    @When("^(?:.*) to update a model with basic information$")
    public void update_new_model(List<UpdateModelInformation> updateModelInformationRequest) throws Exception {

        updateModelInformationList = updateModelInformationRequest;
        updateModelInformationList.forEach(
                modelInfo ->
                        actor.attemptsTo(
                                UpdateModel.withModelInformation()
                                        .withEffectiveDate(modelInfo.getEffectiveDate())
                                        .forLanguages(modelInfo.getLanguages())
                                        .andCurrencies(modelInfo.getCurrencies())
                                        .andPriceTypes(modelInfo.getPriceTypes())
                                        .andModelKind(modelInfo.getModelKind())
                                        .andModelLineCode(modelInfo.getModelLineCode())
                                        .andProgram(modelInfo.getProgram())
                                        .andCommercialKind(modelInfo.getCommercialKind())
                                        .andClientType(modelInfo.getClientType())
                                        .andPhase(modelInfo.getPhase())
                                        .andComment(modelInfo.getComment())
                                        .andTarrif(modelInfo.getTarrif())
                                        .andModelName(modelInfo.getModelName())
                                        .updateModel()
                        )
        );
    }

    @Then("^s?he should see the updated model$")
    public void verify_updated_model() throws Throwable {
        updateModelInformationList.forEach(
                modelInfo -> {
                    actor.should(seeThat(UpdatedModelInfo.field("Model Name"), is(modelInfo.getModelName())));
                    actor.should(seeThat(UpdatedModelInfo.field("Program"), is(modelInfo.getProgram())));
                    actor.should(seeThat(UpdatedModelInfo.field("EffDate"), is(modelInfo.getEffectiveDate())));
                    actor.should(seeThat(UpdatedModelInfo.field("MdlKnd"), is(modelInfo.getModelKind())));
                    actor.should(seeThat(UpdatedModelInfo.field("Tarrif"), is(modelInfo.getTarrif())));
                    actor.should(seeThat(UpdatedModelInfo.field("Comments"), is(modelInfo.getComment())));
                    actor.should(seeThat(UpdatedModelInfo.field("Phase"), is(modelInfo.getPhase())));
                    actor.should(seeThat(UpdatedModelInfo.field("CommKind"), is(modelInfo.getCommercialKind())));
                    actor.should(seeThat(UpdatedModelInfo.field("ClientType"), is(modelInfo.getClientType())));
                  }
                );

        actor.attemptsTo(CommitModelData.commit());
        actor.attemptsTo(CloseEditModelWindow.close());

    }
}