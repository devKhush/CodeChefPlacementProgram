package Week3_BinarySearch.Assignment;
import java.util.Scanner;

public class LongestSubarray {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            int max = arr[0] % 2 == 0 ? 1 : 0;
            int curr = arr[0] % 2 == 0 ? 1 : 0;
            int i = 1;
            for (i = 1; i < n; i++) {
                if (arr[i] % 2 == 0) {
                    curr++;
                } else {
                    curr = 0;
                }
                max = Math.max(max, curr);
            }
            System.out.println(max);
        }
        sc.close();
    }
}
