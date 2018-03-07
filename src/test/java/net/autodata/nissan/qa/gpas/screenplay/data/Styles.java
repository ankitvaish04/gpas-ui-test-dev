package net.autodata.nissan.qa.gpas.screenplay.data;
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


    public static List<Descriptions> desList=new ArrayList<Descriptions>();
    public static List<Pricing> pricingList=new ArrayList<Pricing>();
    public String getStyleId() {
        return style_id;
    }
    public void setStyleId(String style_id) {
        this.style_id = style_id;

    }
    public String getStyleCode() {
        return style_code;
    }
    public void setStyleCode(String style_code) {
        this.style_code = style_code;

    }
    public String getMfrStyleCode() {
        return mfr_style_code;
    }
    public void setMfrStyleCode(String mfr_style_code) {
        this.mfr_style_code = mfr_style_code;

    }
    public String getNcode() {
        return ncode;
    }
    public void setNcode(String ncode) {
        this.ncode = ncode;

    }
    public String getStyleName() {
        return style_name;
    }
    public void setStyleName(String style_name) {
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
    public void setTrimPlus(String trim_plus) {
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
    public void setDescriptionValues(String description,String descriptionTypeId)
    {
        Descriptions d= new Descriptions();
        d.setDescription(description);
        d.setDescriptionTypeId(descriptionTypeId);
        desList.add(d);
    }
    public void setPriceValues(String price_state, String model_pricing, String effective_date, String non_effective_date)
    {
        Pricing p= new Pricing();
        p.setPriceState(price_state);
        p.setModelPricing(model_pricing);
        p.setEffectiveDate(effective_date);
        p.setNonEffectiveDate(non_effective_date);
        pricingList.add(p);
    }
    public class Descriptions
    {
        private String description_type_id;
        private String description;

        public String getDescriptionTypeId() {

            return description_type_id;
        }
        public void setDescriptionTypeId(String description_type_id)
        {
            this.description_type_id = description_type_id;
        }

        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }



    }
    public class Pricing {

        private String price_state;
        private String model_pricing;
        private String effective_date;
        private String non_effective_date;

        public String getPriceState() {

            return price_state;
        }
        public void setPriceState(String price_state)
        {

            this.price_state = price_state;
        }

        public String getModelPricing() {

            return model_pricing;
        }
        public void setModelPricing(String model_pricing)
        {

            this.model_pricing = model_pricing;
        }

        public String getEffectiveDate() {

            return effective_date;
        }
        public void setEffectiveDate(String effective_date)
        {

            this.effective_date = effective_date;
        }

        public String getNonEffectiveDate() {

            return non_effective_date;
        }
        public void setNonEffectiveDate(String non_effective_date)
        {

            this.non_effective_date = non_effective_date;
        }


    }


}
