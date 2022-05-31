package com.zakharenko.my_triangle.entity;

import com.zakharenko.abstract_figure.entity.AbstractFigure;
import com.zakharenko.abstract_figure.entity.Point;

public class MyTriangle extends AbstractFigure {
    public boolean addPoint(Point point){
        if(pointList.size() < 3){
            pointList.add(point);
            return true;
        } else {
            return false;
        }
    }

    public void removePoint(){
        if(!pointList.isEmpty()){
            pointList.remove(pointList.size() - 1);
        }
    }

    @Override
    public boolean isAllPoints() {
        return pointList.size() == 3;
    }
}
