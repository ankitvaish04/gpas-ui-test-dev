package net.autodata.nissan.qa.gpas.screenplay.customactions;

/**
 * Created by ankit.vaish on 08-03-2018.
 */
import net.serenitybdd.screenplay.Action;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Custom Action using a low-level WebDriver API
 */
public class RightClick implements Action {

    public static RightClick on(Target target) {
        return instrumented(RightClick.class, target);
    }

    private final Target target;

    public RightClick(Target target) {
        this.target = target;
    }

    @Step("{0} right-clicks on #target")
    public <T extends Actor> void performAs(T actor) {
        WebElement element = target.resolveFor(actor);

        as(actor).contextClick(element).perform();
    }

    private Actions as(Actor actor) {
        return new Actions(BrowseTheWeb.as(actor).getDriver());
    }
}
