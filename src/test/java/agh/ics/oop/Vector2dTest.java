package agh.ics.oop;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Vector2dTest {
    Vector2d vector = new Vector2d(2, 4);

    @Test
    void testShouldKnowIfEquals(){
        Vector2d vectorGood = new Vector2d(2, 4);
        Vector2d vectorNotGood = new Vector2d(1, 4);

        boolean good = vector.equals(vectorGood);
        boolean wrong = vector.equals(vectorNotGood);

        Assert.assertTrue(good);
        Assert.assertFalse(wrong);
    }

    @Test
    void testShouldParseToString(){
        String stringVector = vector.toString();

        Assert.assertEquals("(2, 4)", stringVector);
    }

    @Test
    void testShouldKnowIfVectorPrecedes(){
        Vector2d vectorToPreceed = new Vector2d(5,4);
        Vector2d vectorToNotPreceed = new Vector2d(1,4);

        boolean good = vector.precedes(vectorToPreceed);
        boolean wrong = vector.precedes(vectorToNotPreceed);

        Assert.assertTrue(good);
        Assert.assertFalse(wrong);
    }

    @Test
    void testShouldKnowIfVectorFollows(){
        Vector2d vectorToFollow = new Vector2d(1,4);
        Vector2d vectorToNotFollow = new Vector2d(5,4);

        boolean good = vector.follows(vectorToFollow);
        boolean wrong = vector.follows(vectorToNotFollow);

        Assert.assertTrue(good);
        Assert.assertFalse(wrong);
    }

    @Test
    void testShouldKnowWhichVectorIsUpperRight(){
        Vector2d vectorUpperRight = new Vector2d(3, 9);
        Vector2d vectorNotUpperRight = new Vector2d(1, 3);
        Vector2d vectorOnLine = new Vector2d(1, 4);

        Vector2d good = vector.upperRight(vectorUpperRight);
        Vector2d wrong = vector.upperRight(vectorNotUpperRight);
        Vector2d noVectorIsUp = vector.upperRight(vectorOnLine);

        Assert.assertEquals(vectorUpperRight, good);
        Assert.assertNotEquals(vectorNotUpperRight, wrong);
        Assert.assertNull(noVectorIsUp);

    }

    @Test
    void testShouldKnowWhichVectorIsLowerLeft(){
        Vector2d vectorLowerLeft = new Vector2d(-1, 3);
        Vector2d vectorNotLowerLeft = new Vector2d(5, 20);
        Vector2d vectorOnLine = new Vector2d(-5, 4);

        Vector2d good = vector.lowerLeft(vectorLowerLeft);
        Vector2d wrong = vector.lowerLeft(vectorNotLowerLeft);
        Vector2d noVectorIsLower = vector.lowerLeft(vectorOnLine);

        Assert.assertEquals(vectorLowerLeft, good);
        Assert.assertNotEquals(vectorNotLowerLeft, wrong);
        Assert.assertNull(noVectorIsLower);
    }

    @Test
    void testShouldKnowVectorPlusOtherVector(){
        Vector2d vectorToAdd = new Vector2d(-1, 10);

        Vector2d addedVectors = vector.add(vectorToAdd);

        Assert.assertEquals(new Vector2d(1, 14), addedVectors);
    }

    @Test
    void testShouldKnowVectorMinusOtherVector(){
        Vector2d vectorToAdd = new Vector2d(-1, 10);

        Vector2d subtractedVectors = vector.subtract(vectorToAdd);

        Assert.assertEquals(new Vector2d(3, -6), subtractedVectors);
    }

    @Test
    void testShouldKnowOppositeVector(){
        Vector2d oppositeVector = vector.opposite();

        Assert.assertEquals(new Vector2d(-2, -4), oppositeVector);
    }
}