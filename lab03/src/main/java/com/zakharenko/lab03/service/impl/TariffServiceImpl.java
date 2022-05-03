package com.zakharenko.lab03.service.impl;

import com.zakharenko.lab03.dal.JSONDal;
import com.zakharenko.lab03.dal.exception.DalException;
import com.zakharenko.lab03.dal.factory.DalFactory;
import com.zakharenko.lab03.dal.repository.Repository;
import com.zakharenko.lab03.dal.repository.impl.RepositoryTariffImpl;
import com.zakharenko.lab03.entity.tariff.AllTariffs;
import com.zakharenko.lab03.entity.tariff.ListTariff;
import com.zakharenko.lab03.entity.tariff.Tariff;
import com.zakharenko.lab03.service.GeneratorService;
import com.zakharenko.lab03.service.TariffService;
import com.zakharenko.lab03.service.creator.Creator;
import com.zakharenko.lab03.service.creator.TariffListCreator;
import com.zakharenko.lab03.service.exception.ServiceException;
import com.zakharenko.lab03.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

public class TariffServiceImpl implements TariffService {
    private static final String JSP_TARIFFS = "tariffs";

    @Override
    public void addTariff(String value, HttpServletRequest request) throws ServiceException {
        GeneratorService generatorService = ServiceFactory.getInstance().getGeneratorService();
        Tariff tariff = switch (value){
            case "CHILD_TARIFF" -> generatorService.generateChildTariff();
            case "FULL_UNLIMITED_TARIFF" -> generatorService.generateFullUnlimitedTariff();
            case "PENSION_TARIFF" -> generatorService.generatePensionTariff();
            case "LIMIT_TARIFF" -> generatorService.generateLimitTariff();
            case "UNLIMITED_INTERNET_TARIFF" -> generatorService.generateUnlimitedInternetTariff();
            case "UNLIMITED_MIN_TARIFF" -> generatorService.generateUnlimitedMinTariff();
            default -> throw new ServiceException("Unexpected value: " + value);
        };
        Repository<Tariff> repository = RepositoryTariffImpl.getInstance();
        repository.add(tariff);
        request.setAttribute(JSP_TARIFFS, repository.getStorage());
    }

    @Override
    public void removeTariff(HttpServletRequest request) throws ServiceException {
        Repository<Tariff> repository = RepositoryTariffImpl.getInstance();
        if(request.getParameter("INDEX").isEmpty()){
            request.setAttribute(JSP_TARIFFS, repository.getStorage());
        } else {
            int index;
            try {
                index = Integer.parseInt(request.getParameter("INDEX"));
            } catch (Exception e) {
                throw new ServiceException(e);
            }
            try {
                repository.remove(index);
                request.setAttribute(JSP_TARIFFS, repository.getStorage());
            } catch (DalException e) {
                throw new ServiceException(e);
            }
        }
    }

    @Override
    public void setTariff(HttpServletRequest request) throws ServiceException {
        Repository<Tariff> repository = RepositoryTariffImpl.getInstance();
        if(request.getParameter("INDEX").isEmpty() || request.getParameter("NAME_TARIFF").isEmpty()){
            request.setAttribute(JSP_TARIFFS, repository.getStorage());
        } else {
            int index;
            try {
                index = Integer.parseInt(request.getParameter("INDEX"));
            } catch (Exception e) {
                throw new ServiceException(e);
            }
            Tariff tariff = repository.get(index);
            tariff.setTariffName(request.getParameter("NAME_TARIFF"));
            try {
                repository.update(index, tariff);
                request.setAttribute(JSP_TARIFFS, repository.getStorage());
            } catch (DalException e) {
                throw new ServiceException(e);
            }
        }
    }

    @Override
    public void loadFile(HttpServletRequest request) throws ServiceException {
        try {
            Repository<Tariff> repository = RepositoryTariffImpl.getInstance();
            Creator<ListTariff<Tariff>> creator = new TariffListCreator();
            List<Tariff> list = creator.createFromFile(request.getPart("file").getInputStream()).getList();
            repository.addAll(list);
            request.setAttribute(JSP_TARIFFS, list);
        } catch (IOException | ServletException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void saveFile(HttpServletRequest request) throws ServiceException {
        Repository<Tariff> repository = RepositoryTariffImpl.getInstance();
        JSONDal jsonDal = DalFactory.getInstance().getJSONFileDal();
        Creator<ListTariff<Tariff>> creator = new TariffListCreator();
        AllTariffs allTariffs = creator.createAllTariffs(repository.getStorage());
        try {
            jsonDal.writeTariffsToJSON(
                    request.getParameter("FILE_NAME"),
                    allTariffs
            );
            request.setAttribute(JSP_TARIFFS, repository.getStorage());
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
