package gui.graphics.sinus;

import java.util.ArrayList;

import javafx.scene.layout.Pane;

public class SinusPresenter
{
    private SinusModel sinusModel;
    
    private SinusView sinusView;

    public void init(SinusModel sModel, SinusView sView)
    {
        this.sinusModel = sModel;
        this.sinusView = sView;
        sinusView.drawCoordinateSystem();
        sinusView.drawSinus();
    }
    
    public Pane getSinusView()
    {
        return sinusView;
    }
    
    public ArrayList<double[]> getCoordinateList()
    {
        return sinusModel.getCoordinateList();
    }

}
