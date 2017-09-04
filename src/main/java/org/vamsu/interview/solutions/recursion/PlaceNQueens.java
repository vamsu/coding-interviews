package org.vamsu.interview.solutions.recursion;

import org.vamsu.interview.solutions.utils.PrintUtils;

/**
 * Created by vamsu on 9/3/17.
 */
public class PlaceNQueens {
    public static final int SIZE = 4;

    private static boolean isSafe(int[][] chessBoard, int row, int col) {
        //Columns must not have one more queen
        for (int r = 0; r < row; r++) {
            if (chessBoard[r][col] == 1) {
                return false;
            }
        }
        //Diagonal \ must not have one more queen
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (chessBoard[r][c] == 1) {
                return false;
            }
        }

        //Diagonal / must not have one more queen
        for (int r = row, c = col; r >= 0 && c < SIZE; r--, c++) {
            if (chessBoard[r][col] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void printQueens(int[][] chessBoard, int row) {
        if (row == SIZE) {
            PrintUtils.prettyPrint("Solution:", chessBoard);
            return;
        }
        for (int col = 0; col < SIZE; col++) {
            if (isSafe(chessBoard, row, col)) {
                chessBoard[row][col] = 1;
                printQueens(chessBoard, row + 1);
                chessBoard[row][col] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] chessBoard = new int[SIZE][SIZE];
        PrintUtils.prettyPrint("Chess Board", chessBoard);
        printQueens(chessBoard, 0);
    }
}
