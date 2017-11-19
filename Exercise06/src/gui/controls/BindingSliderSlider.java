package gui.controls;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BindingSliderSlider extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        GridPane root = new GridPane();
        Scene scene = new Scene(root);

        Slider slider1 = new Slider(0, 100, 50);
        Slider slider2 = new Slider(0, 100, 50);
        Slider slider3 = new Slider(0, 100, 50);
        Slider slider4 = new Slider(0, 300, 150);

        Insets insets = new Insets(10);

        NumberBinding firstSum = Bindings.add(slider1.valueProperty(), slider2.valueProperty());
        NumberBinding totalSum = Bindings.add(firstSum, slider3.valueProperty());
        slider4.valueProperty().bind(totalSum);

        root.setPadding(insets);
        root.add(slider1, 0, 1);
        root.add(slider2, 1, 1);
        root.add(slider3, 2, 1);
        root.add(slider4, 1, 0);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Binding-Beispie: Addition von Slidern");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
