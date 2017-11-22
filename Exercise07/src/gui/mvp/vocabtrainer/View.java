package gui.mvp.vocabtrainer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class View
{
    private Presenter presenter;

    @FXML
    private Label vocable;

    @FXML
    private TextField translation;

    @FXML
    private Label status;

    public void setPresenter(Presenter presenter)
    {
        this.presenter = presenter;
    }

    public void setNewWord()
    {
        presenter.setNewWord();
    }

    public void checkWord()
    {
        presenter.checkWord(translation.getText(), vocable.getText());
    }

    public void setNewView(String newWord)
    {
        vocable.setText(newWord);
        translation.setText("");
        status.setText(null);
    }

    public void statusTrue()
    {
        status.setText("Die Lösung war richtig");
    }

    public void statusFalse()
    {
        status.setText("Die Lösung war falsch. Sie können es nochmal versuchen.");
    }

}
