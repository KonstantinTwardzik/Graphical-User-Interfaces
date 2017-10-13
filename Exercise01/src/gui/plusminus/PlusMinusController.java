package gui.plusminus;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PlusMinusController
{
    private int counter = 0;

    @FXML
    private Label counterL;

    public void buttonClickedPlus()
    {
        counter++;
        counterL.setText("" + counter);
    }
    
    public void buttonClickedMinus()
    {
        counter--;
        counterL.setText("" + counter);
    }
    

    
    
}
