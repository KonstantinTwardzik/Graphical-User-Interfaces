package gui.country.combo;

import java.text.DecimalFormat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Presenter
{
    private ObservableList<Country> countries;

    private CountryInfo countryInfo;

    private Country helper;

    public Presenter()
    {
        countries = FXCollections.observableArrayList();
        helper = new Country("Keine L\u00e4nder vorhanden", "", 1, 1);
        Country germany = new Country("Deutschland", "Berlin", 82175684, 357385);
        Country usa = new Country("USA", "Washington, D.C.", 322755353, 9826675);
        Country luxembourg = new Country("Luxemburg", "Luxemburg", 511840, 2568);
        Country canada = new Country("Kanada", "Ottawa", 34278406, 9984670);
        Country belgium = new Country("Belgien", "Br\u00fcssel", 10839905, 30528);
        countries.add(germany);
        countries.add(usa);
        countries.add(luxembourg);
        countries.add(canada);
        countries.add(belgium);

    }

    public void setCountryInfo(CountryInfo countryInfo)
    {
        this.countryInfo = countryInfo;
    }

    public void addCountry(Country country)
    {
        if (helper == countryInfo.getCurrentCountry())
        {
            countries.add(country);
            countryInfo.setToNextElement();
            deleteCountry(helper);
        }
        else
        {
            countries.add(country);
        }
    }

    public void deleteCountry(Country country)
    {

        for (int i = 0; i < countries.size(); i++)
        {
            if (countries.get(i) == country)
            {
                if (helper == countryInfo.getCurrentCountry())
                {
                    break;
                }
                else if (countries.size() == 1)
                {
                    addCountry(helper);
                    countryInfo.setToNextElement();
                    countryInfo.setEmptyView();
                    countries.remove(0);
                    break;
                }
                else if (country == countryInfo.getCurrentCountry())
                {
                    countryInfo.setToNextElement();
                    countries.remove(i);
                    break;
                }
                else
                {
                    countries.remove(i);
                    break;
                }

            }
        }
    }

    public void newCountry(String country, String capital, String population, String area)
    {
        try
        {
            if (country.matches("[a-zA-z-\\s]*") && capital.matches("[a-zA-z-\\s]*") && population.matches("[0-9]*") && area.matches("[0-9]*"))
            {
                long populationVal = Long.parseLong(population);
                long areaVal = Long.parseLong(area);
                Country countryNew = new Country(country, capital, populationVal, areaVal);
                addCountry(countryNew);
                countryInfo.setTextFieldPrompt();
                if (countries.size() == 1)
                {
                    countryInfo.setToFirstElement();
                }
            }
            else
            {
                System.out.println("Eingabe Fehlerhaft");
            }
        }
        catch (Exception e)
        {
            System.out.println("Krasser Fehler");
        }
    }

    public ObservableList<Country> getCountries()
    {
        return countries;
    }

    public String formatter(long exactValue, boolean exact)
    {
        String newValue;

        if (exact)
        {
            DecimalFormat formatter = new DecimalFormat("###,###.###");
            newValue = formatter.format(exactValue);
        }
        else
        {
            long roundedValue;
            if (exactValue > 999999)
            {
                roundedValue = (exactValue + 500000) / 1000000 * 1000000;
                roundedValue /= 1000000;
                DecimalFormat formatter = new DecimalFormat("###,###.###");
                newValue = formatter.format(roundedValue);
                newValue += " Mill.";
            }
            else if (exactValue >= 1000)
            {
                roundedValue = (exactValue + 500) / 1000 * 1000;
                DecimalFormat formatter = new DecimalFormat("###,###.###");
                newValue = formatter.format(roundedValue);
            }

            else if (exactValue < 1000)
            {
                roundedValue = exactValue;
                DecimalFormat formatter = new DecimalFormat("###,###.###");
                newValue = formatter.format(roundedValue);
            }
            else
            {
                roundedValue = (exactValue + 5000) / 10000 * 10000;
                DecimalFormat formatter = new DecimalFormat("###,###.###");
                newValue = formatter.format(roundedValue);
            }

        }
        return newValue;
    }
}
