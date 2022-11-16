package agh.ics.oop;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    private Vector2d vector;

    @BeforeEach
    void init(){
        vector = new Vector2d(2, 4);
    }

    @Test
    void testShouldKnowIfEquals(){
        Vector2d vectorGood = new Vector2d(2, 4);
        Vector2d vectorNotGood = new Vector2d(1, 4);

        boolean good = vector.equals(vectorGood);
        boolean wrong = vector.equals(vectorNotGood);

        assertTrue(good);
        assertFalse(wrong);
    }

    @Test
    void testShouldParseToString(){
        String stringVector = vector.toString();

        assertEquals("(2, 4)", stringVector);
    }

    @Test
    void testShouldKnowIfVectorPrecedes(){
        Vector2d vectorToPreceed = new Vector2d(5,4);
        Vector2d vectorToNotPreceed = new Vector2d(1,4);

        boolean good = vector.precedes(vectorToPreceed);
        boolean wrong = vector.precedes(vectorToNotPreceed);

        assertTrue(good);
        assertFalse(wrong);
    }

    @Test
    void testShouldKnowIfVectorFollows(){
        Vector2d vectorToFollow = new Vector2d(1,4);
        Vector2d vectorToNotFollow = new Vector2d(5,4);

        boolean good = vector.follows(vectorToFollow);
        boolean wrong = vector.follows(vectorToNotFollow);

        assertTrue(good);
        assertFalse(wrong);
    }

    @Test
    void testShouldKnowWhichVectorIsUpperRight(){
        Vector2d vector1 = new Vector2d(1, 6);

        Vector2d upperRight = vector.upperRight(vector1);

        assertEquals(upperRight, new Vector2d(2, 6));
        assertNotEquals(upperRight, new Vector2d(1, 6));

    }

    @Test
    void testShouldKnowWhichVectorIsLowerLeft(){
        Vector2d vector1 = new Vector2d(1, 6);

        Vector2d lowerLeft = vector.lowerLeft(vector1);

        assertEquals(lowerLeft, new Vector2d(1, 4));
        assertNotEquals(lowerLeft, new Vector2d(1, 6));
    }

    @Test
    void testShouldKnowVectorPlusOtherVector(){
        Vector2d vectorToAdd = new Vector2d(-1, 10);

        Vector2d addedVectors = vector.add(vectorToAdd);

        assertEquals(new Vector2d(1, 14), addedVectors);
    }

    @Test
    void testShouldKnowVectorMinusOtherVector(){
        Vector2d vectorToAdd = new Vector2d(-1, 10);

        Vector2d subtractedVectors = vector.subtract(vectorToAdd);

        assertEquals(new Vector2d(3, -6), subtractedVectors);
    }

    @Test
    void testShouldKnowOppositeVector(){
        Vector2d oppositeVector = vector.opposite();

        assertEquals(new Vector2d(-2, -4), oppositeVector);
    }
}
