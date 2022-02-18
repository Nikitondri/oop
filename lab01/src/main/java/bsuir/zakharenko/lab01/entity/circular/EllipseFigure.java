package main.java.bsuir.zakharenko.lab01.entity.circular;

import main.java.bsuir.zakharenko.lab01.entity.FigureType;
import main.java.bsuir.zakharenko.lab01.entity.Point;

public class EllipseFigure extends CircularFigure{
    private final double a;
    private final double b;

    public EllipseFigure(Point centre, double a, double b) {
        super(FigureType.ELLIPSE, centre);
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }



}
