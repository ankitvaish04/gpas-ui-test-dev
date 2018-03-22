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
public class CreatedModelRulesInfo implements Question{

    private int rulesInfoHeaderIndex;
    private static String columnName = "";
    private static String columnValue = "";
    private static int rowNum = 0;

    @Override
    public Object answeredBy(Actor actor) {
        rulesInfoHeaderIndex = getElementIndex(columnName);
        System.out.println("ROW#:" + rowNum);
        columnValue= getDriver().findElement(By.xpath("//div[@role='tabpanel']/div[4]/div/div/table/tbody/tr["+rowNum+"]/td["+rulesInfoHeaderIndex+"]")).getText().trim();
        return columnValue;
    }

    private int getElementIndex(String columnName) {
        int count=1;
        List<WebElement> list = getDriver().findElements(By.xpath("//div[@class='rTool-row']/table[4]/tbody/tr/td"));
        for(WebElement el:list)
        {
            if(el.getText().equalsIgnoreCase(columnName))
                break;
            count++;
        }
        return count;
    }

    public static CreatedModelRulesInfo field(String fieldName, int index){
        columnName = fieldName;
        rowNum = index;
        return new CreatedModelRulesInfo();
    }
}