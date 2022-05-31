package com.zakharenko.my_pentagon.service.drawer;

import com.zakharenko.abstract_figure.entity.AbstractFigure;
import com.zakharenko.abstract_figure.service.drawer.DrawerFigure;
import javafx.scene.canvas.GraphicsContext;


public class DrawerFigurePentagon implements DrawerFigure {
    @Override
    public void draw(GraphicsContext gc, AbstractFigure figure) {
        gc.fillPolygon(
                new double[]{
                        figure.getPoint(0).getX(),
                        figure.getPoint(1).getX(),
                        figure.getPoint(2).getX(),
                        figure.getPoint(3).getX(),
                        figure.getPoint(4).getX(),
                },
                new double[]{
                        figure.getPoint(0).getY(),
                        figure.getPoint(1).getY(),
                        figure.getPoint(2).getY(),
                        figure.getPoint(3).getY(),
                        figure.getPoint(4).getY(),
                },
                figure.getListPoint().size()
        );
    }
}
