package gui.intro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main04 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        Label l1 = new Label("Hallo Welt");
        Label l2 = new Label("Nochmals hallo");
        Label l3 = new Label("Oh lord jesus");
        GridPane root = new GridPane();
        root.add(l1, 0, 0);
        root.add(l2, 0, 1);
        root.add(l3, 0, 2);

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
