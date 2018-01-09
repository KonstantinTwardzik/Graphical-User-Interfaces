import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.stage.Stage;

public class Bezier extends Application
{

    private Circle startPoint;

    private Circle cPoint1;

    private Circle cPoint2;

    private Circle endPoint;

    private Label startLabel;

    private Label cP1Label;

    private Label cP2Label;

    private Label endLabel;

    private CubicCurve bezier;

    @Override
    public void start(Stage primaryStage)
    {
        Pane root = new Pane();
        drawBezier(root);

        primaryStage.setTitle("Bezier-Kurve");
        primaryStage.setScene(new Scene(root, 355, 270));
        primaryStage.show();
    }

    private void drawBezier(Pane root)
    {

        startPoint = new Circle(50, 50, 8, Color.RED);
        cPoint1 = new Circle(100, 200, 8, Color.RED);
        cPoint2 = new Circle(250, 200, 8, Color.RED);
        endPoint = new Circle(300, 50, 8, Color.RED);
        startLabel = new Label("Start");
        cP1Label = new Label("Control Point 1");
        cP2Label = new Label("Control Point 2");
        endLabel = new Label("End");
        bezier = new CubicCurve();
        // bezier.setMouseTransparent(true);
        // cPoint1.setCursor(Cursor.HAND);

        bezier.startXProperty().bind(startPoint.centerXProperty());
        bezier.startYProperty().bind(startPoint.centerYProperty());
        bezier.controlX1Property().bind(cPoint1.centerXProperty());
        bezier.controlY1Property().bind(cPoint1.centerYProperty());
        bezier.controlX2Property().bind(cPoint2.centerXProperty());
        bezier.controlY2Property().bind(cPoint2.centerYProperty());
        bezier.endXProperty().bind(endPoint.centerXProperty());
        bezier.endYProperty().bind(endPoint.centerYProperty());
        startLabel.layoutXProperty().bind(startPoint.centerXProperty().add(10));
        startLabel.layoutYProperty().bind(startPoint.centerYProperty().subtract(10));
        cP1Label.layoutXProperty().bind(cPoint1.centerXProperty().add(10));
        cP1Label.layoutYProperty().bind(cPoint1.centerYProperty().subtract(10));
        cP2Label.layoutXProperty().bind(cPoint2.centerXProperty().add(10));
        cP2Label.layoutYProperty().bind(cPoint2.centerYProperty().subtract(10));
        endLabel.layoutXProperty().bind(endPoint.centerXProperty().add(10));
        endLabel.layoutYProperty().bind(endPoint.centerYProperty().subtract(10));

        bezier.setStroke(Color.BLACK);
        bezier.setFill(null);
        bezier.setStrokeWidth(3);
        startLabel.setTextFill(Color.RED);
        cP1Label.setTextFill(Color.RED);
        cP2Label.setTextFill(Color.RED);
        endLabel.setTextFill(Color.RED);

        startPoint.setOnMouseDragged(e -> mouseDragged(e.getX(), e.getY(), startPoint, root));
        cPoint1.setOnMouseDragged(e -> mouseDragged(e.getX(), e.getY(), cPoint1, root));
        cPoint2.setOnMouseDragged(e -> mouseDragged(e.getX(), e.getY(), cPoint2, root));
        endPoint.setOnMouseDragged(e -> mouseDragged(e.getX(), e.getY(), endPoint, root));

        root.getChildren().add(bezier);
        root.getChildren().add(startPoint);
        root.getChildren().add(cPoint1);
        root.getChildren().add(cPoint2);
        root.getChildren().add(endPoint);
        root.getChildren().add(startLabel);
        root.getChildren().add(cP1Label);
        root.getChildren().add(cP2Label);
        root.getChildren().add(endLabel);
    }

    private void mouseDragged(double x, double y, Circle curPoint, Pane root)
    {
        if (x > 0 && x < root.getWidth())
        {
            curPoint.setCenterX(x);
        }
        if (y > 0 && y < root.getHeight())
        {
            curPoint.setCenterY(y);
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
