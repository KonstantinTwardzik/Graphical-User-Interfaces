package gui.mvp.login;

import java.util.HashMap;

public class Model
{
    private HashMap<String, String> userList;

    private final int errorConstant = 2;

    private int errorCount;

    private String lastLoginName;

    public Model()
    {
        userList = new HashMap<>();
        userList.put("hänsel", "password1");
        userList.put("gretel", "password2");
        userList.put("aschenputtel", "password3");
        userList.put("wolf", "password4");
        userList.put("7zwerge", "password5");
        userList.put("hansimglück", "password6");
    }

    public boolean isOkay(String loginName, String password)
    {
        return password.equals(userList.get(loginName));
    }

<<<<<<< Updated upstream
<<<<<<< Updated upstream
    public boolean countTries(String loginName)
    {
        boolean extraError = false;
=======
    public Boolean countTries(String loginName)
    {
        Boolean extraError = false;
>>>>>>> Stashed changes
=======
    public Boolean countTries(String loginName)
    {
        Boolean extraError = false;
>>>>>>> Stashed changes
        if (loginName.equals(lastLoginName))
        {
            errorCount++;
            if (errorCount == errorConstant)
            {
                errorCount = 0;

                extraError = true;
            }
        }
        else
        {
            lastLoginName = loginName;
            errorCount = 0;
        }
        return extraError;
    }
}
