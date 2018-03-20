package net.autodata.nissan.qa.gpas.screenplay.features.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.autodata.nissan.qa.gpas.screenplay.customactions.CloseEditModelWindow;
import net.autodata.nissan.qa.gpas.screenplay.customactions.CommitModelData;
import net.autodata.nissan.qa.gpas.screenplay.customactions.SwitchToChildWindow;
import net.autodata.nissan.qa.gpas.screenplay.model.*;
import net.autodata.nissan.qa.gpas.screenplay.questions.CreatedModelStyleInfo;
import net.autodata.nissan.qa.gpas.screenplay.ui.ApplicationHomePage;
import net.autodata.nissan.qa.gpas.screenplay.ui.EditModelPage;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class CreateModelEquipmentSteps {

    public static List<CreateModelEquipmentInformation> createModelEquipmentInformationList;
    public static List<CreateEquipDescriptionsInformation> createEquipDescriptionsInformationList;

    @When("^(?:.*) to create equipments with basic information$")
    public void create_new_euipments(List<CreateModelEquipmentInformation> createModelEquipmentInformationRequest) throws Exception {

        createModelEquipmentInformationList = createModelEquipmentInformationRequest;
        theActorInTheSpotlight().attemptsTo(
                Click.on(ApplicationHomePage.BUTTON_TARGET("Edit Button","Edit")),
                SwitchToChildWindow.edit(),
                Click.on(EditModelPage.TABS_TARGET("Equip Tab", "Equip"))
        );
/*        createModelEquipmentInformationList.forEach(
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
        );*/
    }

    @And("^(?:.*) wants to create equipment descriptions for the model$")
    public void create_eqiup_descriptions(List<CreateEquipDescriptionsInformation> createEquipDescriptionsInformationRequest) throws Throwable {

/*      createEquipDescriptionsInformationList = createEquipDescriptionsInformationRequest;
        createEquipDescriptionsInformationList.forEach(
                marketingDescInfo ->
                        theActorInTheSpotlight().attemptsTo(
                                CreateMarketingDescriptions.withInformation()
                                        .withDescriptionTypeId(marketingDescInfo.getDescriptionType())
                                        .andDescription(marketingDescInfo.getDescription())
                                        .createMarketingDescriptions()
                        )
        );*/

        theActorInTheSpotlight().attemptsTo(Click.on(EditModelPage.BUTTON_TARGET("Submit Button", "Submit")));

    }

    @Then("^s?he should see the created equipments for the model$")
    public void verify_model_equipments() throws Throwable {

/*
        createModelEquipmentInformationList.forEach(
                modelStyleInfo -> {
                    theActorInTheSpotlight().should(seeThat(CreatedModelStyleInfo.field("pID"), is(modelStyleInfo.getStyleID())));
                    theActorInTheSpotlight().should(seeThat(CreatedModelStyleInfo.field("Code"), is(modelStyleInfo.getStyleCode())));
                    theActorInTheSpotlight().should(seeThat(CreatedModelStyleInfo.field("Version"), is(modelStyleInfo.getVersionName())));
                    theActorInTheSpotlight().should(seeThat(CreatedModelStyleInfo.field("Style Name"), is(modelStyleInfo.getStyleName())));
                    theActorInTheSpotlight().should(seeThat(CreatedModelStyleInfo.field("Trim"), is(modelStyleInfo.getTrim())));
                    theActorInTheSpotlight().should(seeThat(CreatedModelStyleInfo.field("Trim Plus"), is(modelStyleInfo.getTrimPlus())));
                }
        );

        theActorInTheSpotlight().attemptsTo(CommitModelData.commit());
        theActorInTheSpotlight().attemptsTo(CloseEditModelWindow.close());
*/

    }

}