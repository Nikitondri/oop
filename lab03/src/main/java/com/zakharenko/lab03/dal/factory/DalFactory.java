package com.zakharenko.lab03.dal.factory;


import com.zakharenko.lab03.dal.JSONDal;
import com.zakharenko.lab03.dal.impl.JSONDalImpl;

public class DalFactory {
    private static final DalFactory instance = new DalFactory();

    private final JSONDal JSONFileDal = new JSONDalImpl();

    private DalFactory(){ }

    public static DalFactory getInstance(){
        return instance;
    }

    public JSONDal getJSONFileDal(){
        return JSONFileDal;
    }
}
