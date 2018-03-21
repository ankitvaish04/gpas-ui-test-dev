package net.autodata.nissan.qa.gpas.screenplay.features.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.autodata.nissan.qa.gpas.screenplay.customactions.CloseEditModelWindow;
import net.autodata.nissan.qa.gpas.screenplay.customactions.CommitModelData;
import net.autodata.nissan.qa.gpas.screenplay.customactions.SwitchToChildWindow;
import net.autodata.nissan.qa.gpas.screenplay.model.*;
import net.autodata.nissan.qa.gpas.screenplay.questions.CreatedModelEquipmentInfo;
import net.autodata.nissan.qa.gpas.screenplay.ui.ApplicationHomePage;
import net.autodata.nissan.qa.gpas.screenplay.ui.EditModelPage;
import net.serenitybdd.screenplay.actions.Click;
import java.util.List;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class CreateModelEquipmentSteps {

    public static List<CreateModelEquipmentInformation> createModelEquipmentInformationList;
    public static List<CreateEquipDescriptionsInformation> createEquipDescriptionsInformationList;

    @When("^(?:.*) to create equipments with basic information$")
    public void create_new_equipment(List<CreateModelEquipmentInformation> createModelEquipmentInformationRequest) throws Exception {

        createModelEquipmentInformationList = createModelEquipmentInformationRequest;
        theActorInTheSpotlight().attemptsTo(
                Click.on(ApplicationHomePage.BUTTON_TARGET("Edit Button","Edit")),
                SwitchToChildWindow.edit(),
                Click.on(EditModelPage.TABS_TARGET("Equip Tab", "Equip"))
        );
        createModelEquipmentInformationList.forEach(
                modelEqipInfo ->
                        theActorInTheSpotlight().attemptsTo(
                                CreateModelEquipment.withInformation()
                                        .withHeader(modelEqipInfo.getIsHeader())
                                        .andSpec(modelEqipInfo.getIsSpec())
                                        .andMostPopular(modelEqipInfo.getIsMostPopular())
                                        .andOrderCode(modelEqipInfo.getOrderCode())
                                        .andOptionKind(modelEqipInfo.getOptionKind())
                                        .andUtf(modelEqipInfo.getUtf())
                                        .andFlags(modelEqipInfo.getFlags())
                                        .andFilterRules(modelEqipInfo.getFilterRules())
                                        .createModelEquipments()
                        )
        );
    }

    @And("^(?:.*) wants to create equipment descriptions for the model$")
    public void create_eqiup_descriptions(List<CreateEquipDescriptionsInformation> createEquipDescriptionsInformationRequest) throws Throwable {

        createEquipDescriptionsInformationList = createEquipDescriptionsInformationRequest;
        createEquipDescriptionsInformationList.forEach(
                equipDescInfo ->
                        theActorInTheSpotlight().attemptsTo(
                                CreateEquipDescriptions.withInformation()
                                        .withDescriptionType(equipDescInfo.getDescriptionType())
                                        .andDescription(equipDescInfo.getDescription())
                                        .createEquipDescriptions()
                        )
        );

        theActorInTheSpotlight().attemptsTo(Click.on(EditModelPage.BUTTON_TARGET("Submit Button", "Submit")));
    }

    @Then("^s?he should see the created equipments for the model$")
    public void verify_model_equipment() throws Throwable {

        if(createModelEquipmentInformationList.get(0).getIsHeader().equalsIgnoreCase("Y"))
        {
            createModelEquipmentInformationList.forEach(
                    modelEquipInfo -> {
                        theActorInTheSpotlight().should(seeThat(CreatedModelEquipmentInfo.field("Code"), is(modelEquipInfo.getOrderCode())));
                        theActorInTheSpotlight().should(seeThat(CreatedModelEquipmentInfo.field("Spec"), is(modelEquipInfo.getIsSpec())));
                        theActorInTheSpotlight().should(seeThat(CreatedModelEquipmentInfo.field("Flg"), is("HDR")));
                    }
            );
        }
        else
        {
            createModelEquipmentInformationList.forEach(
                    modelEquipInfo -> {
                        theActorInTheSpotlight().should(seeThat(CreatedModelEquipmentInfo.field("Code"), is(modelEquipInfo.getOrderCode())));
                        theActorInTheSpotlight().should(seeThat(CreatedModelEquipmentInfo.field("OpK"), is(modelEquipInfo.getOptionKind())));
                        theActorInTheSpotlight().should(seeThat(CreatedModelEquipmentInfo.field("UTF"), is(modelEquipInfo.getUtf())));
                        theActorInTheSpotlight().should(seeThat(CreatedModelEquipmentInfo.field("Spec"), is(modelEquipInfo.getIsSpec())));
                        theActorInTheSpotlight().should(seeThat(CreatedModelEquipmentInfo.field("MP"), is(modelEquipInfo.getIsMostPopular())));
                        theActorInTheSpotlight().should(seeThat(CreatedModelEquipmentInfo.field("Flg"), containsString(modelEquipInfo.getFlags())));
                    }
            );
        }

        theActorInTheSpotlight().attemptsTo(CommitModelData.commit());
        theActorInTheSpotlight().attemptsTo(CloseEditModelWindow.close());
    }
}