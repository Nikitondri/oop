package by.zakharenko.lab02.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFigure {
    protected List<Point> pointList;

    public abstract boolean addPoint(Point point);
    public abstract void removePoint();
    public abstract boolean isAllPoints();


    protected AbstractFigure(){
        pointList = new ArrayList<>();
    }

    public List<Point> getListPoint(){
        return pointList;
    }

    public Point getPoint(int index){
        if(index < pointList.size()){
            return pointList.get(index);
        } else {
            return null;
        }
    }
}
