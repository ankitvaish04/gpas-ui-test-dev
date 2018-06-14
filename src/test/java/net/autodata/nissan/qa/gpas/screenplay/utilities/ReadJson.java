package net.autodata.nissan.qa.gpas.screenplay.utilities;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.autodata.nissan.qa.gpas.screenplay.data.Styles;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankit.vaish on 06-03-2018.
 */
public class ReadJson {

    public static Styles.Descriptions d = null;

    public static ReadJson getInstance() {
        return new ReadJson();
    }

    public List<Styles> initStylesData(String fileName) throws IOException {
        List<Styles> stylesList = new ArrayList<Styles>();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File(getClass().getClassLoader().getResource(fileName).getPath()));
        root.path("CreateStyles").forEach(creatStyle -> {
            Styles style = new Styles();

            style.setStyleId(creatStyle.get("style_id").asText());
            style.setStyleCode(creatStyle.get("style_code").asText());
            style.setMfrStyleCode(creatStyle.get("mfr_style_code").asText());
            style.setNcode(creatStyle.get("ncode").asText());
            style.setStyleName(creatStyle.get("style_name").asText());
            style.setTrim(creatStyle.get("trim").asText());
            style.setTrimPlus(creatStyle.get("trim_plus").asText());
            style.setVersionName(creatStyle.get("version_name").asText());

            creatStyle.get("descriptions").forEach(description ->{
                style.setDescriptionValues(description.get("description_type_id").asText(),description.get("description").asText());
            });

            creatStyle.get("pricing").forEach(pricing -> {
                style.setPriceValues(pricing.get("price_state").asText(), pricing.get("model_pricing").asText(), pricing.get("effective_date").asText(), pricing.get("non_effective_date").asText());
            });

            style.setStyleSetName(creatStyle.get("styleSetName").asText());

            stylesList.add(style);
        });


        // Print the values
            stylesList.forEach(st->{
                System.out.println("style id "+st.getStyleId());
                System.out.println("MRFS ID " +st.getMfrStyleCode());
                System.out.println(" Ncode "+st.getNcode());
                System.out.println("StyleName "+st.getStyleName());
            });

            Styles.desList.forEach(des->{
                System.out.println(des.getDescription());
                System.out.println(des.getDescriptionTypeId());
            });

            Styles.pricingList.forEach(price->{
                System.out.println("price state "+price.getPriceState());
                System.out.println("model pricing "+price.getModelPricing());
                System.out.println("effective date "+price.getEffectiveDate());
                System.out.println("non effective date "+price.getNonEffectiveDate());
            });


        return stylesList;
    }

    public JSONObject envInputFile(String envInputFile) throws IOException, ParseException {
        //Get file from resources folder
        JSONObject jsonObject=null;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            URL url=classLoader.getResource(envInputFile);
            FileReader file = new FileReader(classLoader.getResource(envInputFile).getPath());
            JSONParser envInputs = new JSONParser();
            jsonObject=(JSONObject) envInputs.parse(file);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return jsonObject;

    }

}
