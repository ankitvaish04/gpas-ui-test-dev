package net.autodata.nissan.qa.gpas.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


/**
 * Created by ankit.vaish on 28-02-2018.
 */
public class EditModelPage extends PageObject{

    public static final Target MODELACTION_LISTBOX = Target.the("'Action' dropdown")
            .locatedBy("//select[@class='gwt-ListBox']");

    public static final Target MODEL_NAME_HEADER = Target.the("Model Name")
            .locatedBy("//tr[@class='rTool-row row_selected']/td[6]");
    
    public static final Target MODEL_NAME = Target.the("'Model Name' input box")
            .locatedBy("(//input[@class=\"gwt-TextBox\"])[last()]");

    public static final Target STYLE_TABLE = Target.the("'Style Table'")
            .locatedBy("//div[@role='tabpanel']/div[2]/div/div/table/tfoot/tr/td");

    public static final Target STYLE_TABLE_ROW1 = Target.the("'Style Table Row#1'")
            .locatedBy("//div[@role='tabpanel']/div[2]/div/div/table/tbody/tr[1]");

    public static final Target EQUIP_TABLE = Target.the("'Equip Table'")
            .locatedBy("//div[@role='tabpanel']/div[3]/div/div/table/tfoot/tr/td");

    public static final Target EQUIP_TABLE_ROW1 = Target.the("'Equip Table Row#1'")
            .locatedBy("//div[@role='tabpanel']/div[3]/div/div/table/tbody/tr[2]");

    public static final Target MAKE_HEADER_BUTTON = Target.the("'Make Header Button'")
            .locatedBy("//td[@class='row_edit']/table/tbody/tr/td/table/tbody/tr/td[6]/button");

    public static final Target TRANSLATE_BUTTON_EN = Target.the("'Translate Button(En)'")
            .locatedBy("(//button[@lng='en' and text()='Translate'])[last()]");

    public static final Target MARKETING_DESCRIPTIONS_TABLE = Target.the("'Marketing Descriptions Table'")
            .locatedBy("(//table[@class='r-border'])[last()-1]/tbody/tr[2]/td/table");

    public static final Target MARKETING_DESCRIPTIONS_ROW1 = Target.the("'Marketing Descriptions Table Row#1'")
            .locatedBy("(//table[@class='r-border'])[last()-1]/tbody/tr[2]/td/table/tbody/tr[1]");

    public static final Target MARKETING_DESCRIPTIONS_TYPE = Target.the("'Marketing Description Type' dropdown")
            .locatedBy("(//select[@class='gwt-ListBox'])[last()]");

    public static final Target MARKETING_DESCRIPTION_TEXT = Target.the("'Marketing Description Text'")
            .locatedBy("(//textarea[@title='Description'])[1]");

    public static final Target PRICING_TABLE = Target.the("'Pricing Table Row#1'")
            .locatedBy("(//table[@class='r-border'])[last()]/tbody/tr[2]/td/table");

    public static final Target PRICING_TABLE_ROW1 = Target.the("'Pricing Table Row#1'")
            .locatedBy("(//table[@class='r-border'])[last()]/tbody/tr[2]/td/table/tbody/tr[1]");

    public static final Target PRICE_STATE = Target.the("'Pricing State Dropdown'")
            .locatedBy("(//select[@class='gwt-ListBox'])[last()]");

    public static final Target PRICE_USD = Target.the("'Retail/MSRP(USD)'")
            .locatedBy("(//input[@class='gwt-TextBox rosetta-numeric'])[last()-1]");

    public static final Target PRICE_CAD = Target.the("'Retail/MSRP(CAD)'")
            .locatedBy("(//input[@class='gwt-TextBox rosetta-numeric'])[last()]");

    public static final Target EFFECTIVE_DATE = Target.the("'Effective Date'")
            .locatedBy("//input[@class='gwt-TextBox rosetta-numeric bad_data' and @name='Effective Date']");

    public static final Target NON_EFFECTIVE_DATE = Target.the("'Non-Effective Date'")
            .locatedBy("//input[@class='gwt-TextBox rosetta-numeric bad_data' and @name='Non-Effective Date']");

    public static final Target EQUIPMENT_DESCRIPTIONS_TABLE = Target.the("'Marketing Descriptions Table'")
            .locatedBy("(//table[@class='r-border'])[last()]/tbody/tr[2]/td/table");

    public static final Target EQUIPMENT_DESCRIPTIONS_ROW1 = Target.the("'Marketing Descriptions Table Row#1'")
            .locatedBy("(//table[@class='r-border'])[last()]/tbody/tr[2]/td/table/tbody/tr[1]");

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
                .locatedBy("(//button[text()='"+ title +"'])[last()]");
    }

    public static final Target TABS_TARGET(String targetElementName , String title)
    {
        return  Target.the(targetElementName)
                .locatedBy("//div[@class='gwt-HTML' and text()='"+ title +" '] ");
    }

    public static final Target STYLE_MENU_OPTION(String title)
    {
        return Target.the(title)
                .locatedBy("//td[@role='menuitem' and text()='"+ title +"']");
    }

    public static final Target CHECKBOX_TARGET(String title)
    {
        return Target.the(title)
                .locatedBy("//span[@title='"+ title +"']/input");
    }

    public static final Target EQUIP_FLAG(String title)
    {
        return Target.the(title)
                .locatedBy("//input[@value='"+ title +"']");
    }

}

