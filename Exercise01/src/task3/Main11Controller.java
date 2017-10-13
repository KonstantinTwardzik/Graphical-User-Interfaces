package task3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Main11Controller
{
    private int counter;
    @FXML
    private Label labello;

    public void buttonClicked(ActionEvent e)
    {
        counter++;
        labello.setText("Hallo Welt zum " + counter + ". mal!");
    }
}
