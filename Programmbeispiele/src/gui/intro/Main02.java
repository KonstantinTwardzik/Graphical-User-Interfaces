package gui.intro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main02 extends Application
{
    public void start(Stage primaryStage)
    {
        Label l = new Label("Hallo Welt");
        StackPane root = new StackPane();
        root.getChildren().add(l);
        
        Scene scene = new Scene(root, 310, 70);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
