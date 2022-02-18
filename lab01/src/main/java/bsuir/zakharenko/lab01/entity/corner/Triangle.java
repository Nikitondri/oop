package main.java.bsuir.zakharenko.lab01.entity.corner;

import main.java.bsuir.zakharenko.lab01.entity.FigureType;
import main.java.bsuir.zakharenko.lab01.entity.Point;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends CornerFigure{
    public Triangle(Point a, Point b, Point c) {
        super(FigureType.TRIANGLE, null);
        List<Point> points = new ArrayList<>();
        points.add(a);
        points.add(b);
        points.add(c);
        setPoints(points);
    }
}