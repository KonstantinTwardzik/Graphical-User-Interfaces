package gui.mvp.quiz;

import java.io.IOException;
import java.util.List;

import gui.mvp.quiz.game.QuizPresenter;
import gui.mvp.quiz.game.QuizView;
import gui.mvp.quiz.main.MainPresenter;
import gui.mvp.quiz.main.MainView;
import gui.mvp.quiz.model.Model;
import gui.mvp.quiz.overview.OverviewPresenter;
import gui.mvp.quiz.overview.OverviewView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        MainPresenter mainPresenter = initApplication(getParameters().getUnnamed());
        mainPresenter.startQuizAgain();
        mainPresenter.connectOverView();
        Scene scene = new Scene(mainPresenter.getView());
        stage.setScene(scene);
        stage.setTitle("Quiz");
        stage.show();
    }

    private MainPresenter initApplication(List<String> args) throws IOException
    {
        MainPresenter mainPresenter = new MainPresenter();
        MainView mainView = new MainView();
        QuizPresenter quizPresenter = new QuizPresenter();
        QuizView quizView = new QuizView();
        OverviewPresenter overviewPresenter = new OverviewPresenter();
        Model model = ModelInitializer.initModel(args.get(0));
        OverviewView overviewView = new OverviewView();

        mainPresenter.init(mainView, quizPresenter, overviewPresenter);
        quizPresenter.init(quizView, model);
        overviewPresenter.init(overviewView, model);
        quizView.init(quizPresenter);
        overviewView.init(overviewPresenter);
        mainView.init(mainPresenter);

        return mainPresenter;
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
