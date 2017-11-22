package gui.mvp.login;

import java.time.LocalDateTime;

import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;

public class View
{
    private Presenter presenter;

    private GridPane pane;

    private TextField loginName;

    private PasswordField password;

    private Label status;

    private TextArea statusLog;

    private String name;

    private String pw;

    public View(Presenter presenter)
    {
        this.presenter = presenter;
    }

    public void initView()
    {
        pane = new GridPane();
        Insets insets = new Insets(5);
        pane.setPadding(insets);
        pane.setHgap(2);
        pane.setVgap(5);
        pane.add(new Label("Login-Kennung:"), 0, 0);
        loginName = new TextField();
        pane.add(loginName, 1, 0);
        pane.add(new Label("Passwort:"), 0, 1);
        password = new PasswordField();
        pane.add(password, 1, 1);
        Button b = new Button("Login");
        pane.add(b, 0, 2, 2, 1);
        status = new Label();
        pane.add(status, 0, 3, 2, 1);
        statusLog = new TextArea();
        pane.add(statusLog, 0, 4, 3, 3);
        Button b1 = new Button("Liste löschen");
        pane.add(b1, 0, 8);

        EventHandler<ActionEvent> h = e -> handle();
        EventHandler<ActionEvent> h2 = e -> clearLog();
        loginName.setOnAction(h);
        password.setOnAction(h);
        b.setOnAction(h);
        b1.setOnAction(h2);
    }

    private void clearLog()
    {
        statusLog.setText("");
    }

    private void handle()
    {
        name = loginName.getText();
        pw = password.getText();
        name = name.trim();
        pw = pw.trim();
        presenter.login(name, pw);
    }

    public Pane getUI()
    {
        return pane;
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
