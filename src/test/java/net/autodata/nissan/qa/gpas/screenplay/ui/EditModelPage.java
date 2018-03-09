package net.autodata.nissan.qa.gpas.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


/**
 * Created by ankit.vaish on 28-02-2018.
 */
public class EditModelPage extends PageObject{

    public static final Target MODELACTION_LISTBOX = Target.the("'Action' dropdown")
            .locatedBy("//select[@class='gwt-ListBox']");

    public static final Target MODEL_NAME = Target.the("Model Name")
            .locatedBy("//tr[@class='rTool-row row_selected']/td[6]");

    public static final Target INPUT_BOX_TARGET(String targetElementName , String title)
    {
        return  Target.the(targetElementName)
                .locatedBy("//input[@title='"+ title +"']");
    }

    public static final Target DIALOGBOX_AVAIABLE_LIST_TARGET(String targetElementName)
    {
        return  Target.the(targetElementName)
                .locatedBy("(//select[@class='SelectorListBox'])[last()-1]");
    }

    public static final Target BUTTON_TARGET(String targetElementName , String title)
    {
        return  Target.the(targetElementName)
                .locatedBy("//button[text()='"+ title +"']");
    }
}

