package lab3.Mapped.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import lab3.Mapped.models.SprinterTraining;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class MappedParser {
    private static final Type SPR_TYPE = new TypeToken<List<SprinterTraining>>() {
    }.getType();

    public static SprinterTraining getSprinterTraining(String path) throws FileNotFoundException{
        Gson gson = new Gson();
        JsonReader jr = new JsonReader(new FileReader(path));
        List<SprinterTraining> sprinterTrainingList = gson.fromJson(jr, SPR_TYPE);
        return sprinterTrainingList.get(0);
    }
}
