package task2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class VBoxExample extends Application
{
    public void start(Stage primaryStage)
    {
        VBox root = new VBox(10);
        Insets ins = new Insets(10);
        root.setPadding(ins);
        root.setAlignment(Pos.TOP_RIGHT);
        root.setFillWidth(true);
        for (int i = 1; i <= 5; i++)
        {
            Button b = new Button("Button " + i);
            b.setLayoutX(i * 20);
            b.setLayoutY(i * 20);
            if (i == 1)
            {
                b.setMaxWidth(Double.MAX_VALUE);
                VBox.setVgrow(b, Priority.ALWAYS);
            }
            else if (i == 2)
            {
                b.setMaxHeight(Double.MAX_VALUE);
                VBox.setVgrow(b, Priority.ALWAYS);
            }
            else if (i == 4)
            {
                b.setMaxHeight(Double.MAX_VALUE);
                b.setMaxWidth(Double.MAX_VALUE);
                VBox.setVgrow(b, Priority.ALWAYS);
                VBox.setVgrow(b, Priority.ALWAYS);
            }
            root.getChildren().add(b);
        }

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("VBox-Beispiel");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
