package gui.mvp.quiz.editor;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DialogueView extends GridPane
{
    private EditorPresenter editorPresenter;

    private Label label;

    private TextArea textArea;

    private Button addAnswer;

    private Button addQuestion;

    private Button cancel;

    private Insets insets;

    private ToggleGroup toggleGroup;

    private VBox allAnswersBox;

    private ArrayList<TextField> answerList;

    private ArrayList<RadioButton> rBList;

    public DialogueView()
    {
        initView();
    }

    public void init(EditorPresenter eP)
    {
        this.editorPresenter = eP;
    }

    public void initView()
    {
        label = new Label("Frage:");
        textArea = new TextArea();
        textArea.setId("dialogQuestion");
        textArea.setPromptText("Frage");
        addAnswer = new Button("Antwort hinzuf\u00fcgen");
        addQuestion = new Button("Hinzuf\u00fcgen");
        cancel = new Button("Abbrechen");
        insets = new Insets(10);
        toggleGroup = new ToggleGroup();
        allAnswersBox = new VBox();

        add(label, 0, 0);
        add(textArea, 0, 1, 5, 1);
        add(addAnswer, 0, 2);
        add(allAnswersBox, 0, 3, 5, 1);
        add(addQuestion, 3, 2);
        add(cancel, 4, 2);

        addAnswer.setOnAction(e -> addAnswer());
        cancel.setOnAction(e -> editorPresenter.hideDialogue());
        addQuestion.setOnAction(e -> editorPresenter.addQuestion());

        setPadding(insets);
        setHgap(5);
        setVgap(5);
    }

    public void initEditView(String questionString, String[] answerArray2, int indexOfCorrectAnswer)
    {
        clearView();
        answerList = new ArrayList<TextField>();
        rBList = new ArrayList<RadioButton>();
        addQuestion.setText("\u00c4ndern");
        textArea.setText(questionString);
        setAnswersFields(answerArray2, indexOfCorrectAnswer);
        addQuestion.setOnAction(e -> editorPresenter.changeQuestion());
    }

    public void initNewQuestionView()
    {
        clearView();
        answerList = new ArrayList<TextField>();
        rBList = new ArrayList<RadioButton>();
        addQuestion.setText("Hinzuf\u00fcgen");
        addQuestion.setOnAction(e -> editorPresenter.addQuestion());

    }

    private void clearView()
    {
        textArea.setText("");
        allAnswersBox.getChildren().clear();
    }

    private void addAnswer()
    {
        RadioButton rB = new RadioButton();
        TextField tF = new TextField();
        Button dA = new Button("L\u00f6schen");
        HBox answerBox = new HBox();

        rB.setToggleGroup(toggleGroup);
        tF.setPromptText("Antwort");
        dA.setOnAction(e -> deleteAnswer(answerBox, tF, rB));

        answerList.add(tF);
        rBList.add(rB);

        answerBox.getChildren().add(rB);
        answerBox.getChildren().add(tF);
        answerBox.getChildren().add(dA);
        allAnswersBox.getChildren().add(answerBox);
    }

    private void deleteAnswer(HBox deleteMe, TextField tF, RadioButton rB)
    {
        answerList.remove(tF);
        rBList.remove(rB);
        allAnswersBox.getChildren().remove(deleteMe);
    }

    private void setAnswersFields(String[] answerArray, int indexOfCorrectAnswer)
    {
        int i = 0;
        for (String answer : answerArray)
        {
            RadioButton rB = new RadioButton();
            TextField tF = new TextField();
            Button dA = new Button("L\u00f6schen");
            HBox answerBox = new HBox();

            rB.setToggleGroup(toggleGroup);
            tF.setText(answer);
            dA.setOnAction(e -> deleteAnswer(answerBox, tF, rB));
            if (i == indexOfCorrectAnswer)
            {
                rB.setSelected(true);
            }
            answerList.add(tF);
            rBList.add(rB);

            answerBox.getChildren().add(rB);
            answerBox.getChildren().add(tF);
            answerBox.getChildren().add(dA);
            allAnswersBox.getChildren().add(answerBox);
            i++;
        }

    }

    public int getIndexOfCorrectAnswer()
    {
        int index = 0;
        for (RadioButton rB : rBList)
        {
            if (rB.isSelected())
            {
                return index;
            }
            index++;
        }
        return -1;
    }

    public String getQuestion()
    {
        return textArea.getText();
    }

    public String[] getAnswers()
    {
        String[] returnArray = new String[answerList.size()];

        for (int i = 0; i < answerList.size(); i++)
        {
            returnArray[i] = answerList.get(i).getText();
        }
        return returnArray;
    }
}
