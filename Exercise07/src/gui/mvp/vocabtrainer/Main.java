package gui.mvp.vocabtrainer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        try
        {
            Presenter presenter = new Presenter();
            GridPane root;
            View view;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vocabTrainer.fxml"));
            root = (GridPane) loader.load();
            view = (View) loader.getController();
            view.setPresenter(presenter);
            Model model = new Model();
            presenter.setView(view);
            presenter.setModel(model);

            view.init();

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Vokabel-Training");
            primaryStage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
