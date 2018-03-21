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
public class CreatedModelEquipmentInfo implements Question{

    private int equipmentInfoHeaderIndex;
    private static String columnName = "";
    private static String columnValue = "";

    @Override
    public Object answeredBy(Actor actor) {
        equipmentInfoHeaderIndex = getElementIndex(columnName);
        columnValue= getDriver().findElement(By.xpath("//div[@role='tabpanel']/div[3]/div/div/table/tbody/tr/td["+equipmentInfoHeaderIndex+"]/div")).getText().trim();
        return columnValue;
    }

    private int getElementIndex(String columnName) {
        int count=1;
        List<WebElement> list = getDriver().findElements(By.xpath("//div[@class='rTool-row']/table[3]/tbody/tr/td/div"));
        for(WebElement el:list)
        {
            if(el.getText().equalsIgnoreCase(columnName))
                break;
            count++;
        }
        return count;
    }

    public static CreatedModelEquipmentInfo field(String fieldName){
        columnName = fieldName;
        return new CreatedModelEquipmentInfo();
    }
}