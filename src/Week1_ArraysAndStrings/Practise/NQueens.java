package Week1_ArraysAndStrings.Practise;
import java.util.Scanner;

public class NQueens {
    private static boolean canSolveNQueen(int column, int n, int[][] board, int[] row, int[] lowerDiag, int[] upperDiag){
        if (column == n)
            return true;

        for (int i = 0; i < n; i++){
            if (canPlaceQueen(i, column, n, board, row, lowerDiag, upperDiag)){
                row[i] = 1;
                board[i][column] = 1;
                lowerDiag[i + column] = 1;
                upperDiag[n-1  + i - column] = 1;
                if (canSolveNQueen(column + 1, n, board, row, lowerDiag, upperDiag))
                    return true;
                upperDiag[n-1 + i - column] = 0;
                lowerDiag[i + column] = 0;
                board[i][column] = 0;
                row[i] = 0;
            }
        }
        return false;
    }

    private static  boolean canPlaceQueen(int i, int j, int n, int[][] board, int[] row,
                                          int[] lowerDiag, int[] upperDiag){
        return row[i] == 0 && lowerDiag[i + j] == 0 & upperDiag[n-1 + i - j] == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++){
            int n = sc.nextInt();
            int[][] board = new int[n][n];
            int[] row = new int[n];
            int[] lowerDiag = new int[2*n - 1];
            int[] upperDiag = new int[2*n - 1];

            canSolveNQueen(0, n, board, row, upperDiag, lowerDiag);
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    System.out.print(board[r][c] + " ");
                }
                System.out.println();
            }
        }
    }
}
