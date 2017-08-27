package org.vamsu.interview.solutions.dp;

/* A Naive re
cursive implementation of 0-1 Knapsack problem */
public class KnapSack {

    // A utility function that returns maximum of two integers
    private static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Returns the maximum value that can be put in a knapsack of capacity W
    private static int knapSack(int capacity, int weights[], int values[], int index) {
        // Base Case
        if (index == 0 || capacity == 0)
            return 0;

        // If weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (weights[index - 1] > capacity) {
            return knapSack(capacity, weights, values, index - 1);
        }
        else {
            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
            return max(values[index - 1] + knapSack(capacity - weights[index - 1], weights, values, index - 1),
                    knapSack(capacity, weights, values, index - 1));
        }
    }


    // Driver program to test above function
    public static void main(String args[]) {
        int values[] = new int[]{60, 100, 120};
        int weights[] = new int[]{10, 20, 30};
        int capacity = 50;
        int index = values.length;
        System.out.println(knapSack(capacity, weights, values, index));
    }
}

