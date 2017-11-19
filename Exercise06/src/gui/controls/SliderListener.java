package gui.controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SliderListener extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        GridPane root = new GridPane();
        Scene scene = new Scene(root);
        Slider slider = new Slider(0, 100, 50);
        Label label = new Label();
        Insets insets = new Insets(10);

        slider.setMinorTickCount(10);
        slider.setMajorTickUnit(50);
        slider.setBlockIncrement(5);
        slider.setShowTickMarks(true);
        slider.setSnapToTicks(true);
        label.setText("Slider wurde noch nicht bewegt.");
        root.setPadding(insets);
        root.add(slider, 0, 0);
        root.add(label, 0, 1);

        slider.valueProperty().addListener((ov, oldValue, newValue) -> update(oldValue, newValue, label));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Slider mit Listener");
        primaryStage.show();
    }

    private void update(Number oldValue, Number newValue, Label label)
    {
        label.setText("Änderung des Sliders um " + ((double) newValue - (double) oldValue));
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
