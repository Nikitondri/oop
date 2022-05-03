package com.zakharenko.lab03.service.creator;


import com.zakharenko.lab03.entity.tariff.AllTariffs;
import com.zakharenko.lab03.entity.tariff.Tariff;
import com.zakharenko.lab03.service.exception.ServiceException;

import java.io.InputStream;
import java.util.List;

public interface Creator<T> {
    T createFromFile(InputStream inputStream) throws ServiceException;
    AllTariffs createAllTariffs(List<Tariff> list);
}
