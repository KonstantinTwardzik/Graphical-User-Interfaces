import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class FilledPolygon extends Application
{

    private Polygon polygon;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Pane root = new Pane();
        Scene scene = new Scene(root, 220, 200);

        polygon = new Polygon();

        root.getChildren().add(polygon);

        for (int i = 0; i < 10; i++)
        {
            if (i < 5)
            {
                int index = i * 2;
                Circle circle = new Circle(10.0 + (i * 40.0), 10 + (i * 20), 8, Color.RED);
                circle.setCursor(Cursor.HAND);

                Double coordinateX = new Double(circle.getCenterX());
                Double coordinateY = new Double(circle.getCenterY());

                polygon.getPoints().add(coordinateX);
                polygon.getPoints().add(coordinateY);

                circle.setOnMouseDragged(e -> mousedragged(e.getX(), e.getY(), circle, index, root));
                root.getChildren().add(circle);

            }
            else
            {
                int index = i * 2;
                Circle circle = new Circle(170.0 - ((i - 5) * 40.0), 10 + (i * 20), 8, Color.RED);
                circle.setCursor(Cursor.HAND);

                polygon.getPoints().addAll(new Double[]
                { circle.getCenterX(), circle.getCenterY() });

                circle.setOnMouseDragged(e -> mousedragged(e.getX(), e.getY(), circle, index, root));
                root.getChildren().add(circle);
            }
        }

        polygon.setFill(Color.MEDIUMAQUAMARINE);
        polygon.setStroke(Color.BLACK);
        polygon.setStrokeWidth(3);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Gefülltes Polygon");
        primaryStage.show();
    }

    private void mousedragged(double x, double y, Circle circle, int index, Pane root)
    {
        if (x > 0 && x < root.getWidth())
        {
            circle.setCenterX(x);
            polygon.getPoints().set(index, x);
        }
        if (y > 0 && y < root.getHeight())
        {
            circle.setCenterY(y);
            polygon.getPoints().set(index + 1, y);
        }

    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
