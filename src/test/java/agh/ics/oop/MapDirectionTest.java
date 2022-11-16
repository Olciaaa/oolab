package agh.ics.oop;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapDirectionTest {
    static MapDirection north;
    static MapDirection south;
    static MapDirection east;
    static MapDirection west;

    @BeforeAll
    static void init(){
        north = MapDirection.NORTH;
        south = MapDirection.SOUTH;
        east = MapDirection.EAST;
        west = MapDirection.WEST;
    }

    @Test
    void testShouldKnowNextDirection() {
        MapDirection resultForNorth = north.next();
        MapDirection resultForSouth = south.next();
        MapDirection resultForEast = east.next();
        MapDirection resultForWest = west.next();

        assertEquals(east, resultForNorth);
        assertEquals(west, resultForSouth);
        assertEquals(south, resultForEast);
        assertEquals(north, resultForWest);
    }

    @Test
    void testShouldKnowPreviousDirection(){
        MapDirection resultForNorth = north.previous();
        MapDirection resultForSouth = south.previous();
        MapDirection resultForEast = east.previous();
        MapDirection resultForWest = west.previous();

        assertEquals(west, resultForNorth);
        assertEquals(east, resultForSouth);
        assertEquals(north, resultForEast);
        assertEquals(south, resultForWest);
    }
}
