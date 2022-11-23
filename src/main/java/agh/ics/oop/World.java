package agh.ics.oop;

import java.util.HashMap;
import java.util.stream.Stream;

public class World {
    public static void main(String[] args) throws Exception {
        try{
            MoveDirection[] directions = new OptionsParser().parse(args);
            IWorldMap map = new GrassField(10);
            //IWorldMap map = new RectangularMap(10, 5);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        }
        catch (IllegalArgumentException exception) {
            //System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }
}
