package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GrassFieldTest {
    @Test
    public void placeTest() {
        GrassField map = new GrassField(20);
        Animal animal1 = new Animal(map, new Vector2d(4, 4));
        Animal animal2 = new Animal(map, new Vector2d(2, 4));
        Animal animal3 = new Animal(map, new Vector2d(4, 4));
        Animal animal4 = new Animal(map, new Vector2d(7, 3));

        map.place(animal1);
        map.place(animal2);
        map.place(animal3);
        map.place(animal4);

        assertTrue(map.getElementsOnMap().containsValue(animal1));
        assertTrue(map.getElementsOnMap().containsValue(animal2));
        assertFalse(map.getElementsOnMap().containsValue(animal3));
        assertTrue(map.getElementsOnMap().containsValue(animal4));
    }

    @Test
    public void isOccupiedTest() {
        GrassField map = new GrassField(0);
        Animal animal = new Animal(map, new Vector2d(3, 4));
        map.place(animal);

        assertTrue(map.isOccupied(animal.getPosition()));
        assertFalse(map.isOccupied(new Vector2d(2, 2)));
    }

    @Test
    public void canMoveToTest() {
        GrassField map = new GrassField(10);
        Animal animal = new Animal(map, new Vector2d(3, 4));
        map.place(animal);

        assertTrue(map.canMoveTo(new Vector2d(2, 2)));
        assertFalse(map.canMoveTo(animal.getPosition()));
    }

    @Test
    public void objectAtTest() {
        GrassField map = new GrassField(10);
        Animal animal = new Animal(map, new Vector2d(3, 4));
        map.place(animal);

        assertEquals(animal, map.objectAt(animal.getPosition()));
        assertNotEquals(animal, map.objectAt(new Vector2d(2, 2)));
    }
}
