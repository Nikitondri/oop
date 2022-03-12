package by.zakharenko.lab02.service.impl;

import by.zakharenko.lab02.entity.AbstractFigure;
import by.zakharenko.lab02.entity.Point;
import by.zakharenko.lab02.service.DrawService;
import by.zakharenko.lab02.service.drawer.DrawerFigure;
import by.zakharenko.lab02.service.drawer.DrawerPoint;
import by.zakharenko.lab02.service.drawer.impl.DrawerPointImpl;
import javafx.scene.canvas.GraphicsContext;

public class DrawServiceImpl implements DrawService {
    private final DrawerPoint drawerPoint;

    public DrawServiceImpl() {
        drawerPoint = new DrawerPointImpl();
    }

    @Override
    public void drawFigure(double x, double y, GraphicsContext gc, AbstractFigure figure, DrawerFigure drawer) {
        Point point = new Point(x, y);
        figure.addPoint(point);
        if(figure.isAllPoints()){
            clearPoints(gc, figure);
            drawer.draw(gc, figure);
            deletePoints(figure);
        } else {
            drawerPoint.draw(gc, point);
        }
    }

    private void deletePoints(AbstractFigure figure){
            figure.getListPoint().subList(0, figure.getListPoint().size()).clear();
    }

    private void clearPoints(GraphicsContext gc, AbstractFigure figure){
        for(Point point : figure.getListPoint()){
            drawerPoint.clear(gc, point);
        }
    }


}
