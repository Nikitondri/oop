package com.zakharenko.serialize.dal;


import com.zakharenko.serialize.dal.exception.DalException;

import java.util.List;

public interface JsonDal<T> {
    void saveToJson(List<T> list, String path) throws DalException;
    List<T> readFromJson(String path) throws DalException;
}
