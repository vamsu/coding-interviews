package org.vamsu.interview.solutions;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vamsu.interview.solutions.arrays.MinValueIndexWithinRangeFastPreProcess;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by vamsu on 6/10/17.
 */
class MinValueIndexWithinRangeFastPreProcessTest {
    private MinValueIndexWithinRangeFastPreProcess.MinArray minArray;

    @BeforeEach
    void before() {
        int[] arr = {1, 4, -1, -5, 2, -2, 0, 10, 19};
        minArray = new MinValueIndexWithinRangeFastPreProcess.MinArray(arr);
    }

    @Test
    void valid() {
        assertEquals(new Integer(3), minArray.query(new MinValueIndexWithinRangeFastPreProcess.Range(0, 5)));
        assertEquals(new Integer(3), minArray.query(new MinValueIndexWithinRangeFastPreProcess.Range(3, 4)));
        assertEquals(new Integer(6), minArray.query(new MinValueIndexWithinRangeFastPreProcess.Range(6, 8)));
        assertEquals(new Integer(0), minArray.query(new MinValueIndexWithinRangeFastPreProcess.Range(0, 0)));
    }

    @Test
    void invalid() {
        assertThrows(IllegalArgumentException.class, () -> minArray.query(new MinValueIndexWithinRangeFastPreProcess.Range(10, 0)));
        assertEquals(null, minArray.query(new MinValueIndexWithinRangeFastPreProcess.Range(-1, -1)));
    }
}



