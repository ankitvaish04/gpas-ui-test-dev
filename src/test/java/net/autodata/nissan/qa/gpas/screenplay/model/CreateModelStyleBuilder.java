package net.autodata.nissan.qa.gpas.screenplay.model;

import net.autodata.nissan.qa.gpas.screenplay.tasks.CreateModelStyleWithRequiredValues;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;

public class CreateModelStyleBuilder {

    private String styleID;
    private String styleCode;
    private String mfrStyleCode;
    private String nCode;
    private String styleName;
    private String trim;
    private String trimPlus;
    private String versionName;
    private String styleSetName;

    public CreateModelStyleBuilder withStyleId(String styleID) {
        this.styleID = styleID;
        return this;
    }

    public CreateModelStyleBuilder forStyleCode(String styleCode) {
        this.styleCode = styleCode;
        return this;
    }

    public CreateModelStyleBuilder andMfrStyleCode(String mfrStyleCode) {
        this.mfrStyleCode = mfrStyleCode;
        return this;
    }

    public CreateModelStyleBuilder andNCode(String nCode) {
        this.nCode = nCode;
        return this;
    }

    public CreateModelStyleBuilder andStyleName(String styleName) {
        this.styleName = styleName;
        return this;
    }

    public CreateModelStyleBuilder andTrim(String trim) {
        this.trim = trim;
        return this;
    }

    public CreateModelStyleBuilder andTrimPlus(String trimPlus) {
        this.trimPlus = trimPlus;
        return this;
    }

    public CreateModelStyleBuilder withVersionName(String versionName) {
        this.versionName = versionName;
        return this;
    }

    public CreateModelStyleBuilder andStyleSetName(String styleSetName) {
        this.styleSetName = styleSetName;
        return this;
    }


    public Performable createModelStyle() {
        return Instrumented.instanceOf(CreateModelStyleWithRequiredValues.class)
                .withProperties(styleID,styleCode,mfrStyleCode,nCode,styleName,trim,trimPlus,versionName,styleSetName);
    }
}
