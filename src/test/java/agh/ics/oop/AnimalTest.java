package agh.ics.oop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest
{
    @Test
    void testAnimalIsAt()
    {
        Animal animal1 = new Animal(new RectangularMap(4, 4), new Vector2d(2, 2));
        Animal animal2 = new Animal(new RectangularMap(4, 4), new Vector2d(2, 2));
        Animal animal3 = new Animal(new RectangularMap(4, 4), new Vector2d(2, 2));
        Animal animal4 = new Animal(new RectangularMap(4, 4), new Vector2d(2, 2));

        assertTrue(animal1.isAt(new Vector2d(2, 2)));
        assertFalse(animal2.isAt(new Vector2d(2, 3)));
        assertFalse(animal3.isAt(new Vector2d(3, 2)));
        assertFalse(animal4.isAt(new Vector2d(3, 3)));
    }

    @Test
    public void testCorrectDirectionWhenTurnRight() {
        Animal animal = new Animal(new RectangularMap(4, 4), new Vector2d(2, 2));

        assertEquals(animal.getDirection(), MapDirection.NORTH);

        animal.move(MoveDirection.RIGHT);
        assertEquals(animal.getDirection(), MapDirection.EAST);

        animal.move(MoveDirection.RIGHT);
        assertEquals(animal.getDirection(), MapDirection.SOUTH);

        animal.move(MoveDirection.RIGHT);
        assertEquals(animal.getDirection(), MapDirection.WEST);

        animal.move(MoveDirection.RIGHT);
        assertEquals(animal.getDirection(), MapDirection.NORTH);
    }

    @Test
    public void testCorrectDirectionWhenTurnLeft() {
        Animal animal = new Animal(new RectangularMap(4, 4), new Vector2d(2, 2));

        assertEquals(animal.getDirection(), MapDirection.NORTH);

        animal.move(MoveDirection.LEFT);
        assertEquals(animal.getDirection(), MapDirection.WEST);

        animal.move(MoveDirection.LEFT);
        assertEquals(animal.getDirection(), MapDirection.SOUTH);

        animal.move(MoveDirection.LEFT);
        assertEquals(animal.getDirection(), MapDirection.EAST);

        animal.move(MoveDirection.LEFT);
        assertEquals(animal.getDirection(), MapDirection.NORTH);
    }

    @Test
    public void testAnimalPositionChange() {
        Animal animal1 = new Animal(new RectangularMap(4, 4), new Vector2d(2, 2));
        Animal animal2 = new Animal(new RectangularMap(4, 4), new Vector2d(2, 2));
        Animal animal3 = new Animal(new RectangularMap(4, 4), new Vector2d(2, 2));
        Animal animal4 = new Animal(new RectangularMap(4, 4), new Vector2d(2, 2));

        animal1.move(MoveDirection.FORWARD);
        animal2.move(MoveDirection.BACKWARD);
        animal3.move(MoveDirection.RIGHT);
        animal4.move(MoveDirection.LEFT);

        assertEquals(animal1.getPosition(), new Vector2d(2, 3));
        assertNotEquals(animal1.getPosition(), new Vector2d(1, 3));
        assertEquals(animal2.getPosition(), new Vector2d(2, 1));
        assertNotEquals(animal2.getPosition(), new Vector2d(2, 5));
        assertEquals(animal3.getPosition(), new Vector2d(2, 2));
        assertNotEquals(animal3.getPosition(), new Vector2d(3, 2));
        assertEquals(animal3.getPosition(), new Vector2d(2, 2));
        assertNotEquals(animal4.getPosition(), new Vector2d(1, 2));
    }

    @Test
    public void testAnimalBehaviourWhileMoving(){
        Animal animal = new Animal(new RectangularMap(4, 4), new Vector2d(2, 2));
        assertEquals(animal.getPosition(), new Vector2d(2, 2));

        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getPosition(), new Vector2d(2, 3));

        animal.move(MoveDirection.RIGHT)
                .move(MoveDirection.FORWARD);
        assertEquals(animal.getPosition(), new Vector2d(3, 3));

        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getPosition(), new Vector2d(4, 3));

        animal.move(MoveDirection.LEFT)
                .move(MoveDirection.FORWARD);
        assertEquals(animal.getPosition(), new Vector2d(4, 4));

        animal.move(MoveDirection.BACKWARD)
                .move(MoveDirection.BACKWARD)
                .move(MoveDirection.BACKWARD);
        assertEquals(animal.getPosition(), new Vector2d(4, 1));

        animal.move(MoveDirection.BACKWARD)
                .move(MoveDirection.FORWARD)
                .move(MoveDirection.BACKWARD)
                .move(MoveDirection.FORWARD);
        assertEquals(animal.getPosition(), new Vector2d(4, 1));
    }

    @Test
    public void testGoOutsideTheMap() {
        Animal animal1 = new Animal(new RectangularMap(4, 4), new Vector2d(0, 0));
        assertEquals(animal1.getPosition(), new Vector2d(0, 0));

        Animal animal2 = new Animal(new RectangularMap(4, 4), new Vector2d(4, 0));
        animal2.move(MoveDirection.BACKWARD);
        assertEquals(animal2.getPosition(), new Vector2d(4, 0));

        Animal animal3 = new Animal(new RectangularMap(4, 4), new Vector2d(0, 4));
        animal3.move(MoveDirection.FORWARD);
        assertEquals(animal3.getPosition(), new Vector2d(0, 4));

        Animal animal4 = new Animal(new RectangularMap(4, 4), new Vector2d(4, 4));
        animal4.move(MoveDirection.FORWARD);
        assertEquals(animal4.getPosition(), new Vector2d(4, 4));

        Animal animal5 = new Animal(new RectangularMap(4, 4), new Vector2d(3, 4));
        animal5.move(MoveDirection.FORWARD);
        assertEquals(animal5.getPosition(), new Vector2d(3, 4));

        Animal animal6 = new Animal(new RectangularMap(4, 4), new Vector2d(1, 0));
        animal6.move(MoveDirection.BACKWARD);
        assertEquals(animal6.getPosition(), new Vector2d(1, 0));

        //automatic rotation of Animal is NORTH
        Animal animal7 = new Animal(new RectangularMap(4, 4), new Vector2d(2, 4));
        animal7.move(MoveDirection.FORWARD);
        assertEquals(animal7.getPosition(), new Vector2d(2, 4));

        Animal animal8 = new Animal(new RectangularMap(4, 4), new Vector2d(3, 0));
        animal8.move(MoveDirection.RIGHT).move(MoveDirection.RIGHT);
        animal8.move(MoveDirection.FORWARD);
        assertEquals(animal8.getPosition(), new Vector2d(3, 0));

        Animal animal9 = new Animal(new RectangularMap(4, 4), new Vector2d(4, 2));
        animal9.move(MoveDirection.RIGHT);
        animal9.move(MoveDirection.FORWARD);
        assertEquals(animal9.getPosition(), new Vector2d(4, 2));

        Animal animal10 = new Animal(new RectangularMap(4, 4), new Vector2d(0, 2));
        animal10.move(MoveDirection.LEFT);
        animal10.move(MoveDirection.FORWARD);
        assertEquals(animal10.getPosition(), new Vector2d(0, 2));
    }

    @Test
    void testToString()
    {
        Animal testAnimal1 = new Animal(new RectangularMap(4, 4), new Vector2d(2, 2));
        Animal testAnimal2 = new Animal(new RectangularMap(4, 4), new Vector2d(2, 2));

        testAnimal2.move(MoveDirection.FORWARD);
        testAnimal2.move(MoveDirection.FORWARD);
        testAnimal2.move(MoveDirection.RIGHT);
        testAnimal2.move(MoveDirection.BACKWARD);

        assertEquals("^", testAnimal1.toString());
        assertEquals(">", testAnimal2.toString());
    }
}
