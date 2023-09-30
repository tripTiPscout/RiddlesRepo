package bg.codexio.riddles;

import bg.codexio.riddles.rabbit.RabbitsBusiness;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RabbitsBusinessTest {

    @Test
    public void testAreGardensSquare() {
        int[][] areaOfGardens = {
                {0,1,1,0,0,1,1,0,0,0},
                {0,1,1,0,0,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,1},
                {0,1,1,0,1,1,0,1,1,1},
                {0,1,1,0,1,1,0,1,1,1}
        };

        assertTrue(RabbitsBusiness.areGardensSquare(areaOfGardens));
    }

    @Test
    public void testAreGardensNotSquare() {
        int[][] areaOfGardens = {
                {0,1,1,0,0,1,1,0,0,0},
                {0,1,1,0,0,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,1},
                {0,1,1,0,1,1,0,1,1,1}
        };

        assertFalse(RabbitsBusiness.areGardensSquare(areaOfGardens));
    }

    @Test
    public void testFindGroupSize() {
        int[][] areaOfGardens = {
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1},
                {0,0,0,0,0,0,0,1,1,1},
                {0,0,0,0,0,0,0,1,1,1}
        };

        assertEquals(9, RabbitsBusiness.findGroupSize(areaOfGardens, 2, 7));
    }

    @Test
    public void testIsSquare() {
        assertTrue(RabbitsBusiness.isSquare(16));
        assertFalse(RabbitsBusiness.isSquare(14));
    }
}
