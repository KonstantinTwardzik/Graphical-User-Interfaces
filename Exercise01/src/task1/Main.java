package task1;

public class Main
{
    public static void main(String[] args)
    {
       
        Actor actor = new Actor();
        Role hello = new HelloRole();
        Role general1 = new GeneralRole("Zifix! hats des jetzt geklappt?");
        Role bye = new ByeRole();
        
        actor.addRole(hello);
        actor.addRole(general1);
        actor.action();
        actor.addRole(bye);
        actor.action();
        actor.clearRoles();
        actor.addRole(bye);
        actor.action();
    }
}
