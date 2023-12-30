package agh.ics.oop.presenter;
import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.Arrays;
import java.util.List;

public class SimulationPresenter implements MapChangeListener {
    @FXML
    private Label moveDescriptionLabel;
    @FXML
    private Button startButton;
    private AbstractWorldMap worldMap;
    @FXML
    private Label infoLabel;
    @FXML
    private TextField movesTextField;
    @FXML
    private GridPane mapGrid;
    public void setWorldMap(AbstractWorldMap worldMap) {
        this.worldMap = worldMap;
    }
    public void drawMap() {

        if (worldMap != null && mapGrid != null) {
            String mapContent = worldMap.toString();
            infoLabel.setText(mapContent);
            clearGrid();
            Boundary bounds = worldMap.getCurrentBounds();
            int width = bounds.upperRight().getX() - bounds.lowerLeft().getX() + 1;
            int height = bounds.upperRight().getY() - bounds.lowerLeft().getY() + 1;

            int CELL_WIDTH = 50;
            int CELL_HEIGHT = 50;

            for (int i = 0; i < width; i++) {
                mapGrid.getColumnConstraints().add(new ColumnConstraints(CELL_WIDTH));
            }
            for (int j = 0; j < height; j++) {
                mapGrid.getRowConstraints().add(new RowConstraints(CELL_HEIGHT));
            }

            for (int i = bounds.lowerLeft().getX(); i <= bounds.upperRight().getX(); i++) {
                for (int j = bounds.lowerLeft().getY(); j <= bounds.upperRight().getY(); j++) {
                    Label label = new Label(worldMap.objectAt(new Vector2d(i, j)).toString());

                    GridPane.setHalignment(label, HPos.CENTER);

                    mapGrid.add(label, i - bounds.lowerLeft().getX(), j - bounds.lowerLeft().getY());
                }
            }
        }
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        drawMap();
    }

    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0));
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }
    @FXML
    private void onSimulationStartClicked() {

        String movesText = movesTextField.getText();
        if (!movesText.isEmpty()) {
            String[] movesArray = movesText.split("\\s+");
            List<MoveDirection> moves = OptionsParser.parse(movesArray);
            String moveDescription = "Moves: " + Arrays.toString(movesArray);
            moveDescriptionLabel.setText(moveDescription);

            try {
                ConsoleMapDisplay observer = new ConsoleMapDisplay();
                worldMap.addObserver(this);
                Simulation simulation = new Simulation(moves, List.of(new Vector2d(0, 0), new Vector2d(3, 4)), worldMap);
                simulation.run();
                worldMap.addObserver(observer);
            }
            catch(IllegalArgumentException er){
            er.printStackTrace();
        }
            Platform.runLater(this::drawMap);
        }
        else {
            infoLabel.setText("Lista ruchów jest pusta!");
        }
    }
}

