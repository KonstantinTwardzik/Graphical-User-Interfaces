package gui.mvp.quiz.main;

import gui.mvp.quiz.game.QuizPresenter;
import gui.mvp.quiz.overview.OverviewPresenter;

public class MainPresenter
{

    private MainView mainView;

    private QuizPresenter quizPresenter;

    private OverviewPresenter overviewPresenter;

    public void init(MainView mV, QuizPresenter qP, OverviewPresenter oP)
    {
        this.mainView = mV;
        this.quizPresenter = qP;
        this.overviewPresenter = oP;
    }

    public MainView getView()
    {
        return mainView;
    }

    public void startQuizAgain()
    {
        quizPresenter.startQuizAgain();
        mainView.setMainArea(quizPresenter.getView());
    }

    public void showOverviewView()
    {
        overviewPresenter.update();
        mainView.setMainArea(overviewPresenter.getView());
    }

    public void showQuizView()
    {
        mainView.setMainArea(quizPresenter.getView());
    }

    public void connectOverView()
    {
        overviewPresenter.initView();
    }
}
