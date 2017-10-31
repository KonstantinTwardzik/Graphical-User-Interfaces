package task4;

public class timekeeper
{
    private long start;
    private long end;

    public void start()
    {
        start = System.currentTimeMillis();
    }

    public void end()
    {
        end = System.currentTimeMillis();
    }

    public long pastTime()
    {
        return end - start;
    }

}