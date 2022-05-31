package com.zakharenko.serialize.dal.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.zakharenko.serialize.dal.JsonDal;
import com.zakharenko.serialize.dal.exception.DalException;
import com.zakharenko.serialize.dal.util.AbstractFigureAdapter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class JsonDalImpl<T> implements JsonDal<T> {

    private final Gson gson;

    public JsonDalImpl() {
        gson = new GsonBuilder()
                .registerTypeAdapter((new TypeToken<List<T>>() {}).getType(), new AbstractFigureAdapter<T>())
                .setPrettyPrinting()
                .create();
    }

    @Override
    public void saveToJson(List<T> list, String path) throws DalException {
        try(FileWriter fileWriter = new FileWriter(path)){
            fileWriter.write(gson.toJson(list, (new TypeToken<List<T>>() {}).getType()));
            fileWriter.flush();
        } catch (IOException e) {
            throw new DalException(e);
        }
    }

    @Override
    public List<T> readFromJson(String path) throws DalException {
        try {
            return gson.fromJson(new FileReader(path), (new TypeToken<List<T>>() {}).getType());
        } catch (FileNotFoundException e) {
            throw new DalException(e);
        }
    }
}
