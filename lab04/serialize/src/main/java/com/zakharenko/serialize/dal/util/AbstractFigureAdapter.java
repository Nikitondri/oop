package com.zakharenko.serialize.dal.util;

import com.google.gson.*;
import com.zakharenko.serialize.logic.CheckSumUtil;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AbstractFigureAdapter<T> implements JsonSerializer<List<T>>, JsonDeserializer<List<T>>{

    private static final String TYPE = "type";
    private static final String PROPERTIES = "properties";
    private static final String CHECK_SUM = "checkSum";
    private static final String OBJECT = "object";


    @Override
    public JsonElement serialize(List<T> objects, Type type, JsonSerializationContext context) {
        String checkSum = CheckSumUtil.findCheckSum(objects);
        JsonArray array = new JsonArray();
        for(T ob : objects){
            JsonObject figureJson = new JsonObject();
            figureJson.add(TYPE, new JsonPrimitive(ob.getClass().getName()));
            figureJson.add(PROPERTIES, context.serialize(ob, ob.getClass()));
            array.add(figureJson);
        }
        JsonObject json = new JsonObject();
        json.add(CHECK_SUM, new JsonPrimitive(checkSum));
        json.add(OBJECT, array);
        return json;
    }

    @Override
    public List<T> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String checkSum = jsonObject.get(CHECK_SUM).getAsString();
        JsonArray array = jsonObject.get(OBJECT).getAsJsonArray();
        List<T> result = new ArrayList<>();
        for(JsonElement element : array){
            JsonObject figureJson = element.getAsJsonObject();
            String type = figureJson.get(TYPE).getAsString();
            JsonElement el = figureJson.get(PROPERTIES);
            try {
                result.add(context.deserialize(el, Class.forName(type)));
            } catch (ClassNotFoundException e) {
                throw new JsonParseException("Unknown element type: " + type, e);
            }
        }
        if(!checkSum.equals(CheckSumUtil.findCheckSum(result))){
            throw new JsonParseException("Checksum did not match");
        }
        return result;
    }
}
