package by.zakharenko.lab02.service;

import by.zakharenko.lab02.entity.AbstractFigure;
import by.zakharenko.lab02.service.drawer.DrawerFigure;
import javafx.scene.canvas.GraphicsContext;

public interface DrawService {
    void drawFigure(double x, double y, GraphicsContext gc, AbstractFigure figure, DrawerFigure drawer);
}
