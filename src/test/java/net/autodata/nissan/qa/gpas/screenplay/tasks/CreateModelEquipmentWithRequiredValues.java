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


public class CreateModelEquipmentWithRequiredValues implements Task {

    private final String isHeader;
    private final String isSpec;
    private final String isMostPopular;
    private final String orderCode;
    private final String optionKind;
    private final String utf;
    private final String flags;
    private final String filterRules;

    public CreateModelEquipmentWithRequiredValues(String isHeader, String isSpec, String isMostPopular, String orderCode, String optionKind, String utf, String flags, String filterRules) {
        this.isHeader = isHeader;
        this.isSpec = isSpec;
        this.isMostPopular = isMostPopular;
        this.orderCode = orderCode;
        this.optionKind = optionKind;
        this.utf = utf;
        this.flags = flags;
        this.filterRules = filterRules;

    }

    @Override
    @Step("{0} looks to create model equipments")
    public <T extends Actor> void performAs(T actor) {

        if(getDriver().findElements(By.xpath("//div[@role='tabpanel']/div[3]/div/div/table/tbody/tr")).size()==1) {
            actor.attemptsTo(
                    RightClick.on(EditModelPage.EQUIP_TABLE),
                    Click.on(EditModelPage.STYLE_MENU_OPTION("Insert New Record"))
            );
        }

        else {
            actor.attemptsTo(
                    RightClick.on(EditModelPage.EQUIP_TABLE_ROW1),
                    Click.on(EditModelPage.STYLE_MENU_OPTION("Insert New Record"))
            );
        }

        if (isHeader.equalsIgnoreCase("Y")){
            actor.attemptsTo(Click.on(EditModelPage.MAKE_HEADER_BUTTON));
            actor.attemptsTo(Enter.theValue(orderCode).into(EditModelPage.INPUT_BOX_TARGET("OrderCode", "Order Code")));
            if(isSpec.equalsIgnoreCase("Y"))
                actor.attemptsTo(Click.on(EditModelPage.CHECKBOX_TARGET("Is Specification")));
        }
        else {
            actor.attemptsTo(
                    Enter.theValue(orderCode).into(EditModelPage.INPUT_BOX_TARGET("OrderCode", "Order Code")),
                    Enter.theValue(optionKind).into(EditModelPage.INPUT_BOX_TARGET("UTF", "OptionKind")),
                    Enter.theValue(utf).into(EditModelPage.INPUT_BOX_TARGET("UTF", "UTF")),
                    Click.on(EditModelPage.INPUT_BOX_TARGET("Flags", "Flags"))
            );

            String[] equipFlags = flags.split(",");
            for(String flag:equipFlags)
              actor.attemptsTo(Click.on(EditModelPage.EQUIP_FLAG(flag.trim())));

            actor.attemptsTo(Click.on(EditModelPage.BUTTON_TARGET("OK Button","OK")));

            if (isSpec.equalsIgnoreCase("Y"))
                actor.attemptsTo(Click.on(EditModelPage.CHECKBOX_TARGET("Is Specification")));

            if (isMostPopular.equalsIgnoreCase("Y"))
                actor.attemptsTo(Click.on(EditModelPage.CHECKBOX_TARGET("Most Popular")));
        }

    }

}