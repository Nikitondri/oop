package by.zakharenko.lab02.service.impl;

import by.zakharenko.lab02.service.DrawService;
import by.zakharenko.lab02.service.util.DrawerProvider;
import com.zakharenko.abstract_figure.entity.AbstractFigure;
import com.zakharenko.abstract_figure.entity.Point;
import com.zakharenko.abstract_figure.service.drawer.DrawerFigure;
import com.zakharenko.abstract_figure.service.drawer.DrawerPoint;
import com.zakharenko.abstract_figure.service.drawer.impl.DrawerPointImpl;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import java.util.List;


public class DrawServiceImpl implements DrawService {
    private final DrawerPoint drawerPoint;

    public DrawServiceImpl() {
        drawerPoint = new DrawerPointImpl();
    }

    @Override
    public boolean drawFigure(double x, double y, GraphicsContext gc, AbstractFigure figure, DrawerFigure drawer) {
        Point point = new Point(x, y);
        figure.addPoint(point);
        if(figure.isAllPoints()){
            clearPoints(gc, figure);
            drawer.draw(gc, figure);
            return true;
        } else {
            drawerPoint.draw(gc, point);
            return false;
        }
    }

    @Override
    public void clearPoints(GraphicsContext gc, AbstractFigure figure){
        for(Point point : figure.getListPoint()){
            drawerPoint.clear(gc, point);
        }
    }

    @Override
    public void drawListFigure(GraphicsContext gc, List<AbstractFigure> list) {
        DrawerProvider drawerProvider = new DrawerProvider();
        for(AbstractFigure abstractFigure : list){
            drawerProvider.getDrawer(abstractFigure).draw(gc, abstractFigure);
        }
    }
}
