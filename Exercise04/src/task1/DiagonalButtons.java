package task1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DiagonalButtons extends Application
{
    @Override
    public void start(Stage primaryStage)
    {

        Pane root = new Pane();

        for (int i = 0; i <= 9; i++)
        {
            Button b = new Button("Button " + (i + 1));
            b.setLayoutX((i - 1) * 20);
            b.setLayoutY((i - 1) * 20);

            b.layoutXProperty().bind(root.widthProperty().subtract(85).divide(9).multiply(i));
            b.layoutYProperty().bind(root.heightProperty().subtract(31).divide(9).multiply(i));

            root.getChildren().add(b);
        }

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pane-Beispiel");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
