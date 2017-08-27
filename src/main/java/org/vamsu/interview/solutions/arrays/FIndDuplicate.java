package org.vamsu.interview.solutions.arrays;

import java.util.Arrays;

public class FIndDuplicate {

    public static void main(String args[]) {
        findByLL(new int[]{3, 4, 2, 3, 1, 5});
        findByLL(new int[]{1, 2, 3, 1});
    }

    public static int findByLL(int[] input) {
        if (input == null || input.length <= 1) {
            return -1;
        }
        int n = input.length - 1;
        int posInCycle = n + 1;
        for (int i = 0; i < n; i++) {
            posInCycle = input[posInCycle - 1];
        }

        int rememberedValue = posInCycle;
        int currentValue = input[posInCycle - 1];
        int cycleLength = 1;
        while (currentValue != rememberedValue) {
            currentValue = input[currentValue - 1];
            cycleLength++;
        }
        int pointerAhead = n + 1;
        for (int i = 0; i < cycleLength; i++) {
            pointerAhead = input[pointerAhead - 1];
        }

        int pointerStart = n + 1;
        while (pointerStart != pointerAhead) {
            pointerStart = input[pointerStart - 1];
            pointerAhead = input[pointerAhead - 1];
        }
        System.out.println("Input: " + Arrays.toString(input) + ", Result: " + pointerStart);
        return pointerStart;
    }

}
