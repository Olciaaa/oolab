package agh.ics.oop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    @Test
    public void placeTest() {
        RectangularMap map = new RectangularMap(6, 8);
        Animal animal1 = new Animal(map, new Vector2d(4, 4));
        Animal animal2 = new Animal(map, new Vector2d(2, 4));
        Animal animal3 = new Animal(map, new Vector2d(4, 4));
        Animal animal4 = new Animal(map, new Vector2d(7, 3));

        map.place(animal1);
        map.place(animal2);
        map.place(animal3);
        map.place(animal4);

        assertTrue(map.getAnimalsOnMap().contains(animal1));
        assertTrue(map.getAnimalsOnMap().contains(animal2));
        assertFalse(map.getAnimalsOnMap().contains(animal3));
        assertFalse(map.getAnimalsOnMap().contains(animal4));
    }

    @Test
    public void isOccupiedTest() {
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(map, new Vector2d(3, 4));
        map.place(animal);

        assertTrue(map.isOccupied(animal.getPosition()));
        assertFalse(map.isOccupied(new Vector2d(2, 2)));
    }

    @Test
    public void canMoveToTest() {
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(map, new Vector2d(3, 4));
        map.place(animal);

        assertTrue(map.canMoveTo(new Vector2d(2, 2)));
        assertFalse(map.canMoveTo(animal.getPosition()));
    }

    @Test
    public void objectAtTest() {
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(map, new Vector2d(3, 4));
        map.place(animal);

        assertEquals(animal, map.objectAt(animal.getPosition()));
        assertNull(map.objectAt(new Vector2d(2, 2)));
    }
}
