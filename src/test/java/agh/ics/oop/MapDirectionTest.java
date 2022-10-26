package agh.ics.oop;

import org.testng.Assert;
import org.testng.annotations.Test;

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
        Assert.assertEquals(MapDirection.EAST, resultForNorth);
        Assert.assertEquals(MapDirection.WEST, resultForSouth);
        Assert.assertEquals(MapDirection.SOUTH, resultForEast);
        Assert.assertEquals(MapDirection.NORTH, resultForWest);
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
        Assert.assertEquals(MapDirection.WEST, resultForNorth);
        Assert.assertEquals(MapDirection.EAST, resultForSouth);
        Assert.assertEquals(MapDirection.NORTH, resultForEast);
        Assert.assertEquals(MapDirection.SOUTH, resultForWest);
    }
}
