package net.autodata.nissan.qa.gpas.screenplay.features.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.autodata.nissan.qa.gpas.screenplay.customactions.CloseEditModelWindow;
import net.autodata.nissan.qa.gpas.screenplay.customactions.CommitModelData;
import net.autodata.nissan.qa.gpas.screenplay.customactions.SwitchToChildWindow;
import net.autodata.nissan.qa.gpas.screenplay.model.CheckCVCOptKinds;
import net.autodata.nissan.qa.gpas.screenplay.model.CheckCVCOptKindsInformation;
import net.autodata.nissan.qa.gpas.screenplay.questions.GeneratedOptKindsInfo;
import net.autodata.nissan.qa.gpas.screenplay.ui.ApplicationHomePage;
import net.autodata.nissan.qa.gpas.screenplay.ui.EditModelPage;
import net.serenitybdd.screenplay.actions.Click;
import java.util.List;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.autodata.nissan.qa.gpas.screenplay.features.steps.UserLoginSteps.actor;
import static org.hamcrest.Matchers.is;

public class CheckCVCOptKindsSteps {

    public static List<CheckCVCOptKindsInformation> checkCVCOptKindsInformationList;

    @When("^(?:.*) to generate Option Kinds under CVC with information$")
    public void generate_CVC_OptKinds(List<CheckCVCOptKindsInformation> checkCVCOptKindsInformationRequest) throws Exception {

        checkCVCOptKindsInformationList = checkCVCOptKindsInformationRequest;
        //System.out.println("LIST SIZE:" + checkCVCOptKindsInformationList.size());
        actor.attemptsTo(
                Click.on(ApplicationHomePage.BUTTON_TARGET("Edit Button","Edit")),
                SwitchToChildWindow.edit(),
                Click.on(EditModelPage.TABS_TARGET("CVC Tab", "CVC"))
        );
        checkCVCOptKindsInformationList.forEach(
                modelCVCInfo ->
                        actor.attemptsTo(
                                CheckCVCOptKinds.withInformation()
                                        .withOptKinds(modelCVCInfo.getOptkinds())
                                        .getCVCOptKinds()
                        )
        );
    }

    @Then("^s?he should see the required Option Kinds under CVC for the model$")
    public void verify_CVC_OptKinds() throws Throwable {

        int index = 0;
        int j = checkCVCOptKindsInformationList.size();

        for (CheckCVCOptKindsInformation el:checkCVCOptKindsInformationList){
            index = checkCVCOptKindsInformationList.indexOf(el)+ j;
            j = j-2;
            actor.should(seeThat(GeneratedOptKindsInfo.field("Option Kinds", index), is(el.getOptkinds())));
        }

        actor.attemptsTo(CommitModelData.commit());
        actor.attemptsTo(CloseEditModelWindow.close());

    }
}