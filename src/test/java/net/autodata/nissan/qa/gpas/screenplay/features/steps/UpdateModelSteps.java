package net.autodata.nissan.qa.gpas.screenplay.features.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.autodata.nissan.qa.gpas.screenplay.model.*;
import net.autodata.nissan.qa.gpas.screenplay.questions.UpdatedModelInfo;
import java.util.List;
import java.util.Map;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;

public class UpdateModelSteps {

    private List<UpdateModelInformation> updateModelInformationList;
    List<Map<String,String>> data=null;

    @When("^(?:.*) to update a model with basic information$")
    public void update_new_model(List<UpdateModelInformation> updateModelInformationRequest) throws Exception {

        updateModelInformationList = updateModelInformationRequest;
        updateModelInformationList.forEach(
                modelInfo ->
                        theActorInTheSpotlight().attemptsTo(
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
                    theActorInTheSpotlight().should(
                            seeThat(UpdatedModelInfo.field("Model Name"), is(modelInfo.getModelName())),
                            seeThat(UpdatedModelInfo.field("Model Name"), is(modelInfo.getModelName())),
                            seeThat(UpdatedModelInfo.field("EffDate"), is(modelInfo.getEffectiveDate())),
                            seeThat(UpdatedModelInfo.field("MdlKnd"), is(modelInfo.getModelKind())),
                            seeThat(UpdatedModelInfo.field("Tarrif"), is(modelInfo.getTarrif())),
                            seeThat(UpdatedModelInfo.field("Comments"), is(modelInfo.getComment())),
                            seeThat(UpdatedModelInfo.field("Phase"), is(modelInfo.getPhase())),
                            seeThat(UpdatedModelInfo.field("CommKind"), is(modelInfo.getCommercialKind())),
                            seeThat(UpdatedModelInfo.field("ClientType"), is(modelInfo.getClientType()))
                    );

                  }
                );
    }
}