package net.autodata.nissan.qa.gpas.screenplay.utilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankit.vaish on 06-03-2018.
 */
public class Styles {

    private String style_id;
    private String style_code;
    private String mfr_style_code;
    private String ncode;
    private String style_name;
    private String trim;
    private String trim_plus;
    private String version_name;
    private String styleSetName;
    private Descriptions descriptions;

public static List<Descriptions> desList=new ArrayList<Descriptions>();


    public String getStyle_id() {
        return style_id;
    }

    public void setStyle_id(String style_id) {
        this.style_id = style_id;

    }

    public String getStyle_code() {
        return style_code;
    }

    public void setStyle_code(String style_code) {
        this.style_code = style_code;

    }

    public String getMfr_style_code() {
        return mfr_style_code;
    }

    public void setMfr_style_code(String mfr_style_code) {
        this.mfr_style_code = mfr_style_code;

    }

    public String getNcode() {
        return ncode;
    }

    public void setNcode(String ncode) {
        this.ncode = ncode;

    }

    public String getStyle_name() {
        return style_name;
    }

    public void setStyle_name(String style_name) {
        this.style_name = style_name;

    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;

    }

    public String getTrim_plus() {
        return trim_plus;
    }

    public void setTrim_plus(String trim_plus) {
        this.trim_plus = trim_plus;

    }

    public String getVersionName() {
        return version_name;
    }

    public void setVersionName(String version_name) {
        this.version_name = version_name;

    }

    public String getStyleSetName() {
        return styleSetName;
    }

    public void setStyleSetName(String styleSetName) {
        this.styleSetName = styleSetName;

    }

    public Descriptions getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(Descriptions descriptions) {
        this.descriptions = descriptions;

    }

    public Descriptions getDescInstance()

    {
        return  new Descriptions();
    }

      public  class Descriptions
    {
        private String description_type_id;
        private String description;

        public String getdescription_type_id() {

            return description_type_id;
        }
        public void setdescription_type_id(String description_type_id)
        {

            this.description_type_id = description_type_id;
        }

        public String getdescription() {
            return description;
        }
        public void setdescription(String description) {
            this.description = description;
        }



    }

    void setDescriptionValues(String description,String descriptionTypeId)
    {
        Descriptions d= new Descriptions();
        d.setdescription(description);
        d.setdescription_type_id(descriptionTypeId);
        desList.add(d);
    }


}
