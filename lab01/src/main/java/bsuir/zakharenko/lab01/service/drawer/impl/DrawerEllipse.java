package main.java.bsuir.zakharenko.lab01.service.drawer.impl;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import main.java.bsuir.zakharenko.lab01.entity.circular.EllipseFigure;
import main.java.bsuir.zakharenko.lab01.service.drawer.Drawer;

public class DrawerEllipse implements Drawer<EllipseFigure> {
    public static final DrawerEllipse instance = new DrawerEllipse();

    private DrawerEllipse(){}

    public static DrawerEllipse getInstance(){
        return instance;
    }

    @Override
    public Group draw(EllipseFigure figure){
        Ellipse ellipse = new Ellipse(figure.getCentre().getX(), figure.getCentre().getY(), figure.getA(), figure.getB());
        ellipse.setFill(Color.WHITE);
        ellipse.setStrokeWidth(1);
        ellipse.setStroke(Color.BLACK);
        return new Group(ellipse);
    }
}
