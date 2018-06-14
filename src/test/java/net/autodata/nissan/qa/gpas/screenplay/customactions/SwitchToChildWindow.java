package net.autodata.nissan.qa.gpas.screenplay.customactions;

import net.autodata.nissan.qa.gpas.screenplay.ui.EditModelPage;
import net.autodata.nissan.qa.gpas.screenplay.utilities.GlobalVars;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.locators.WaitForWebElements;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.apache.commons.io.FileUtils.waitFor;

/**
 * Created by ankit.vaish on 07-03-2018.
 */
public class SwitchToChildWindow implements Interaction{

    @Override
    public <T extends Actor> void performAs(T actor) {


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        WaitUntil.the(EditModelPage.MODELACTION_LISTBOX, WebElementStateMatchers.isCurrentlyEnabled());
        GlobalVars.PARENT_WINDOW = getDriver().getWindowHandle();
        System.out.println("window s"+getDriver().getWindowHandles());
           for (String s:getDriver().getWindowHandles()) {
                if(!s.equalsIgnoreCase(GlobalVars.PARENT_WINDOW ))
                    getDriver().switchTo().window(s);
           }

    }

    public static SwitchToChildWindow edit(){
        return new SwitchToChildWindow();
    }

}
