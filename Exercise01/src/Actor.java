
public class Actor
{
    private Role role;

    private int count = 0;

    private Role[] roleList = new Role[10];

    public void action(int i, String message)
    {
        for (int i1 = 0; i1 < roleList.length; i1++)
            if (role != null)
            {
                roleList[i1].play(i1, message);
            }
    }

    public void addRole(Role role)
    {
        roleList[count] = role;
        count++;
    }

    public void clearRoles()
    {
        roleList = new Role[10];
        count = 0;
    }
}
