package com.zakharenko.abstract_figure.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFigure implements Serializable {
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

    public List<Point> getPointList() {
        return pointList;
    }

    public void setPointList(List<Point> pointList) {
        this.pointList = pointList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractFigure that = (AbstractFigure) o;
        return pointList.equals(that.pointList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointList);
    }

    @Override
    public String toString() {
        return "AbstractFigure{" +
                "pointList=" + pointList +
                '}';
    }
}
