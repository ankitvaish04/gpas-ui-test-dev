package net.autodata.nissan.qa.gpas.screenplay.model;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.ui.Model;
import org.yecht.Data;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ankit.vaish on 13-03-2018.
 */
public class Test {

    static int i=0;
    public static void main(String[] args) throws ParseException, InterruptedException, MalformedURLException {

        String s="30 29601 Model from Serenity 1 test {30}";
        String s1="";
        //System.out.println(s.substring(0,3)+s.substring(9));
        //System.out.println(s.replaceFirst("\\d{5}\\s",""));
        System.out.println(s.replaceFirst("\\d{5}\\s",""));
       // System.out.println(s.replaceAll("/^[0-9]{5}$/",""));
        //System.out.println(s.replaceAll("[0-9]", "X"));

        String ss = "2017-07-18";
        String sss = ss.replace("-","/");
        System.out.println(sss);

        Date today = new Date();

//If you print Date, you will get un formatted output
        System.out.println("Today is : " + today);

//formatting date in Java using SimpleDateFormat
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        String date = DATE_FORMAT.format(today);
        System.out.println("Today in dd-MM-yyyy format : " + date);

//Another Example of formatting Date in Java using SimpleDateFormat
        DATE_FORMAT = new SimpleDateFormat("dd/MM/yy");
        date = DATE_FORMAT.format(today);
        System.out.println("Today in dd/MM/yy pattern : " + date);

//formatting Date with time information
        DATE_FORMAT = new SimpleDateFormat("dd-MM-yy:HH:mm:SS");
        date = DATE_FORMAT.format(today);
        System.out.println("Today in dd-MM-yy:HH:mm:SS : " + date);

//SimpleDateFormat example – Date with timezone information
        DATE_FORMAT = new SimpleDateFormat("dd-MM-yy:HH:mm:SS Z");
        date = DATE_FORMAT.format(today);
        System.out.println("Today in dd-MM-yy:HH:mm:SSZ : " + date);

        String sDate1="2017-07-18";
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);

        DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
        String newdate = DATE_FORMAT.format(date1);
        System.out.println(sDate1+"\t"+newdate);

        List<String> createModelRulesInformationList = new ArrayList<String>();
        createModelRulesInformationList.add("1");
        createModelRulesInformationList.add("2");
        createModelRulesInformationList.add("3");
        createModelRulesInformationList.add("4");
        createModelRulesInformationList.add("5");
        createModelRulesInformationList.add("6");
        createModelRulesInformationList.add("7");
        createModelRulesInformationList.add("8");
        createModelRulesInformationList.add("9");
        createModelRulesInformationList.add("10");
        createModelRulesInformationList.add("11");
        createModelRulesInformationList.add("12");
        createModelRulesInformationList.add("13");
        createModelRulesInformationList.add("14");
        createModelRulesInformationList.add("15");


        createModelRulesInformationList.forEach(item->{
            System.out.println(++i);
        });

        int index = 0;
        int j = createModelRulesInformationList.size();
        for(String el:createModelRulesInformationList){
            index = createModelRulesInformationList.indexOf(el)+ j;  //6-4  //-4
            j = j-2;
            System.out.println("Index is:" + index);
        }

        String columnValue = "440.00\n0.00";
        String price = columnValue.split("\n")[0].replace(",","");
        System.out.println("Price :" + price);

        String path = "C:\\Users\\ankit.vaish\\Desktop\\New folder\\geckodriver-v0.20.0-win64\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", path);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities = DesiredCapabilities.firefox();
        capabilities.setBrowserName("firefox");
        capabilities.setVersion("47");
        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setCapability("marionette", false);

        WebDriver driver = new FirefoxDriver(capabilities);

        driver.navigate().to(new URL("http://qa.user:qa.user@localhost:8080/rosettaTools/"));

        driver.manage().window().maximize();
        driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[4]/div/div[3]/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td/select/option[9]")).click();
        driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[4]/div/div[3]/table/tbody/tr[2]/td[3]/table/tbody/tr[2]/td/select/option")).click();
        driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[4]/div/div[3]/table/tbody/tr[2]/td[4]/table/tbody/tr[2]/td/select/option")).click();
        driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[4]/div/div[3]/table/tbody/tr[2]/td[5]/table/tbody/tr[2]/td/select/option[12]")).click();
        driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[4]/div/div[3]/table/tbody/tr[2]/td[6]/table/tbody/tr[9]/td/button")).click();
        Thread.sleep(10000);

        driver.quit();





    }
}
