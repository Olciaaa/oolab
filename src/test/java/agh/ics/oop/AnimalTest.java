package agh.ics.oop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest
{
    @Test
    void testAnimalIsAt()
    {
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        Animal animal3 = new Animal();
        Animal animal4 = new Animal();

        assertTrue(animal1.isAt(new Vector2d(2, 2)));
        assertFalse(animal2.isAt(new Vector2d(2, 3)));
        assertFalse(animal3.isAt(new Vector2d(3, 2)));
        assertFalse(animal4.isAt(new Vector2d(3, 3)));
    }

    @Test
    public void testCorrectDirectionWhenTurnRight() {
        Animal animal = new Animal();

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
        Animal animal = new Animal();

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
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        Animal animal3 = new Animal();
        Animal animal4 = new Animal();

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
        Animal animal = new Animal();
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
        Animal animal = new Animal();

        animal.setPosition(new Vector2d(0, 0));
        animal.move(MoveDirection.BACKWARD);
        assertEquals(animal.getPosition(), new Vector2d(0, 0));

        animal.setPosition(new Vector2d(4, 0));
        animal.move(MoveDirection.BACKWARD);
        assertEquals(animal.getPosition(), new Vector2d(4, 0));

        animal.setPosition(new Vector2d(0, 4));
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getPosition(), new Vector2d(0, 4));

        animal.setPosition(new Vector2d(4, 4));
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getPosition(), new Vector2d(4, 4));

        animal.setPosition(new Vector2d(3, 4));
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getPosition(), new Vector2d(3, 4));

        animal.setPosition(new Vector2d(1, 0));
        animal.move(MoveDirection.BACKWARD);
        assertEquals(animal.getPosition(), new Vector2d(1, 0));

        animal.setPosition(new Vector2d(2, 4));
        animal.setDirection(MapDirection.NORTH);
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getPosition(), new Vector2d(2, 4));

        animal.setPosition(new Vector2d(3, 0));
        animal.setDirection(MapDirection.SOUTH);
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getPosition(), new Vector2d(3, 0));

        animal.setPosition(new Vector2d(4, 2));
        animal.setDirection(MapDirection.EAST);
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getPosition(), new Vector2d(4, 2));

        animal.setPosition(new Vector2d(0, 2));
        animal.setDirection(MapDirection.WEST);
        animal.move(MoveDirection.FORWARD);
        assertEquals(animal.getPosition(), new Vector2d(0, 2));
    }

    @Test
    void testToString()
    {
        Animal testAnimal1 = new Animal();
        Animal testAnimal2 = new Animal();

        testAnimal2.move(MoveDirection.FORWARD);
        testAnimal2.move(MoveDirection.FORWARD);
        testAnimal2.move(MoveDirection.RIGHT);
        testAnimal2.move(MoveDirection.BACKWARD);

        assertEquals("orientacja: Północ, pozycja: (2, 2)", testAnimal1.toString());
        assertEquals("orientacja: Wschód, pozycja: (1, 4)", testAnimal2.toString());
    }
}
