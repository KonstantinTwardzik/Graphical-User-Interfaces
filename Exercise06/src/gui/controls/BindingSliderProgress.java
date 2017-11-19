package gui.controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BindingSliderProgress extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        GridPane root = new GridPane();
        Scene scene = new Scene(root);
        Insets insets = new Insets(10);
        Slider slider = new Slider(-1.1, 1.1, 0);
        ProgressBar progressBar = new ProgressBar();
        ProgressIndicator progressIndicator = new ProgressIndicator();

        root.setPadding(insets);
        root.add(slider, 0, 0);
        root.add(progressBar, 0, 1);
        root.add(progressIndicator, 0, 2);

        progressBar.progressProperty().bind(slider.valueProperty());
        progressIndicator.progressProperty().bind(slider.valueProperty());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Binding-Beispiel: Slider und Progress");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
