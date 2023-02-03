package Week4_Sorting.Practise;
import java.util.Scanner;

public class NQueen {
    private static boolean solve(int column, int[][] board, int n){
        if (column == n)
            return true;

        for (int row = 0; row < n; row++){
            if (canPlaceQueen(row, column, board, n)){
                board[row][column] = 1;
                if (solve(column + 1, board, n))
                    return true;
                board[row][column] = 0;
            }
        }
        return false;
    }

    private static boolean canPlaceQueen(int row, int col, int[][] board, int n){
        int j = col - 1;
        int i = row;
        while (j >= 0){
            if (board[i][j] == 1) return false;
            j--;
        }

        i = row - 1;
        j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1) return false;
            i--; j--;
        }

        i = row + 1;
        j = col - 1;
        while (i < n && j >= 0){
            if (board[i][j] == 1) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int[][] board = new int[n][n];

            solve(0, board, n);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++){
                    System.out.print(board[i][j] + " ");
                }
                print("");
            }
        }
    }


    private static <T> void print(T o){
        System.out.println(o);
    }
}
