package gui.mvp.quiz.overview;

import gui.mvp.quiz.model.Question;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

public class OverviewView extends GridPane
{
    private OverviewPresenter overviewPresenter;

    private Label label;

    private TableView<Question> table;

    private Button delete;

    private Insets insets;

    public void init(OverviewPresenter oP)
    {
        this.overviewPresenter = oP;
    }

    public void initView(ObservableList<Question> questions)
    {
        insets = new Insets(5);
        label = new Label("Übersicht");
        table = new TableView<Question>();
        delete = new Button("Ergebnisse löschen");
        delete.setId("deleteHistory");
        table.setItems(questions);
        table.setId("overviewTable");
        setTable();

        delete.setOnAction(e -> overviewPresenter.deleteCounts());

        add(label, 0, 0);
        add(table, 0, 1, 3, 1);
        add(delete, 0, 2);


        setPadding(insets);
        setHgap(5);
        setVgap(5);
        // setHgrow(table, Priority.ALWAYS);
        // setGridLinesVisible(true);
        // this.setPrefSize(500, 100);
    }

    public void setTable()
    {
        TableColumn<Question, String> questionCol = new TableColumn<Question, String>("Frage");
        questionCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Question, String>, ObservableValue<String>>()
        {

            @Override
            public ObservableValue<String> call(CellDataFeatures<Question, String> question)
            {
                return question.getValue().getQuestionProperty();
            }
        });
        questionCol.setId("questionCol");
        table.getColumns().add(questionCol);

        TableColumn<Question, Integer> totalAnswerCol = new TableColumn<Question, Integer>("Antworten");
        totalAnswerCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Question, Integer>, ObservableValue<Integer>>()
        {

            @Override
            public ObservableValue<Integer> call(CellDataFeatures<Question, Integer> totalAnswers)
            {
                return totalAnswers.getValue().getTries().asObject();
            }
        });
        totalAnswerCol.setId("totalAnswerCol");
        table.getColumns().add(totalAnswerCol);

        TableColumn<Question, Integer> correctAnswerCol = new TableColumn<Question, Integer>("davon Richtig");
        correctAnswerCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Question, Integer>, ObservableValue<Integer>>()
        {

            @Override
            public ObservableValue<Integer> call(CellDataFeatures<Question, Integer> correctAnswers)
            {
                return correctAnswers.getValue().getCorrectTries().asObject();
            }
        });
        correctAnswerCol.setId("correctAnswerCol");
        table.getColumns().add(correctAnswerCol);
    }

}
