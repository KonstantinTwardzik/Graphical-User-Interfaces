package gui.plusminus;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PlusMinus extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        try
        {
            GridPane root = FXMLLoader.load(getClass().getResource("PlusMinus.fxml"));

            Scene scene = new Scene(root, 310, 70);
            primaryStage.setScene(scene);
            primaryStage.setTitle("PlusMinus");
            primaryStage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
