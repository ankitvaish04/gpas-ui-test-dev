package net.autodata.nissan.qa.gpas.screenplay.features.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.autodata.nissan.qa.gpas.screenplay.model.*;
import java.util.List;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UpdateModelSteps {

    private List<UpdateModelInformation> updateModelInformationList;

    @And("^(?:.*) to update a model with basic information$")
    public void update_new_model(List<UpdateModelInformation> updateModelInformationRequest) throws Throwable {

        updateModelInformationList = updateModelInformationRequest;

    }

    @When("^s?he has completed updating the model")
    public void update_new_model() throws Exception {
        updateModelInformationList.forEach(
                modelInfo ->
                        theActorInTheSpotlight().attemptsTo(
                                UpdateModel.withModelInformation()
                                        .withEffectiveDate(modelInfo.getEffectivedate())
                                        .forLanguages(modelInfo.getLanguages())
                                        .andCurrencies(modelInfo.getCurrencies())
                                        .andPriceTypes(modelInfo.getPriceTypes())
                                        .andModelLineCode(modelInfo.getModelLineCode())
                                        .updateModel()
                        )
        );
    }

    @Then("^s?he should see the updated model$")
    public void verify_updated_model() throws Throwable {
        /*modelInformationList.forEach(
                modelInfo ->
                        theActorInTheSpotlight().attemptsTo(
                                SearchModel.searchModelYmmId()
                                        .onCountry(modelInfo.getCountry())
                                        .andYear(modelInfo.getModelYear())
                                        .forSubdivision(modelInfo.getSubdivision())
                                        .withModelName(modelInfo.getModelName())
                                        .searchModel()
                        )
        );

        theActorInTheSpotlight().should(seeThat(Model.displayedInList(), containsString((GlobalVars.ymmId)))); */
    }

}