package net.autodata.nissan.qa.gpas.screenplay.customactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

/**
 * Created by ankit.vaish on 07-03-2018.
 */
public class RetrieveYmmId implements Interaction{

    private String ymmId="";
    @Override
    public <T extends Actor> void performAs(T actor) {

        String currentUrl = BrowseTheWeb.as(actor).getDriver().getCurrentUrl().trim();
        ymmId = currentUrl.substring(currentUrl.lastIndexOf("=") + 1).trim();
        //System.out.println("Current URL: " + currentUrl);
        //System.out.println("YMMID      : " + GlobalVars.ymmId);
    }

    public static RetrieveYmmId fromUrl(){
        return new RetrieveYmmId();
    }

}
