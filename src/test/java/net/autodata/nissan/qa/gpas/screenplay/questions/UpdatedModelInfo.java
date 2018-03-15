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
public class UpdatedModelInfo implements Question{

    private int modelInfoHeaderIndex;
    private static String columnName = "";
    private String columnValue = "";

    @Override
    public Object answeredBy(Actor actor) {
        modelInfoHeaderIndex = getElementIndex(columnName);
        columnValue= getDriver().findElement(By.xpath("//div[@role='tabpanel']/div/div/div/table/tbody/tr/td["+modelInfoHeaderIndex+"]/div")).getText().trim();
        return columnValue;
    }

    private int getElementIndex(String columnName) {
        int count=1;
        List<WebElement>list = getDriver().findElements(By.xpath("//div[@class='rTool-row']/table[1]/tbody/tr/td/div"));
        for(WebElement el:list)
        {
            if(el.getText().equalsIgnoreCase(columnName))
                break;
            count++;
        }
        return count;
    }

    public static UpdatedModelInfo field(String fieldName){
        columnName = fieldName;
        return new UpdatedModelInfo();
    }
}