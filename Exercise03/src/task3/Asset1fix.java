package task3;

import javafx.beans.property.*;

/*
 * b)
 * Konsistenz ist nun gegeben, da nun sobald accountBalanceEuro 
 * geändert wird, accountBalanceDollar benachrichtigt und 
 * aktualisiert wird.
 */

public class Asset1fix
{
    private static final double FACTOR = 1.1;

    private DoubleProperty accountBalanceEuro;

    private ReadOnlyDoubleWrapper accountBalanceDollar;

    public Asset1fix(double initialValue)
    {
        accountBalanceEuro = new SimpleDoubleProperty(initialValue);
        accountBalanceDollar = new ReadOnlyDoubleWrapper();
        accountBalanceDollar.bind(accountBalanceEuro.multiply(FACTOR));

    }

    public void setAccountBalanceEuro(double newValue)
    {
        accountBalanceEuro.set(newValue);
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