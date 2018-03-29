package net.autodata.nissan.qa.gpas.screenplay.questions;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.WebElement;
import java.util.List;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by ankit.vaish on 28-03-2018.
 */
public class FavoriteModelList implements Question{

    private static String ymmid = "";
    List<WebElement> modelList = null;

    @Override
    public Object answeredBy(Actor actor) {

        boolean flag = false;
        modelList = getDriver().findElements(By.xpath("(//div[@class='gwt-TabLayoutPanelContent'])[1]/table/tbody/tr[2]/td/table/tbody/tr/td[3]"));
        for(WebElement el:modelList){
            if(el.getText().trim().equalsIgnoreCase(ymmid))
                return flag;
        }
        flag = true;
        return flag;
    }

    public static FavoriteModelList doesNotContain(String ymmId){
        ymmid = ymmId;
        return new FavoriteModelList();
    }
}