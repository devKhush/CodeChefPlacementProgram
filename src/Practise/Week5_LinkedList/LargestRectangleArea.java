package Practise.Week5_LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class LargestRectangleArea {

    private static int[] nextSmallerElement(int n, int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] NSE = new int[n];

        for (int i = 0; i < n; i++){
            while (!stack.isEmpty()  &&  arr[i] < arr[stack.peek()])
                NSE[stack.pop()] = i;
            stack.push(i);
        }
        while (!stack.isEmpty())
            NSE[stack.pop()] = n;
        return NSE;
    }

    private static int[] prevSmallerElement(int n, int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] PSE = new int[n];

        for (int i = n - 1; i >= 0; i--){
            while (!stack.isEmpty()  &&  arr[i] < arr[stack.peek()])
                PSE[stack.pop()] = i;
            stack.push(i);
        }
        while (!stack.isEmpty())
            PSE[stack.pop()] = -1;
        return PSE;
    }


    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            int n = sc.nextInt();
            int[] heights = new int[n];
            for (int i = 0; i < n; i++)
                heights[i] = sc.nextInt();

            int[] PSE = prevSmallerElement(n, heights);
            int[] NSE = nextSmallerElement(n, heights);

            long maxArea = 0;
            for (int i = 0; i < n; i++){
                long currArea = heights[i] * ((long) NSE[i] - PSE[i] - 1);
                maxArea = Math.max(maxArea, currArea);
            }
            System.out.println(maxArea);
        }
    }
}
