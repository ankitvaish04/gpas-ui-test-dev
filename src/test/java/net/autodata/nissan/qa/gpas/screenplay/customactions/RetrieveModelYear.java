package net.autodata.nissan.qa.gpas.screenplay.customactions;

import net.autodata.nissan.qa.gpas.screenplay.utilities.GlobalVars;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.WebElement;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by ankit.vaish on 07-03-2018.
 */
public class RetrieveModelYear implements Interaction{

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElement header=getDriver().findElement(By.xpath("//div[@class='ModelHeaderLabel']"));
        GlobalVars.Model_YEAR=header.getText().split(" ")[1];
    }

    public static RetrieveModelYear fromHeader(){
        return  new RetrieveModelYear();
    }

}