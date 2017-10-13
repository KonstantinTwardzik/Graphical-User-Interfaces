package gui.intro;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main07 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        try
        {
            GridPane root = FXMLLoader.load(getClass().getResource("Main07.fxml"));
            // FXMLLoader loader = new
            // FXMLLoader(getClass().getResource("Main07.fxml"));
            // GridPane root = (GridPane)loader.load();

            Scene scene = new Scene(root, 310, 70);
            Button b = (Button) scene.lookup("#button");
            b.setOnAction(e -> System.out.println("Hallo Welt"));
            primaryStage.setScene(scene);
            primaryStage.setTitle("Hello World");
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
