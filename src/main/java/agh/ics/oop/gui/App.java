package agh.ics.oop.gui;

import agh.ics.oop.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.geometry.HPos;

import java.io.FileNotFoundException;
import java.util.Map;

public class App extends Application {
    final int width = 30;
    final int height = 30;
    private final GridPane grid = new GridPane();
    private AbstractWorldMap map;
    private SimulationEngine engine;
    private Button button;
    private TextField textField;
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init(){
        try {
            map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            button = new Button("Start");
            textField = new TextField();
            int moveDelay = 300;
            engine = new SimulationEngine(map, positions, this, moveDelay);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        init();
        stage = primaryStage;
        stage.setTitle("Zwierzaki");
        Vector2d lowerCorner = map.getZeroPoint();
        Vector2d upperCorner = map.getLastPoint();

        int width = (upperCorner.x() - lowerCorner.x() + 2) * this.width;
        int height = (upperCorner.y() - lowerCorner.y() + 3) * this.height;

        HBox input = new HBox(button, textField);
        VBox verticalBox = new VBox(grid, input);
        verticalBox.setAlignment(Pos.CENTER);
        input.setAlignment(Pos.CENTER);

        button.setOnAction(event -> {
            MoveDirection[] directions = OptionsParser.parse(textField.getText().split(" "));
            engine.setMoves(directions);
            Thread thread = new Thread(engine);
            thread.start();
        });
        drawMap();

        Scene scene = new Scene(verticalBox, width, height);
        stage.setScene(scene);
        stage.show();
    }

    public void drawMap() throws FileNotFoundException {
        grid.setGridLinesVisible(false);
        grid.getChildren().clear();
        grid.getColumnConstraints().clear();
        grid.getRowConstraints().clear();
        grid.setGridLinesVisible(true);

        Map<Vector2d, IWorldElement> elementsOnMap = map.getElementsOnMap();

        Vector2d leftBottomCorner = map.getZeroPoint();
        Vector2d rightTopCorner = map.getLastPoint();

        Label label = new Label("y / x");
        grid.add(label, 0, 0);
        grid.getColumnConstraints().add(new ColumnConstraints(width));
        grid.getRowConstraints().add(new RowConstraints(height));
        GridPane.setHalignment(label, HPos.CENTER);

        for (int i = leftBottomCorner.x(); i <= rightTopCorner.x(); i++) {
            Label labelX = new Label("" + i);
            grid.add(labelX, i - leftBottomCorner.x() + 1, 0);
            grid.getColumnConstraints().add(new ColumnConstraints(width));
            GridPane.setHalignment(labelX, HPos.CENTER);
        }

        for (int i = leftBottomCorner.y(); i <= rightTopCorner.y(); i++) {
            Label labelY = new Label("" + i);
            grid.add(labelY, 0, rightTopCorner.y() - i + 1);
            grid.getRowConstraints().add(new RowConstraints(height));
            GridPane.setHalignment(labelY, HPos.CENTER);
        }

        for (IWorldElement el : elementsOnMap.values()) {
            VBox element = new GuiElementBox(el).getVerticalBox();
            Vector2d position = el.getPosition();
            grid.add(element, position.x() - leftBottomCorner.x() + 1, rightTopCorner.y() - position.y() + 1);
            GridPane.setHalignment(element, HPos.CENTER);
        }
        stage.show();
    }

    public void redrawMap() {
        Platform.runLater(() -> {
            try {
                drawMap();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}
