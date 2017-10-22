package gui.calculator;

import javax.script.ScriptException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController
{
    private String buttonText;

    private String textfieldContent;

    private Computation computer = new Computation();

    @FXML
    private TextField display;

    public void buttonClicked(ActionEvent e)
    {
        Button clicked = (Button) e.getSource();
        buttonText = clicked.getText();
        if ("=".equals(buttonText))
        {
            updateTextfieldContent();
            compute(computer);
        }
        else if ("CLEAR".equals(buttonText))
        {
            clear();
        }
        else if ("DELETE".equals(buttonText))
        {
            delete();
        }
        else
        {
            updateTextfieldContent();
            update(buttonText);
        }

    }

    public void updateTextfieldContent()
    {
        textfieldContent = display.getText();
    }

    public void update(String newContent)
    {
        display.setText(textfieldContent + newContent);
    }

    public void compute(Computation computeObject) 
    {
        try
        {
            Object result = computeObject.evaluate(textfieldContent);
            String resultString = "=" + result;
            update(resultString);
        }
        catch (ScriptException exc)
        {
            System.out.println(exc);
            update("=>FEHLER");
        }
    }

    public void delete()
    {
        updateTextfieldContent();
        if (textfieldContent.length() > 0)
        {
            String deletedContent;
            deletedContent = textfieldContent.substring(0, textfieldContent.length() - 1);
            textfieldContent = "";
            update(deletedContent);
        }
    }

    public void clear()
    {
        textfieldContent = "";
        update("");
    }

}
