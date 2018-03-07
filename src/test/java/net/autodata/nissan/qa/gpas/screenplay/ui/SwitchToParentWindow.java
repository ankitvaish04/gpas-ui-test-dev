package net.autodata.nissan.qa.gpas.screenplay.ui;

import net.autodata.nissan.qa.gpas.screenplay.utilities.GlobalVars;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by ankit.vaish on 07-03-2018.
 */
public class SwitchToParentWindow implements Interaction{

    @Override
    public <T extends Actor> void performAs(T actor) {


        getDriver().switchTo().window(GlobalVars.PARENT_WINDOW);
    }

    public static SwitchToParentWindow parent(){
        return new SwitchToParentWindow();
    }

}
