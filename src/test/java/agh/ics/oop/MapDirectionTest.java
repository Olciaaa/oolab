package agh.ics.oop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapDirectionTest {
    @Test
    void testShouldKnowNextDirection() {
        // given:
        MapDirection north = MapDirection.NORTH;
        MapDirection south = MapDirection.SOUTH;
        MapDirection east = MapDirection.EAST;
        MapDirection west = MapDirection.WEST;

        // when:
        MapDirection resultForNorth = north.next();
        MapDirection resultForSouth = south.next();
        MapDirection resultForEast = east.next();
        MapDirection resultForWest = west.next();

        // then:
        assertEquals(MapDirection.EAST, resultForNorth);
        assertEquals(MapDirection.WEST, resultForSouth);
        assertEquals(MapDirection.SOUTH, resultForEast);
        assertEquals(MapDirection.NORTH, resultForWest);
    }

    @Test
    void testShouldKnowPreviousDirection(){
        // given:
        MapDirection north = MapDirection.NORTH;
        MapDirection south = MapDirection.SOUTH;
        MapDirection east = MapDirection.EAST;
        MapDirection west = MapDirection.WEST;

        // when:
        MapDirection resultForNorth = north.previous();
        MapDirection resultForSouth = south.previous();
        MapDirection resultForEast = east.previous();
        MapDirection resultForWest = west.previous();

        // then:
        assertEquals(MapDirection.WEST, resultForNorth);
        assertEquals(MapDirection.EAST, resultForSouth);
        assertEquals(MapDirection.NORTH, resultForEast);
        assertEquals(MapDirection.SOUTH, resultForWest);
    }
}
