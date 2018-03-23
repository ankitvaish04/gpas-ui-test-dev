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
public class CreatedModelPricingInfo implements Question{

    private int pricingInfoHeaderIndex;
    private static String columnName = "";
    private static String columnValue = "";
    private static int rowNum = 0;

    @Override
    public Object answeredBy(Actor actor) {
        pricingInfoHeaderIndex = getElementIndex(columnName);
        if(columnName.equalsIgnoreCase("Retail/MSRP")) {
            columnValue = getDriver().findElement(By.xpath("//div[@role='tabpanel']/div[5]/div/div/table/tbody/tr[" + rowNum + "]/td[5]/div/table/tbody/tr/td[2]/div")).getText().trim();
            columnValue = columnValue.split("\n")[0].replace(",","");
            return columnValue;
        }
        if(columnName.equalsIgnoreCase("PS")) {
            columnValue = getDriver().findElement(By.xpath("//div[@role='tabpanel']/div[5]/div/div/table/tbody/tr[" + rowNum + "]/td[5]/div/table/tbody/tr/td[4]/div")).getText().trim();
            switch (columnValue){
                case "0": return columnValue = "Actual";
                case "1": return columnValue = "W/A";
                case "2": return columnValue = "Estimated";
                case "3": return columnValue = "VQ Actual";
                case "5": return columnValue = "VQ Estimated";
            }
        }
        if(columnName.equalsIgnoreCase("R/F")) {
            columnValue = getDriver().findElement(By.xpath("//div[@role='tabpanel']/div[5]/div/div/table/tbody/tr["+rowNum+"]/td[5]/div/table/tbody/tr/td[5]/div")).getText().trim();
            return columnValue;
        }
        if(columnName.equalsIgnoreCase("EffDate")) {
            columnValue = getDriver().findElement(By.xpath("//div[@role='tabpanel']/div[5]/div/div/table/tbody/tr[" + rowNum + "]/td[5]/div/table/tbody/tr/td[6]/div")).getText().trim();
            return columnValue;
        }
        if(columnName.equalsIgnoreCase("NonEffDate")) {
            columnValue = getDriver().findElement(By.xpath("//div[@role='tabpanel']/div[5]/div/div/table/tbody/tr[" + rowNum + "]/td[5]/div/table/tbody/tr/td[7]/div")).getText().trim();
            return columnValue;
        }

        columnValue = getDriver().findElement(By.xpath("//div[@role='tabpanel']/div[5]/div/div/table/tbody/tr["+rowNum+"]/td["+pricingInfoHeaderIndex+"]")).getText().trim();
        return columnValue;
    }

    private int getElementIndex(String columnName) {
        int count=1;
        List<WebElement> list = getDriver().findElements(By.xpath("//div[@class='rTool-row']/table[5]/tbody/tr/td"));
        for(WebElement el:list)
        {
            if(el.getText().equalsIgnoreCase(columnName))
                break;
            count++;
        }
        return count;
    }

    public static CreatedModelPricingInfo field(String fieldName, int index){
        columnName = fieldName;
        rowNum = index;
        return new CreatedModelPricingInfo();
    }
}