package gui.mvp.quiz.editor;

import java.util.NoSuchElementException;
import java.util.Optional;

import gui.mvp.quiz.UndoRedoManager;
import gui.mvp.quiz.main.MainPresenter;
import gui.mvp.quiz.model.Model;
import gui.mvp.quiz.model.Question;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

public class EditorPresenter
{
    private MainPresenter mainPresenter;

    private EditorView editorView;

    private DialogueView dialogueView;
    
    private UndoRedoManager undoRedoManager;

    private Model model;

    public void init(MainPresenter mP, EditorView eV, Model m, DialogueView dV, UndoRedoManager uRM)
    {
        this.mainPresenter = mP;
        this.editorView = eV;
        this.model = m;
        this.dialogueView = dV;
        this.undoRedoManager = uRM;

    }

    public GridPane getView()
    {
        return this.editorView;
    }

    public void addQuestionView()
    {
        dialogueView.initNewQuestionView();
        mainPresenter.showDialogueStage();
    }

    public void editQuestionView()
    {
        int selectedItemIndex = editorView.getSelectedItemIndex();
        if (selectedItemIndex != -1)
        {
            String questionString = model.getSpecificQuestionQuestion(selectedItemIndex);
            String[] answerArray = model.getSpecificQuestionAnswerArry(selectedItemIndex);
            int indexOfCorrectAnswer = model.getSpecificQuestionIndexOfCorrectAnswer(selectedItemIndex);
            dialogueView.initEditView(questionString, answerArray, indexOfCorrectAnswer);
            mainPresenter.showDialogueStage();
        }
        else
        {
            nothingSelectedWarning();
        }

    }

    public void hideDialogue()
    {
        mainPresenter.hideDialogueStage();
    }
    
    private void nothingSelectedWarning()
    {
        Alert nothingSelectedAlert = new Alert(AlertType.INFORMATION);
        nothingSelectedAlert.setHeaderText("");
        nothingSelectedAlert.setContentText("Es muss eine Frage ausgew\u00e4hlt werden!");
        nothingSelectedAlert.setX(100);
        nothingSelectedAlert.setY(100);
        nothingSelectedAlert.show();
    }

    private void fillEverythingWarning()
    {
        Alert nothingSelectedAlert = new Alert(AlertType.INFORMATION);
        nothingSelectedAlert.setHeaderText("");
        nothingSelectedAlert.setContentText("Es muss eine Frage beschrieben sein, mindestens 1 Antwort geben und genau 1 korrekte Antwort geben");
        nothingSelectedAlert.setX(100);
        nothingSelectedAlert.setY(100);
        nothingSelectedAlert.show();
    }

    public void initView()
    {
        editorView.initView(model.getQuestions());
    }

    public void changeQuestion()
    {
        int itemIndex = editorView.getSelectedItemIndex();
        String question = dialogueView.getQuestion();
        String[] answers = dialogueView.getAnswers();
        int indexOfCorrectAnswer = dialogueView.getIndexOfCorrectAnswer();
        System.out.println(indexOfCorrectAnswer);
        if (itemIndex != -1 && !question.equals("") && answers.length > 0 && indexOfCorrectAnswer != -1)
        {
            model.setSpecificQuestion(question, answers, indexOfCorrectAnswer, itemIndex);
            mainPresenter.hideDialogueStage();
            editorView.initListView();
        }
        else
        {
            fillEverythingWarning();
        }
    }

    public void addQuestion()
    {
        String question = dialogueView.getQuestion();
        String[] answers = dialogueView.getAnswers();
        int indexOfCorrectAnswer = dialogueView.getIndexOfCorrectAnswer();
        if (!question.equals("") && answers.length > 0 && indexOfCorrectAnswer != -1)
        {
            Question newQuestion = new Question(question, answers, indexOfCorrectAnswer);
            model.addQuestion(newQuestion);
            mainPresenter.hideDialogueStage();
            undoRedoQuestion action = new undoRedoQuestion();
            undoRedoManager.addAction(action);
            action.redo;
        }
        else
        {
            fillEverythingWarning();
        }

    }
    
    public void deleteQuestion()
    {
        int itemIndex = editorView.getSelectedItemIndex();
        if (itemIndex != -1)
        {
            try
            {
                Alert reallyDeleteAlert = new Alert(AlertType.CONFIRMATION);
                reallyDeleteAlert.setHeaderText("");
                reallyDeleteAlert.setContentText("Soll diese Frage wirklich gel\u00f6scht werden?");
                reallyDeleteAlert.setX(100);
                reallyDeleteAlert.setY(100);
                Optional<ButtonType> result = reallyDeleteAlert.showAndWait();
                if (result.get() == ButtonType.OK)
                {
                    model.deleteQuestion(itemIndex);
                    addUndoAction(itemIndex);
                    mainPresenter.disableContinue();
                }
            }
            catch (NoSuchElementException e)
            {
                System.out.println("Kein plan was hier passiert");
            }

        }
        else
        {
            nothingSelectedWarning();
        }
    }
    
    public void addUndoAction (int itemIndex)
    {        
        //undoRedoManager.addAction(action);
    }

}
