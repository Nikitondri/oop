package by.zakharenko.lab02.repository.impl;

import by.zakharenko.lab02.repository.Repository;
import by.zakharenko.lab02.repository.exception.RepositoryException;
import com.zakharenko.abstract_figure.entity.AbstractFigure;

import java.util.ArrayList;
import java.util.List;

public class AbstractFigureRepository implements Repository<AbstractFigure> {
    private static AbstractFigureRepository instance;

    private final List<AbstractFigure> storage;

    private AbstractFigureRepository(){
        storage = new ArrayList<>();
    }

    public static AbstractFigureRepository getInstance(){
        if(instance == null){
            instance = new AbstractFigureRepository();
        }
        return instance;
    }

    @Override
    public void add(AbstractFigure figure) {
        storage.add(figure);
    }

    @Override
    public void addAll(List<AbstractFigure> list) {
        storage.addAll(list);
    }

    @Override
    public AbstractFigure get(int index) throws RepositoryException {
        if(index < storage.size()){
            return storage.get(index);
        } else {
            throw new RepositoryException("Incorrect index");
        }
    }

    @Override
    public void update(int index, AbstractFigure newT) throws RepositoryException {
        try {
            storage.set(index, newT);
        } catch (NullPointerException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public void remove(int index) throws RepositoryException {
        if(index < storage.size()){
            storage.remove(index);
        } else {
            throw new RepositoryException("Incorrect index");
        }
    }

    @Override
    public void removeAll() {
//        for(AbstractFigure abstractFigure : storage){
//            storage.remove(abstractFigure);
//        }
        int size = findSize();
        if(size != 0) {
            for (int i = 0; i < size; i++) {
                storage.remove(0);
            }
        }
//        storage = new ArrayList<>();
    }

    @Override
    public int findSize() {
        return storage.size();
    }

    @Override
    public List<AbstractFigure> getStorage() {
        return new ArrayList<>(storage);
    }
}
