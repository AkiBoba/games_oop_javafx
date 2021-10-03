package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean result = false;
        for (int index = 0; index < board.length; index++) {
            if (board[index][index] == 1 && (checkX(board, index) || checkY(board, index))) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean checkX(int[][] board, int row) {
        boolean rsl = true;
        for (int col = 0; col < board[row].length; col++) {
            if (board[row][col] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean checkY(int[][] board, int column) {
        boolean rslt = true;
        for (int row = 0; row < board[column].length; row++) {
            if (board[row][column] != 1) {
                rslt = false;
                break;
            }
        }
        return rslt;
    }
}
