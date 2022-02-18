package main.java.bsuir.zakharenko.lab01.service.drawer;

import javafx.scene.Group;
import main.java.bsuir.zakharenko.lab01.entity.AbstractFigure;

public interface Drawer<T extends AbstractFigure> {
    Group draw(T figure);
}
