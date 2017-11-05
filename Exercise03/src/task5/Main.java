package task5;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class Main
{
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<String>();
        ObservableList<String> observableList = FXCollections.observableList(list);
        observableList.addListener(new ListChangeListener<String>()
        {
            @Override
            public void onChanged(ListChangeListener.Change<? extends String> change)
            {
                while (change.next())
                {
                    if (change.wasUpdated())
                    {
                                           
                    }
                    
                    else if (change.wasReplaced())
                    {
                        
                    }
                    else if (change.wasRemoved())
                    {
                        System.out.println(change.getRemovedSize());
                    }
                    else if (change.wasAdded())
                    {
                        System.out.println("AddedSize: " + change.getAddedSize() + ": " + change.getAddedSubList());
                        System.out.println("AddedObject at position: " + change.toString());                                            
                    }
                }
            }
        });

        observableList.add("Element 1");
        observableList.add("Element 2");
        observableList.addAll("Element 1", "Element 3");

    }
}