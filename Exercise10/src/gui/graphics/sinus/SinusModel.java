package gui.graphics.sinus;

import java.util.ArrayList;

public class SinusModel
{
    private ArrayList<double[]> coordinateList;

    public SinusModel()
    {
        coordinateList = new ArrayList<double[]>();
        setCoordinateList();
    }

    public ArrayList<double[]> getCoordinateList()
    {
        return coordinateList;
    }

    public void setCoordinateList()
    {
        for (int i = 0; i < (64 * 18); i++)
        {
            int j = i * 10;
            double[] coordinate = new double[2];
            coordinate[0] = (j) / 100.0;
            coordinate[1] = Math.sin((j) / 100.0);
            coordinateList.add(coordinate);
        }
    }

}
