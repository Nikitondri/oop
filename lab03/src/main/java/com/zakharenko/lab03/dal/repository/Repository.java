package com.zakharenko.lab03.dal.repository;

import com.zakharenko.lab03.dal.exception.DalException;

import java.util.List;

public interface Repository<T> {
    void add(T t);
    void addAll(List<T> list);
    T get(int index);
    void update(int index, T newT) throws DalException;
    void remove(int index) throws DalException;
    int findSize();
    List<T> getStorage();
}
