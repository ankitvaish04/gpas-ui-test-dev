package net.autodata.nissan.qa.gpas.screenplay.features;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin   = {"pretty"},
        features = {"classpath:features/model/create_model.feature"},
        glue     = {"classpath:net.autodata.nissan.qa.gpas.screenplay.features.steps"},
        junit    = {"--filename-compatible-names"}
)
public class CreateModelTestSuite {}
