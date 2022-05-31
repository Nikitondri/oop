package com.zakharenko.abstract_figure.service.drawer;


import com.zakharenko.abstract_figure.entity.Point;
import javafx.scene.canvas.GraphicsContext;

public interface DrawerPoint {
    void draw(GraphicsContext gc, Point point);
    void clear(GraphicsContext gc, Point point);
}
