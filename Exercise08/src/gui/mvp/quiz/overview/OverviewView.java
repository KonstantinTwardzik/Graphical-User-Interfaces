package gui.mvp.quiz.overview;

import gui.mvp.quiz.model.Question;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class OverviewView extends GridPane
{
    private OverviewPresenter overviewPresenter;

    private Label label;

    private ListView<Question> list;

    private Button delete;

    public void init(OverviewPresenter oP)
    {
        this.overviewPresenter = oP;
    }

    public void initView(ObservableList<Question> questions)
    {

        label = new Label("Übersicht");
        list = new ListView<Question>();
        delete = new Button("Ergebnisse löschen");
        delete.setId("deleteHistory");
        list.setItems(questions);
        list.setId("overviewList");

        delete.setOnAction(e -> overviewPresenter.deleteCounts());

        add(label, 0, 0);
        add(list, 0, 1);
        add(delete, 0, 2);
        update();
    }

    public void update()
    {
        list.setCellFactory(param -> new ListCell<Question>()
        {
            protected void updateItem(Question item, boolean empty)
            {
                super.updateItem(item, empty);

                if (empty || item == null || item.getQuestion() == null)
                {
                    setText(null);
                }
                else
                {
                    setText(item.getQuestion() + (" (Antworten: " + item.getTries() + ", davon Richtig: " + item.getCorrectTries() + ")"));
                }
            }
        });
    }

}
