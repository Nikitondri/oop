package by.zakharenko.lab02.service.drawer.impl;

import by.zakharenko.lab02.entity.Point;
import by.zakharenko.lab02.service.drawer.DrawerPoint;
import javafx.scene.canvas.GraphicsContext;

public class DrawerPointImpl implements DrawerPoint {
    private static final double POINT_RADIUS = 5;

    @Override
    public void draw(GraphicsContext gc, Point point) {
        gc.fillOval(point.getX(), point.getY(), POINT_RADIUS, POINT_RADIUS);
    }

    @Override
    public void clear(GraphicsContext gc, Point point) {
        gc.clearRect(point.getX(), point.getY(), POINT_RADIUS, POINT_RADIUS);
    }
}
