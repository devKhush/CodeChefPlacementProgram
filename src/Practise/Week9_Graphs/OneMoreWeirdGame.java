package Practise.Week9_Graphs;
import java.util.Scanner;

public class OneMoreWeirdGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] grid = new int[m][n];
            int score = 0;

            int[] di = {1, -1, 0, 0};
            int[] dj = {0, 0, 1, -1};

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = 1;
                    for (int a = 0; a < 4; a++){
                        int newI = i + di[a];
                        int newJ = j + dj[a];
                        if (newI >= 0 && newJ >= 0 && newI < m && newJ < n && grid[newI][newJ]==1){
                            score += 1;
                        }
                    }
                }
            }
            System.out.println(score);

            // Solution 2
            System.out.println((m - 1) + (1 + 2*(m - 1)) * (n - 1));
        }
    }
}
