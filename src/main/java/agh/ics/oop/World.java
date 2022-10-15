package agh.ics.oop;
import static agh.ics.oop.Direction.*;

import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class World {
    public static void main(String[] args){
        //System.out.println("start");
        //Direction[] directions = prepareDataFromStream(args);
        //run(directions);
        //System.out.println("stop");

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

    }

    private static Direction[] prepareDataFromStream(String[] data){
        List<Direction> dirs =  Stream.of(data) //ciąg obiektów się tworzy
                .map(Direction::fromCode) //operacja na ciągu, mapuje typ obiektu do innego typu, dla każdego dziaba woła metodę fromCode
                .collect(Collectors.toList()); //zbiera przekonwertowane dziaby do listy

        return dirs.toArray(new Direction[0]);
    }

    private static void run(Direction[] directions) {
        for (Direction direction : directions) {
            switch (direction) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case LEFT -> System.out.println("Zwierzak skręca w prawo");
                case RIGHT -> System.out.println("Zwierzak skręca w lewo");
                default -> System.out.println("Wprowadzono błędną wartość");
            }
        }
    }

    private static Direction[] prepareData(String[] data){
        Direction[] directions = new Direction[data.length];

        for(int i = 0; i < data.length; i++) {
            directions[i] = switch(data[i]) {
                case "f" -> FORWARD;
                case "b" -> BACKWARD;
                case "l" -> LEFT;
                case "r" -> RIGHT;
                default -> WRONG;
            };
        }
        return directions;
    }

    private static Direction[] prepareDataTraditionally(String[] data){
        List<Direction> directions = new ArrayList<Direction>();

        for (String el:data) {
            Direction dziab = Direction.fromCode(el);
            directions.add(dziab);
        }

        return directions.toArray(new Direction[0]);
    }
}
