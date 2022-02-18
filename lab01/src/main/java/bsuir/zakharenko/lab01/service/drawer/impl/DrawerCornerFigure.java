package main.java.bsuir.zakharenko.lab01.service.drawer.impl;

import javafx.scene.Group;
import javafx.scene.shape.Line;
import main.java.bsuir.zakharenko.lab01.entity.corner.CornerFigure;
import main.java.bsuir.zakharenko.lab01.service.drawer.Drawer;

public class DrawerCornerFigure implements Drawer<CornerFigure> {
    public static final DrawerCornerFigure instance = new DrawerCornerFigure();

    private DrawerCornerFigure(){}

    public static DrawerCornerFigure getInstance(){
        return instance;
    }

    @Override
    public Group draw(CornerFigure figure){
        Group group = new Group();
        for(int i = 0; i < figure.getNumPoint() - 1; i++){
            Line line = new Line();
            line.setStartX(figure.getPoint(i).getX());
            line.setStartY(figure.getPoint(i).getY());
            line.setEndX(figure.getPoint(i + 1).getX());
            line.setEndY(figure.getPoint(i + 1).getY());
            group.getChildren().add(line);
        }
        Line line = new Line();
        line.setStartX(figure.getPoint(0).getX());
        line.setStartY(figure.getPoint(0).getY());
        line.setEndX(figure.getPoint(figure.getNumPoint() - 1).getX());
        line.setEndY(figure.getPoint(figure.getNumPoint() - 1).getY());
        group.getChildren().add(line);
        return group;
    }
}
