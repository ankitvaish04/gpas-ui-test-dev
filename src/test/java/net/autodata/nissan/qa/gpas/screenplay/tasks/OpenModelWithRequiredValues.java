package net.autodata.nissan.qa.gpas.screenplay.tasks;

import net.autodata.nissan.qa.gpas.screenplay.customactions.*;
import net.autodata.nissan.qa.gpas.screenplay.ui.ApplicationHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


public class OpenModelWithRequiredValues implements Task {

    private final String ymmId;
    private final String country;
    private final String modelYear;
    private final String subDivision;
    private final String modelName;
    private int rows = 0;
    public static boolean edit_model_flag;

    public OpenModelWithRequiredValues(String ymmId, String country, String modelYear, String subDivision, String modelName) {
        this.ymmId = ymmId;
        this.country = country;
        this.modelYear = modelYear;
        this.subDivision = subDivision;
        this.modelName = modelName;
    }

    @Override
    @Step("{0} looks to to open a favorite model for editing")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(ApplicationHomePage.TAB("My Favorites")));

        if(getDriver().findElements(By.xpath("(//div[@class='gwt-TabLayoutPanelContent'])[1]/table/tbody/tr[2]/td/table/tbody/tr")).size()==1)
            edit_model_flag = false;
        else {
            rows = getDriver().findElements(By.xpath("(//div[@class='gwt-TabLayoutPanelContent'])[1]/table/tbody/tr[2]/td/table/tbody/tr")).size();
            for(int i=2; i<=rows; i++){
                if(getDriver().findElement(By.xpath("(//div[@class='gwt-TabLayoutPanelContent'])[1]/table/tbody/tr[2]/td/table/tbody/tr["+i+"]/td[3]/div")).getText().equalsIgnoreCase(ymmId)) {
                    actor.attemptsTo(Click.on(ApplicationHomePage.EDIT_BUTTON(i)));
                    edit_model_flag = true;
                    break;
                }
                else
                   edit_model_flag = false;
            }
        }

        actor.attemptsTo(
                SwitchToChildWindow.edit()

        );

    }
}