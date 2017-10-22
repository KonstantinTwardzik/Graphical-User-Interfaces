package task6;
import java.util.ArrayList;

public class VerySimpleIntegerProperty
{
    private int value;

    private ArrayList<Object> listeners = new ArrayList<Object>();

    public int getValue()
    {
        return value;
    }

    public void setValue (int newValue)
    {
        for (int i = 0; i < listeners.size(); i++)
        {
            ChangeListener listen = (ChangeListener)listeners.get(i);
            listen.changed(value, newValue);  
        }

        this.value = newValue;
    }

    void addListener(ChangeListener cl)
    {
        listeners.add(cl);
    }

    void removeListener(ChangeListener cl)
    {
        
        listeners.remove(cl);
    }

}