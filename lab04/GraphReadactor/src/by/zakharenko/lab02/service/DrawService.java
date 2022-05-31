package by.zakharenko.lab02.service;


import com.zakharenko.abstract_figure.entity.AbstractFigure;
import com.zakharenko.abstract_figure.service.drawer.DrawerFigure;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public interface DrawService {
    boolean drawFigure(double x, double y, GraphicsContext gc, AbstractFigure figure, DrawerFigure drawer);
    void drawListFigure(GraphicsContext gc, List<AbstractFigure> list);
    void clearPoints(GraphicsContext gc, AbstractFigure figure);
}
