package gui.intro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main06 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        Button b = new Button("Hallo Welt");
        b.setOnAction(e -> System.out.println("Hallo Welt"));
        GridPane root = new GridPane();
        root.add(b, 0, 0);

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
