package main.java.bsuir.zakharenko.lab01.entity.corner;

import main.java.bsuir.zakharenko.lab01.entity.FigureType;
import main.java.bsuir.zakharenko.lab01.entity.Point;

import java.util.ArrayList;
import java.util.List;

public class Pentagon extends CornerFigure{
    public Pentagon(Point a, Point b, Point c, Point d, Point e) {
        super(FigureType.PENTAGON, null);
        List<Point> points = new ArrayList<>();
        points.add(a);
        points.add(b);
        points.add(c);
        points.add(d);
        points.add(e);
        setPoints(points);
    }
}
