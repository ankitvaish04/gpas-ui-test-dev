package net.autodata.nissan.qa.gpas.screenplay.utilities;


import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public static Styles.Descriptions d=null;

    public  JSONObject readJson(String createModelInputs) throws IOException, ParseException {
        //Get file from resources folder
        JSONObject jsonObject=null;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            URL url=classLoader.getResource(createModelInputs);
            FileReader file = new FileReader(classLoader.getResource(createModelInputs).getPath());
            JSONParser envInputs = new JSONParser();
            jsonObject=(JSONObject) envInputs.parse(file);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return jsonObject;

    }

    public static void initInputData()
    {
        List<Styles> stylesList= new ArrayList<Styles>();
        try
        {
            ObjectMapper mapper = new ObjectMapper();

            JsonNode root = mapper.readTree(new File("F:\\Nissan\\Serenity\\gpas-ui-test-dev\\src\\test\\resources\\CreateModelInputs.json"));

            // Get id
            root.path("CreateStyles").forEach(creatStyle->{
                Styles st=new Styles();

                st.setStyle_id(creatStyle.get("style_id").asText());
                st.setStyle_code(creatStyle.get("style_code").asText());

                st.setMfr_style_code(creatStyle.get("mfr_style_code").asText());
                st.setNcode(creatStyle.get("ncode").asText());
                st.setVersionName(creatStyle.get("version_name").asText());

                st.setStyle_name(creatStyle.get("style_name").asText());
                st.setTrim(creatStyle.get("trim").asText());
                st.setTrim_plus(creatStyle.get("trim_plus").asText());

               creatStyle.get("descriptions").forEach(description->
               {

                     st.setDescriptionValues(description.get("description").asText(),description.get("description_type_id").asText());

               });


                stylesList.add(st);


            });


            stylesList.forEach(st->{
                System.out.println("style id "+st.getStyle_id());
                System.out.println("MRFS ID " +st.getMfr_style_code());
                System.out.println(" Ncode "+st.getNcode());
                System.out.println("StyleName "+st.getStyle_name());
            });

            Styles.desList.forEach(des->{
                System.out.println(des.getdescription());
                System.out.println(des.getdescription_type_id());
            });

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        initInputData();
    }

}
