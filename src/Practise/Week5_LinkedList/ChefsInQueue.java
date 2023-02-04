package Practise.Week5_LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class ChefsInQueue {
    private static int[] nextSmallerElement(int n, int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] nextSmaller = new int[n];

        for (int i = 0; i < n; i++){
            while (!stack.isEmpty()  && arr[i] < arr[stack.peek()])
                nextSmaller[stack.pop()] = i;
            stack.add(i);
        }
        while (!stack.isEmpty())
            nextSmaller[stack.pop()] = -1;

        return nextSmaller;
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] chefs = new int[n];
        for (int i = 0; i < n; i++)
            chefs[i] = sc.nextInt();

        // Application of next smaller element
        int[] nextSmaller = nextSmallerElement(n, chefs);
        final int MOD = 1000000007;

        long fear = 1;

        for (int i = 0; i < n; i++){
            if (nextSmaller[i] != -1)
                fear = ((fear % MOD) * ((nextSmaller[i] - i + 1) % MOD)) % MOD;
        }
        System.out.println(fear);
    }
}
