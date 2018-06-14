package net.autodata.nissan.qa.gpas.screenplay.features.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.autodata.nissan.qa.gpas.screenplay.customactions.CloseEditModelWindow;
import net.autodata.nissan.qa.gpas.screenplay.customactions.CommitModelData;
import net.autodata.nissan.qa.gpas.screenplay.customactions.SwitchToChildWindow;
import net.autodata.nissan.qa.gpas.screenplay.model.CreateModelDisclaimer;
import net.autodata.nissan.qa.gpas.screenplay.model.CreateModelDisclaimerInformation;
import net.autodata.nissan.qa.gpas.screenplay.questions.CreatedModelDisclaimerInfo;
import net.autodata.nissan.qa.gpas.screenplay.questions.CreatedModelEIMInfo;
import net.autodata.nissan.qa.gpas.screenplay.ui.ApplicationHomePage;
import net.autodata.nissan.qa.gpas.screenplay.ui.EditModelPage;
import net.serenitybdd.screenplay.actions.Click;
import java.util.List;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.autodata.nissan.qa.gpas.screenplay.features.steps.UserLoginSteps.actor;
import static org.hamcrest.Matchers.is;

public class CreateDisclaimerSteps {

    public static List<CreateModelDisclaimerInformation> createModelDisclaimerInformationList;

    @When("^(?:.*) to create disclaimers with basic information$")
    public void create_new_disclaimers(List<CreateModelDisclaimerInformation> createModelDisclaimerInformationRequest) throws Exception {

        createModelDisclaimerInformationList = createModelDisclaimerInformationRequest;
        //System.out.println("SIZE:" + createModelEIMInformationList.size());
        actor.attemptsTo(
                Click.on(ApplicationHomePage.BUTTON_TARGET("Edit Button","Edit")),
                SwitchToChildWindow.edit(),
                Click.on(EditModelPage.TABS_TARGET("Disc Tab", "Disc"))
        );
        createModelDisclaimerInformationList.forEach(
                modelDisclaimerInfo ->
                        actor.attemptsTo(
                                CreateModelDisclaimer.withInformation()
                                        .withRefCode(modelDisclaimerInfo.getRefCode())
                                        .andShortName(modelDisclaimerInfo.getShortName())
                                        .andDescription(modelDisclaimerInfo.getDescription())
                                        .createModelDisclaimer()
                        )
        );
    }

    @Then("^s?he should see the created disclaimers for the model$")
    public void verify_model_disclaimers() throws Throwable {

        int index = 0;
        int j = createModelDisclaimerInformationList.size();

        for (CreateModelDisclaimerInformation el:createModelDisclaimerInformationList){
            index = createModelDisclaimerInformationList.indexOf(el)+ j;
            j = j-2;
            actor.should(seeThat(CreatedModelDisclaimerInfo.field("Code", index), is(el.getRefCode())));
            actor.should(seeThat(CreatedModelDisclaimerInfo.field("Short Name", index), is(el.getShortName())));
            actor.should(seeThat(CreatedModelDisclaimerInfo.field("Disclaimer", index), is(el.getDescription())));
        }

        actor.attemptsTo(CommitModelData.commit());
        actor.attemptsTo(CloseEditModelWindow.close());

    }
}