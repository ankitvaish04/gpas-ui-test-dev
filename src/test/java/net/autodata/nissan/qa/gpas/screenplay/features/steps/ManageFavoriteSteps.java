package net.autodata.nissan.qa.gpas.screenplay.features.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.autodata.nissan.qa.gpas.screenplay.customactions.CloseEditModelWindow;
import net.autodata.nissan.qa.gpas.screenplay.model.*;
import net.autodata.nissan.qa.gpas.screenplay.questions.FavoriteModelList;
import net.autodata.nissan.qa.gpas.screenplay.questions.UpdatedModelInfo;
import java.util.List;
import static net.autodata.nissan.qa.gpas.screenplay.tasks.OpenModelWithRequiredValues.edit_model_flag;
import static net.autodata.nissan.qa.gpas.screenplay.tasks.RemoveModelWithRequiredValues.remove_model_flag;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.autodata.nissan.qa.gpas.screenplay.features.steps.UserLoginSteps.actor;
import static org.hamcrest.Matchers.is;


public class ManageFavoriteSteps {

    private List<FavoriteModelInformation> modelInformationList;

    @When("^(?:.*) wants to open a favorite model for editing with basic information")
    public void edit_favorite_model(List<FavoriteModelInformation> modelInformationRequest) throws Exception {
        modelInformationList = modelInformationRequest;
        modelInformationList.forEach(
                modelInfo ->
                        actor.attemptsTo(
                                FavoriteModel.withModelInformation()
                                        .withYmmId(modelInfo.getYmmId())
                                        .onCountry(modelInfo.getCountry())
                                        .andYear(modelInfo.getModelYear())
                                        .forSubdivision(modelInfo.getSubDivision())
                                        .withModelName(modelInfo.getModelName())
                                        .openModel()
                        )
        );
    }

    @Then("^s?he should see the selected model open in edit model with correct information$")
    public void verify_model_opens_in_edit_mode() throws Throwable {
        if(edit_model_flag) {

            modelInformationList.forEach(
                    modelInfo -> {
                        actor.should(seeThat(UpdatedModelInfo.field("YmmId"), is(modelInfo.getYmmId())));
                        actor.should(seeThat(UpdatedModelInfo.field("MdlYr"), is(modelInfo.getModelYear())));
                        actor.should(seeThat(UpdatedModelInfo.field("Model name"), is(modelInfo.getModelName())));
                        actor.should(seeThat(UpdatedModelInfo.field("SDiv Name"), is(modelInfo.getSubDivision())));
                    }
            );

            actor.attemptsTo(CloseEditModelWindow.close());
        }
        else
            System.out.println("Model with YmmId:" + modelInformationList.get(0).getYmmId() + " not found!!");
    }

    @When("^(?:.*) wants to remove a favorite model with basic information")
    public void remove_favorite_model(List<FavoriteModelInformation> modelInformationRequest) throws Exception {
        modelInformationList = modelInformationRequest;
        modelInformationList.forEach(
                modelInfo ->
                        actor.attemptsTo(
                                FavoriteModel.withModelInformation()
                                        .withYmmId(modelInfo.getYmmId())
                                        .onCountry(modelInfo.getCountry())
                                        .andYear(modelInfo.getModelYear())
                                        .forSubdivision(modelInfo.getSubDivision())
                                        .withModelName(modelInfo.getModelName())
                                        .removeModel()
                        )
        );
    }

    @Then("^s?he should see the selected model removed from the My Favorites list$")
    public void verify_model_is_removed() throws Throwable {
        if(remove_model_flag) {
            modelInformationList.forEach(
                    modelInfo -> {
                        actor.should(seeThat(FavoriteModelList.doesNotContain(modelInfo.getYmmId())));
                    }
            );
        }
        else
            System.out.println("Model with YmmId:" + modelInformationList.get(0).getYmmId() + " not found!!");
    }

}
