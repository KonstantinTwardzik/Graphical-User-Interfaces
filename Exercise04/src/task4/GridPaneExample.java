package task4;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class GridPaneExample extends Application
{
    public void start(Stage primaryStage)
    {
        GridPane root = new GridPane();

        root.setHgap(5);
        root.setVgap(5);
        Insets ins = new Insets(10);
        root.setPadding(ins);

        for (int i = 1; i <= 5; i++)
        {
            for (int j = 1; j <= 5; j++)
            {
                if (i < 3 || j < 3)
                {
                    Button b = new Button("Button " + i + "/" + j);
                    // b.setMaxHeight(Double.MAX_VALUE);
                    // b.setMaxWidth(Double.MAX_VALUE);
                    root.add(b, i - 1, j - 1);

                }

            }
            if (i % 2 == 0)
            {
                RowConstraints row = new RowConstraints(10, 22, Double.MAX_VALUE);
                row.setVgrow(Priority.ALWAYS);
                row.setValignment(VPos.BOTTOM);
                root.getRowConstraints().add(row);

            }
            else
            {
                RowConstraints row = new RowConstraints(10, 22, Double.MAX_VALUE);
                row.setVgrow(Priority.ALWAYS);
                row.setValignment(VPos.TOP);
                root.getRowConstraints().add(row);
            }

            ColumnConstraints column = new ColumnConstraints(50, 75, Double.MAX_VALUE);
            column.setHgrow(Priority.ALWAYS);
            column.setHalignment(HPos.RIGHT);
            root.getColumnConstraints().add(column);
        }

        Button b;

        b = new Button("Button 6/*");

        // b.setMaxHeight(Double.MAX_VALUE);
        root.add(b, 5, 0, 1, 4);

        b = new Button("Button */6");
        // b.setMaxWidth(Double.MAX_VALUE);
        root.add(b, 0, 5, 3, 1);

        b = new Button("Button 3/3");
        // b.setMaxHeight(Double.MAX_VALUE);
        // b.setMaxWidth(Double.MAX_VALUE);
        root.add(b, 2, 2, 3, 3);

        root.setGridLinesVisible(true);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("GridPane-Beispiel");
        primaryStage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
