package com.zakharenko.lab03.dal.repository.impl;

import com.zakharenko.lab03.dal.exception.DalException;
import com.zakharenko.lab03.dal.repository.Repository;
import com.zakharenko.lab03.entity.tariff.Tariff;

import java.util.ArrayList;
import java.util.List;

public class RepositoryTariffImpl implements Repository<Tariff> {
    private static RepositoryTariffImpl instance;

    private final List<Tariff> storage;

    private RepositoryTariffImpl(){
        storage = new ArrayList<>();
    }

    public static RepositoryTariffImpl getInstance(){
        if(instance == null){
            instance = new RepositoryTariffImpl();
        }
        return instance;
    }

    @Override
    public void add(Tariff tariff) {
        storage.add(tariff);
    }

    @Override
    public void addAll(List<Tariff> list) {
        storage.addAll(list);
    }

    @Override
    public Tariff get(int index) {
        if(index < storage.size()){
            return storage.get(index);
        }
        return null;
    }

    @Override
    public void update(int index, Tariff newT) throws DalException {
        try {
            storage.set(index, newT);
        } catch (NullPointerException e){
            throw new DalException("Incorrect index in method update QuadrangleRepository");
        }
    }

    @Override
    public void remove(int index) throws DalException {
        if(index < storage.size()){
            storage.remove(index);
        } else{
            throw new DalException("Incorrect index in method update QuadrangleRepository");
        }
    }

    @Override
    public int findSize() {
        return storage.size();
    }

    @Override
    public List<Tariff> getStorage() {
        return new ArrayList<>(storage);
    }
}
