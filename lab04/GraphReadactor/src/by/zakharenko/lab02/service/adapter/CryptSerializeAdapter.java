package by.zakharenko.lab02.service.adapter;

import by.egorstrupinski.service.SerializeCryptService;
import by.egorstrupinski.service.SerializeCryptServiceImpl;
import by.zakharenko.lab02.service.FigureService;
import by.zakharenko.lab02.service.exception.ServiceException;
import com.zakharenko.abstract_figure.entity.AbstractFigure;

import java.io.IOException;
import java.util.List;

public class CryptSerializeAdapter implements FigureService {

    private final SerializeCryptService service;

    public CryptSerializeAdapter() {
        service = new SerializeCryptServiceImpl();
    }

    @Override
    public void saveToFile(String path, List<AbstractFigure> list) throws ServiceException {
        try {
            service.save(path, list);
        } catch (IOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<AbstractFigure> loadFromFile(String path) throws ServiceException {
        try {
            return (List<AbstractFigure>) service.load(path);
        } catch (IOException | ClassNotFoundException e) {
            throw new ServiceException(e);
        }
    }
}
