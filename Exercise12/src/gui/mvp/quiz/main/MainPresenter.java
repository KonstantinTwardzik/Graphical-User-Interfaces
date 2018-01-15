package gui.mvp.quiz.main;

import gui.mvp.quiz.Main;
import gui.mvp.quiz.UndoRedoManager;
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
    
    private UndoRedoManager undoRedoManager;

    public void init(MainView mV, QuizPresenter qP, OverviewPresenter oP, EditorPresenter eP, DialogueView dV, UndoRedoManager uRM)
    {
        this.mainView = mV;
        this.quizPresenter = qP;
        this.overviewPresenter = oP;
        this.editorPresenter = eP;
        this.dialogueView = dV;
        this.undoRedoManager = uRM;
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
        mainView.disableUndo();
        mainView.disableRedo();
    }

    public void showOverviewView()
    {
        mainView.setMainArea(overviewPresenter.getView());
        mainView.disableUndo();
        mainView.disableRedo();
    }

    public void showQuizView()
    {
        mainView.setMainArea(quizPresenter.getView());
        mainView.disableUndo();
        mainView.disableRedo();
    }

    public void initViews()
    {
        overviewPresenter.initView();
        editorPresenter.initView();
    }

    public void showEditorView()
    {
        mainView.setMainArea(editorPresenter.getView());
        checkUndoRedoButtons();          
    }
    
    public void checkUndoRedoButtons()
    {
        if(undoRedoManager.canUndo())
        {
            mainView.enableUndo();
        }
        else
        {
            mainView.disableUndo();
        }
       
        if(undoRedoManager.canRedo())
        {
            mainView.enableRedo();
        }
        else
        {
            mainView.disableRedo();
        }
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
    
    public void undo()
    {
        //undo
    }

    public void redo()
    {
        //redo
    }

}
