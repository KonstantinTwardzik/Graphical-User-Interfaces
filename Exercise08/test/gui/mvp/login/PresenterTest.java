package gui.mvp.login;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PresenterTest
{
    private Presenter presenter;

    private MockModel model;

    private MockView view;

    @Before
    public void init()
    {
        presenter = new Presenter();
        model = new MockModel();
        view = new MockView(presenter);
        presenter.setModel(model);
        presenter.setView(view);
    }

    @Test
    public void testMissingInput()
    {
        presenter.login("", "abc");
        assertTrue(model.getOkayCalls() == 0 && view.getResetInputCalls() == 0 && view.getShowInputErrorCalls() == 1 && view.getShowLoginErrorCalls() == 0 && view.getShowOkayMessageCalls() == 0);
    }

    @Test
    public void testBadInput()
    {
        model.setOkayReturnValue(false);
        presenter.login("abc", "def");
        assertTrue(model.getOkayCalls() == 1 && view.getResetInputCalls() == 0 && view.getShowInputErrorCalls() == 0 && view.getShowLoginErrorCalls() == 1 && view.getShowOkayMessageCalls() == 0);
    }

    @Test
    public void testCorrectInput()
    {
        model.setOkayReturnValue(true);
        presenter.login("abc", "def");
        assertTrue(model.getOkayCalls() == 1 && view.getResetInputCalls() == 1 && view.getShowInputErrorCalls() == 0 && view.getShowLoginErrorCalls() == 0 && view.getShowOkayMessageCalls() == 1);
    }

    @Test
    public void testThreeTimesBadInput()
    {
        model.setOkayReturnValue(false);
        presenter.login("abc", "def");
        presenter.login("abc", "def");
        model.setNotOkayReturnValue(true);
        presenter.login("abc", "def");

        assertTrue(model.getErrorCalls() == 3 && view.getShowExtraLoginErrorCalls() == 1 && view.getShowLoginErrorCalls() == 2);
    }
}
