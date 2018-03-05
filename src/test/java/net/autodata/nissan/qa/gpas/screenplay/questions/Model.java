package net.autodata.nissan.qa.gpas.screenplay.questions;

import net.autodata.nissan.qa.gpas.screenplay.tasks.ModelDetails;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
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
            if(models.get(i).getText().contains("29572")){
                modelName = models.get(i).getText();
                System.out.println("Model Name: " + modelName);
            }
        }
        //return Text.of(modelDetails.SELECT_MODEL_YMMID).viewedBy(actor).asString();
        return modelName;
    }

    public static Model displayedInList(){
        return new Model();
    }
}