package main.java.bsuir.zakharenko.lab01.controller;

import javafx.scene.Group;
import main.java.bsuir.zakharenko.lab01.entity.AbstractFigure;
import main.java.bsuir.zakharenko.lab01.entity.FigureType;
import main.java.bsuir.zakharenko.lab01.entity.Point;
import main.java.bsuir.zakharenko.lab01.entity.circular.CircleFigure;
import main.java.bsuir.zakharenko.lab01.entity.circular.EllipseFigure;
import main.java.bsuir.zakharenko.lab01.entity.corner.*;
import main.java.bsuir.zakharenko.lab01.service.drawer.impl.DrawerCircle;
import main.java.bsuir.zakharenko.lab01.service.drawer.impl.DrawerCornerFigure;
import main.java.bsuir.zakharenko.lab01.service.drawer.impl.DrawerEllipse;


import java.util.ArrayList;
import java.util.List;

public class Runner {
    public void execute(Group root) {
        for(AbstractFigure figure : init()){
            if(figure.getType() == FigureType.CIRCLE){
                root.getChildren().add(DrawerCircle.getInstance().draw((CircleFigure) figure));
            } else if(figure.getType() == FigureType.ELLIPSE){
                root.getChildren().add(DrawerEllipse.getInstance().draw((EllipseFigure) figure));
            } else {
                root.getChildren().add(DrawerCornerFigure.getInstance().draw((CornerFigure) figure));
            }
        }
    }

    private List<AbstractFigure> init(){
        List<AbstractFigure> list = new ArrayList<>();
        list.add(new Triangle(new Point(1, 1), new Point(50,50), new Point(100, 1)));
        list.add(new Triangle(new Point(100, 100), new Point(200,200), new Point(200, 100)));
        list.add(new Quadrangle(new Point(250, 100), new Point(250,150), new Point(300, 150), new Point(300, 100)));
        list.add(new CircleFigure(new Point(100, 400), 50));
        list.add(new EllipseFigure(new Point(400, 400), 50, 100));
        list.add(new Pentagon(new Point(450, 50), new Point(500, 50), new Point(520, 100), new Point(520, 200), new Point(450, 50)));
        list.add(new Section(new Point(20, 550), new Point(580, 550)));
        return list;
    }
}
