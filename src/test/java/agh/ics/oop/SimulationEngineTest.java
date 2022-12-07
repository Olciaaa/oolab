package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class SimulationEngineTest {
    @Test
    void TestSimulation() throws InterruptedException {
        //given:
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};

        //when:
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        App application = new App();
        SimulationEngine engine = new SimulationEngine(map, positions, application, 300);
        engine.setMoves(directions);
        Application.launch(App.class, args);
        engine.run();

        //then:
        assertEquals(engine.getAnimals().get(0).getPosition(), new Vector2d(2, 0));
        assertEquals(engine.getAnimals().get(1).getPosition(), new Vector2d(3, 5));

    }
}
