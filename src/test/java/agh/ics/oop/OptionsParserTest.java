package agh.ics.oop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {
    @Test
    public void testMoveParserWithAllCorrectInput() {
        String[] toParse = {"l", "left", "f", "forward", "r", "right", "b", "backward"};

        MoveDirection[] expected = {MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.FORWARD,
                MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.BACKWARD};

        assertArrayEquals(expected, OptionsParser.parse(toParse));
    }

    @Test
    public void testMoveParserWithFewMistakesInInput() {
        String[] toParse = {"f", "f", "r", "l", "f", "f", "backward", "usless", "a", "p", "right"};

        MoveDirection[] expected = {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT,
                MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT};

        assertArrayEquals(expected, OptionsParser.parse(toParse));
    }

    @Test
    public void testMoveParserWithAllIncorrectInput() {
        String[] toParse = {"blalala", "unexpected", "tralala", "z", "surprise", "backwaard", "lr"};

        MoveDirection[] expected = {};

        assertArrayEquals(expected, OptionsParser.parse(toParse));
    }

    @Test
    public void testMoveParserWithEmptyInput() {
        String[] toParse = {};

        MoveDirection[] expected = {};

        assertArrayEquals(expected, OptionsParser.parse(toParse));
    }
}
