package gui.collections;

import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;

public class ObservableMapDemo
{
    public static void main(String[] args)
    {
        Map<String, String> map = new HashMap<String, String>();
        ObservableMap<String, String> observableMap = FXCollections.observableMap(map);
        observableMap.addListener(new MapChangeListener<String, String>()
        {
            @Override
            public void onChanged(MapChangeListener.Change<? extends String, ? extends String> change)
            {
                System.out.println("Map wurde ge�ndert");
            }
        });

        observableMap.put("Schl�ssel 1", "Wert 1");
        System.out.println("Gr��e: " + observableMap.size());

        map.put("Schl�ssel 2", "Wert 2");
        System.out.println("Gr��e: " + observableMap.size());
    }
}
