package task1;

public class Actor
{
    private Role[] roleList = new Role[10];

    private int count = 0;

    public void action()
    {
        for (int i1 = 0; i1 < roleList.length; i1++)
            if (roleList[i1] != null)
            {
                roleList[i1].play();
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
 