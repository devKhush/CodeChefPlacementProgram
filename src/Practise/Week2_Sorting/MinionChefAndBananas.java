package Practise.Week2_Sorting;
import java.util.Scanner;

public class MinionChefAndBananas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int totalHour = sc.nextInt();

            int[] arr = new int[n];
            int max = -1;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                max = Math.max(max,arr[i]);
            }

            // Running a Binary Search
            int minHourReq = -1;
            int low = 1, high = max;

            while (low <= high){
                int mid = low + (high - low)/2;
                int hoursUsed = 0;

                // Check if all fruits can be eaten
                for (int i = 0; i < n; i++){
                     // hoursUsed += Math.ceil(arr[i] / (double)mid);
                    hoursUsed += arr[i] / mid;
                    if (arr[i] % mid != 0){
                        hoursUsed++;
                    }
                }
                if (hoursUsed <= totalHour){
                    minHourReq = mid;
                    high = mid - 1;
                }
                else low = mid + 1;
            }
            System.out.println(minHourReq);
        }
    }
}
