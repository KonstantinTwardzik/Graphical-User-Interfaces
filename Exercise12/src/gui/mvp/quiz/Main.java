package gui.mvp.quiz;

import java.io.IOException;
import java.util.List;

import gui.mvp.quiz.editor.DialogueView;
import gui.mvp.quiz.editor.EditorPresenter;
import gui.mvp.quiz.editor.EditorView;
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
    private static Stage mainStage;
    private static Stage dialogueStage;
    
    @Override
    public void start(Stage stage) throws Exception
    {
        Main.mainStage = stage;
        MainPresenter mainPresenter = initApplication(getParameters().getUnnamed());
        mainPresenter.startQuizAgain();
        mainPresenter.initViews();
        Scene scene = new Scene(mainPresenter.getView(), 600, 230);

        mainStage.setScene(scene);
        mainStage.setTitle("Quiz");
        mainStage.setX(50);
        mainStage.setY(50);
        mainStage.show();
        
        Scene dialogueScene = new Scene(mainPresenter.getDialogueView(), 600, 400);
        dialogueStage = new Stage();
        dialogueStage.setScene(dialogueScene);
        dialogueStage.setTitle("Dialog");
    }

    private MainPresenter initApplication(List<String> args) throws IOException
    {
        MainPresenter mainPresenter = new MainPresenter();
        MainView mainView = new MainView();
        QuizPresenter quizPresenter = new QuizPresenter();
        QuizView quizView = new QuizView();
        OverviewPresenter overviewPresenter = new OverviewPresenter();
        EditorPresenter editorPresenter = new EditorPresenter();
        EditorView editorView = new EditorView();
        Model model = ModelInitializer.initModel(args.get(0));
        OverviewView overviewView = new OverviewView();
        DialogueView dialogueView = new DialogueView();
        UndoRedoManager undoRedoManager = new UndoRedoManager();
        
        

        mainPresenter.init(mainView, quizPresenter, overviewPresenter, editorPresenter, dialogueView, undoRedoManager);
        quizPresenter.init(quizView, model);
        overviewPresenter.init(overviewView, model);
        editorPresenter.init(mainPresenter, editorView, model, dialogueView, undoRedoManager);
        quizView.init(quizPresenter);
        overviewView.init(overviewPresenter);
        mainView.init(mainPresenter);
        editorView.init(editorPresenter);
        dialogueView.init(editorPresenter);

        return mainPresenter;
    }
    
    public static void showDialogueStage()
    {
        dialogueStage.setX(mainStage.getX());
        dialogueStage.setY(mainStage.getY() + 265);
        dialogueStage.show();
    }

    public static void hideDialogueStage()
    {
        dialogueStage.hide();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
