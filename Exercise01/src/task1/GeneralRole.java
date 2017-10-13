package task1;

public class GeneralRole implements Role
{
    private String message;

    public GeneralRole(String message)
    {
        this.message = message;
    }

    @Override
    public void play()
    {
        System.out.println(message);
    }

}
