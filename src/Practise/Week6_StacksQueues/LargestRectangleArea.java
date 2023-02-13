package Practise.Week6_StacksQueues;
import java.util.Scanner;
import java.util.Stack;

public class LargestRectangleArea {
    private static long largestAreaInRectangle(int n, int[] arr){
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;

        for (int i = 0; i <= n; i++){
            while (!stack.isEmpty()  &&  (i==n || arr[stack.peek()] > arr[i])){
                int bar  = stack.pop();
                int prevSmall = !stack.isEmpty() ? stack.peek() : -1;
                maxArea = Math.max(maxArea, arr[bar] * ((long) i - prevSmall - 1));
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] heights = new int[n];
            for (int i = 0; i < n; i++)
                heights[i] = sc.nextInt();

            System.out.println(largestAreaInRectangle(n, heights));
        }
    }
}
