package agh.ics.oop;
import org.junit.jupiter.api.Assertions;
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

    @Test()
    public void testMoveParserWithFewMistakesInInput(){
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String[] toParse = {"f", "f", "r", "l", "f", "f", "backward", "usless", "a", "p", "right"};
            OptionsParser.parse(toParse);
        });

        Assertions.assertEquals("usless is not legal move specification.", exception.getMessage());
    }

    @Test
    public void testMoveParserWithAllIncorrectInput(){
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String[] toParse = {"blalala", "unexpected", "tralala", "z", "surprise", "backwaard", "lr"};
            OptionsParser.parse(toParse);
        });

        Assertions.assertEquals("blalala is not legal move specification.", exception.getMessage());
    }

    @Test
    public void testMoveParserWithEmptyInput() {
        String[] toParse = {};

        MoveDirection[] expected = {};

        assertArrayEquals(expected, OptionsParser.parse(toParse));
    }
}
