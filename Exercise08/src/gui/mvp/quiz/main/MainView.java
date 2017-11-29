package gui.mvp.quiz.main;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class MainView extends BorderPane
{
    private MainPresenter mainPresenter;

    private Button startQuiz;

    private Button continueQuiz;

    private Button overView;

    private HBox topArea;

    private Insets insets;

    public MainView()
    {
        initView();
    }

    public void init(MainPresenter mP)
    {
        this.mainPresenter = mP;
    }

    private void initView()
    {
        topArea = new HBox();
        insets = new Insets(10);
        startQuiz = new Button("Quiz starten!");
        continueQuiz = new Button("Quiz fortsetzen!");
        overView = new Button("Überblick!");
        overView.setId("overview");
        setPadding(insets);

        startQuiz.setOnAction(e -> mainPresenter.startQuizAgain());
        overView.setOnAction(e -> mainPresenter.showOverviewView());
        continueQuiz.setOnAction(e -> mainPresenter.showQuizView());

        topArea.getChildren().add(startQuiz);
        topArea.getChildren().add(continueQuiz);
        topArea.getChildren().add(overView);

        setTop(topArea);
    }

    public void setMainArea(GridPane mainArea)
    {
        setCenter(mainArea);
    }

}
