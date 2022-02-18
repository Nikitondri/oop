package main.java.bsuir.zakharenko.lab01.entity.corner;

import main.java.bsuir.zakharenko.lab01.entity.FigureType;
import main.java.bsuir.zakharenko.lab01.entity.Point;

import java.util.ArrayList;
import java.util.List;

public class Quadrangle extends CornerFigure{
    public Quadrangle(Point a, Point b, Point c, Point d) {
        super(FigureType.SQUARE, null);
        List<Point> points = new ArrayList<>();
        points.add(a);
        points.add(b);
        points.add(c);
        points.add(d);
        setPoints(points);
    }
}
