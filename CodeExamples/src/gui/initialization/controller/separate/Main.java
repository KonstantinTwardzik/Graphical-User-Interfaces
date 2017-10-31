package gui.initialization.controller.separate;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class Main extends Application
{

    public Main()
    {
        System.out.println("<" + this.hashCode() + "> Konstruktor: " + this.getClass().getName());
    }

    public void start(Stage primaryStage)
    {
        try
        {
            System.out.println("<" + this.hashCode() + "> start(...): " + this.getClass().getName());

            primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Main.fxml"))));
            primaryStage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
