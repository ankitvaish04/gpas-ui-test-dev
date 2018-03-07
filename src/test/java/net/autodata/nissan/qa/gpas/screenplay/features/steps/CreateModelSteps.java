package net.autodata.nissan.qa.gpas.screenplay.features.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.autodata.nissan.qa.gpas.screenplay.model.CreateModel;
import net.autodata.nissan.qa.gpas.screenplay.model.ModelInformation;
import net.autodata.nissan.qa.gpas.screenplay.model.SearchModel;
import net.autodata.nissan.qa.gpas.screenplay.questions.Model;
import net.autodata.nissan.qa.gpas.screenplay.utilities.GlobalVars;

import java.util.List;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

public class CreateModelSteps {

    private List<ModelInformation> modelInformationList;

    @And("^(?:.*) wants to create a model with basic information$")
    public void create_new_model(List<ModelInformation> modelInformationRequest) throws Throwable {

        modelInformationList = modelInformationRequest;

    }

    @When("^s?he has completed creating the model")
    public void create_new_model() throws Exception {
        modelInformationList.forEach(
                modelInfo ->
                        theActorInTheSpotlight().attemptsTo(
                                CreateModel.withModelInformation()
                                        .onCountry(modelInfo.getCountry())
                                        .andYear(modelInfo.getModelYear())
                                        .forSubdivision(modelInfo.getSubdivision())
                                        .withModelName(modelInfo.getModelName())
                                        .andModelId(modelInfo.getModelId())
                                        .createNewModel()
                        )
        );
    }

    @Then("^s?he should see the created model$")
    public void verify_created_model() throws Throwable {
        modelInformationList.forEach(
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

        theActorInTheSpotlight().should(seeThat(Model.displayedInList(), containsString((GlobalVars.ymmId))));
    }

}
