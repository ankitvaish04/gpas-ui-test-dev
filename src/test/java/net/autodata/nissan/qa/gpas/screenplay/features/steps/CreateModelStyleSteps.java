package net.autodata.nissan.qa.gpas.screenplay.features.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.autodata.nissan.qa.gpas.screenplay.customactions.CloseEditModelWindow;
import net.autodata.nissan.qa.gpas.screenplay.customactions.CommitModelData;
import net.autodata.nissan.qa.gpas.screenplay.model.*;
import net.autodata.nissan.qa.gpas.screenplay.questions.UpdatedModelInfo;
import java.util.List;
import java.util.Map;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class CreateModelStyleSteps {

    private List<CreateModelStyleInformation> createModelStyleInformationList;

    @When("^(?:.*) to create a model style with basic information$")
    public void create_new_style(List<CreateModelStyleInformation> createModelStyleInformationRequest) throws Exception {

        createModelStyleInformationList = createModelStyleInformationRequest;
        createModelStyleInformationList.forEach(
                modelStyleInfo ->
                        theActorInTheSpotlight().attemptsTo(
                                CreateModelStyle.withModelInformation()
                                        .withStyleId(modelStyleInfo.getStyleID())
                                        .forStyleCode(modelStyleInfo.getStyleCode())
                                        .andMfrStyleCode(modelStyleInfo.getMfrStyleCode())
                                        .andNCode(modelStyleInfo.getNCode())
                                        .andStyleName(modelStyleInfo.getStyleName())
                                        .andTrim(modelStyleInfo.getTrim())
                                        .andTrimPlus(modelStyleInfo.getTrimPlus())
                                        .withVersionName(modelStyleInfo.getVersionName())
                                        .andStyleSetName(modelStyleInfo.getStyleSetName())
                                        .createModelStyle()
                        )
        );
    }

    @And("^(?:.*) wants to create marketing descriptions for the model$")
    public void create_marketing_descriptions(List<CreateModelStyleInformation> createModelStyleInformationRequest) throws Throwable {

        createModelStyleInformationList = createModelStyleInformationRequest;

    }

    @And("^(?:.*) he creates pricing data for the model$")
    public void create_pricing(List<CreateModelStyleInformation> createModelStyleInformationRequest) throws Throwable {

        createModelStyleInformationList = createModelStyleInformationRequest;

    }

    @Then("^s?he should see the created styles for the model$")
    public void verify_updated_model() throws Throwable {
       /* updateModelInformationList.forEach(
                modelInfo -> {
                    theActorInTheSpotlight().should(seeThat(UpdatedModelInfo.field("Model Name"), is(modelInfo.getModelName())));
                    theActorInTheSpotlight().should(seeThat(UpdatedModelInfo.field("Program"), is(modelInfo.getProgram())));
                    theActorInTheSpotlight().should(seeThat(UpdatedModelInfo.field("EffDate"), is(modelInfo.getEffectiveDate())));
                    theActorInTheSpotlight().should(seeThat(UpdatedModelInfo.field("MdlKnd"), is(modelInfo.getModelKind())));
                    theActorInTheSpotlight().should(seeThat(UpdatedModelInfo.field("Tarrif"), is(modelInfo.getTarrif())));
                    theActorInTheSpotlight().should(seeThat(UpdatedModelInfo.field("Comments"), is(modelInfo.getComment())));
                    theActorInTheSpotlight().should(seeThat(UpdatedModelInfo.field("Phase"), is(modelInfo.getPhase())));
                    theActorInTheSpotlight().should(seeThat(UpdatedModelInfo.field("CommKind"), is(modelInfo.getCommercialKind())));
                    theActorInTheSpotlight().should(seeThat(UpdatedModelInfo.field("ClientType"), is(modelInfo.getClientType())));
                  }
                );

        theActorInTheSpotlight().attemptsTo(CommitModelData.commit());
        theActorInTheSpotlight().attemptsTo(CloseEditModelWindow.close());*/

    }

}