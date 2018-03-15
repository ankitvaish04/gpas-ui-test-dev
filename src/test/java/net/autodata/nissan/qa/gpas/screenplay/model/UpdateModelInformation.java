package net.autodata.nissan.qa.gpas.screenplay.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Value;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Value
public class UpdateModelInformation {

    private final String effectiveDate;
    private final String languages;
    private final String currencies;
    private final String priceTypes;
    private final String modelKind;
    private final String modelLineCode;
    private final String program;
    private final String commercialKind;
    private final String clientType;
    private final String phase;
    private final String comment;
    private final String tarrif;
    private final String modelName;

    public static List<Map<String,String>> asMap(List<UpdateModelInformation> ob)
    {
        List<Map<String,String>> listMap=null;
        for(UpdateModelInformation object:ob)
        {
            listMap = new ArrayList<Map<String,String>>();
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> map = mapper.convertValue(object, new TypeReference<Map<String, String>>() {});
            listMap.add(map);
        }
        return listMap;
    }
}
