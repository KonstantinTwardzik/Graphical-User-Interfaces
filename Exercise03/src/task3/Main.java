package task3;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;

public class Main
{
    public static void main(String[] args)
    {
        // Asset1 A1 = new Asset1(20);
        // Asset1fix A1 = new Asset1fix(20);
        Asset1lazy A1 = new Asset1lazy(20);

        double dollar = A1.getAccountBalanceDollar();
        double euro = A1.getAccountBalanceEuro();

        System.out.println("Initialisierung:");
        System.out.println("Dollar: " + A1.accountBalanceDollarProperty()); // 22
        System.out.println("Euro: " + A1.accountBalanceEuroProperty()); // 20
        System.out.println("Dollar: " + dollar); // 22
        System.out.println("Euro: " + euro); // 20
        System.out.println();

        A1.setAccountBalanceEuro(30);

        dollar = A1.getAccountBalanceDollar();
        euro = A1.getAccountBalanceEuro();

        System.out.println("Änderung durch set:");
        System.out.println("Dollar: " + A1.accountBalanceDollarProperty()); // 33
        System.out.println("Euro: " + A1.accountBalanceEuroProperty()); // 30
        System.out.println("Dollar: " + dollar); // 33
        System.out.println("Euro: " + euro); // 30
        System.out.println();

        DoubleProperty euroProp = A1.accountBalanceEuroProperty();

        euroProp.set(100);

        dollar = A1.getAccountBalanceDollar();
        euro = A1.getAccountBalanceEuro();

        System.out.println("Änderung der EuroProp ausserhalb von Asset1:");
        System.out.println("Dollar: " + A1.accountBalanceDollarProperty()); // 33
        System.out.println("Euro: " + A1.accountBalanceEuroProperty()); // 100
        System.out.println("Dollar: " + dollar); // 33
        System.out.println("Euro: " + euro); // 100
        System.out.println();

    }
}
