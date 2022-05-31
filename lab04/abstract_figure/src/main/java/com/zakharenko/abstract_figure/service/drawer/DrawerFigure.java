package com.zakharenko.abstract_figure.service.drawer;

import com.zakharenko.abstract_figure.entity.AbstractFigure;
import com.zakharenko.abstract_figure.entity.Point;
import javafx.scene.canvas.GraphicsContext;

public interface DrawerFigure {
    void draw(GraphicsContext gc, AbstractFigure figure);

    default void swapPoint(AbstractFigure figure){
        if(figure.getPoint(0).getY() > figure.getPoint(1).getY()){
            swapY(figure.getPoint(0), figure.getPoint(1));
        }
        if(figure.getPoint(0).getX() > figure.getPoint(1).getX()){
            swapX(figure.getPoint(0), figure.getPoint(1));
        }
    }

    default void swapX(Point a, Point b){
        double buf = a.getX();
        a.setX(b.getX());
        b.setX(buf);
    }

    default void swapY(Point a, Point b){
        double buf = a.getY();
        a.setY(b.getY());
        b.setY(buf);
    }
}
