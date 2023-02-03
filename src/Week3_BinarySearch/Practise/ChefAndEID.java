package Week3_BinarySearch.Practise;

import java.util.Arrays;
import java.util.Scanner;

public class ChefAndEID {
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

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n-1; i++){
                min = Math.min(min, arr[i+1] - arr[i]);
            }
            System.out.println(min);
        }
    }
}
