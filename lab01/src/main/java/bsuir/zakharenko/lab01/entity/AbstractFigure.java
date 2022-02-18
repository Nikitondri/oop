package main.java.bsuir.zakharenko.lab01.entity;

public abstract class AbstractFigure {
    protected FigureType type;

    protected AbstractFigure(FigureType type) {
        this.type = type;
    }

    public FigureType getType() {
        return type;
    }

}
