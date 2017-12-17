package gui.graphics.sinus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage arg0) throws Exception
    {
        SinusPresenter sinusPresenter = initApplication();
        Pane root = sinusPresenter.getSinusView();
        Scene scene = new Scene(root);
        
        
        Stage mainStage = new Stage();
        mainStage.setTitle("Sinus");
        mainStage.setScene(scene);
        mainStage.setMinWidth(600);
        mainStage.setMinHeight(400);
        mainStage.setWidth(800);
        mainStage.setHeight(600);
        mainStage.show();

    }
    
    public SinusPresenter initApplication()
    {
        SinusModel sinusModel = new SinusModel();
        SinusPresenter sinusPresenter = new SinusPresenter();
        SinusView sinusView = new SinusView();
        
        sinusView.init(sinusPresenter);
        sinusPresenter.init(sinusModel, sinusView);
        
        return sinusPresenter;
    }

    public static void main(String[] args)
    {
        launch(args);       
    }
}
