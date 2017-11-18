package gui.pizza;

import java.util.Map;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Pizza extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Map<String, String> argsMap = getParameters().getNamed();
        Configuration config = ParameterConverter.createConfiguration(argsMap);

        int i = 0;
        int row = 0;
        int column = 0;
        String[] sizeNames = config.getSizeNames();
        String[] toppingNames = config.getToppingNames();
        CheckBox[] toppingNamesCB = new CheckBox[toppingNames.length];
        RadioButton[] sizeNamesRB = new RadioButton[sizeNames.length];
        int[] sizePrices = config.getSizePrices();
        int[] toppingPrices = config.getToppingPrices();
        int numberOfDefaultToppings = config.getNumberOfDefaultToppings();
        ToggleGroup sizeGroup = new ToggleGroup();

        GridPane root = new GridPane();
        Scene scene = new Scene(root);

        // topping Checkboxes
        while (i < toppingNames.length)
        {
            CheckBox cB = new CheckBox();
            cB.setText(toppingNames[i]);
            if (i < numberOfDefaultToppings)
            {
                cB.setSelected(true);
                cB.setDisable(true);
            }

            toppingNamesCB[i] = cB;

            root.add(cB, column, row);
            row++;
            if (row == 4)
            {
                row = 0;
                column++;
            }

            i++;
        }

        column = 0;
        row = 5;
        i = 0;

        // size RadioButtons
        while (i < sizeNames.length)
        {
            RadioButton rB = new RadioButton();
            rB.setText(sizeNames[i]);
            root.add(rB, column, row);
            sizeNamesRB[i] = rB;
            column++;
            i++;
            rB.setToggleGroup(sizeGroup);
        }

        // Button & Textarea
        Button btn = new Button();
        btn.setText("Bestellen!");
        root.add(btn, 0, 6);

        TextArea tA = new TextArea();
        tA.setEditable(false);
        tA.setId("bestelltext");
        root.add(tA, 0, 7, 4, 2);

        root.setGridLinesVisible(false);

        btn.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                String ingredients = "";
                String size = "";
                float price = 0;
                for (int i2 = 0; i2 < toppingNamesCB.length; i2++)
                {
                    CheckBox selected = toppingNamesCB[i2];

                    if (selected.isSelected())
                    {
                        ingredients = ingredients + toppingNames[i2] + ", ";
                        price += toppingPrices[i2];
                    }

                }

                for (int i3 = 0; i3 < sizeNamesRB.length; i3++)
                {
                    RadioButton selected = sizeNamesRB[i3];
                    if (selected.isSelected())
                    {
                        size = sizeNames[i3];
                        price += sizePrices[i3];
                    }
                }

                price = price/100;

                tA.setText("Sie haben eine Pizza bestellt.\nZutaten: " + ingredients + "\nDie Größe ist: " + size + "\nDer Preis beträgt: " + price + "0€\nVielen Dank.");

            }
        });

        // Primary Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pizza :)");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
