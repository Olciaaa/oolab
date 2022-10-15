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
        MapDirection resultForNorth = MapDirection.next(north);
        MapDirection resultForSouth = MapDirection.next(south);
        MapDirection resultForEast = MapDirection.next(east);
        MapDirection resultForWest = MapDirection.next(west);

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
        MapDirection resultForNorth = MapDirection.previous(north);
        MapDirection resultForSouth = MapDirection.previous(south);
        MapDirection resultForEast = MapDirection.previous(east);
        MapDirection resultForWest = MapDirection.previous(west);

        // then:
        Assert.assertEquals(MapDirection.WEST, resultForNorth);
        Assert.assertEquals(MapDirection.EAST, resultForSouth);
        Assert.assertEquals(MapDirection.NORTH, resultForEast);
        Assert.assertEquals(MapDirection.SOUTH, resultForWest);
    }
}
