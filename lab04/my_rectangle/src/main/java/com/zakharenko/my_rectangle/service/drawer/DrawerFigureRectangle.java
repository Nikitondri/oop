package com.zakharenko.my_rectangle.service.drawer;


import com.zakharenko.abstract_figure.entity.AbstractFigure;
import com.zakharenko.abstract_figure.service.drawer.DrawerFigure;
import javafx.scene.canvas.GraphicsContext;

public class DrawerFigureRectangle implements DrawerFigure {
    @Override
    public void draw(GraphicsContext gc, AbstractFigure figure) {
            swapPoint(figure);
            gc.fillRect(
                    figure.getPoint(0).getX(),
                    figure.getPoint(0).getY(),
                    Math.abs(figure.getPoint(0).getX() - figure.getPoint(1).getX()),
                    Math.abs(figure.getPoint(0).getY() - figure.getPoint(1).getY())
            );
    }
}
