package by.zakharenko.lab02.service;

import by.zakharenko.lab02.service.exception.ServiceException;
import com.zakharenko.abstract_figure.entity.AbstractFigure;

import java.util.List;

public interface FigureService {
    void saveToFile(String path, List<AbstractFigure> list) throws ServiceException;
    List<AbstractFigure> loadFromFile(String path) throws ServiceException;
}
