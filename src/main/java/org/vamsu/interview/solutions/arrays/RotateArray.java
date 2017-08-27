package org.vamsu.interview.solutions.arrays;

import org.vamsu.interview.solutions.utils.PrintUtils;

public class RotateArray {
    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[][] input = {
                {0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15}
        };
        PrintUtils.prettyPrint("Input", input);
        rotateArray.rotate(input);
        PrintUtils.prettyPrint("Output", input);
    }

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) {
            return;
        }
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i +1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        PrintUtils.prettyPrint("Output", matrix);
        for (int i = 0; i < n; i++) {
            int head = 0;
            int tail = n - 1;
            while (head < tail) {
                int temp = matrix[i][head];
                matrix[i][head] = matrix[i][tail];
                matrix[i][tail] = temp;
                head++;
                tail--;
            }
        }
    }

}