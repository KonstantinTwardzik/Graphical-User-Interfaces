package gui.mvp.quiz.game;

import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class QuizView extends GridPane
{
    private QuizPresenter quizPresenter;

    private Label questionLabel;

    private ArrayList<RadioButton> rBList;

    private Button next;

    // private int currentQuestionNumber;

    public QuizView()
    {
        initView();
    }

    public void init(QuizPresenter qP)
    {
        this.quizPresenter = qP;
    }

    public void initView()
    {
        questionLabel = new Label();
        rBList = new ArrayList<>();
        next = new Button("=>");
        setHgap(5);
        setVgap(5);
        questionLabel.setFont(Font.font(null, FontWeight.BOLD, 16));
        questionLabel.setId("question");

        next.setOnAction(e -> quizPresenter.checkAndSetNext());

        add(questionLabel, 0, 0);
        add(next, 0, 8);
    }

    // public void setCurrentQuestionNumber(int currentQuestion)
    // {
    // currentQuestionNumber = currentQuestion + 1;
    // }

    public void setQuestion(String question)
    {
        questionLabel.setText(question); // currentQuestionNumber + ". " + =>
                                         // mit Ziffern vor den fragen aber ASB
                                         // will das nicht
    }

    public void setAnswers(String[] answers)
    {
        int iAdd = 0;
        rBList = new ArrayList<RadioButton>();
        ToggleGroup tG = new ToggleGroup();
        while (iAdd < answers.length)
        {
            RadioButton rB = new RadioButton(answers[iAdd]);
            rBList.add(rB);
            add(rB, 0, (iAdd + 2));
            rB.setToggleGroup(tG);
            iAdd++;
        }
    }

    public void clearAnswers()
    {
        for (int iDelete = 0; iDelete < rBList.size(); iDelete++)
        {
            RadioButton deleteMe = rBList.get(iDelete);
            for (int i3 = 0; i3 < getChildren().size(); i3++)
            {
                if (deleteMe == getChildren().get(i3))
                {
                    getChildren().remove(i3);
                    break;
                }
            }
        }

    }

    public void endOfQuiz()
    {
        questionLabel.setText("Ende des Quiz");
        next.setDisable(true);
    }

    public void resetToStart()
    {
        next.setDisable(false);
    }

    public int getSelectedRadioButton()
    {
        int selectedIndex = -1;
        for (int iCheck = 0; iCheck < rBList.size(); iCheck++)
        {
            if (rBList.get(iCheck).isSelected())
            {
                selectedIndex = iCheck;
                break;
            }
        }
        return selectedIndex;
    }
}
