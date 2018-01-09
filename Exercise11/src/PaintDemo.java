import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

public class PaintDemo extends Application
{
    private Pane root;

    private Path currentPath;

    private ComboBox<Paint> colorBox;

    private ComboBox<Integer> sizeBox;

    private Button delete;

    private ArrayList<Path> pathList;

    @Override
    public void start(Stage primaryStage)
    {
        root = new Pane();
        root.minWidth(800);
        root.minHeight(600);
        root.setOnMousePressed(e -> mousePressed(e.getX(), e.getY()));
        root.setOnMouseDragged(e -> mouseDragged(e.getX(), e.getY()));
        root.setOnMouseReleased(e -> mouseReleased());

        ObservableList<Paint> colors = FXCollections.observableArrayList(Color.BLACK, Color.BLUE, Color.RED, Color.GREEN, Color.MEDIUMAQUAMARINE);
        ObservableList<Integer> sizes = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        pathList = new ArrayList<>();

        sizeBox = new ComboBox<Integer>(sizes);
        colorBox = new ComboBox<Paint>(colors);
        colorBox.setLayoutX(61);
        delete = new Button("Löschen");
        delete.setLayoutX(168);
        sizeBox.setValue(1);
        // colorBox.setValue(Color.BLACK); same as next loc
        colorBox.getSelectionModel().selectFirst();

        // Farbe noch mit CellFactory richtig anzeigen lassen

        delete.setOnAction(e -> deletePath());

        root.getChildren().add(sizeBox);
        root.getChildren().add(colorBox);
        root.getChildren().add(delete);

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Paint Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void deletePath()
    {
        for (int i = 0; i < pathList.size(); i++)
        {
            for (int j = 0; j < root.getChildren().size(); j++)
            {
                if (root.getChildren().get(j) == pathList.get(i))
                {
                    root.getChildren().remove(j);
                }
            }
        }
        pathList = new ArrayList<Path>();
    }

    private void mousePressed(double x, double y)
    {
        currentPath = new Path();
        currentPath.setStroke(colorBox.getValue());
        currentPath.setStrokeWidth(sizeBox.getValue().doubleValue());
        currentPath.getElements().add(new MoveTo(x, y));
        root.getChildren().add(currentPath);
        pathList.add(currentPath);
    }

    private void mouseDragged(double x, double y)
    {
        currentPath.getElements().add(new LineTo(x, y));
    }

    private void mouseReleased()
    {
        currentPath = null;
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
