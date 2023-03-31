package Assignments.Week6_LinkedListsStacksQueues;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int[] nextGreater = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++){
            while (!stack.isEmpty()  &&  arr[i] > arr[stack.peek()]){
                nextGreater[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }
        for (int val : nextGreater) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
