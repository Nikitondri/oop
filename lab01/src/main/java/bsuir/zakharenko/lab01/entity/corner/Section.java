package main.java.bsuir.zakharenko.lab01.entity.corner;

import main.java.bsuir.zakharenko.lab01.entity.FigureType;
import main.java.bsuir.zakharenko.lab01.entity.Point;

import java.util.ArrayList;
import java.util.List;

public class Section extends CornerFigure{
    public Section(Point a, Point b) {
        super(FigureType.SECTION, null);
        List<Point> points = new ArrayList<>();
        points.add(a);
        points.add(b);
        setPoints(points);
    }
}
