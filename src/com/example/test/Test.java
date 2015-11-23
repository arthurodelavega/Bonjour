package com.example.test;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by arthur on 23/11/2015.
 */

public class Test extends Application {
    private String fromMoney;
    private String toMoney;
    public void makeButton(Button b,String name,Double layoutX,Double layoutY)
    {
        b.setText(name);
        b.setLayoutX(layoutX);
        b.setLayoutY(layoutY);
    }
    public static void main(String[] args) {

        Application.launch(Test.class, args);
    }
    public void handleClickOnButtonFrom(Button a,Button b,Button c)
    {
        a.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(a.getTextFill()==Color.RED)
                    a.setTextFill(Color.BLACK);
                else {
                    a.setTextFill(Color.RED);
                    b.setTextFill(Color.BLACK);
                    c.setTextFill(Color.BLACK);
                    fromMoney = a.getText();
                }
            }
        });
    }
    public void handleClickOnButtonTo(Button a,Button b,Button c)
    {
        a.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(a.getTextFill()==Color.RED)
                    a.setTextFill(Color.BLACK);
                else {
                    a.setTextFill(Color.RED);
                    b.setTextFill(Color.BLACK);
                    c.setTextFill(Color.BLACK);
                    toMoney = a.getText();
                }
            }
        });
    }
    @Override
    public void start(Stage primaryStage) {


        primaryStage.setTitle("Convertisseur!");
        Group root= new Group();
        Scene scene = new Scene(root,300,250,Color.DARKORANGE);
        TextField numberFrom=new TextField();
        numberFrom.setPrefSize(75, 12);
        numberFrom.setLayoutX(20);
        numberFrom.setLayoutY(20);

        TextField numberTo=new TextField();
        numberTo.setDisable(true);
        numberTo.setPrefSize(75,12);
        numberTo.setLayoutX(210);
        numberTo.setLayoutY(20);


        Button EURFrom = new Button();
        makeButton(EURFrom,"EUR",20.0,100.0);
        Button USDFrom = new Button();
        makeButton(USDFrom,"USD",20.0,130.0);
        Button GBDFrom = new Button();
        makeButton(GBDFrom,"GBD",20.0,160.0);
        Button GBDTo = new Button();
        makeButton(GBDTo,"GBD",250.0,160.0);
        Button USDTo = new Button();
        makeButton(USDTo,"USD",250.0,130.0);
        Button EURTo = new Button();
        makeButton(EURTo,"EUR",250.0,100.0);
        Button calcul = new Button();
        handleClickOnButtonFrom(EURFrom,USDFrom,GBDFrom);
        handleClickOnButtonFrom(USDFrom,EURFrom,GBDFrom);
        handleClickOnButtonFrom(GBDFrom,EURFrom,USDFrom);
        handleClickOnButtonTo(EURTo, USDTo, GBDTo);
        handleClickOnButtonTo(USDTo,EURTo,GBDTo);
        handleClickOnButtonTo(GBDTo,USDTo,EURTo);

        makeButton(calcul,"Convert :)",125.0,225.0);
        calcul.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                numberTo.setText(Calcul.calcul(fromMoney, toMoney, numberFrom.getText()));
            }
        });

        root.getChildren().add(EURFrom);
        root.getChildren().add(GBDFrom);
        root.getChildren().add(USDFrom);
        root.getChildren().add(EURTo);
        root.getChildren().add(USDTo);
        root.getChildren().add(GBDTo);
        root.getChildren().add(numberFrom);
        root.getChildren().add(numberTo);
        root.getChildren().add(calcul);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}