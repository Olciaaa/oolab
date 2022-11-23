package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] data) {
        ArrayList<MoveDirection> directions = new ArrayList<MoveDirection>();

        for (String s : data) {
            if (preparedData(s) != null) {
                directions.add(preparedData(s));
            }
        }

        return directions.toArray(new MoveDirection[0]);
    }

    private static MoveDirection preparedData(String data) throws IllegalArgumentException {
        return switch(data){
            case "forward", "f" -> MoveDirection.FORWARD;
            case "backward", "b" -> MoveDirection.BACKWARD;
            case "left", "l" -> MoveDirection.LEFT;
            case "right", "r" -> MoveDirection.RIGHT;
            default -> throw new IllegalArgumentException(data + " is not legal move specification.");
        };
    }
}
