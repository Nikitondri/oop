package by.zakharenko.lab02.service.impl;

import by.zakharenko.lab02.service.FigureService;
import by.zakharenko.lab02.service.exception.ServiceException;
import com.zakharenko.abstract_figure.entity.AbstractFigure;
import com.zakharenko.serialize.dal.JsonDal;
import com.zakharenko.serialize.dal.exception.DalException;
import com.zakharenko.serialize.dal.impl.JsonDalImpl;

import java.util.List;

public class FigureServiceImpl implements FigureService {

    private final JsonDal<AbstractFigure> jsonDal;

    public FigureServiceImpl() {
        jsonDal = new JsonDalImpl();
    }


    @Override
    public void saveToFile(String path, List<AbstractFigure> list) throws ServiceException {
        try {
            jsonDal.saveToJson(list, "src/resources/" + path);
        } catch (DalException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<AbstractFigure> loadFromFile(String path) throws ServiceException {
        try {
            return jsonDal.readFromJson(path);
        } catch (DalException e) {
            throw new ServiceException(e);
        }
    }
}
