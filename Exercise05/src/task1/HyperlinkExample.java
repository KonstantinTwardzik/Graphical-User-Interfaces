package task1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HyperlinkExample extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        int counter = 0;
        GridPane root = new GridPane();
        Scene scene = new Scene(root);

        Hyperlink hyperLink = new Hyperlink();
        hyperLink.setText("Dies ist ein verfickter Hyperlink --- endlich");

        Label label = new Label();

        CheckBox visited = new CheckBox();
        visited.setText("Besucht");
        CheckBox underlined = new CheckBox();
        underlined.setText("Unterstrichen");
        CheckBox lineBreak = new CheckBox();
        lineBreak.setText("Umbruch");

        root.add(hyperLink, 0, 0);
        root.add(label, 0, 1);
        root.add(visited, 0, 2);
        root.add(underlined, 0, 3);
        root.add(lineBreak, 0, 4);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Hyperlink");
        primaryStage.show();

        // hyperLink.setOnAction(new EventHandler<ActionEvent>()
        // {
        // private int counter;
        //
        // @Override
        // public void handle(ActionEvent event)
        // {
        // counter++;
        // label.setText("Hallo Welt zum " + counter + ". mal!");
        //
        // }
        // });

        hyperLink.setOnAction(e -> increaseCounterAndUpdate(counter, label));

        hyperLink.visitedProperty().bindBidirectional(visited.selectedProperty());
        hyperLink.underlineProperty().bindBidirectional(underlined.selectedProperty());
        hyperLink.wrapTextProperty().bindBidirectional(lineBreak.selectedProperty());
    }

    public void increaseCounterAndUpdate(int counter, Label label)
    {
        counter++;
        label.setText("Hallo Welt zum " + counter + ". mal!");
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}