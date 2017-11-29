package gui.mvp.quiz.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model
{
    private ObservableList<Question> questions;

    private int currentQuestionCounter;

    public Model()
    {
        questions = FXCollections.observableArrayList();
        currentQuestionCounter = 0;
    }

    public void addQuestion(Question q)
    {
        questions.add(q);
    }

    public String getQuestion()
    {

        return questions.get(currentQuestionCounter).getQuestion();
    }

    public String[] getAnswers()
    {
        return questions.get(currentQuestionCounter).getPossibleAnswers();
    }

    public int getCurrentQuestionCounter()
    {
        return currentQuestionCounter;
    }

    public void incrementCounter()
    {
        currentQuestionCounter++;
    }

    public int getQuestionsSize()
    {
        return questions.size();
    }

    public void resetToStart()
    {
        currentQuestionCounter = 0;
    }

    public ObservableList<Question> getQuestions()
    {
        return questions;
    }

    public void checkSolution(int solution)
    {
        if (solution == -1)
        {

        }
        else if (solution == questions.get(currentQuestionCounter).getIndexOfCorrectAnswer())
        {
            questions.get(currentQuestionCounter).plusTry();
            questions.get(currentQuestionCounter).plusCorrectTry();
        }
        else
        {
            questions.get(currentQuestionCounter).plusTry();
        }

    }

    public void setCountsToZero()
    {
        for (int i = 0; i < questions.size(); i++)
        {
            questions.get(i).setCorrectTries(0);
            questions.get(i).setTries(0);
        }
    }
}
