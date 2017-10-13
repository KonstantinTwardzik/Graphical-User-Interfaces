package gui.counter;

public class Incrementer
{
    private int value;

    public Incrementer(int counter)
    {
        this.value = counter;
    }

    public void increment()
    {
        value++;
    }

    public int getValue()
    {
        return value;
    }
}