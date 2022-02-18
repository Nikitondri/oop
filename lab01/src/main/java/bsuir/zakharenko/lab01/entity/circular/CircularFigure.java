package main.java.bsuir.zakharenko.lab01.entity.circular;

import main.java.bsuir.zakharenko.lab01.entity.AbstractFigure;
import main.java.bsuir.zakharenko.lab01.entity.FigureType;
import main.java.bsuir.zakharenko.lab01.entity.Point;

public abstract class CircularFigure extends AbstractFigure {
    protected Point centre;

    protected CircularFigure(FigureType type, Point centre) {
        super(type);
        this.centre = centre;
    }

    public Point getCentre() {
        return centre;
    }

}
