package by.zakharenko.lab02.controller;

import by.zakharenko.lab02.entity.*;
import by.zakharenko.lab02.service.DrawService;
import by.zakharenko.lab02.service.drawer.DrawerFigure;
import by.zakharenko.lab02.service.drawer.impl.DrawerFigureOval;
import by.zakharenko.lab02.service.drawer.impl.DrawerFigurePentagon;
import by.zakharenko.lab02.service.drawer.impl.DrawerFigureRectangle;
import by.zakharenko.lab02.service.drawer.impl.DrawerFigureTriangle;
import by.zakharenko.lab02.service.impl.DrawServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller {
    @FXML
    public Canvas canvas;
    @FXML
    public ColorPicker colorPicker;
    public Button buttonClear;
    @FXML
    private MenuButton buttonFigure;

    private AbstractFigure figure;
    private DrawerFigure drawerFigure;
    private final DrawService drawService = new DrawServiceImpl();

    @FXML
    public void initialize(){
        buttonFigure.setText("Rectangle");
        figure = new MyRectangle();
        drawerFigure = new DrawerFigureRectangle();

        colorPicker.setValue(Color.BLACK);
        buttonFigure.getItems().remove(0);
        buttonFigure.getItems().remove(0);

        MenuItem rectItem = new MenuItem("Rectangle");
        MenuItem ovalItem = new MenuItem("Oval");
        MenuItem triangleItem = new MenuItem("Triangle");
        MenuItem pentagonItem = new MenuItem("Pentagon");

        rectItem.setOnAction(event ->{
            buttonFigure.setText("Rectangle");
            figure = new MyRectangle();
            drawerFigure = new DrawerFigureRectangle();
        });
        ovalItem.setOnAction(event ->{
            buttonFigure.setText("Oval");
            figure = new MyOval();
            drawerFigure = new DrawerFigureOval();
        });
        triangleItem.setOnAction(event ->{
            buttonFigure.setText("Triangle");
            figure = new MyTriangle();
            drawerFigure = new DrawerFigureTriangle();
        });
        pentagonItem.setOnAction(event ->{
            buttonFigure.setText("Pentagon");
            figure = new MyPentagon();
            drawerFigure = new DrawerFigurePentagon();
        });

        buttonFigure.getItems().add(rectItem);
        buttonFigure.getItems().add(ovalItem);
        buttonFigure.getItems().add(triangleItem);
        buttonFigure.getItems().add(pentagonItem);
    }

    public void mouseClicked(javafx.scene.input.MouseEvent mouseEvent) {
        canvas.getGraphicsContext2D().setFill(colorPicker.getValue());
        drawService.drawFigure(mouseEvent.getX(), mouseEvent.getY(), canvas.getGraphicsContext2D(), figure, drawerFigure);
    }


    public void clearClicked() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}
