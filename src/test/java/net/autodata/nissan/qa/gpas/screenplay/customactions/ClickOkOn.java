package net.autodata.nissan.qa.gpas.screenplay.customactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.Alert;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ClickOkOn implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        Alert alert = getDriver().switchTo().alert();
          alert.accept();
    }

    public static ClickOkOn commitAlerts(){
        return new ClickOkOn();
    }
}
