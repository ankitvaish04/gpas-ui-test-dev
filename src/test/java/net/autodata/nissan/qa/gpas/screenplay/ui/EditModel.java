package net.autodata.nissan.qa.gpas.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


/**
 * Created by ankit.vaish on 28-02-2018.
 */
public class EditModel extends PageObject{

    public static final Target MODELACTION_LISTBOX = Target.the("'Action' dropdown")
            .locatedBy("//select[@class='gwt-ListBox']");

}

