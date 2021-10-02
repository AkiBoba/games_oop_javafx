package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean result = false;
        for (int row = 0; row < board.length; row++) {
            result = checkX(board, row);
            if (result) {
                return result;
            }
        }

        for (int col = 0; col < board.length; col++) {
            result = checkY(board, col);
            if (result) {
                return result;
            }
        }
        return result;
    }

    public static boolean checkX(int[][] board, int row) {
        boolean rsl = true;
        for (int col = 0; col < board.length; col++) {
            if (board[row][col] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean checkY(int[][] board, int column) {
        boolean rslt = true;
        for (int row = 0; row < board.length; row++) {
            if (board[row][column] != 1) {
                rslt = false;
                break;
            }
        }
        return rslt;

    }
}
