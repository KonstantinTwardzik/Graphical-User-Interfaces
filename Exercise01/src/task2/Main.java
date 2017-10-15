package task2;

public class Main
{
    public static void main(String[] args)
    {

        List list = new List();
        list.add("Hallo");
        list.add("chillig");
        list.add("hat anscheindend geklappt");

        list.forEach(new Executable()
        {
            public void execute()
            {
                System.out.println("Code wurde ausgeführt!");
            }
        });
        
        list.getEntries();

//        list.forEach(e -> System.out.println("Hallo"));
    }
}
