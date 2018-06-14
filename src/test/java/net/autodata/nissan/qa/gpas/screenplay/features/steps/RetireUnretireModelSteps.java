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
import static org.hamcrest.CoreMatchers.hasItem;
import static net.autodata.nissan.qa.gpas.screenplay.features.steps.UserLoginSteps.actor;

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
                    actor.attemptsTo(
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

        actor.attemptsTo(
                Click.on(ApplicationHomePage.BUTTON_TARGET("Retire Model Button","Retire Model")),
                ClickOkOn.retireUnretireModelAlert()
        );
        //Thread.sleep(5000);
        //actor.attemptsTo(ClickOkOn.retireUnretireModelAlert());
    }

    @Then("^s?he should see the model as retired$")
    public void verify_model_retired() throws Throwable {
        modelInformationList.forEach(
                modelInfo ->
                {
                    actor.attemptsTo(
                            SearchModel.searchModelYmmId()
                                    .onCountry(modelInfo.getCountry())
                                    .andYear(modelInfo.getModelYear())
                                    .forSubdivision(modelInfo.getSubdivision())
                                    .withModelName(modelInfo.getModelName())
                                    .searchModel()
                    );

                    retired_model = modelInfo.getModelPermId() + " " + modelInfo.getModelName() + " {" + modelInfo.getModelPermId() + "} (Retired!)";
                    System.out.println("Retired -- >" + retired_model);
                    actor.should(
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
                    actor.attemptsTo(
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

        actor.attemptsTo(
                Click.on(ApplicationHomePage.BUTTON_TARGET("Unretire Model Button","Unretire Model")),
                ClickOkOn.retireUnretireModelAlert()
        );

    }

    @Then("^s?he should see the model as unretired$")
    public void verify_model_unretired() throws Throwable {
        modelInformationList.forEach(
                modelInfo ->
                {
                    actor.attemptsTo(
                            SearchModel.searchModelYmmId()
                                    .onCountry(modelInfo.getCountry())
                                    .andYear(modelInfo.getModelYear())
                                    .forSubdivision(modelInfo.getSubdivision())
                                    .withModelName(modelInfo.getModelName())
                                    .searchModel()
                    );

                    unretired_model = modelInfo.getModelPermId() + " " + modelInfo.getModelName() + " {" + modelInfo.getModelPermId() + "}";
                    System.out.println("UnRetired -- >" + unretired_model);
                    actor.should(
                            seeThat(ModelList.displayed(modelInformationList), hasItem(unretired_model))
                    );
                }

        );
    }
}