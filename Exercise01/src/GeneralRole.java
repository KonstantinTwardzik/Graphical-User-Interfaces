
public class GeneralRole implements Role
{
    private String message;

    public GeneralRole(String message)
    {
        this.message = message;
    }

    @Override
    public void play(int i, String message)
    {
        System.out.println(message);
    }

}
