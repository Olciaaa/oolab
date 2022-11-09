package agh.ics.oop;

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
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        //then:
        assertEquals(engine.getAnimals().get(0).getPosition(), new Vector2d(2, 0));
        assertEquals(engine.getAnimals().get(1).getPosition(), new Vector2d(3, 5));

    }
}
