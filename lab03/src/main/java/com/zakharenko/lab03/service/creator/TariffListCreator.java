package com.zakharenko.lab03.service.creator;

import com.zakharenko.lab03.dal.JSONDal;
import com.zakharenko.lab03.dal.exception.DalException;
import com.zakharenko.lab03.dal.factory.DalFactory;
import com.zakharenko.lab03.dal.impl.JSONDalImpl;
import com.zakharenko.lab03.dal.util.FileResourcesUtils;
import com.zakharenko.lab03.entity.tariff.*;
import com.zakharenko.lab03.service.exception.ServiceException;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class TariffListCreator implements Creator<ListTariff<Tariff>> {

    /**
     * initializes an ListTariff object with data from a file
     * @see ListTariff
     * @return ListTariff object with initialized fields
     * @throws ServiceException to handle exceptions
     */
    @Override
    public ListTariff<Tariff> createFromFile(InputStream inputStream) throws ServiceException {
        try{
            DalFactory dalFactory = DalFactory.getInstance();
            JSONDal jsonDal = dalFactory.getJSONFileDal();
            Reader reader = new InputStreamReader(inputStream);
            AllTariffs allTariffs = jsonDal.readTariffsFromJSON(reader);
            return allTariffsToListTariff(allTariffs);
        } catch (DalException e){
            throw new ServiceException("Error creator");
        }
    }

    @Override
    public AllTariffs createAllTariffs(List<Tariff> tariffs) {
        ListTariff<ChildTariff> childTariffs = new ListTariff<>();
        ListTariff<PensionTariff> pensionTariffs = new ListTariff<>();
        ListTariff<FullUnlimitedTariff> fullUnlimitedTariffs = new ListTariff<>();
        ListTariff<LimitTariff> limitTariffs = new ListTariff<>();
        ListTariff<UnlimitedInternetTariff> unlimitedInternetTariffs = new ListTariff<>();
        ListTariff<UnlimitedMinTariff> unlimitedMinTariffs = new ListTariff<>();
        for(Tariff tariff : tariffs) {
            if (ChildTariff.class.equals(tariff.getClass())) {
                childTariffs.addTariff((ChildTariff) tariff);
            } else if (PensionTariff.class.equals(tariff.getClass())) {
                pensionTariffs.addTariff((PensionTariff) tariff);
            } else if (LimitTariff.class.equals(tariff.getClass())) {
                limitTariffs.addTariff((LimitTariff) tariff);
            } else if (UnlimitedInternetTariff.class.equals(tariff.getClass())) {
                unlimitedInternetTariffs.addTariff((UnlimitedInternetTariff) tariff);
            } else if (UnlimitedMinTariff.class.equals(tariff.getClass())) {
                unlimitedMinTariffs.addTariff((UnlimitedMinTariff) tariff);
            } else if (FullUnlimitedTariff.class.equals(tariff.getClass())) {
                fullUnlimitedTariffs.addTariff((FullUnlimitedTariff) tariff);
            }
        }
        return new AllTariffs(
                limitTariffs,
                fullUnlimitedTariffs,
                childTariffs,
                pensionTariffs,
                unlimitedInternetTariffs,
                unlimitedMinTariffs
        );
    }

    private ListTariff<Tariff> allTariffsToListTariff(AllTariffs allTariffs) throws ServiceException {
        try {
            ListTariff<Tariff> listTariff = new ListTariff<>();
            listTariff.addListTariff(allTariffs.getArrLimitTariff());
            listTariff.addListTariff(allTariffs.getArrFullUnlimitedTariff());
            listTariff.addListTariff(allTariffs.getArrChildTariff());
            listTariff.addListTariff(allTariffs.getArrPensionTariff());
            listTariff.addListTariff(allTariffs.getArrUnlimitedInternetTariff());
            listTariff.addListTariff(allTariffs.getArrUnlimitedMinTariff());
            return listTariff;
        }catch (Exception e){
            throw new ServiceException(e);
        }
    }
}
