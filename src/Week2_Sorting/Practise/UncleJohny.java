package Week2_Sorting.Practise;

import java.util.Arrays;
import java.util.Scanner;

public class UncleJohny {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            int K = sc.nextInt() - 1;
            int song = arr[K];
            Arrays.sort(arr);

            for (int i = 0; i < n; i++)
                if (arr[i] == song) {
                    System.out.println(i + 1);
                    break;
                }
        }
    }
}
