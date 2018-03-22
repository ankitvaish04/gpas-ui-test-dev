package net.autodata.nissan.qa.gpas.screenplay.tasks;

import net.autodata.nissan.qa.gpas.screenplay.customactions.RightClick;
import net.autodata.nissan.qa.gpas.screenplay.ui.EditModelPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


    public class CreateModelRulesWithRequiredValues implements Task {

    private final String orderCode;
    private final String operator;
    private final String operand;

    public CreateModelRulesWithRequiredValues(String orderCode,String operator,String operand) {
        this.orderCode = orderCode;
        this.operator = operator;
        this.operand = operand;
    }

    @Override
    @Step("{0} looks to create model rules")
    public <T extends Actor> void performAs(T actor) {

        if(getDriver().findElements(By.xpath("//div[@role='tabpanel']/div[4]/div/div/table/tbody/tr")).size()==0)
            actor.attemptsTo(RightClick.on(EditModelPage.RULE_TABLE));
        else
            actor.attemptsTo(RightClick.on(EditModelPage.RULE_TABLE_ROW1));

            actor.attemptsTo(

                    Click.on(EditModelPage.STYLE_MENU_OPTION("Insert New Record")),
                    Enter.theValue(orderCode).into(EditModelPage.INPUT_BOX_TITLED("Order Code", "Order Code")),
                    Enter.theValue(operator).into(EditModelPage.INPUT_BOX_TITLED("Operator", "Operator [X,O,R,I]")),
                    Enter.theValue(operand).into(EditModelPage.INPUT_BOX_TITLED("Operand", "Operand")),
                    Click.on(EditModelPage.BUTTON_TARGET("Submit Button", "Submit"))

            );
    }

}