package net.autodata.nissan.qa.gpas.screenplay.features.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.autodata.nissan.qa.gpas.screenplay.customactions.CloseEditModelWindow;
import net.autodata.nissan.qa.gpas.screenplay.customactions.CommitModelData;
import net.autodata.nissan.qa.gpas.screenplay.customactions.SwitchToChildWindow;
import net.autodata.nissan.qa.gpas.screenplay.model.CreateModelEIM;
import net.autodata.nissan.qa.gpas.screenplay.model.CreateModelEIMInformation;
import net.autodata.nissan.qa.gpas.screenplay.questions.CreatedModelEIMInfo;
import net.autodata.nissan.qa.gpas.screenplay.ui.ApplicationHomePage;
import net.autodata.nissan.qa.gpas.screenplay.ui.EditModelPage;
import net.serenitybdd.screenplay.actions.Click;
import java.util.List;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class CreateEIMSteps {

    public static List<CreateModelEIMInformation> createModelEIMInformationList;

    @When("^(?:.*) to create EIMs with basic information$")
    public void create_new_EIMs(List<CreateModelEIMInformation> createModelEIMInformationRequest) throws Exception {

        createModelEIMInformationList = createModelEIMInformationRequest;
        //System.out.println("SIZE:" + createModelEIMInformationList.size());
        theActorInTheSpotlight().attemptsTo(
                Click.on(ApplicationHomePage.BUTTON_TARGET("Edit Button","Edit")),
                SwitchToChildWindow.edit(),
                Click.on(EditModelPage.TABS_TARGET("EIM Tab", "EIM"))
        );
        createModelEIMInformationList.forEach(
                modelEIMInfo ->
                        theActorInTheSpotlight().attemptsTo(
                                CreateModelEIM.withInformation()
                                        .withPosition(modelEIMInfo.getPosition())
                                        .andCharacter(modelEIMInfo.getCharacter())
                                        .andCondition(modelEIMInfo.getCondition())
                                        .createModelEIM()
                        )
        );
    }

    @Then("^s?he should see the created EIMs for the model$")
    public void verify_model_pricing() throws Throwable {

        int index = 0;
        int j = createModelEIMInformationList.size();

        for (CreateModelEIMInformation el:createModelEIMInformationList){
            index = createModelEIMInformationList.indexOf(el)+ j;
            j = j-2;
            theActorInTheSpotlight().should(seeThat(CreatedModelEIMInfo.field("Pos", index), is(el.getPosition())));
            theActorInTheSpotlight().should(seeThat(CreatedModelEIMInfo.field("Characters", index), is(el.getCharacter())));
            theActorInTheSpotlight().should(seeThat(CreatedModelEIMInfo.field("Condition", index), is(el.getCondition())));
        }

        theActorInTheSpotlight().attemptsTo(CommitModelData.commit());
        theActorInTheSpotlight().attemptsTo(CloseEditModelWindow.close());

    }
}