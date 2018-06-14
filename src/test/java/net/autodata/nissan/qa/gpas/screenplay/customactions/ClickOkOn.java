package net.autodata.nissan.qa.gpas.screenplay.customactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ClickOkOn implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
            while(true) {
                try {
                    WebDriverWait wait = new WebDriverWait(getDriver(), 5);
                    wait.until(ExpectedConditions.alertIsPresent());
                    Alert alert = getDriver().switchTo().alert();
                    System.out.println("ALERT:" + alert.getText());
                    alert.accept();
                } catch (Exception e) {
                    //System.out.println("ERROR IS:" + e.getMessage());
                    if(e.getMessage().contains("Expected condition failed: waiting for alert to be present"))
                        return;
                }
            }
    }

    public static ClickOkOn commitAlerts(){
        return new ClickOkOn();
    }

    public static ClickOkOn retireUnretireModelAlert(){
        return new ClickOkOn();
    }
}
