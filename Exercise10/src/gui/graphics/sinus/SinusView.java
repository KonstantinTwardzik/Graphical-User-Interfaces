package gui.graphics.sinus;

import java.util.ArrayList;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.transform.Rotate;

public class SinusView extends BorderPane
{
    private HBox formulaBox;
    
    private SinusPresenter sinusPresenter;

    private Pane drawPane;

    private GridPane sliderPane;

    private Slider amplitude;

    private Label amplitudeLabel;

    private Slider frequence;

    private Label frequenceLabel;

    private Slider phase;

    private Label phaseLabel;

    private Slider zoom;

    private Label zoomLabel;

    private SimpleIntegerProperty halfHeight;

    private SimpleIntegerProperty halfWidth;

    private SimpleDoubleProperty amplitudeProperty;

    private SimpleDoubleProperty frequenceProperty;

    private SimpleDoubleProperty phaseProperty;

    private SimpleDoubleProperty zoomProperty;

    public SinusView()
    {
        initView();
    }

    private void initView()
    {
        formulaBox = new HBox();
        sliderPane = new GridPane();
        drawPane = new Pane();
        drawPane.setMinSize(600, 200);

        halfHeight = new SimpleIntegerProperty();
        halfWidth = new SimpleIntegerProperty();
        halfHeight.bind(drawPane.heightProperty().divide(2));
        halfWidth.bind(drawPane.widthProperty().divide(2));

        amplitude = new Slider(-6, 6, 1);
        amplitudeProperty = new SimpleDoubleProperty();
        amplitudeProperty.bind(amplitude.valueProperty());
        amplitude.setMajorTickUnit(2);
        amplitude.setMinorTickCount(1);
        amplitude.setShowTickLabels(true);
        amplitude.setShowTickMarks(true);
        amplitude.setId("amplitude");
        amplitudeLabel = new Label("Amplitude:");

        frequence = new Slider(1, 20, 5);
        frequenceProperty = new SimpleDoubleProperty();
        frequenceProperty.bind(frequence.valueProperty());
        frequence.setMajorTickUnit(10);
        frequence.setMinorTickCount(6);
        frequence.setShowTickLabels(true);
        frequence.setShowTickMarks(true);
        frequence.setId("frequency");
        frequenceLabel = new Label("Frequenz:");

        phase = new Slider(-100, 100, 0);
        phaseProperty = new SimpleDoubleProperty();
        phaseProperty.bind(phase.valueProperty());
        phase.setMajorTickUnit(50);
        phase.setMinorTickCount(4);
        phase.setShowTickLabels(true);
        phase.setShowTickMarks(true);
        phase.setId("phase");
        phaseLabel = new Label("Phase:");

        zoom = new Slider(10, 210, 30);
        zoomProperty = new SimpleDoubleProperty();
        zoomProperty.bind(zoom.valueProperty());
        zoom.setMajorTickUnit(100);
        zoom.setMinorTickCount(10);
        zoom.setShowTickLabels(true);
        zoom.setShowTickMarks(true);
        zoom.setId("zoom");
        zoomLabel = new Label("Zoom:");

        initLabel();

        sliderPane.add(amplitudeLabel, 0, 0);
        sliderPane.add(amplitude, 1, 0);
        sliderPane.add(frequenceLabel, 0, 1);
        sliderPane.add(frequence, 1, 1);
        sliderPane.add(phaseLabel, 0, 2);
        sliderPane.add(phase, 1, 2);
        sliderPane.add(zoomLabel, 0, 3);
        sliderPane.add(zoom, 1, 3);

        this.setTop(formulaBox);
        this.setCenter(drawPane);
        this.setBottom(sliderPane);
    }

    private void initLabel()
    {
        Label aLabel = new Label();
        Label formulaLabel1 = new Label(" * sin(");
        Label fLabel = new Label();
        Label formulaLabel2 = new Label(" * x + ");
        Label pLabel = new Label();
        Label formulaLabel3 = new Label(")");
        
        aLabel.textProperty().bind(amplitudeProperty.asString());
        fLabel.textProperty().bind(frequenceProperty.asString());
        pLabel.textProperty().bind(phaseProperty.asString());
        
        formulaBox.getChildren().add(fLabel);
        formulaBox.getChildren().add(formulaLabel1);
        formulaBox.getChildren().add(aLabel);
        formulaBox.getChildren().add(formulaLabel2);
        formulaBox.getChildren().add(pLabel);
        formulaBox.getChildren().add(formulaLabel3);
    }

    public void init(SinusPresenter sPresenter)
    {
        this.sinusPresenter = sPresenter;
    }

    public void drawCoordinateSystem()
    {
        Line xAxis = new Line();
        Line yAxis = new Line();

        xAxis.setStartX(0);
        xAxis.startYProperty().bind(halfHeight);
        xAxis.endXProperty().bind(drawPane.widthProperty());
        xAxis.endYProperty().bind(halfHeight);
        yAxis.startXProperty().bind(halfWidth);
        yAxis.setStartY(0);
        yAxis.endXProperty().bind(halfWidth);
        yAxis.endYProperty().bind(drawPane.heightProperty());

        drawPane.getChildren().add(xAxis);
        drawPane.getChildren().add(yAxis);

    }

    public void drawSinus()
    {
        ArrayList<double[]> coordinateList = sinusPresenter.getCoordinateList();

        Path posPath = new Path();
        Path negPath = new Path();
        MoveTo middle = new MoveTo();
        Rotate rotate = new Rotate();


        rotate.pivotXProperty().bind(halfWidth);
        rotate.pivotYProperty().bind(halfHeight);
        rotate.setAngle(180);
        middle.xProperty().bind(halfWidth);
        middle.yProperty().bind(halfHeight);
        posPath.getElements().add(middle);
        negPath.getElements().add(middle);

        for (int i = 1; i < coordinateList.size(); i++)
        {
            LineTo currentPosLine = new LineTo();
            LineTo currentNegLine = new LineTo();

            currentPosLine.xProperty().bind(halfWidth.add(frequenceProperty.multiply(zoomProperty.multiply(coordinateList.get(i)[0]))));
            currentPosLine.yProperty().bind(halfHeight.add(amplitudeProperty.multiply(zoomProperty.multiply(coordinateList.get(i)[1]))));

            currentNegLine.xProperty().bind(halfWidth.add(frequenceProperty.multiply(zoomProperty.multiply(coordinateList.get(i)[0]))));
            currentNegLine.yProperty().bind(halfHeight.add(amplitudeProperty.multiply(zoomProperty.multiply(coordinateList.get(i)[1]))));

            posPath.getElements().add(currentPosLine);
            negPath.getElements().add(currentNegLine);
        }

        negPath.getTransforms().add(rotate);
        negPath.layoutXProperty().bind(phaseProperty);
        posPath.layoutXProperty().bind(phaseProperty);

        drawPane.getChildren().add(posPath);
        drawPane.getChildren().add(negPath);

    }

}
