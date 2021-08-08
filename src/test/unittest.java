package src.test;

import static src.main.GameOfLife.nextGeneration;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class unittest {

    @Test
    void testGeneration1() {

        int[][] grid = {
                {1, 0, 1, 0},
                {0, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 1, 0, 1}
        };

        int[][] expectedGeneration1 = {
                {0, 0, 1, 0},
                {1, 1, 0, 1},
                {0, 0, 1, 1},
                {0, 0, 1, 0}
        };

        int[][] expectedGeneration2 = {
                {1, 0, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 0}
        };

        int[][] expectedGeneration3 = {
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 1, 1}
        };

        int[][] actualGeneration1 = nextGeneration(grid, 4, 4);
        int[][] actualGeneration2 = nextGeneration(expectedGeneration1, 4, 4);
        int[][] actualGeneration3 = nextGeneration(expectedGeneration2, 4, 4);

        assertArrayEquals(expectedGeneration1, actualGeneration1);
        assertArrayEquals(expectedGeneration2, actualGeneration2);
        assertArrayEquals(expectedGeneration3, actualGeneration3);
    }

}
