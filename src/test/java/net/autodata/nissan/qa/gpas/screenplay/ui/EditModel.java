package net.autodata.nissan.qa.gpas.screenplay.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by ankit.vaish on 28-02-2018.
 */
public class EditModel extends PageObject{

    private String Parentwindow=null;
    public static final Target MODELACTION_LISTBOX = Target.the("'Action' dropdown")
            .locatedBy("//select[@class='gwt-ListBox']");

    public void switchToEditModelWindow() throws InterruptedException {
        Parentwindow = getDriver().getWindowHandle();
        for (String s:getDriver().getWindowHandles()) {
             if(!s.equalsIgnoreCase(Parentwindow))
               getDriver().switchTo().window(s);
        }

        waitFor((ExpectedConditions.visibilityOfElementLocated((By.xpath("//select[@class='gwt-ListBox']")))));
    }

    public void switchToParentWindow() throws InterruptedException {
        getDriver().switchTo().window(Parentwindow);
    }
}

