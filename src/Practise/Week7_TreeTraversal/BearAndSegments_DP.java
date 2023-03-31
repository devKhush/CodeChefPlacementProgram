package Practise.Week7_TreeTraversal;
import java.util.Arrays;
import java.util.Scanner;

public class BearAndSegments_DP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            int n = sc.nextInt();
            int p = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            solve_Tabulation(arr, n, p);
        }
    }

    private static void solve_Tabulation(int[] arr, int n, int P){
        int[][] dp = new int[n][P];

        dp[0][arr[0] % P] = 1;
        dp[0][0] += 1;

        for (int i = 1; i < n; i++){
            for (int sum = 0; sum < P; sum++){
                int notTake = dp[i - 1][sum];
                int val = (sum - arr[i]);
                if (val < 0)
                    val = val % P + P;
                val = val % P;
                int take = dp[i - 1][val];
                dp[i][sum] = take + notTake;
            }
        }
        for (int[] r : dp)
            System.out.println(Arrays.toString(r));

        for (int sum = P - 1; sum >= 0; sum--){
            if (dp[n - 1][sum] != 0) {
                System.out.println(sum + " " + dp[n - 1][sum]);
                break;
            }
        }
    }

    private static void solve_Memoization(int[] arr, int n, int P){
        Integer[][] dp = new Integer[n][P];

        f(n - 1, P - 1, P, arr, dp);

        for (Integer[] r : dp)
            System.out.println(Arrays.toString(r));

        for (int sum = P - 1; sum >= 0; sum--){
            if (dp[n - 1][sum] != null && dp[n - 1][sum] != 0)
                System.out.println(sum + " " + dp[n - 1][sum]);
        }

    }

    private static int f(int i, int sum, int P, int[] arr, Integer[][] dp){
        if (i < 0)
            return sum == 0 ? 1 : 0;
        if (dp[i][sum] != null)
            return dp[i][sum];

        int notTake = f(i - 1, sum, P, arr, dp);

        int newSum = sum - arr[i];
        if (newSum < 0)
            newSum += P;
        int take = f(i - 1, newSum, P, arr, dp);
        return dp[i][sum] = notTake + take;
    }
}
