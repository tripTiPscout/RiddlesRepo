package bg.codexio.riddles;

import bg.codexio.riddles.colorfulballs.BallsBox;
import bg.codexio.riddles.colorfulballs.BallsException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BallsBoxTest {

    private Map<String, Integer> ballsColorCount;

    @BeforeEach
    public void setUp() {
        ballsColorCount = new HashMap<>();
    }

    @AfterEach
    public void resetSystemIn() {
        System.setIn(System.in);
    }

    @Test
    void testFillBoxWithBalls() {
        String input = "Red: 5\n" +
                "blue: 3\n" +
                "GREEN: 4\n" +
                "green: 4\n" +
                "End\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertDoesNotThrow(() -> BallsBox.fillBoxWithBalls(ballsColorCount));

        assertEquals(5, ballsColorCount.get("red"));
        assertEquals(3, ballsColorCount.get("blue"));
        assertEquals(8, ballsColorCount.get("green"));
    }

    @Test
    void testFillBoxWithBallsInvalidInput() {
        String input = "Green: -2\n" +
                "End\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        BallsException exception = assertThrows(BallsException.class, () -> BallsBox.fillBoxWithBalls(ballsColorCount));
        assertEquals("Number of balls added to box should be more than 0.", exception.getMessage());
    }

    @Test
    void testFillBoxWithBallsEmptyBox() {
        String input = "end\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        BallsException exception = assertThrows(BallsException.class, () -> BallsBox.fillBoxWithBalls(ballsColorCount));
        assertEquals("The ball box is empty.", exception.getMessage());
    }

    @Test
    void testMinBallsToRemove() throws BallsException {
        ballsColorCount.put("red", 5);
        ballsColorCount.put("blue", 3);

        int result = BallsBox.minBallsToRemove(ballsColorCount);

        assertEquals(7, result);
    }

    @Test
    void testMinBallsToRemoveSingleColor() {
        ballsColorCount.put("red", 10);

        BallsException exception = assertThrows(BallsException.class, () -> BallsBox.minBallsToRemove(ballsColorCount));
        assertEquals("There is only one color of balls in the box.", exception.getMessage());
    }
}
