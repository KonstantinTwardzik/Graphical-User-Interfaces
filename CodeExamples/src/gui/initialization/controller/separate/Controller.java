package gui.initialization.controller.separate;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * fx:controller="gui.initialization.controller.separate.Controller" zeigt auf
 * diese Klasse
 */
public class Controller
{
    @FXML
    private Label label;

    private int counter = 42;

    public Controller()
    {
        System.out.println("<" + this.hashCode() + "> Konstruktor: " + this.getClass().getName());
        /**
         * Konstruktor wird **nur** während FXMLLoader.load() aufgerufen! vgl.:
         * Thread.currentThread().dumpStack();
         */
        /**
         * Jedoch sind FXML-Objekte noch null, da die Dependency Injection erst
         * **nach** dem Konstruktor greifen kann.
         */
        System.out.println("<" + this.hashCode() + "> Label im Konstruktor: " + label);
    }

    /**
     * Parameterlose Methode initalize() wird von JavaFX im Controller
     * **automatisch** aufgerufen. Früher: implements javafx.fxml.Initializable
     */
    // @FXML
    // private void initialize() {
    public void initialize()
    {
        System.out.println("<" + this.hashCode() + "> initialize(): " + this.getClass().getName());
        updateLabel();
        System.out.println("<" + this.hashCode() + "> Label in initialize(): " + label);
    }

    public void buttonClicked()
    {
        counter++;
        updateLabel();
    }

    public void updateLabel()
    {
        label.setText(String.valueOf(counter));
    }
}
