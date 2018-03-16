package net.autodata.nissan.qa.gpas.screenplay.questions;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.WebElement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by ankit.vaish on 05-03-2018.
 */
public class UpdatedModelInfo implements Question{

    private int modelInfoHeaderIndex;
    private static String columnName = "";
    private static String columnValue = "";

    @Override
    public Object answeredBy(Actor actor) {
        modelInfoHeaderIndex = getElementIndex(columnName);
        columnValue= getDriver().findElement(By.xpath("//div[@role='tabpanel']/div/div/div/table/tbody/tr/td["+modelInfoHeaderIndex+"]/div")).getText().trim();
        if(columnName.equalsIgnoreCase("EffDate"))
            columnValue = getFormattedDate(columnValue);
        return columnValue;
    }

    private String getFormattedDate(String columnValue) {
        Date date= null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(columnValue);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDate = DATE_FORMAT.format(date);
        System.out.println(columnValue+"\t"+formattedDate);
        return formattedDate;
    }

    private int getElementIndex(String columnName) {
        int count=1;
        List<WebElement> list = getDriver().findElements(By.xpath("//div[@class='rTool-row']/table[1]/tbody/tr/td/div"));
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