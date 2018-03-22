package net.autodata.nissan.qa.gpas.screenplay.tasks;

import net.autodata.nissan.qa.gpas.screenplay.customactions.RightClick;
import net.autodata.nissan.qa.gpas.screenplay.ui.EditModelPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


public class CreateModelStyleWithRequiredValues implements Task {

    private final String styleID;
    private final String styleCode;
    private final String mfrStyleCode;
    private final String nCode;
    private final String styleName;
    private final String trim;
    private final String trimPlus;
    private final String versionName;
    private final String styleSetName;


    public CreateModelStyleWithRequiredValues(String styleID,String styleCode,String mfrStyleCode,String nCode,String styleName,String trim,String trimPlus,String versionName,String styleSetName) {
        this.styleID = styleID;
        this.styleCode = styleCode;
        this.mfrStyleCode = mfrStyleCode;
        this.nCode = nCode;
        this.styleName = styleName;
        this.trim = trim;
        this.trimPlus = trimPlus;
        this.versionName = versionName;
        this.styleSetName = styleSetName;

    }

    @Override
    @Step("{0} looks to create a model style")
    public <T extends Actor> void performAs(T actor) {

        if(getDriver().findElements(By.xpath("//div[@role='tabpanel']/div[2]/div/div/table/tbody/tr")).size()==0)
            actor.attemptsTo(RightClick.on(EditModelPage.STYLE_TABLE));
        else
            actor.attemptsTo(RightClick.on(EditModelPage.STYLE_TABLE_ROW1));

            actor.attemptsTo(

                    Click.on(EditModelPage.STYLE_MENU_OPTION("Insert New Record")),
                    Enter.theValue(styleID).into(EditModelPage.INPUT_BOX_TITLED("pStyle Id", "StylePermId")),
                    Enter.theValue(styleCode).into(EditModelPage.INPUT_BOX_TITLED("Style Code", "Style Code")),
                    Enter.theValue(mfrStyleCode).into(EditModelPage.INPUT_BOX_TITLED("Mfr Style Code", "Mfr Style Code")),
                    Enter.theValue(nCode).into(EditModelPage.INPUT_BOX_TITLED("NCode", "NCode")),
                    Enter.theValue(styleName).into(EditModelPage.INPUT_BOX_TITLED("Style Name", "Style Name")),
                    Enter.theValue(trim).into(EditModelPage.INPUT_BOX_TITLED("Trim", "Trim")),
                    Enter.theValue(trimPlus).into(EditModelPage.INPUT_BOX_TITLED("Trim Plus", "Trim Plus")),
                    Enter.theValue(versionName).into(EditModelPage.INPUT_BOX_TITLED("Version Name", "Version Name")),
                    Click.on(EditModelPage.TRANSLATE_BUTTON_EN)

            );
    }

}