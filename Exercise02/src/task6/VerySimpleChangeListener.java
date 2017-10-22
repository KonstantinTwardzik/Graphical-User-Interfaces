package task6;

public class VerySimpleChangeListener implements ChangeListener
{
    @Override
    public void changed(int oldValue, int newValue)
    {
        System.out.println("changed from " + oldValue + " to " + newValue);
        
    }
    
}
