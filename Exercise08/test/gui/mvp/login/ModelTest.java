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
        assertTrue("Test f�r erfolgreiches Login", model.isOkay("wolf", "password4"));
    }

    @Test
    public void testWrongName()
    {
        assertFalse("Test f�r falschen Namen", model.isOkay("wrongName", "password4"));
    }

    @Test
    public void testWrongPassword()
    {
        assertFalse("Test f�r falsches Passwort", model.isOkay("wolf", "wrongPassword"));
    }

    @Test
    public void testThreeTimesWrongPassword()
    {
        model.isOkay("wolf", "wrongPassword");
        model.isOkay("wolf", "wrongPassword");
        model.isOkay("wolf", "wrongPassword");
        assertTrue("Test f�r 3x falsches Passwort", model.isOkay("wolf", "wrongPassword") );
<<<<<<< Updated upstream
    }

    @Test
    public void testWrongPasswordThreeTimes()
    {
        model.countTries("d");
        model.countTries("d");
        assertTrue("Test f�r 3x falsches Passwort", model.countTries("d"));
=======
>>>>>>> Stashed changes
    }
}
