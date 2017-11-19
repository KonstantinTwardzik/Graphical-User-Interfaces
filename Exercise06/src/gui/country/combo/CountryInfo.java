package gui.country.combo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CountryInfo extends Application
{

    private TextField countryField;

    private TextField capitalField;

    private TextField populationField;

    private TextField areaField;

    private Label land;

    private Label capitalLord;

    private Label people;

    private Label areaLord;

    private Label densityLord;

    private Label countryName;

    private Label capital;

    private Label population;

    private Label area;

    private Label density;

    private Button add;

    private Button delete;

    private Insets insets;

    private Presenter presenter;

    private ObservableList<Country> countries;

    private ComboBox<Country> countrySelector;

    private CheckBox exactValues;

    public CountryInfo()
    {
        presenter = initiatePresenter();
        presenter.setCountryInfo(this);
        countryField = new TextField();
        capitalField = new TextField();
        populationField = new TextField();
        areaField = new TextField();
        land = new Label("Land:");
        capitalLord = new Label("Hauptstadt:");
        people = new Label("Einwohner:");
        areaLord = new Label("Fl\u00e4che (in qkm):");
        densityLord = new Label("Bev\u00f6lkerungsdichte (in Personen pro qkm):");
        countryName = new Label();
        capital = new Label();
        population = new Label();
        area = new Label();
        density = new Label();
        add = new Button("Hinzuf\u00fcgen");
        delete = new Button("L\u00f6schen");
        insets = new Insets(10);
        countries = FXCollections.observableArrayList();
        countries = presenter.getCountries();
        countrySelector = new ComboBox<>(countries);
        exactValues = new CheckBox("exakte Angaben");
        countryField.setPromptText("Land");
        capitalField.setPromptText("Hauptstadt");
        populationField.setPromptText("Einwohner");
        areaField.setPromptText("Fl\u00e4che");
        countrySelector.setId("countrySelector");
        exactValues.setId("exactValues");
        countryName.setId("countryName");
        capital.setId("capital");
        population.setId("population");
        area.setId("area");
        density.setId("density");
        countryField.setId("countryField");
        capitalField.setId("capitalField");
        populationField.setId("populationField");
        areaField.setId("areaField");
        add.setId("add");
        delete.setId("delete");
        countrySelector.setPromptText("Keine L\u00e4nder vorhanden");
    }

    public Presenter initiatePresenter()
    {
        presenter = new Presenter();
        return presenter;
    }

    public void setTextFieldPrompt()
    {
        countryField.setText(null);
        capitalField.setText(null);
        populationField.setText(null);
        areaField.setText(null);
    }

    public void setEmptyView()
    {
        countryName.setText("");
        capital.setText("");
        population.setText("");
        area.setText("");
        density.setText("");
    }

    public void updateView(Country country)
    {
        if (countries.size() > 0)
        {
            countryName.setText(country.getName());
            capital.setText(country.getCapital());
            population.setText(presenter.formatter(country.getPeople(), exactValues.isSelected()));
            area.setText(presenter.formatter(country.getArea(), exactValues.isSelected()));
            density.setText(presenter.formatter(country.getDensity(), exactValues.isSelected()));
        }

    }

    public void updateExact()
    {
        Country c = countrySelector.getValue();
        population.setText(presenter.formatter(c.getPeople(), exactValues.isSelected()));
        area.setText(presenter.formatter(c.getArea(), exactValues.isSelected()));
        density.setText(presenter.formatter(c.getDensity(), exactValues.isSelected()));
    }

    public void setToFirstElement()
    {
        countrySelector.getSelectionModel().selectFirst();
    }

    public void setToNextElement()
    {
        countrySelector.getSelectionModel().selectNext();
    }

    public Country getCurrentCountry()
    {
        return countrySelector.getValue();
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        GridPane root = new GridPane();
        Scene scene = new Scene(root);

        countrySelector.valueProperty().addListener((ov, oldValue, newValue) -> updateView(newValue));
        exactValues.selectedProperty().addListener((ov, oldValue, newValue) -> updateExact());
        delete.setOnAction(e -> presenter.deleteCountry(countrySelector.getValue()));
        add.setOnAction(e -> presenter.newCountry(countryField.getText(), capitalField.getText(), populationField.getText(), areaField.getText()));
        setToFirstElement();

        root.setVgap(5);
        root.setHgap(5);
        root.setPadding(insets);
        root.add(countrySelector, 0, 0);
        root.add(exactValues, 1, 0);
        root.add(land, 0, 2);
        root.add(countryName, 1, 2);
        root.add(capitalLord, 0, 3);
        root.add(capital, 1, 3);
        root.add(people, 0, 4);
        root.add(population, 1, 4);
        root.add(areaLord, 0, 5);
        root.add(area, 1, 5);
        root.add(densityLord, 0, 6);
        root.add(density, 1, 6);
        root.add(countryField, 0, 7);
        root.add(capitalField, 1, 7);
        root.add(populationField, 0, 8);
        root.add(areaField, 1, 8);
        root.add(add, 1, 9);
        root.add(delete, 0, 9);

        primaryStage.setScene(scene);
        primaryStage.setTitle("L\u00e4nder-Informationen");
        primaryStage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
