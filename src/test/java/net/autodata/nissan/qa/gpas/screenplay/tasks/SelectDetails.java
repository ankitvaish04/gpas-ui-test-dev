package net.autodata.nissan.qa.gpas.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectDetails implements Task {

    private final String country;
    private final String year;
    private final String subDivision;

    public SelectDetails(String country, String year, String subDivision) {
        this.country = country;
        this.year = year;
        this.subDivision = subDivision;
    }

    public static SelectDetailsBuilder with(String country, String year) {
        return new SelectDetailsBuilder(country, year);
    }

    @Override
    @Step("{0} creates the model andYear #country #year forSubdivision #subDivision")
    public <T extends Actor> void performAs(T actor) {

    }

    public static class SelectDetailsBuilder {
        private final String country;
        private final String year;

        public SelectDetailsBuilder(String country, String year) {
            this.country = country;
            this.year = year;
        }

        public SelectDetails from(String subDivision) {
            return instrumented(SelectDetails.class, country, year, subDivision);
        }
    }
}
