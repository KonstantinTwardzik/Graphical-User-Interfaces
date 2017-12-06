package gui.mvp.quiz.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Question
{
    private SimpleStringProperty question;

    private String[] possibleAnswers;

    private int indexOfCorrectAnswer;

    private SimpleIntegerProperty tries;

    private SimpleIntegerProperty correctTries;

    public Question(String question, String[] possibleAnswers, int indexOfCorrectAnswer)
    {
        if (indexOfCorrectAnswer >= possibleAnswers.length || indexOfCorrectAnswer < 0)
        {
            throw new IllegalArgumentException("Keine Korrekte Antwort");
        }
        else
        {
            this.tries = new SimpleIntegerProperty(0);
            this.correctTries = new SimpleIntegerProperty(0);
            this.question = new SimpleStringProperty(question);
            this.possibleAnswers = possibleAnswers;
            this.indexOfCorrectAnswer = indexOfCorrectAnswer;
        }
    }
  
    public String getQuestion()
    {
        return question.get();
    }
    
    public SimpleStringProperty getQuestionProperty()
    {
        return question;
    }

    public String[] getPossibleAnswers()
    {
        return possibleAnswers;
    }

    public int getIndexOfCorrectAnswer()
    {
        return indexOfCorrectAnswer;
    }

    public SimpleIntegerProperty getTries()
    {
        return tries;
    }

    public SimpleIntegerProperty getCorrectTries()
    {
        return correctTries;
    }

    public void plusTry()
    {
        tries.set(tries.get() + 1);

    }

    public void plusCorrectTry()
    {
        correctTries.set(correctTries.get() + 1);
    }

    public void setTries(int tries)
    {
        this.tries.set(tries);
    }

    public void setCorrectTries(int correctTries)
    {
        this.correctTries.set(correctTries);
    }

    public void setQuestion(String question)
    {
        this.question.set(question);
    }
    
    public void setAnswers(String[] answers)
    {
        this.possibleAnswers = answers;
    }
    
    public void setIndexOfCorrectAnswer (int index)
    {
        this.indexOfCorrectAnswer = index;
    }

}
