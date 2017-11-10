package task1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

public class HyperlinkController
{
    private int counter;

    @FXML
//    private Hyperlink hyperLink;

    private Label label;

//    private CheckBox visited, underlined, lineBreak;
//
//    public HyperlinkController()
//    {
//      hyperLink.visitedProperty().bind(visited.selectedProperty());
//      hyperLink.underlineProperty().bind(underlined.selectedProperty());
//      hyperLink.wrapTextProperty().bind(lineBreak.selectedProperty());
//    }
    
    public void hyperLinkClicked(ActionEvent e)
    {
        counter++;
        label.setText("Hallo Welt zum " + counter + ". mal!");
    }
    

}
