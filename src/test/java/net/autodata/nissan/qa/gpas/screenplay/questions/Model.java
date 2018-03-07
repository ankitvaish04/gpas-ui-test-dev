package net.autodata.nissan.qa.gpas.screenplay.questions;

import net.autodata.nissan.qa.gpas.screenplay.tasks.ModelDetails;
import net.autodata.nissan.qa.gpas.screenplay.ui.EditModel;
import net.autodata.nissan.qa.gpas.screenplay.utilities.GlobalVars;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.WebElement;
import java.util.List;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by ankit.vaish on 05-03-2018.
 */
public class Model implements Question{

    ModelDetails modelDetails;

    @Override
    public Object answeredBy(Actor actor) {
        List<WebElement> models = null;
        String modelName = null;
        models = getDriver().findElements(By.xpath("//select[contains(@title, 'ymmId, ModelName')]/option"));
        for (int i = 0; i<models.size(); i++){
            if(models.get(i).getText().contains(GlobalVars.ymmId)){
                modelName = models.get(i).getText();
                System.out.println("Model Name: " + modelName);
            }
        }
        return modelName;
    }

    public static Model displayedInList(){
        return new Model();
    }
}