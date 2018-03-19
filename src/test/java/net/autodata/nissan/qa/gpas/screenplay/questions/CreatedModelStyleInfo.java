package net.autodata.nissan.qa.gpas.screenplay.questions;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.WebElement;
import java.util.List;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by ankit.vaish on 05-03-2018.
 */
public class CreatedModelStyleInfo implements Question{

    private int styleInfoHeaderIndex;
    private static String columnName = "";
    private static String columnValue = "";

    @Override
    public Object answeredBy(Actor actor) {
        styleInfoHeaderIndex = getElementIndex(columnName);
        columnValue= getDriver().findElement(By.xpath("//div[@role='tabpanel']/div[2]/div/div/table/tbody/tr/td["+styleInfoHeaderIndex+"]/div")).getText().trim();
        return columnValue;
    }

    private int getElementIndex(String columnName) {
        int count=1;
        List<WebElement> list = getDriver().findElements(By.xpath("//div[@class='rTool-row']/table[2]/tbody/tr/td/div"));
        for(WebElement el:list)
        {
            if(el.getText().equalsIgnoreCase(columnName))
                break;
            count++;
        }
        return count;
    }

    public static CreatedModelStyleInfo field(String fieldName){
        columnName = fieldName;
        return new CreatedModelStyleInfo();
    }
}