package net.autodata.nissan.qa.gpas.screenplay.features.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.autodata.nissan.qa.gpas.screenplay.customactions.ClickOkOn;
import net.autodata.nissan.qa.gpas.screenplay.model.*;
import net.autodata.nissan.qa.gpas.screenplay.questions.ModelList;
import net.autodata.nissan.qa.gpas.screenplay.ui.ApplicationHomePage;
import net.serenitybdd.screenplay.actions.Click;
import java.util.List;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.hasItem;


public class RetireUnretireModelSteps {

    private List<ModelInformation> modelInformationList;
    private String retired_model = "";
    private String unretired_model = "";

    @When("^(?:.*) selects a model to retire with basic information")
    public void select_model_to_retire(List<ModelInformation> modelInformationRequest) throws Exception {
        modelInformationList = modelInformationRequest;
        modelInformationList.forEach(
                modelInfo ->
                {
                    theActorInTheSpotlight().attemptsTo(
                            SelectDetails.withModelInformation()
                                    .onCountry(modelInfo.getCountry())
                                    .andYear(modelInfo.getModelYear())
                                    .forSubdivision(modelInfo.getSubdivision())
                                    .withModelPermID(modelInfo.getModelPermId())
                                    .selectModel()
                    );
                }
        );
    }

    @And("^s?he retires the selected model")
    public void retire_model() throws Exception {

        theActorInTheSpotlight().attemptsTo(
                Click.on(ApplicationHomePage.BUTTON_TARGET("Retire Model Button","Retire Model")),
                ClickOkOn.retireUnretireModelAlert()
        );

    }

    @Then("^s?he should see the model as retired$")
    public void verify_model_retired() throws Throwable {
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

                    retired_model = modelInfo.getModelPermId() + " " + modelInfo.getModelName() + " {" + modelInfo.getModelPermId() + "}  (Retired!)";
                    theActorInTheSpotlight().should(
                            seeThat(ModelList.displayed(modelInformationList), hasItem(retired_model))
                    );
                }

        );
    }

    @When("^(?:.*) selects a model to unretire with basic information")
    public void select_model_to_unretire(List<ModelInformation> modelInformationRequest) throws Exception {
        modelInformationList = modelInformationRequest;
        modelInformationList.forEach(
                modelInfo ->
                {
                    theActorInTheSpotlight().attemptsTo(
                            SelectDetails.withModelInformation()
                                    .onCountry(modelInfo.getCountry())
                                    .andYear(modelInfo.getModelYear())
                                    .forSubdivision(modelInfo.getSubdivision())
                                    .withModelPermID(modelInfo.getModelPermId())
                                    .selectModel()
                    );
                }
        );
    }

    @And("^s?he unretires the selected model")
    public void unretire_model() throws Exception {

        theActorInTheSpotlight().attemptsTo(
                Click.on(ApplicationHomePage.BUTTON_TARGET("Unretire Model Button","Unretire Model")),
                ClickOkOn.retireUnretireModelAlert()
        );

    }

    @Then("^s?he should see the model as unretired$")
    public void verify_model_unretired() throws Throwable {
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

                    unretired_model = modelInfo.getModelPermId() + " " + modelInfo.getModelName() + " {" + modelInfo.getModelPermId() + "}";
                    theActorInTheSpotlight().should(
                            seeThat(ModelList.displayed(modelInformationList), hasItem(unretired_model))
                    );
                }

        );
    }
}