package gui.mvp.quiz.overview;

import gui.mvp.quiz.model.Model;
import javafx.scene.layout.GridPane;

public class OverviewPresenter
{

    private Model model;

    private OverviewView overView;

    public void init(OverviewView oV, Model m)
    {
        this.overView = oV;
        this.model = m;
    }

    public void initView()
    {
        overView.initView(model.getQuestions());
    }

    public GridPane getView()
    {
        return overView;
    }

    public void deleteCounts()
    {
        model.setCountsToZero();
    }
}
