package com.zakharenko.lab03.dal;


import com.zakharenko.lab03.dal.exception.DalException;
import com.zakharenko.lab03.entity.ParametersList;
import com.zakharenko.lab03.entity.tariff.AllTariffs;

import java.io.Reader;

public interface JSONDal {
    AllTariffs readTariffsFromJSON(Reader reader) throws DalException;
    ParametersList readParametersFromJSON(String path) throws DalException;
    void writeTariffsToJSON(String path, AllTariffs allTariffs) throws DalException;
}
