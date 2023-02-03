package Practise.Week3_BinarySearch;
import java.util.Arrays;
import java.util.Scanner;

public class AverageFlex {
    private static boolean check(int val, int[] arr ,int n){
        int low = 0, high = n -1;
        int ans = -1;

        while (low <= high){
            int mid = low + ((high-low)>>1);
            if (arr[mid] <= val){
                ans = mid;
                low = mid + 1;
            }
            else
                high = mid  - 1;
        }
        return ans + 1 >= n - ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);

            int count = 0;
            for (int i = 0; i < n; i++){
                count += check(arr[i], arr, n) ? 1 : 0;
            }
            System.out.println(count);
        }
    }
}
