package gui.mvp.quiz.editor;

import gui.mvp.quiz.model.Question;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class EditorView extends GridPane
{
    private EditorPresenter editorPresenter;

    private Label label;

    private ListView<Question> listView;

    private Button addQuestion;

    private Button editQuestion;

    private Button deleteQuestion;

    private Insets insets;

    public void init(EditorPresenter ep)
    {
        this.editorPresenter = ep;
    }

    public void initView(ObservableList<Question> questions)
    {
        insets = new Insets(5);
        label = new Label("Editor");
        listView = new ListView<Question>();
        listView.setItems(questions);
        listView.setId("editorList");
        addQuestion = new Button("Frage hinzuf\u00fcgen");
        editQuestion = new Button("Frage editieren");
        deleteQuestion = new Button("Frage l\u00f6schen");
        initListView();


        addQuestion.setId("addQuestion");
        editQuestion.setId("editQuestion");
        deleteQuestion.setId("deleteQuestion");

        add(label, 0, 0);
        add(listView, 0, 1, 3, 1);
        add(addQuestion, 0, 3);
        add(editQuestion, 1, 3);
        add(deleteQuestion, 2, 3);

        addQuestion.setOnAction(e -> editorPresenter.addQuestionView());
        editQuestion.setOnAction(e -> editorPresenter.editQuestionView());
        deleteQuestion.setOnAction(e -> editorPresenter.deleteQuestion());

        setPadding(insets);
        setHgap(5);
        setVgap(5);
    }
    
    public void initListView()
    {
        listView.setCellFactory(param -> new ListCell<Question>()
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
                    setText(item.getQuestion());
                    
                }
            }
        });

    }
    
    public int getSelectedItemIndex()
    {
        int itemIndex = -1;
        itemIndex = listView.getSelectionModel().getSelectedIndex();
        return itemIndex;
    }
}
