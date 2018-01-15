package gui.mvp.quiz.main;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
//import javafx.scene.control.Menu;
//import javafx.scene.control.MenuBar;
//import javafx.scene.control.MenuItem;
//import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class MainView extends BorderPane
{
    private MainPresenter mainPresenter;

    private Button startQuiz;

    private Button continueQuiz;

    private Button overView;

    private Button editQuiz;

    private Button undo;

    private Button redo;

    private HBox topArea;

    private Insets insets;

    // private MenuBar menuBar;
    //
    // private Menu edit;
    //
    // private MenuItem startQuizItem;
    //
    // private MenuItem continueQuizItem;
    //
    // private MenuItem overViewItem;
    //
    // private MenuItem editQuizItem;

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
        editQuiz = new Button("Quiz editieren!");
        undo = new Button("Rückgängig!");
        redo = new Button("Wiederholen!");
        undo.setId("undo");
        redo.setId("redo");
        // menuBar = new MenuBar();
        // edit = new Menu("Bearbeiten");
        // startQuizItem = new MenuItem("Quiz starten!");
        //
        // continueQuizItem = new MenuItem("Quiz fortsetzen!");
        // overViewItem = new MenuItem("Überblick!");
        // editQuizItem = new MenuItem("Quiz editieren!");

        // edit.getItems().addAll(startQuizItem, continueQuizItem, overViewItem,
        // editQuizItem);
        // menuBar.getMenus().add(edit);

        setPadding(insets);

        // startQuizItem.setOnAction(e -> mainPresenter.startQuizAgain());
        // overViewItem.setOnAction(e -> mainPresenter.showOverviewView());
        // continueQuizItem.setOnAction(e -> mainPresenter.showQuizView());
        // editQuizItem.setOnAction(e -> mainPresenter.showEditorView());
        // startQuizItem.setAccelerator(KeyCombination.keyCombination("Ctrl+1"));
        // continueQuizItem.setAccelerator(KeyCombination.keyCombination("Ctrl+2"));
        // overViewItem.setAccelerator(KeyCombination.keyCombination("Ctrl+3"));
        // editQuizItem.setAccelerator(KeyCombination.keyCombination("Ctrl+4"));
        startQuiz.setOnAction(e -> mainPresenter.startQuizAgain());
        overView.setOnAction(e -> mainPresenter.showOverviewView());
        continueQuiz.setOnAction(e -> mainPresenter.showQuizView());
        editQuiz.setOnAction(e -> mainPresenter.showEditorView());
        undo.setOnAction(e -> mainPresenter.undo());
        redo.setOnAction(e -> mainPresenter.redo());

        topArea.getChildren().add(startQuiz);
        topArea.getChildren().add(continueQuiz);
        topArea.getChildren().add(overView);
        topArea.getChildren().add(editQuiz);
        topArea.getChildren().add(undo);
        topArea.getChildren().add(redo);

        setTop(topArea);
        // setTop(menuBar);
        setPrefSize(600, 230);
        topArea.setSpacing(6);

    }

    public void setMainArea(GridPane mainArea)
    {
        setCenter(mainArea);
        mainArea.setMaxWidth(Double.MAX_VALUE);
    }

    public void disableContinue()
    {
        continueQuiz.setDisable(true);
    }

    public void enableContinue()
    {
        continueQuiz.setDisable(false);
    }

    public void disableUndo()
    {
        undo.setDisable(true);
    }
    
    public void disableRedo()
    {
        redo.setDisable(true);
    }
    
    public void enableUndo()
    {
        undo.setDisable(false);

    }
    
    public void enableRedo()
    {
        redo.setDisable(false);
    }
    
    
}
