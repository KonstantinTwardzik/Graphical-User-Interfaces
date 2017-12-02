package gui.mvp.login;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ModelTest
{
    private Model model;

    @Before
    public void init()
    {
        model = new Model();
    }

    @Test
    public void testCorrectNameAndPassword()
    {
        assertTrue("Test für erfolgreiches Login", model.isOkay("wolf", "password4"));
    }

    @Test
    public void testWrongName()
    {
        assertFalse("Test für falschen Namen", model.isOkay("wrongName", "password4"));
    }

    @Test
    public void testWrongPassword()
    {
        assertFalse("Test für falsches Passwort", model.isOkay("wolf", "wrongPassword"));
    }

    @Test
    public void testWrongPasswordThreeTimes()
    {
        model.countTries("d");
        model.countTries("d");
        assertTrue("Test für 3x falsches Passwort", model.countTries("d"));
    }
}
