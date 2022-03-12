package main.java.bsuir.zakharenko.lab01.entity.circular;

import main.java.bsuir.zakharenko.lab01.entity.FigureType;
import main.java.bsuir.zakharenko.lab01.entity.Point;

public class CircleFigure extends CircularFigure{
    private final double radius;

    public CircleFigure(Point centre, double newRadius) {
        super(FigureType.CIRCLE, centre);
        radius = newRadius;
    }

    public double getRadius() {
        return radius;
    }

}
