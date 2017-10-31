package gui.initialization.controller.same;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

/**
 * fx:controller="gui.initialization.controller.same.Main" zeigt auf diese
 * Klasse
 */
public class Main extends Application
{
    @FXML
    private Label label;

    private int counter = 42;

    public Main()
    {
        System.out.println("<" + this.hashCode() + "> Konstruktor: " + this.getClass().getName());
        /**
         * Konstruktor wird während launch() ** UND ** FXMLLoader.load()
         * aufgerufen --> 2 (!!) Objekte! vgl.:
         * Thread.currentThread().dumpStack();
         */
        /**
         * Initialisierung würde auf beiden Objekten stattfinden. Jedoch sind
         * FXML-Objekte noch null, da die Dependency Injection erst **nach** dem
         * Konstruktor greifen kann.
         */
        System.out.println("<" + this.hashCode() + "> Label im Konstruktor: " + label);
    }

    public void start(Stage primaryStage)
    {
        try
        {
            System.out.println("<" + this.hashCode() + "> start(...): " + this.getClass().getName());
            /**
             * start() wird auf dem in launch() erzeugten Objekt aufgerufen.
             * Dieses wird später verworfen und ist für eine Initialisierung
             * ungeeignet.
             */

            primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Main.fxml"))));
            primaryStage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        launch(args);
        /**
         * public **static** void launch(String... args) Keine Initialisierung
         * möglich, da kein Objekt existiert.
         */
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
