package gui.mvp.login;

public class Presenter
{
    private ViewController view;

    private Model model;

    private final int errorConstant = 2;

    private int errorCount;

    private String lastLoginName;

    public Presenter()
    {
    }

    public void setView(ViewController view)
    {
        this.view = view;
    }

    public void setModel(Model model)
    {
        this.model = model;
    }

    public void login(String loginName, String password)
    {
        if (loginName.isEmpty())
        {
            view.showInputError();
        }
        else if (model.isOkay(loginName, password))
        {
            view.resetInput();
            view.showOkayMessage();
        }
        else
        {
            if (!countTries(loginName))
            {
                view.showLoginError();
            }

        }
    }

    public Boolean countTries(String loginName)
    {
        Boolean extraError = false;
        if (loginName.equals(lastLoginName))
        {
            errorCount++;
            if (errorCount == errorConstant)
            {
                errorCount = 0;
                view.showExtraLoginError();
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
