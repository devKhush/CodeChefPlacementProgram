package Week3_BinarySearch.Practise;
import java.util.Arrays;
import java.util.Scanner;

public class CopsAndThiefDevu {
    /**************************************** Brute Force *******************************************/
    public static void solution1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            boolean[] cantReach = new boolean[101];
            for (int i = 0; i < n; i++){
                for (int house = Math.max(1, arr[i]-x*y); house <= Math.min(100, arr[i]+x*y); house++)
                    cantReach[house] = true;
            }
            int houseReachable = 0;
            for (int i = 1; i <= 100; i++)
                houseReachable += !cantReach[i] ? 1 : 0;
            System.out.println(houseReachable);
        }
    }


    /**************************************** Efficient Solution *******************************************/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            int[] houseStart = new int[n];
            int[] houseEnd = new int[n];

            Arrays.sort(arr);

            for (int i = 0; i < n; i++){
                houseStart[i] = arr[i] - x*y;
                houseEnd[i] = arr[i] + x*y;
            }

            int houseReachable = 0;
            for (int i = 0; i < n - 1; i++){
                houseReachable += Math.max(0, houseStart[i+1] - houseEnd[i] - 1);
            }
            houseReachable += Math.max(0, houseStart[0] - 1);
            houseReachable += Math.max(0, 100 - houseEnd[n-1]);

            System.out.println(houseReachable);
        }
    }
}
