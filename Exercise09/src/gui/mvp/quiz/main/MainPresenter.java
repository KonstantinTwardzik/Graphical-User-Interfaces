package gui.mvp.quiz.main;

import gui.mvp.quiz.Main;
import gui.mvp.quiz.editor.DialogueView;
import gui.mvp.quiz.editor.EditorPresenter;
import gui.mvp.quiz.game.QuizPresenter;
import gui.mvp.quiz.overview.OverviewPresenter;

public class MainPresenter
{

    private MainView mainView;

    private QuizPresenter quizPresenter;

    private OverviewPresenter overviewPresenter;

    private EditorPresenter editorPresenter;

    private DialogueView dialogueView;

    public void init(MainView mV, QuizPresenter qP, OverviewPresenter oP, EditorPresenter eP, DialogueView dV)
    {
        this.mainView = mV;
        this.quizPresenter = qP;
        this.overviewPresenter = oP;
        this.editorPresenter = eP;
        this.dialogueView = dV;
    }

    public MainView getView()
    {
        return mainView;
    }

    public void startQuizAgain()
    {
        quizPresenter.startQuizAgain();
        mainView.setMainArea(quizPresenter.getView());
        mainView.enableContinue();
    }

    public void showOverviewView()
    {
        mainView.setMainArea(overviewPresenter.getView());
    }

    public void showQuizView()
    {
        mainView.setMainArea(quizPresenter.getView());
    }

    public void initViews()
    {
        overviewPresenter.initView();
        editorPresenter.initView();
    }

    public void showEditorView()
    {
        mainView.setMainArea(editorPresenter.getView());
    }

    public DialogueView getDialogueView()
    {
        return dialogueView;
    }

    public void showDialogueStage()
    {
        Main.showDialogueStage();
        disableContinue();
    }
    
    public void hideDialogueStage()
    {
        Main.hideDialogueStage();
    }

    public void disableContinue()
    {
        mainView.disableContinue();
    }

}
