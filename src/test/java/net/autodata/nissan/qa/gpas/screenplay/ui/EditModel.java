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
    private String currentUrl;
    public static String ymmId;

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

    public String getymmId() {
        currentUrl = getDriver().getCurrentUrl().trim();
        ymmId = currentUrl.substring(currentUrl.lastIndexOf("=") + 1).trim();
        System.out.println("Current URL: " + currentUrl);
        System.out.println("YMMID      : " + ymmId);
        return ymmId;
    }

    public void switchToParentWindowAndRefresh() throws InterruptedException {
        getDriver().switchTo().window(Parentwindow);
        getDriver().navigate().refresh();
    }
}

