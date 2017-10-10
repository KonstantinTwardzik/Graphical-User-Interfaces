package gui.counter;

public class Decrementer
{
    private int value;

    public Decrementer(int counter)
    {
        this.value = counter;
    }

    public void decrement()
    {
        value--;
    }

    public int getValue()
    {
        return value;
    }

}
