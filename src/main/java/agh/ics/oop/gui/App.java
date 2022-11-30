package agh.ics.oop.gui;

import agh.ics.oop.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.geometry.HPos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;

import java.util.Map;

public class App extends Application{
    final int width = 30;
    final int height = 30;
    AbstractWorldMap map;
    GridPane grid = new GridPane();

    @Override
    public void init() throws Exception {
        try {
            String[] args = getParameters().getRaw().toArray(new String[0]);
            MoveDirection[] directions = OptionsParser.parse(args);
            map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Zwierzaki");
        drawMap();
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void drawMap() {
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
            Label element = new Label(el.toString());
            Vector2d position = el.getPosition();
            grid.add(element, position.x() - leftBottomCorner.x() + 1, rightTopCorner.y() - position.y() + 1);
            GridPane.setHalignment(element, HPos.CENTER);
        }
    }
}
