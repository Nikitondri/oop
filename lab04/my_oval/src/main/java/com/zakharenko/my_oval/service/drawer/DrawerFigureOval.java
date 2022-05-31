package com.zakharenko.my_oval.service.drawer;

import com.zakharenko.abstract_figure.entity.AbstractFigure;
import com.zakharenko.abstract_figure.service.drawer.DrawerFigure;
import javafx.scene.canvas.GraphicsContext;

public class DrawerFigureOval implements DrawerFigure {
    @Override
    public void draw(GraphicsContext gc, AbstractFigure figure) {
            swapPoint(figure);
            gc.fillOval(
                    figure.getPoint(0).getX(),
                    figure.getPoint(0).getY(),
                    Math.abs(figure.getPoint(0).getX() - figure.getPoint(1).getX()),
                    Math.abs(figure.getPoint(0).getY() - figure.getPoint(1).getY())
            );
    }
}
