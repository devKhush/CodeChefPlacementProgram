package Assignments.Week3_BinarySearch;
import java.util.Scanner;

public class QueriesInAnArray {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        for (int query = 0; query < q; query++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int ele = sc.nextInt();

            int low = start - 1, high = end - 1;
            int index = -1;
            while (low <= high) {
                int mid = low + ((high - low) >> 1);
                if (arr[mid] < ele)
                    low = mid + 1;
                else {
                    high = mid - 1;
                    index = mid;
                }
            }
            if (index == -1)
                System.out.println(0);
            else
                System.out.println(end - index);
        }
        sc.close();
    }
}
