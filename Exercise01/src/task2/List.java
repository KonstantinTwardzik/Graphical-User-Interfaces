package task2;

public class List
{
    private String[] list;

    private String[] helpList;

    private int count = 0;

    public List()
    {
        list = new String[0];
        helpList = new String[0];
    }

    public void add(String message)
    {
        helpList = new String[count];
        for (int i = 0; i < count; i++)
        {
            helpList[i] = list[i];
        }
        count++;
        list = new String[count];
        for (int i = 0; i < (count - 1); i++)
        {
            list[i] = helpList[i];
        }
        list[count - 1] = message;
        helpList = null;
    }

    public void forEach(Executable exec)
    {
        for (int i = 0; i < count; i++)
        {
            exec.execute();
        }
        System.out.println("Code wird ausgeführt ...");
        
    }
    
    public void getEntries () 
    {
        for (int i = 0; i < count; i++)
        {
            System.out.println(list[i]);
        }
    }
}
