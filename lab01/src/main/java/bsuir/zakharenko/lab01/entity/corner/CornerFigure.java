package main.java.bsuir.zakharenko.lab01.entity.corner;

import main.java.bsuir.zakharenko.lab01.entity.AbstractFigure;
import main.java.bsuir.zakharenko.lab01.entity.FigureType;
import main.java.bsuir.zakharenko.lab01.entity.Point;

import java.util.List;

public abstract class CornerFigure extends AbstractFigure {
    protected List<Point> points;

    protected CornerFigure(FigureType type, List<Point> points) {
        super(type);
        this.points = points;
    }

    public Point getPoint(int index){
        return points.get(index);
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public int getNumPoint(){
        return points.size();
    }
}
