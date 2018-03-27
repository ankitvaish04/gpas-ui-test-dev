package net.autodata.nissan.qa.gpas.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

//@DefaultUrl("http://gpasqa:gpasqa@localhost:11080/rosettaTools/")
@DefaultUrl("http://qa.user:qa.user@localhost:8080/rosettaTools/")
public class ApplicationHomePage extends PageObject {

    public static final Target INPUT_BOX_TARGET(String targetElementName , String title)
    {
        return  Target.the(targetElementName)
                .locatedBy("//input[@title='"+ title +"']");
    }

    public static final Target BUTTON_TARGET(String targetElementName , String title)
    {
        return  Target.the(targetElementName)
                .locatedBy("//button[text()='"+ title +"']");
    }

    public static final Target TAB(String title)
    {
        return  Target.the(title)
                .locatedBy("//div[@class='SelectorLabel' and text()='"+ title +"']");
    }

    public static final Target REMOVE_BUTTON(int i)
    {
        return  Target.the("Remove Button")
                .locatedBy("(//div[@class='gwt-TabLayoutPanelContent'])[1]/table/tbody/tr[2]/td/table/tbody/tr[" + i + "]/td/button[text()='Remove']");
    }

    public static final Target EDIT_BUTTON(int i)
    {
        return  Target.the("Edit Button")
                .locatedBy("(//div[@class='gwt-TabLayoutPanelContent'])[1]/table/tbody/tr[2]/td/table/tbody/tr[" + i + "]/td/button[text()='Edit']");
    }


}
