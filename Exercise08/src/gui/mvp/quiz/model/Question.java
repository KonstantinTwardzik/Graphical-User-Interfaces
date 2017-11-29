package gui.mvp.quiz.model;

public class Question
{
    private String question;

    private String[] possibleAnswers;

    private int indexOfCorrectAnswer;

    private int tries;

    private int correctTries;

    public Question(String question, String[] possibleAnswers, int indexOfCorrectAnswer)
    {
        if (indexOfCorrectAnswer >= possibleAnswers.length || indexOfCorrectAnswer < 0)
        {
            throw new IllegalArgumentException("Keine Korrekte Antwort");
        }
        else
        {
            this.question = question;
            this.possibleAnswers = possibleAnswers;
            this.indexOfCorrectAnswer = indexOfCorrectAnswer;
        }
    }

    public String getQuestion()
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

    public int getTries()
    {
        return tries;
    }

    public int getCorrectTries()
    {
        return correctTries;
    }

    public void plusTry()
    {
        tries++;
    }

    public void plusCorrectTry()
    {
        correctTries++;
    }

    public void setTries(int tries)
    {
        this.tries = tries;
    }

    public void setCorrectTries(int correctTries)
    {
        this.correctTries = correctTries;
    }

}
