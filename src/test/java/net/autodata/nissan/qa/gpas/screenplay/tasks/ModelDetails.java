package net.autodata.nissan.qa.gpas.screenplay.tasks;

import net.serenitybdd.screenplay.targets.Target;

public class ModelDetails {

    static final Target CREATE_MODEL_BUTTON = Target.the("'Create Model' field")
            .locatedBy("//button[text()='Create Model']");

    static final Target SELECT_COUNTRY = Target.the("list of countries")
            .locatedBy("//*[@title='Select Country']");

    static final Target SELECT_MODEL_YEAR = Target.the("list of model years")
            .locatedBy("//*[@title='Select Model Year']");

    static final Target SELECT_SUBDIVISION = Target.the("list of subdivision")
            .locatedBy("//*[@title='Select Subdivision']");

    static final Target SELECT_MODEL_YEAR_FROM_OPTION = Target.the("list of model years")
            .locatedBy("//tr[3]//select[@class='gwt-ListBox']");

    static final Target SELECT_SUBDIVISION_FROM_OPTION = Target.the("list of subdivision")
            .locatedBy("//tr[3]//td[4]//select[@class='gwt-ListBox']");

    static final Target CREATE_MODEL_NAME = Target.the("model name")
            .locatedBy("//tr[3]//td[6]//input[@class='gwt-TextBox']");

    static final Target CREATE_MODEL_PERM_ID = Target.the("permanent model id")
            .locatedBy("//tr[3]//td[5]//input[@class='gwt-TextBox rosetta-numeric']");

    static final Target CREATE_MODEL_SEQUENCE = Target.the("model sequence")
            .locatedBy("//tr[3]//td[8]//input[@class='gwt-TextBox rosetta-numeric']");

    static final Target MODEL_SUBMIT_BUTTON = Target.the("'Submit Model' field")
            .locatedBy("//table[@class='row_edit']//button[@class='rosetta-Button'][text()='Submit']");

    static final Target SELECT_MODEL_YMMID = Target.the("model ymmid")
            .locatedBy("//select[contains(@title, 'ymmid, ModelName')]");
}
