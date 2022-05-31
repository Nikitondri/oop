package com.zakharenko.my_rectangle.entity;


import com.zakharenko.abstract_figure.entity.AbstractFigure;
import com.zakharenko.abstract_figure.entity.Point;

import java.io.Serializable;

public class MyRectangle extends AbstractFigure implements Serializable {

    public boolean addPoint(Point point){
        if(pointList.size() < 2){
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
        return pointList.size() == 2;
    }
}
