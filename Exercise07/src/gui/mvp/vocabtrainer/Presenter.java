package gui.mvp.vocabtrainer;

public class Presenter
{
    private Model model;

    private View view;

    public void setView(View view)
    {
        this.view = view;
    }

    public void setModel(Model model)
    {
        this.model = model;
    }

    public void checkWord(String englishWord, String germanWord)
    {
        if (model.isOkay(englishWord, germanWord))
        {
            view.statusTrue();
        }
        else
        {
            view.statusFalse();
        }
    }

    public void setNewWord()
    {
        view.setNewView(model.getNewWord());
    }
}
