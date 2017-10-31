package task3;

import javafx.beans.property.*;

/*
 * c)
 * Hier ist Konsistenz gegeben und die Properties werden erst erstellt
 * wenn sie angefragt werden. 
 */

public class Asset1lazy
{
    private static final double FACTOR = 1.1;

    private Double accountBalanceEuro;

    private DoubleProperty accountBalanceEuroProperty;

    private Double accountBalanceDollar;

    private ReadOnlyDoubleWrapper accountBalanceDollarProperty;

    public Asset1lazy(double initialValue)
    {
        accountBalanceEuro = initialValue;
        accountBalanceDollar = initialValue * FACTOR;

    }

    public DoubleProperty accountBalanceEuroProperty()
    {
        if (accountBalanceEuroProperty == null)
        {
            accountBalanceEuroProperty = new SimpleDoubleProperty(accountBalanceEuro);
            accountBalanceDollarProperty = new ReadOnlyDoubleWrapper();
            accountBalanceDollarProperty.bind(accountBalanceEuroProperty.multiply(FACTOR));
        }
        return accountBalanceEuroProperty;
    }

    public ReadOnlyDoubleWrapper accountBalanceDollarProperty()
    {
        if (accountBalanceEuroProperty == null)
        {
            accountBalanceEuroProperty = new SimpleDoubleProperty(accountBalanceEuro);
            accountBalanceDollarProperty = new ReadOnlyDoubleWrapper();
            accountBalanceDollarProperty.bind(accountBalanceEuroProperty.multiply(FACTOR));
        }
        return accountBalanceDollarProperty;
    }

    public void setAccountBalanceEuro(double newValue)
    {
        if (accountBalanceEuroProperty == null)
        {
            accountBalanceEuro = newValue;
            accountBalanceDollar = newValue * FACTOR;
        }
        else
        {
            accountBalanceEuroProperty.set(newValue);
        }
    }

    public double getAccountBalanceEuro()
    {
        if (accountBalanceEuroProperty == null)
        {
            return accountBalanceEuro;
        }
        else
        {
            return accountBalanceEuroProperty.get();
        }
    }

    public double getAccountBalanceDollar()
    {
        if (accountBalanceDollarProperty == null)
        {
            return accountBalanceDollar;
        }
        else
        {
            return accountBalanceDollarProperty.get();
        }
    }
}
