package gui.mvp.vocabtrainer;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Random;

public class Model
{
    private HashMap<String, String> wordList;

    private ArrayList<String> keys;

    public Model()
    {
        wordList = new HashMap<>();
        wordList.put("Katze", "cat");
        wordList.put("Hund", "dog");
        wordList.put("Elefant", "elephant");
        wordList.put("Maus", "mouse");
        wordList.put("Thomas", "stinkt");
        keys = new ArrayList<String>(wordList.keySet());

    }

    public boolean isOkay(String englishWord, String germanWord)
    {
        return englishWord.equals(wordList.get(germanWord));
    }

    public String getNewWord()
    {
        Random random = new Random();
        String randomKey = keys.get(random.nextInt(keys.size()));
        return randomKey;
    }

}
