package net.autodata.nissan.qa.gpas.screenplay.features.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.autodata.nissan.qa.gpas.screenplay.customactions.CloseEditModelWindow;
import net.autodata.nissan.qa.gpas.screenplay.customactions.CommitModelData;
import net.autodata.nissan.qa.gpas.screenplay.customactions.SwitchToChildWindow;
import net.autodata.nissan.qa.gpas.screenplay.model.CreateModelPricing;
import net.autodata.nissan.qa.gpas.screenplay.model.CreateModelPricingInformation;
import net.autodata.nissan.qa.gpas.screenplay.questions.CreatedModelPricingInfo;
import net.autodata.nissan.qa.gpas.screenplay.ui.ApplicationHomePage;
import net.autodata.nissan.qa.gpas.screenplay.ui.EditModelPage;
import net.serenitybdd.screenplay.actions.Click;
import java.util.List;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class CreatePricingSteps {

    public static List<CreateModelPricingInformation> createModelPricingInformationList;

    @When("^(?:.*) to create pricing with basic information$")
    public void create_new_pricing(List<CreateModelPricingInformation> createModelPricingInformationRequest) throws Exception {

        createModelPricingInformationList = createModelPricingInformationRequest;
        theActorInTheSpotlight().attemptsTo(
                Click.on(ApplicationHomePage.BUTTON_TARGET("Edit Button","Edit")),
                SwitchToChildWindow.edit(),
                Click.on(EditModelPage.TABS_TARGET("Prc Tab", "Prc"))
        );
        createModelPricingInformationList.forEach(
                modelPricingInfo ->
                        theActorInTheSpotlight().attemptsTo(
                                CreateModelPricing.withInformation()
                                        .withOrderCode(modelPricingInfo.getOrderCode())
                                        .andPriceState(modelPricingInfo.getPriceState())
                                        .andRetailFleetStatus(modelPricingInfo.getRetailFleetStatus())
                                        .andCondition(modelPricingInfo.getCondition())
                                        .andPricing(modelPricingInfo.getPricing())
                                        .andEffectiveDate(modelPricingInfo.getEffectiveDate())
                                        .andNonEffectiveDate(modelPricingInfo.getNonEffectiveDate())
                                        .createModelPricing()
                        )
        );
    }

    @Then("^s?he should see the created pricing for the model$")
    public void verify_model_pricing() throws Throwable {


        int index = 0;
        int j = createModelPricingInformationList.size();

        for (CreateModelPricingInformation el:createModelPricingInformationList){
            index = createModelPricingInformationList.indexOf(el)+ j;
            j = j-2;
            theActorInTheSpotlight().should(seeThat(CreatedModelPricingInfo.field("Code", index), is(el.getOrderCode())));
            theActorInTheSpotlight().should(seeThat(CreatedModelPricingInfo.field("Retail/MSRP", index), is(el.getPricing())));
            theActorInTheSpotlight().should(seeThat(CreatedModelPricingInfo.field("PS", index), is(el.getPriceState())));
            theActorInTheSpotlight().should(seeThat(CreatedModelPricingInfo.field("R/F", index), is(el.getRetailFleetStatus())));
            theActorInTheSpotlight().should(seeThat(CreatedModelPricingInfo.field("EffDate", index), is(el.getEffectiveDate())));
            theActorInTheSpotlight().should(seeThat(CreatedModelPricingInfo.field("NonEffDate", index), is(el.getNonEffectiveDate())));
        }

        theActorInTheSpotlight().attemptsTo(CommitModelData.commit());
        theActorInTheSpotlight().attemptsTo(CloseEditModelWindow.close());

    }
}