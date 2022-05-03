package com.zakharenko.lab03.service;

import com.zakharenko.lab03.entity.tariff.Tariff;
import com.zakharenko.lab03.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TariffService {
    void addTariff(String tariffType, HttpServletRequest request) throws ServiceException;
    void removeTariff(HttpServletRequest request) throws ServiceException;
    void setTariff(HttpServletRequest request) throws ServiceException;
    void loadFile(HttpServletRequest request) throws ServiceException;
    void saveFile(HttpServletRequest request) throws ServiceException;
}
