package gui.mvp.login.fxml.di;

import java.time.LocalDateTime;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

public class ViewController
{
    private Presenter presenter;

    private String name;

    private String pw;

    @FXML
    private TextField loginName;

    @FXML
    private PasswordField password;

    @FXML
    private Label status;

    @FXML
    private TextArea statusLog;

    public ViewController()
    {
    }

    public void setPresenter(Presenter presenter)
    {
        this.presenter = presenter;
    }
    
    public void clearLog(ActionEvent e)
    {
        statusLog.setText("");
    }

    public void handle(ActionEvent e)
    {
        name = loginName.getText();
        pw = password.getText();
        name = name.trim();
        pw = pw.trim();
        presenter.login(name, pw);
    }

    public void resetInput()
    {
        loginName.setText("");
        password.setText("");
    }

    public void showOkayMessage()
    {
        regularTextStyle();
        status.setText("Login erfolgreich.");
        statusLog.insertText(0, LocalDateTime.now().toString() + ": " + name + " hat sich erfolgreich angemeldet\n");
    }

    public void showInputError()
    {
        regularTextStyle();
        status.setText("Keine Login-Kennung angegeben.");
    }

    public void showLoginError()
    {
        regularTextStyle();
        status.setText("Login-Kennung bzw. Passwort falsch.");
        statusLog.insertText(0, LocalDateTime.now().toString() + ": " + name + " hat erfolglos versucht sich anzumelden\n");
    }

    public void showExtraLoginError()
    {
        errorTextStyle();
        status.setText("Warnung: Wiederholter Fehlversuch für: " + name);
        statusLog.insertText(0, LocalDateTime.now().toString() + ": " + name + " hat mehrmalig fehlerhaft versucht sich anzumelden\n");
    }

    public void regularTextStyle()
    {
        status.setTextFill(Color.BLACK);
        status.setUnderline(false);
    }

    public void errorTextStyle()
    {
        status.setTextFill(Color.RED);
        status.setUnderline(true);
    }
}
