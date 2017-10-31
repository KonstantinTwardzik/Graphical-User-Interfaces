package task2;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Main
{

    public static void main(String[] args)
    {
        SimpleIntegerProperty a = new SimpleIntegerProperty();
        SimpleIntegerProperty b = new SimpleIntegerProperty();

        NumberBinding total = Bindings.add(a.multiply(a), b.multiply(b));

        total.addListener(new ChangeListener<Number>()
        {
            public void changed(ObservableValue<? extends Number> obs, Number oldValue, Number newValue)
            {
                System.out.println(">>>total changed from " + oldValue + " to " + newValue);
            }
        });

        // Test
        a.set(5);
        b.set(4);
        b.set(10);
    }
}
