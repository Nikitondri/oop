package by.zakharenko.lab02.repository;


import by.zakharenko.lab02.repository.exception.RepositoryException;

import java.util.List;

public interface Repository<T> {
    void add(T t);
    void addAll(List<T> list);
    T get(int index) throws RepositoryException;
    void update(int index, T newT) throws RepositoryException;
    void remove(int index) throws  RepositoryException;
    void removeAll();
    int findSize();
    List<T> getStorage();
}
