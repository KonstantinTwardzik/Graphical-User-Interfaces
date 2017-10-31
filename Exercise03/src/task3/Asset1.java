package task3;

import javafx.beans.property.*;

/*
 * a)
 * Konsistenz ist nicht gegeben, da man sich die DoubleProperty: 
 * accountBalanceEuro geben lassen kann. Und diese dann ausserhalb 
 * der dafür vorgesehenen Methoden ändern kann
 */

public class Asset1
{
    private static final double FACTOR = 1.1;

    private DoubleProperty accountBalanceEuro;

    private ReadOnlyDoubleWrapper accountBalanceDollar;

    public Asset1(double initialValue)
    {
        accountBalanceEuro = new SimpleDoubleProperty(initialValue);
        accountBalanceDollar = new ReadOnlyDoubleWrapper(initialValue * FACTOR);
    }

    public void setAccountBalanceEuro(double newValue)
    {
        accountBalanceEuro.set(newValue);
        accountBalanceDollar.set(newValue * FACTOR);
    }

    public double getAccountBalanceEuro()
    {
        return accountBalanceEuro.get();
    }

    public DoubleProperty accountBalanceEuroProperty()
    {
        return accountBalanceEuro;
    }

    public double getAccountBalanceDollar()
    {
        return accountBalanceDollar.get();
    }

    public ReadOnlyDoubleProperty accountBalanceDollarProperty()
    {
        return accountBalanceDollar.getReadOnlyProperty();
    }
}