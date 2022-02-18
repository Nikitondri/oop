package main.java.bsuir.zakharenko.lab01.entity.circular;

import main.java.bsuir.zakharenko.lab01.entity.FigureType;
import main.java.bsuir.zakharenko.lab01.entity.Point;

public class CircleFigure extends CircularFigure{
    private final double radius;

    public CircleFigure(Point centre, double radius) {
        super(FigureType.CIRCLE, centre);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

}
