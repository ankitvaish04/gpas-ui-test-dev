package net.autodata.nissan.qa.gpas.screenplay.tasks;

import com.google.common.collect.ImmutableList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateWithDetails implements Task {

    private final List<String> details;

    @Step("{0} creates the model for: #details")
    public <T extends Actor> void performAs(T actor) {
        details.forEach(
                detail -> actor.attemptsTo()
        );
    }

    public static CreateWithDetails called(String... details) {
        return instrumented(CreateWithDetails.class, asList(details));
    }

    public static CreateWithDetails called(Collection<String> details) {
        return instrumented(CreateWithDetails.class, details);
    }

    public CreateWithDetails(List<String> details) { this.details = ImmutableList.copyOf(details); }
}
