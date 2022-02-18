package main.java.bsuir.zakharenko.lab01.service.drawer.impl;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import main.java.bsuir.zakharenko.lab01.entity.circular.CircleFigure;
import main.java.bsuir.zakharenko.lab01.service.drawer.Drawer;

public class DrawerCircle implements Drawer<CircleFigure> {
    public static final DrawerCircle instance = new DrawerCircle();

    private DrawerCircle(){}

    public static DrawerCircle getInstance(){
        return instance;
    }

    @Override
    public Group draw(CircleFigure figure){
        Circle circle = new Circle(figure.getCentre().getX(), figure.getCentre().getY(), figure.getRadius());
        circle.setFill(Color.WHITE);
        circle.setStrokeWidth(1);
        circle.setStroke(Color.BLACK);
        return new Group(circle);
    }
}
