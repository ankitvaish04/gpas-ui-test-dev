package net.autodata.nissan.qa.gpas.screenplay.questions;

import net.autodata.nissan.qa.gpas.screenplay.model.ModelInformation;
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
public class ModelList implements Question{

    private static List<ModelInformation> modelInformation=null;
    List<WebElement> modelList = null;
    List<String> model = new ArrayList<String>();
    @Override
    public Object answeredBy(Actor actor) {


        modelList = getDriver().findElements(By.xpath("//select[contains(@title, 'ModelName')]/option"));
        modelInformation.forEach(info->{
            modelList.forEach(element->{
                if(element.getText().contains(info.getModelPermId())&& element.getText().contains(info.getModelName()))
                    model.add(element.getText().replaceFirst("\\d{5}\\s",""));
            });
        });
        //System.out.println("MODEL LIST : " + model);
        return model;
    }

    public static ModelList displayed(List<ModelInformation> mi){
        modelInformation = mi;
        return new ModelList();
    }
}