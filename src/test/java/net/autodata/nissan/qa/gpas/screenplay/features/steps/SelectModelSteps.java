package net.autodata.nissan.qa.gpas.screenplay.features.steps;

import cucumber.api.java.en.And;
import net.autodata.nissan.qa.gpas.screenplay.model.SelectDetails;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

/**
 * Created by ankit.vaish on 14-03-2018.
 */
public class SelectModelSteps {

    @And("^s?he selects the model on (.*) for (.*) over (.*) with model Id as (.*)$")
    public void select_model(String country, String modelYear, String subDivision, String modelPermId) throws Throwable {
        theActorInTheSpotlight().attemptsTo(
                SelectDetails.withModelInformation()
                        .onCountry(country)
                        .andYear(modelYear)
                        .forSubdivision(subDivision)
                        .withModelPermID(modelPermId)
                        .selectModel()
        );
    }
}
