package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] data){
        prepareData(data);
        ArrayList<MoveDirection> directions = new ArrayList<MoveDirection>();

        for (String s : data) {
            if (MoveDirection.fromCode(s) != null) {
                directions.add(MoveDirection.fromCode(s));
            }
        }

        return directions.toArray(new MoveDirection[0]);
    }

    private static void prepareData(String[] data){
        for(int i = 0; i < data.length; i++){
            switch(data[i]){
                case "forward" -> data[i] = "f";
                case "backward" -> data[i] = "b";
                case "left" -> data[i] = "l";
                case "right" -> data[i] = "r";
                default -> {}
            }
        }
    }
}
