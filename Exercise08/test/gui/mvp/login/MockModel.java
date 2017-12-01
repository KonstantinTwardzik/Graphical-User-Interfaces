package gui.mvp.login;

public class MockModel extends Model
{
    private boolean isOkayReturnValue;

    private boolean isNotOkayReturnValue;

    private int okayCalls;

    private int errorCalls;

    @Override
    public boolean isOkay(String loginName, String password)
    {
        okayCalls++;
        return isOkayReturnValue;
    }

    public void setOkayReturnValue(boolean b)
    {
        isOkayReturnValue = b;
    }

    public int getOkayCalls()
    {
        return okayCalls;
    }

    public void setNotOkayReturnValue(boolean b)
    {
        isNotOkayReturnValue = b;
    }

    @Override
    public boolean countTries(String loginName)
    {
        errorCalls++;
        return isNotOkayReturnValue;
    }

    public int getErrorCalls()
    {
        return errorCalls;
    }
}
