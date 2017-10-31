package task3;

import javafx.beans.property.*;

public class Asset2
{
    private double accountBalance;

    private DoubleProperty accountBalanceProperty;

    public Asset2(double initialValue)
    {
        accountBalance = initialValue;
    }

    public double getAccountBalance()
    {
        if (accountBalanceProperty == null)
        {
            return accountBalance;
        }
        else
        {
            return accountBalanceProperty.get();
        }
    }

    public void setAccountBalance(double newValue)
    {
        if (accountBalanceProperty == null)
        {
            accountBalance = newValue;
        }
        else
        {
            accountBalanceProperty.set(newValue);
        }
    }

    public DoubleProperty accountBalanceProperty()
    {
        if (accountBalanceProperty == null)
        {
            accountBalanceProperty = new SimpleDoubleProperty(accountBalance);
        }
        return accountBalanceProperty;
    }
}
