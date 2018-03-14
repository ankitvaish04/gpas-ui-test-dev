package net.autodata.nissan.qa.gpas.screenplay.features.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.autodata.nissan.qa.gpas.screenplay.model.CreateModel;
import net.autodata.nissan.qa.gpas.screenplay.model.ModelInformation;
import net.autodata.nissan.qa.gpas.screenplay.model.SearchModel;
import net.autodata.nissan.qa.gpas.screenplay.questions.ModelList;
import java.util.List;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.hasItem;


public class CreateModelSteps {

    private List<ModelInformation> modelInformationList;
    private String created_model = "";

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
                                        .andModelId(modelInfo.getModelPermId())
                                        .createNewModel()
                        )
        );
    }

    @Then("^s?he should see the created model$")
    public void verify_created_model() throws Throwable {
        modelInformationList.forEach(
                modelInfo ->
                {
                    theActorInTheSpotlight().attemptsTo(
                            SearchModel.searchModelYmmId()
                                    .onCountry(modelInfo.getCountry())
                                    .andYear(modelInfo.getModelYear())
                                    .forSubdivision(modelInfo.getSubdivision())
                                    .withModelName(modelInfo.getModelName())
                                    .searchModel()
                    );

                    created_model= modelInfo.getModelPermId() + " " + modelInfo.getModelName() + " {" + modelInfo.getModelPermId() + "}";
                    theActorInTheSpotlight().should(
                            seeThat(ModelList.displayed(modelInformationList), hasItem(created_model))
                    );
                }

        );
    }

}
