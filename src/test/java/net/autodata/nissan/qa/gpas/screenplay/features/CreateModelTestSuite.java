package net.autodata.nissan.qa.gpas.screenplay.features;

import cucumber.api.CucumberOptions;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin   = {"pretty", "html:target/site/serenityBDD"},
        features = {"classpath:features/model"},
        glue     = {"classpath:net.autodata.nissan.qa.gpas.screenplay.features.steps"},
        tags     = {"@RetireUnretireModel"},
        junit    = {"--filename-compatible-names"}
)
public class CreateModelTestSuite {}

