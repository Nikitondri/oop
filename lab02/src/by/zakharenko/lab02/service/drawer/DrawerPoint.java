package by.zakharenko.lab02.service.drawer;

import by.zakharenko.lab02.entity.Point;
import javafx.scene.canvas.GraphicsContext;

public interface DrawerPoint {
    void draw(GraphicsContext gc, Point point);
    void clear(GraphicsContext gc, Point point);
}
