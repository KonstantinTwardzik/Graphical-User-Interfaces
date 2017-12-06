package gui.mvp.quiz.game;

import gui.mvp.quiz.model.Model;
import javafx.scene.layout.GridPane;

public class QuizPresenter
{
    private QuizView quizView;

    private Model model;

    public void init(QuizView qV, Model m)
    {
        this.quizView = qV;
        this.model = m;
    }

    public GridPane getView()
    {
        return quizView;
    }

    public void startQuizAgain()
    {
        model.resetToStart();
        quizView.resetToStart();
        quizView.clearAnswers();
        // quizView.setCurrentQuestionNumber(model.getCurrentQuestionCounter());
        quizView.setQuestion(model.getQuestion());
        quizView.setAnswers(model.getAnswers());
    }

    public void checkAndSetNext()
    {
        if (model.getQuestionsSize() - 1 > model.getCurrentQuestionCounter())
        {
            model.checkSolution(quizView.getSelectedRadioButton());
            quizView.clearAnswers();
            model.incrementCounter();
            // quizView.setCurrentQuestionNumber(model.getCurrentQuestionCounter());
            quizView.setQuestion(model.getQuestion());
            quizView.setAnswers(model.getAnswers());
        }
        else
        {
            model.checkSolution(quizView.getSelectedRadioButton());
            quizView.clearAnswers();
            quizView.endOfQuiz();
            model.incrementCounter();
        }
    }

}
