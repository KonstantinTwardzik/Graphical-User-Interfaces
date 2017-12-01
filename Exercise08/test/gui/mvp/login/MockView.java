package gui.mvp.login;

public class MockView extends View
{
    private int resetInputCalls, showOkayMessageCalls, showInputErrorCalls,
                    showLoginErrorCalls, showExtraLoginErrorCalls;

    public MockView(Presenter p)
    {
        super(p);
    }

    @Override
    public void resetInput()
    {
        resetInputCalls++;
    }

    @Override
    public void showOkayMessage()
    {
        showOkayMessageCalls++;
    }

    @Override
    public void showInputError()
    {
        showInputErrorCalls++;
    }

    @Override
    public void showLoginError()
    {
        showLoginErrorCalls++;
    }

    @Override
    public void showExtraLoginError()
    {
        showExtraLoginErrorCalls++;
    }

    public int getResetInputCalls()
    {
        return resetInputCalls;
    }

    public int getShowOkayMessageCalls()
    {
        return showOkayMessageCalls;
    }

    public int getShowInputErrorCalls()
    {
        return showInputErrorCalls;
    }

    public int getShowLoginErrorCalls()
    {
        return showLoginErrorCalls;
    }

    public int getShowExtraLoginErrorCalls()
    {
        return showExtraLoginErrorCalls;
    }
}
