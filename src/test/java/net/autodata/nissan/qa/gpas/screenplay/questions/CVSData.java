package net.autodata.nissan.qa.gpas.screenplay.questions;

import com.jcraft.jsch.JSchException;
import net.autodata.nissan.qa.gpas.screenplay.tasks.ModelDetails;
import net.autodata.nissan.qa.gpas.screenplay.utilities.GetCSVRecords;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by ankit.vaish on 05-03-2018.
 */
public class CVSData implements Question{

    ModelDetails modelDetails;
    List<String> modelValues=null;
    private Map<String, List<Map<String, String>>> gpasCvsDataInMap = null;

    @Override
    public Object answeredBy(Actor actor) {
        try {
            gpasCvsDataInMap = GetCSVRecords.readCsvFileLines(GetCSVRecords.checkoutCsvFiles());
            gpasCvsDataInMap.get("model").get(0).forEach((key, value) -> {
                modelValues.add(value);


            });
           // assert

        } catch (JSchException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return modelValues.toString();
    }

    public static CVSData inCVSDataStore(){
        return new CVSData();
    }
}