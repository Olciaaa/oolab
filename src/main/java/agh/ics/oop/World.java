package agh.ics.oop;
import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class World {
    public static void main(String[] args) throws Exception{
        /*Animal animal1 = new Animal();
        System.out.println(animal1);
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        System.out.println(animal1);

        System.out.println("start");
        MoveDirection[] directions = OptionsParser.parse(args);
        run(directions);
        System.out.println("stop");

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));*/

        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }

    private static void run(MoveDirection[] directions) {
        for (MoveDirection direction : directions) {
            System.out.println(switch (direction) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case LEFT -> "Zwierzak skręca w lewo";
                case RIGHT -> "Zwierzak skręca w prawo";
            });
        }
    }

    private static MoveDirection[] prepareDataFromStream(String[] data){
        /*List<Direction> dirs =  Stream.of(data) //ciąg obiektów się tworzy
                .map(Direction::fromCode) //operacja na ciągu, mapuje typ obiektu do innego typu, dla każdego dziaba woła metodę fromCode
                .collect(Collectors.toList()); //zbiera przekonwertowane dziaby do listy

        return dirs.toArray(new Direction[0]);*/

        return Stream.of(data) //ciąg obiektów się tworzy
                .map(MoveDirection::fromCode).toArray(MoveDirection[]::new);
    }
}
