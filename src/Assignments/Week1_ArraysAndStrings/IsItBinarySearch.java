package Assignments.Week1_ArraysAndStrings;
import java.util.Scanner;

// How to calculate LCM of an array
// https://www.geeksforgeeks.org/lcm-of-given-array-elements/

public class IsItBinarySearch {
    private static long GCD(long a, long b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }

    private static int GCD_2(int a, int b) {
        if (a == 1 || b == 1)
            return 1;
        while (a != b){
            if (a > b)
                a -= b;
            else
                b -= a;
        }
        return a;
    }

    private static long LCM(long a, long b){
        return a * b / GCD(a, b);
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int K = sc.nextInt();
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = sc.nextInt();

            long minPowerSword = Integer.MAX_VALUE;
            int i = 0;
            int round = 0;
            while (i < N){
                int numHeads = 1<<(round++);
                long lcm = 1;

                for (int j = 0; j < numHeads; j++){
                    lcm = LCM(lcm, arr[i+j]);
                }
                i += numHeads;
                minPowerSword = Math.min(minPowerSword, lcm);
            }
            System.out.println(minPowerSword);
        }
        sc.close();
    }
}

/*
Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int K = sc.nextInt();
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = sc.nextInt();

            int minPowerSword = Integer.MAX_VALUE;
            int i = 0;
            int round = 0;
            while (i < N){
                int numHeads = 1<<(round++);
                int lcm = 1;

                for (int j = 0; j < numHeads; j++){
                    lcm = LCM(lcm, arr[i+j]);
                }
                i += numHeads;
                minPowerSword = Math.min(minPowerSword, lcm);
            }
            System.out.println(minPowerSword);
        }
        sc.close();
 */