package org.vamsu.interview.solutions.playground;

/**
 * Created by vamsu on 5/10/17.
 */
public class Scratch {

    public static void main(String[] args) {
        int arr[][] = {
                {-3, -1, 10},
                {-2, 0, 2},
                {-1, 1, 3},
                {2, 3, 4}
        };

        int row = arr.length - 1;
        int col = arr[0].length - 1;

        int i = 0;
        int j = col - 1;

        int count = 0;
        while (j >= 0 && i < row) {
            if (arr[i][j] < 0) {
                count += (j + 1);
                i += 1;
            } else {
                j -= 1;
            }
        }

        System.out.print(count);

    }
}
