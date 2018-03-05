package net.autodata.nissan.qa.gpas.screenplay.questions;

import net.autodata.nissan.qa.gpas.screenplay.tasks.ModelDetails;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

/**
 * Created by ankit.vaish on 05-03-2018.
 */
public class Model implements Question{

    ModelDetails modelDetails;

    @Override
    public Object answeredBy(Actor actor) {
        return Text.of(modelDetails.SELECT_MODEL_YMMID).viewedBy(actor).asString();
    }

    public static Model displayedInList(){
        return new Model();
    }
}
