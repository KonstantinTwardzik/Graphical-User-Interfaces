package gui.mvp.quiz;

import java.util.ArrayList;
import java.util.List;

import gui.mvp.quiz.editor.EditorView;
import gui.mvp.quiz.model.Model;
import gui.mvp.quiz.model.Question;

public class UndoRedoManager
{
    private List<UndoableRedoableAction> actions;

    private int currentPosition;

    public UndoRedoManager()
    {
        actions = new ArrayList<>();
        currentPosition = 0;
    }

    public void addAction(UndoableRedoableAction action)
    {
        for (int i = actions.size() - 1; i >= currentPosition; i--)
        {
            actions.remove(i);
        }
        actions.add(action);
        currentPosition++;
    }

    public void undo()
    {
        if (currentPosition > 0)
        {
            currentPosition--;
            actions.get(currentPosition).undo();
        }
    }

    public void redo()
    {
        if (currentPosition < actions.size())
        {
            actions.get(currentPosition).redo();
            currentPosition++;
        }
    }

    public static void main(String[] args)
    {
        UndoRedoManager manager = new UndoRedoManager();
        for (int i = 1; i <= 10; i++)
        {
            manager.addAction(new SampleAction("action" + i));
        }
        for (int i = 1; i <= 5; i++)
        {
            manager.redo();
        }
        for (int i = 1; i <= 15; i++)
        {
            manager.undo();
        }
        for (int i = 1; i <= 15; i++)
        {
            manager.redo();
        }
        for (int i = 1; i <= 5; i++)
        {
            manager.undo();
        }
        manager.addAction(new SampleAction("new action" + 1));
        manager.addAction(new SampleAction("new action" + 2));
        for (int i = 1; i <= 15; i++)
        {
            manager.undo();
        }
        for (int i = 1; i <= 15; i++)
        {
            manager.redo();
        }
    }

    public boolean canUndo()
    {
        boolean canUndo = false;
        if (currentPosition > 0)
        {
            canUndo = true;
        }
        return canUndo;
    }

    public boolean canRedo()
    {
        boolean canRedo = false;
        if (currentPosition < actions.size() && actions.size() > 0)
        {
            canRedo = true;
        }
        return canRedo;
    }
}

class SampleAction implements UndoableRedoableAction
{
    private String name;

    public SampleAction(String name)
    {
        super();
        this.name = name;
    }

    public void undo()
    {
        System.out.println("undo " + name);
    }

    public void redo()
    {
        System.out.println("redo " + name);
    }

}

abstract class UndoRedoBase implements UndoableRedoableAction
{
    protected Model model;

    protected EditorView view;

    public UndoRedoBase(Model model, EditorView view)
    {
        this.model = model;
        this.view = view;
    }
}

class UndoRedoQuestion extends UndoRedoBase
{
    private Question oldQuestion;

    private Question newQuestion;

    public UndoRedoQuestion(Model model, EditorView view, String oQ, Question oldQuestion, Question newQuestion)
    {
        super(model, view);
        this.oldQuestion = oldQuestion;
        this.newQuestion = newQuestion;
    }

    public void undo()
    {
        
        // view.showF(oldValue);
    }

    public void redo()
    {

        // view.showF(newValue);
    }
}
